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
public class RequestDetails {
    
    String roadId = "", appId = "", appKey = "";
    
    public void setRoadId(String roadId){
        this.roadId = roadId;
    }
    
    public String getRoadId() {
        return roadId;
    }
    
    public void setAppId(String appId){
        this.appId = appId;
    }
    
    public String getAppId() {
        return appId;
    }
    
    public void setAppKey(String appKey){
        this.appKey = appKey;
    }
    
    public String getAppKey() {
        return appKey;
    }
    
    
}
