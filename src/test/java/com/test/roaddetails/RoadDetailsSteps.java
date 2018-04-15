/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.roaddetails;

import static org.hamcrest.core.IsEqual.equalTo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.test.roaddetails.RoadDetails;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoadDetailsSteps {

    private final RequestDetails requestDetails = new RequestDetails();
    private final RequestDetails requestDetailsInvalid = new RequestDetails();
    private RoadDetailsResult roadDetailsResult = new RoadDetailsResult();

    @Given("^a valid (.*) is specified$")
    public void requestDetails(String roadId) throws Throwable {
        requestDetails.setRoadId(roadId);
    }

    @When("^the client is run appId as (.*) appKey as (.*)$")
    public void sendApplicationDetails(String appId, String appKey) {
        requestDetails.setAppId(appId);
        requestDetails.setAppKey(appKey);
    }
    @Then("^the road (.*),(.*),(.*) should be displayed$")
    public void showRoadName(String displayName, String statusSeverity, String statusSeverityDescription) throws Throwable {
        RoadDetailsUtil roadDetails = new RoadDetailsUtil();
//        roadDetails.setRequestDetails(requestDetails);
        roadDetails.getRoadDetails(requestDetails, roadDetailsResult);
//        roadDetailsResult = roadDetails.getRoadDetailsResult();
System.out.println("displayName :: "+displayName + "roadDetailsResult.getDisplayName() :: "+roadDetailsResult.getDisplayName());
        assertThat(displayName.trim(), equalTo(roadDetailsResult.getDisplayName().trim()));
        assertThat(statusSeverity.trim(), equalTo(roadDetailsResult.getStatusSeverity().trim()));
        assertThat(statusSeverityDescription.trim(), equalTo(roadDetailsResult.getStatusSeverityDescription().trim()));
    }
    
    
     @Given("^a invalid (.*) is specified$")
    public void requestInvalidDetails(String roadId) throws Throwable {
        requestDetailsInvalid.setRoadId(roadId);
    }
     @When("^the application client is run appId as (.*) appKey as (.*)$")
    public void sendApplicationDet(String appId, String appKey) {
        requestDetailsInvalid.setAppId(appId);
        requestDetailsInvalid.setAppKey(appKey);
    }
    @Then("^the road (.*) should be displayed as (.*)$")
    public void showRoadStatus(String roadId, String status) throws Throwable {
        RoadDetailsUtil roadDetails = new RoadDetailsUtil();
//        roadDetails.setRequestDetails(requestDetailsInvalid);
        roadDetails.getRoadDetails(requestDetailsInvalid, roadDetailsResult);
//        roadDetailsResult = roadDetails.getRoadDetailsResult();
        assertThat(roadId.trim(), equalTo(requestDetailsInvalid.getAppId().trim()));
        assertThat(status.trim(), equalTo(roadDetailsResult.getStatus().trim()));
    }
}
