/**
 * Copyright (c) 2023 HeraPass.com, Permission is hereby granted, free of charge,
 * to any person obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package org.primefaces.rain.servlet;

import ai.genpen.dao.AccountDAO;
import ai.genpen.dao.MemberDAO;
import ai.genpen.dao.MembershipDAO;
import ai.genpen.dao.OrganizationDAO;
import ai.genpen.models.Account;
import ai.genpen.models.Member;
import ai.genpen.models.Membership;
import ai.genpen.models.Organization;
import org.primefaces.rain.dao.DatabaseManager;
import org.primefaces.rain.dao.SecurityEventDAO;
import org.primefaces.rain.dao.UserDAO;
import org.primefaces.rain.domain.SecurityAction;
import org.primefaces.rain.domain.SecurityEvent;
import org.primefaces.rain.domain.User;
import org.primefaces.rain.util.Utility;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignupServlet extends HttpServlet {

    //validate signup
    public String enroll(HttpServletRequest request, HttpServletResponse response) {
            Connection connection = DatabaseManager.getConnection();

            try {
                System.out.println("Enroll called");
                String email = request.getParameter("email");
                String roleType = request.getParameter("roleType");
                String orgCode = request.getParameter("orgCode");

                if( orgCode == null || orgCode.isEmpty() ){
                    email = "null@HeraPass.com";
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error403.xhtml");
                    dispatcher.forward(request, response);
                    return "failure";
                }
                if (email == null) {
                    email = "null@HeraPass.com";
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error403.xhtml");
                    dispatcher.forward(request, response);
                    return "failure";
                }
                String challenge = request.getParameter("challenge");
                System.out.println("Challenge Reached");
                if( challenge == null || challenge.isEmpty() || !challenge.endsWith("EE")){
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error403.xhtml");
                    dispatcher.forward(request, response);  
                    return "failure";
                }
                email = email.toLowerCase();
                    
                UserDAO userDAO = new UserDAO(connection);
                try {
                    User u = userDAO.find(email);
                    if (u != null) {
                        try {
                            request.setAttribute("error", 
                                            "This email is already in use. Please enter a new email.");
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/signup.xhtml");
                            dispatcher.forward(request, response);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.xhtml");
                            dispatcher.forward(request, response);
                            return "failure";
                        }
                    } else {

                        request.getSession(true).setAttribute("userid", email);
                        //TODO: Update/remove this date once sandboxes are installed automatically.
                        String password = Utility.randomPassword();
                        String message
                                = "Thank you for joining the HeraPass.com community.\n"
                                + "Your account can be accessed by logging in with the following information:\n\n"
                                + "username: " + email + "\n"
                                + "password: " + password + "\n\n"
                                + "Please login at https://www.herapass.com/login.xhtml \n\n"
                                + "Your account will remain unverified until you log in.\n"
                                + "Unverified accounts will be removed after 30 days.\n"
                                + "Please change your password as soon as you log in.\n"
                                + "\n\nBy logging in you agree to our terms of service. \n"
                                + "Upon activation you will be notified via email.\n "
                                + "Logging in will validate and verify your email and activate your account. \n"
                                + "If you did not initiate this sign-up request please contact us at security@HeraPass.com. \n";

                        System.out.println(message);
                        User u1 = new User();
                        u1.setEmail(email);
                        u1.setUsername(email);
                        u1.setPassword(Utility.hashString(password));
                        u1.setUserStatus(User.USER_STATUS_EMAIL_UNVERIFIED);
                        userDAO.insert(u1);


                        AccountDAO accountDAO = new AccountDAO();
                        Account account = new Account();
                        account.setAccountName(email);
                        account.setBalance(0);
                        account.setWalletAddress(Utility.generateWalletAddress());
                        account.setCurrency("ETH");
                        accountDAO.insert(account);

                        if( roleType != null && !roleType.isEmpty()){
                            if( roleType.equalsIgnoreCase("admin")){

                            } else if ( roleType.equalsIgnoreCase("member")){
                                System.out.println("Member Reached");
                                Member member = new Member();
                                member.setMemberEmail(email);
                                member.setIsActive(true);
                                member.setContactNumber(5555555);
                                member.setCreationDate(new Date(System.currentTimeMillis()).toString());
                                member.setMemberName(email);


                                MemberDAO memberDAO = new MemberDAO();
                                memberDAO.insert(member);

                                Member mem = memberDAO.findByMemberName(email);
                                try {
                                    Integer mid = -1;
                                    if( mem == null ){
                                        System.out.println("Mem is null");
                                    }
                                    else {
                                        mid = mem.getId();
                                        System.out.println("mid:" + mid);
                                    }
                                    OrganizationDAO organizationDAO = new OrganizationDAO();
                                    int oic = Utility.stripCode(orgCode);
                                    Integer orgId = organizationDAO.find(oic).getId();
                                    try {
                                        request.getSession(true).setAttribute("orgId", orgId);
                                    } catch(Exception ex) {
                                        ex.printStackTrace();
                                    }

                                    Membership memberShip = new Membership();
                                    memberShip.setMemberSince(new Date(System.currentTimeMillis()).toString());
                                    memberShip.setMemberId(mid);
                                    memberShip.setFkOrganizationId(orgId);
                                    MembershipDAO dao = new MembershipDAO();
                                    dao.insert(memberShip);

                                } catch(Exception ex) {
                                    ex.printStackTrace();
                                }
                            } else if ( roleType.equalsIgnoreCase("organization")){
                                System.out.println("Org Reached");
                                Organization org = new Organization();
                                org.setName(email);
                                org.setContact(email);
                                org.setIsActive(true);
                                org.setStartDate(new Date(System.currentTimeMillis()).toString());

                                OrganizationDAO organizationDAO = new OrganizationDAO();

                                organizationDAO.insert(org);

                            }
                        }
                        
                        try {
                            //MessageService.send("Welcome to HeraPass.com", message, null, email.toLowerCase(), NotificationType.EMAIL);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        try {
                            System.out.println("Security Event Reached");

                            SecurityEventDAO securityDAO = new SecurityEventDAO(connection);
                            String ip = Utility.getIp(request); //request.getRemoteHost().toString();
                            String country = Utility.getCountry(request);
                            String device = Utility.getDevice(request);

                            Timestamp ts = new Timestamp(System.currentTimeMillis());
                            SecurityEvent sec = new SecurityEvent(email, ip, country, SecurityAction.SIGNUP.name(), ts, device);
                            securityDAO.insert(sec);
                        } catch(Exception ex) { 
                            ex.printStackTrace();
                        }
                        System.out.println("Redirect Event Reached");
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/verification.xhtml");
                        dispatcher.forward(request, response);
                        return "success";
                    }
                } catch (SQLException throwables) {
                    System.out.println("Exception Event Reached");

                    throwables.printStackTrace();
                    request.setAttribute("error",  "An error occurred while trying to log you in.");
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/signup.xhtml");
                    dispatcher.forward(request, response);
                    return "failure";
                }
            } catch (Exception ex) {
                try {
                    System.out.println("Exception Event B Reached");
                    ex.printStackTrace();
                    request.setAttribute("error",  "An error occurred while trying to log you in. Please try again or contact");
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/signup.xhtml");
                    dispatcher.forward(request, response);
                    return "failure";
                } catch (ServletException ex1) {
                    ex1.printStackTrace();
                } catch (IOException ex1) {
                    ex1.printStackTrace();
                    Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
            } finally {
                Utility.closeQuietly(connection, null, null);
            }
            System.out.println("Finally Reached");
            return "failure";

    }

    public static void main(String[] args)
    {
        System.out.println(Utility.stripCode("ORG-1-HERAPASS.COM"));
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            enroll(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
