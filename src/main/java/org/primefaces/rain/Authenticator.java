package org.primefaces.rain;

import org.primefaces.rain.util.Globals;
import org.primefaces.rain.util.Utility;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean("authenticator")
@SessionScoped
@Named
public class Authenticator implements Serializable {
        private String userRole;

    public String getUserRole() {

        if( userRole == null || userRole.isEmpty() || userRole.equalsIgnoreCase("unknown")){
            System.out.println("getRole from Utility returned empty or null or unknown:" + userRole);
            userRole = userRole = Utility.getRole();

        }
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public static void main(String[] args){
        System.out.println(Utility.getRole("logan@genpen.ai"));
        System.out.println(Utility.getRole("sean@genpen.ai"));
        System.out.println(Utility.getRole("newuser@genpen.ai"));
        System.out.println(Utility.getRole(Globals.defaultUser));
    }

}
