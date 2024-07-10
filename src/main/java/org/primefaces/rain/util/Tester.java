package org.primefaces.rain.util;

import ai.genpen.dao.OrganizationDAO;

public class Tester {
    public static void main(String args[])
    {
        String orgCode = "ORG-1-HERAPASS.COM";
        OrganizationDAO organizationDAO = new OrganizationDAO();
        int oic = Utility.stripCode(orgCode);
        int orgId = organizationDAO.find(oic).getId();
        System.out.println(orgId);
    }
}
