package org.primefaces.rain.servlet;

import ai.genpen.dao.MemberDAO;
import ai.genpen.dao.NotificationDAO;
import ai.genpen.models.Member;
import ai.genpen.models.Notification;
import org.primefaces.rain.dao.BenefitDAO;
import org.primefaces.rain.dao.DatabaseManager;
import org.primefaces.rain.dao.SecurityEventDAO;
import org.primefaces.rain.dao.UserDAO;
import org.primefaces.rain.domain.*;
import org.primefaces.rain.service.MessageService;
import org.primefaces.rain.util.Utility;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sean Beecrot <sean@HeraPass.com> <seanbeecroft@gmail.com> 1-416-878-5282
 */
public class BroadcastServlet extends HttpServlet {

    public String send(HttpServletRequest request, HttpServletResponse response) {
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        String benefit = request.getParameter("benefit");
        String description = request.getParameter("description");


        String email = ""; //
        try {
            email = (String)request.getSession(false).getAttribute("userid");
        } catch(Exception ex){

        }
        System.out.println("Got to MemberDAO");
        Connection connection = null;
        try {
            MemberDAO memberDAO = new MemberDAO();
            String challenge = request.getParameter("challenge");
            if( challenge == null || challenge.isEmpty() || !challenge.endsWith("EE")){
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error403.xhtml");
                dispatcher.forward(request, response);  
                return "failure";
            }
            if( email == null ) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error403.xhtml");
                dispatcher.forward(request, response);
            }
            System.out.println("Got to UserDAO");

            connection = DatabaseManager.getConnection();
            UserDAO dao = new UserDAO(connection);
            NotificationDAO notificationDAO = new NotificationDAO();

            email = email.toLowerCase();
            User u = dao.findByEmail(email);
            String org = "HeraPass.com"; // TODO
            if (u != null) {
                try {
                    final String em = email;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            ArrayList<Member> members = memberDAO.findAll();
                            for(int i = 0; i < members.size(); i++ ) {
                                try {
                                    Member m = members.get(i);
                                    try {
                                        Notification notification = new Notification();
                                        notification.setName(em);
                                        notification.setMessage(message);
                                        notification.setRecipient(m.getMemberEmail());
                                        notification.setRead(false);
                                        notification.setTimestamp(new Timestamp(System.currentTimeMillis()).toString());
                                        notification.setDeliveryMethod("EMAIL");

                                        notificationDAO.insert(notification);

                                    } catch(Exception ex) {
                                        System.out.println("NO NOTIFICATION COULD BE ADDED:" + i);
                                    }

                                    try {
                                        Benefit b = new Benefit();
                                        b.setMember(m.getMemberName());
                                        b.setEnabled(true);
                                        b.setActionDate(new Date(System.currentTimeMillis()));
                                        b.setOrganization(org);
                                        b.setAction("");
                                        b.setOwner(em);
                                        b.setDescription(description);

                                        BenefitDAO benefitDAO = new BenefitDAO();
                                        benefitDAO.insert(b);
                                    } catch(Exception ex) {
                                        System.out.println("NO BENEFIT COULD BE ADDED:" + i);
                                    }

                                    try {
                                        MessageService.send(subject, message, null, m.getMemberEmail(), NotificationType.EMAIL);

                                    } catch(Exception ex) {
                                        System.out.println("NO EMAIL COULD BE SENT:" + i);
                                    }
                                    Thread.sleep(300);
                                } catch(Exception ex) { }
                            }

                        }
                    });
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                SecurityEventDAO securityDAO = new SecurityEventDAO(connection);
                String ip = Utility.getIp(request);
                String country = Utility.getCountry(request);
                String device = Utility.getDevice(request);

                Timestamp ts = new Timestamp(System.currentTimeMillis());
                SecurityEvent sec = new SecurityEvent(email, ip, country, SecurityAction.ADD_BENEFIT.name(), ts, device);
                securityDAO.insert(sec);
                request.setAttribute("message", "A new password has been sent to the email on file: " + Utility.redact(email));
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/forgot_password.xhtml");
                try {
                    dispatcher.forward(request, response);
                } catch (ServletException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(BroadcastServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

                return "success";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            if (email == null || email.isEmpty() || !Utility.isValidEmail(email)) {
                request.setAttribute("error", "Unable to reset password for the email provided");
            } else {
                request.setAttribute("error", "Unable to reset password for the email " + Utility.redact(email));
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/forgot_password.xhtml");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException exx) {
                exx.printStackTrace();
            } catch (IOException exx) {
                exx.printStackTrace();
            } catch (Exception exx) {
                exx.printStackTrace();
            }
        } finally {
            Utility.closeQuietly(connection, null, null);
        }
        return "failure";
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
        //response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            send(request, response);
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
