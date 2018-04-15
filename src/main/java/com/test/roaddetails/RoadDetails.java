/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.roaddetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

public class RoadDetails extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static RequestDetails requestDetails = new RequestDetails();
    public static RoadDetailsResult roadDetailsResult = new RoadDetailsResult();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = request.getReader();
        String str = null;
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }
        JSONObject jObj = new JSONObject(sb.toString());
        requestDetails.setRoadId(jObj.getString("id"));
        requestDetails.setAppId(jObj.getString("appId"));
        requestDetails.setAppKey(jObj.getString("appKey"));
        int responseCode = new RoadDetailsUtil().getRoadDetails(requestDetails,roadDetailsResult);
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        String responseResult = "";
        if (responseCode == 200) {
            roadDetailsResult.setStatus("valid");
            responseResult = responseResult = "displayName = " + roadDetailsResult.getDisplayName() + ", statusSeverity = " + roadDetailsResult.getStatusSeverity()
                    + " , statusSeverityDescription = " + roadDetailsResult.getStatusSeverityDescription();
        } else {
            roadDetailsResult.setStatus("invalid");
            responseResult = "Road ID " + requestDetails.getRoadId() + " is invalid";
        }
        response.getWriter().write("RESULT " + responseResult);
    }

//    public int getRoadDetails() throws MalformedURLException, ProtocolException, IOException {
//        String url = "https://api.tfl.gov.uk/Road/" + requestDetails.getRoadId() + "?" + "app_id=" + requestDetails.getAppId() + "&app_key=" + requestDetails.getAppKey();
//        System.out.println("url :: " + url);
//        URL object = null;
//        int responseCode = 404;
//        try {
//            object = new URL(url);
//            HttpURLConnection con = (HttpURLConnection) object.openConnection();
//            con.setDoOutput(true);
//            con.setDoInput(true);
//            con.setRequestProperty("Content-Type", "application/json");
//            con.setRequestProperty("Accept", "application/json");
//            con.setRequestMethod("GET");
//            responseCode = con.getResponseCode();
//            System.out.println("\nSending 'GET' request to URL : " + url);
//            System.out.println("Response Code : " + responseCode);
//            StringBuilder response;
//            try (BufferedReader in = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()))) {
//                String inputLine;
//                response = new StringBuilder();
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//            }
//            //print in String
//            System.out.println(response.toString().substring(0, (response.toString().length() - 1)));
//            //Read JSON response and print
//            String result = response.toString().substring(1, (response.toString().indexOf("\"bounds\"") - 1)) + "}";
//            JSONObject myResponse = new JSONObject(result);
//            System.out.println("result after Reading JSON Response");
//            roadDetailsResult.setDisplayName(myResponse.getString("displayName"));
//            roadDetailsResult.setStatusSeverity(myResponse.getString("statusSeverity"));
//            roadDetailsResult.setStatusSeverityDescription(myResponse.getString("statusSeverityDescription"));
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(RoadDetails.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return responseCode;
//    }
        
}
