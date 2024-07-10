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
package org.primefaces.rain.controllers;

import org.primefaces.rain.dao.UserDAO;
import org.primefaces.rain.domain.NotificationType;
import org.primefaces.rain.domain.User;
import org.primefaces.rain.service.MessageService;
import org.primefaces.rain.util.Utility;
import org.primefaces.rain.dao.DatabaseManager;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ManagedBean(name = "signupController", eager = true)
@SessionScoped
public class SignupController implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;

    private String password;
    private String message;
    private String user;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user.toLowerCase();
    }

    //validate signup
    public String enroll() {
        Connection connection = DatabaseManager.getConnection();
        try {
            try {
                String email = Utility.getParameterByName("email");

                UserDAO userDAO = new UserDAO(connection);
                try {
                    User u = userDAO.find(email.toLowerCase());
                    if (u != null) {
                        FacesContext.getCurrentInstance().addMessage(
                                null,
                                new FacesMessage(FacesMessage.SEVERITY_WARN,
                                        "This email is already in use.",
                                        "Please enter a new email."));
                    } else {
                        String password = Utility.randomPassword();
                        String message = "Thank you for enrolling with HeraPass.com.\n"
                                + "Your account can be accessed by logging in with the following information:\n\n"
                                + "username: " + email.toLowerCase() + "\n"
                                + "password: " + password + "\n\n"
                                + "Please login at https://www.HeraPass.com/login.xhtml \n"
                                + "Please change your password as soon as you log in.\n"
                                + "\n\nBy logging in you agree to our terms of service \n"
                                + "Logging in will validate and verify your email and activate your account \n";
                        
                        Logger.getAnonymousLogger().log(Level.SEVERE, "New Password for " + email.toLowerCase() + " is " + password);
                        User u1 = new User();
                        u1.setEmail(email.toLowerCase());
                        u1.setUsername(email.toLowerCase());
                        u1.setPassword(Utility.hashString(password));
                        u1.setUserStatus(u1.USER_STATUS_EMAIL_UNVERIFIED);   
                        userDAO.insert(u1);
                        // Send email here.
                        //MessageService.test();
                        MessageService.send("Welcome to HeraPass.com", message, null, email.toLowerCase(), NotificationType.EMAIL);
                        HttpServletResponse response = Utility.getResponse();
                        response.sendRedirect("/dashboard.xhtml");
                        return "success";
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    HttpServletResponse response = Utility.getResponse();
                    response.sendRedirect("/signup.xhtml");
                    return "failure";
                }
            } catch (Exception ex) {
                try {
                    ex.printStackTrace();
                    HttpServletResponse response = Utility.getResponse();
                    response.sendRedirect("/signup.xhtml");
                    return "failure";
                } catch (IOException ex1) {
                    Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            HttpServletResponse response = Utility.getResponse();
            response.sendRedirect("/signup.xhtml");
            return "failure";
        } catch (IOException ex) {
            Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Utility.closeQuietly(connection, null, null);

        }
        return "failure";
                
    }

    public String logout() {
        return "logout";
    }
}
