/*
   Copyright 2009-2022 PrimeTek.

   Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

   Licensed under PrimeFaces Commercial License, Version 1.0 (the "License");

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.primefaces.rain.view;

import ai.genpen.dao.AccountDAO;
import ai.genpen.dao.NotificationDAO;
import ai.genpen.dao.OrganizationDAO;
import ai.genpen.models.Account;
import ai.genpen.models.Member;
import ai.genpen.models.Notification;
import ai.genpen.models.Organization;
import org.primefaces.rain.dao.BenefitDAO;
import org.primefaces.rain.dao.DatabaseManager;
import org.primefaces.rain.dao.SecurityEventDAO;
import org.primefaces.rain.domain.Action;
import org.primefaces.rain.domain.Benefit;
import org.primefaces.rain.domain.Order;
import org.primefaces.rain.domain.SecurityEvent;
import org.primefaces.rain.service.OrderService;
import org.primefaces.rain.util.Globals;
import org.primefaces.rain.util.Utility;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@ViewScoped
public class DashboardView implements Serializable {

    private List<Order> ordersThisWeek;

    private List<Order> ordersLastWeek;

    private List<Order> orders;

    private int orderWeek = 0;

    private String email = Utility.getEmail();

    @Inject
    private OrderService service;

    private List<Action> actionLists = new ArrayList<>();


    private List<Benefit> benefitList = new ArrayList<>();
    private List<Member> memberList = new ArrayList<>();
    private List<Organization> organizationList = new ArrayList<>();
    private List<Notification> notificationList = new ArrayList<>();


    @PostConstruct
    public void init() {
        this.ordersThisWeek = this.service.getOrders(25);
        this.ordersLastWeek = this.service.getOrders(25);
        this.orders = this.ordersThisWeek;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public List<Order> getOrdersThisWeek() {
        return ordersThisWeek;
    }

    public void setOrdersThisWeek(List<Order> ordersThisWeek) {
        this.ordersThisWeek = ordersThisWeek;
    }

    public List<Order> getOrdersLastWeek() {
        return ordersLastWeek;
    }

    public void setOrdersLastWeek(List<Order> ordersLastWeek) {
        this.ordersLastWeek = ordersLastWeek;
    }

    public void loadOrders() {
        this.orders = this.orderWeek == 1 ? this.ordersLastWeek : this.ordersThisWeek;
    }

    public int getOrderWeek() {
        return orderWeek;
    }

    public void setOrderWeek(int orderWeek) {
        this.orderWeek = orderWeek;
    }

    private List<Notification> notifications  = new ArrayList<>();


    public List<Action> getActionLists() {

        try {
            Connection connection= DatabaseManager.getConnection();
            SecurityEventDAO dao = new SecurityEventDAO(connection);
            System.out.println("ActionLists:" + email);
            List<SecurityEvent> sec = dao.findByOwner(email);
            for(int i = sec.size() - 1; i >= 0; i--){
                Action a = new Action();
                a.setAction(((SecurityEvent)sec.get(i)).getAction());
                a.setActionDate(new Date(((SecurityEvent)sec.get(i)).getTs().getTime()));
                a.setDevice(((SecurityEvent)sec.get(i)).getDevice());
                a.setOwner(((SecurityEvent)sec.get(i)).getOwner());
                a.setUserIpAddress(((SecurityEvent)sec.get(i)).getIp());
                actionLists.add(a);
            }
            return actionLists;
        } catch (SQLException ex) {
            Logger.getLogger(DashboardView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actionLists;
    }

    public List<Benefit> getBenefitList() {

        try {
            BenefitDAO dao = new BenefitDAO();
            benefitList = new ArrayList<>();
            System.out.println("BenefitLists:" + email);
            List<Benefit> ben = dao.findByMember(email);
            for(int i = 0; i < ben.size(); i++){
                System.out.println("Adding Benefit");
                benefitList.add(ben.get(i));
            }
            return benefitList;
        } catch (SQLException ex) {
            Logger.getLogger(DashboardView.class.getName()).log(Level.SEVERE, null, ex);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return benefitList;
    }

    public List<Member> getMemberList() {

        //Connection connection= DatabaseManager.getConnection();
        OrganizationDAO dao = new OrganizationDAO();
        memberList = new ArrayList<>();

        System.out.println("MemberLists:" + email);
        int orgId = -1;
        try {
            boolean isOrg = dao.isOrganization(email);
            Organization o = dao.findByContact(email);
            orgId = o.getId();
            System.out.println("Org ID:" + orgId);
            System.out.println("Org Member Email:" + email);

        } catch(Exception ex) { ex.printStackTrace();}

        Organization o = dao.find(orgId);
        ArrayList<Member> ben= (ArrayList<Member>) dao.findAllMemberByOrgContact(email);
        for(int i = 0; i < ben.size() ; i++){
            memberList.add(ben.get(i));
        }
        return memberList;
    }

    public List<Account> getAccount() {

        try {
            AccountDAO dao = new AccountDAO();
            Account account = dao.find(email);
            ArrayList<Account> list = new ArrayList<>();
            list.add(account);
            return list;
        } catch(Exception ex){
            ex.printStackTrace();
            ArrayList<Account> list = new ArrayList<>();
            Account account = new Account(); //dao.find(email);
            account.setAccountName(Globals.defaultUser);
            account.setWalletAddress("0xbb56a404723cfF20d0685488B05A02cDC3ERROR");
            account.setBalance(0.00);
            list.add(account);
            return list;
        }
    }
    public List<Organization> getOrganizationList() {

        //Connection connection= DatabaseManager.getConnection();
        OrganizationDAO dao = new OrganizationDAO();
        organizationList = new ArrayList<>();
        System.out.println("OrganizationLists:" + email);
        List<Organization> ben = dao.findAll();
        for(int i = 0; i < ben.size(); i++){
            organizationList.add(ben.get(i));
        }
        return organizationList;

    }

    public List<Notification> getNotificationList() {

        //Connection connection= DatabaseManager.getConnection();
        NotificationDAO dao = new NotificationDAO();
        System.out.println("NotificationLists:" + email);
        notificationList = new ArrayList<>();
        //MemberDAO mdao = new MemberDAO();
        //Member m = mdao.find(email);
        List<Notification> ben = dao.findAllForMe(email);
        if(ben != null) {
            for (int i = 0; i < ben.size(); i++) {
                notificationList.add(ben.get(i));
            }
        } else {
            System.out.println("Notification list was null:" + email);
        }
        return notificationList;

    }


}
