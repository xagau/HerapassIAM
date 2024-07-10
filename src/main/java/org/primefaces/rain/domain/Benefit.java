/*
   Copyright 2022-2023 HeraPass.com.

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
package org.primefaces.rain.domain;

import java.io.Serializable;
import java.util.Date;

public class Benefit implements Serializable {

    private int id;

    private Date actionDate = new Date();
    private Date activationDate = new Date();
    private Date endDate = new Date();

    private boolean enabled = false;

    private String name;

    private String description;

    private String action;

    private String owner;

    private String organization;
    private String member;


    public Benefit(){
        id = (int)System.nanoTime();
        setActionDate(new Date(System.currentTimeMillis()));
        this.name = "BEN" + Long.toHexString(System.currentTimeMillis()).toLowerCase();
        this.setActionDate(new Date(System.currentTimeMillis()));
        this.description = "...";
        this.action = action;
        this.owner = owner;
        this.setMember(member==null||member.isEmpty()?"No member":member);
        this.setOrganization((organization==null||organization.isEmpty())?"HeraSoft.com":organization);
    }

    public Benefit(int id, String name, String desc, String action, String owner, String organization, String member) {
        this.id = id;
        this.setActionDate(new Date(System.currentTimeMillis()));
        this.name = name;
        this.description = desc;
        this.action = action;
        this.owner = owner;
        this.setMember(member);
        this.setOrganization(organization);
    }

    public Benefit(int id, String name, String desc, String action, String owner, Date actionDate, String organization, String member) {
        this.id = id;
        this.setActionDate(actionDate);
        this.name = name;
        this.description = desc;
        this.action = action; 
        this.owner = owner;
        this.setMember(member);
        this.setOrganization(organization);

    }

    public Benefit clone() {

        return new Benefit(getId(),  getName(), getDescription(), getAction(), getOwner(), getActionDate(), getOrganization(), getMember() );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }
}