/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.roaddetails;

/**
 *
 * @author
 */
public class RoadDetailsResult {
    String diaplayName, statusSeverity,statusSeverityDescription,status;
    public void setDisplayName(String diaplayName) {
        this.diaplayName = diaplayName;
    }
    
    public String getDisplayName() {
        return this.diaplayName;
    }
    
    public void setStatusSeverity(String statusSeverity) {
        this.statusSeverity = statusSeverity;
    }
    
    public String getStatusSeverity() {
        return this.statusSeverity;
    }
    
    public void setStatusSeverityDescription(String statusSeverityDescription) {
        this.statusSeverityDescription = statusSeverityDescription;
    }
    
    public String getStatusSeverityDescription() {
        return this.statusSeverityDescription;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return this.status;
    }
}
