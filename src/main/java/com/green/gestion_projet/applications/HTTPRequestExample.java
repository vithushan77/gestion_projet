package com.green.gestion_projet.applications;

import com.google.gson.Gson;
import com.green.gestion_projet.models.HTTPResponse;
import com.green.gestion_projet.utils.HTTPRequest;

import java.util.HashMap;

public class HTTPRequestExample {
    public static void main(String[] args) {
        try {
            String url = "http://localhost:3000/api/v1/auth/authenticate/email";
            Gson gson = new Gson();
            HashMap<String, String> requestBody = new HashMap<>();
            requestBody.put("email", "vithushan@gmail.com");
            requestBody.put("password", "vithushan01");


            HTTPRequest httpRequest = new HTTPRequest.Builder(url, "POST")
                    .setRequestBody(gson.toJson(requestBody))
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer TOKEN123")
                    .build();

            HTTPResponse<String> response = httpRequest.sendRequest();
            System.out.println("Response: " + response.getBody());
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
