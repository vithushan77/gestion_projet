package com.green.gestion_projet.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.green.gestion_projet.adapters.LocalDateTimeTypeAdapter;
import com.green.gestion_projet.exceptions.AuthenticationFailedException;
import com.green.gestion_projet.models.HTTPResponse;
import com.green.gestion_projet.models.entities.User;
import com.green.gestion_projet.singletons.SessionManager;
import com.green.gestion_projet.utils.HTTPRequest;

import java.time.LocalDateTime;
import java.util.HashMap;

public class AuthService {

    public static final String AUTH_URL = "http://localhost:3000/api/v1/auth/authenticate/email";

    public static String authenticate(String email, String password) {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                .create();

        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("email", email);
        requestBody.put("password", password);

        HTTPRequest httpRequest = new HTTPRequest.Builder(AUTH_URL, "POST")
                .setRequestBody(gson.toJson(requestBody))
                .addHeader("Content-Type", "application/json")
                .build();


        try {
            HTTPResponse<String> response = httpRequest.sendRequest();

            if (response.getStatusCode() == 200) {
                HashMap<String, String> responseBody = gson.fromJson(response.getBody(), HashMap.class);
                String token = responseBody.get("token");

                SessionManager.getInstance().setToken(token);

                return token;
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        return null;
    }

    public static User fetchUser(String token) {
        String url = "http://localhost:3000/api/v1/auth/me";

        HTTPRequest httpRequest = new HTTPRequest.Builder(url, "GET")
                .addHeader("Authorization", "Bearer " + token)
                .build();

        try {
            HTTPResponse<String> response = httpRequest.sendRequest();

            if (response.getStatusCode() == 200) {

                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
                        .create();

                HashMap<String, String> responseBody = gson.fromJson(response.getBody(), HashMap.class);
                String userJson = gson.toJson(responseBody.get("user"));
                User user = gson.fromJson(userJson, User.class);

                if (user == null) {
                    throw new AuthenticationFailedException();
                }

                SessionManager.getInstance().setCurrentUser(user);

                return user;
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

        return null;
    }

    public static boolean userExists(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        HTTPRequest httpRequest = new HTTPRequest.Builder("http://localhost:3000/api/v1/users?email=" + email, "GET")
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            HTTPResponse<String> response = httpRequest.sendRequest();
            return response.getStatusCode() == 200;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean logout(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }

        HTTPRequest httpRequest = new HTTPRequest.Builder("http://localhost:3000/api/v1/auth/logout", "DELETE")
                .addHeader("Authorization", "Bearer " + token)
                .build();

        try {
            HTTPResponse<String> response = httpRequest.sendRequest();
            return response.getStatusCode() == 200;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        boolean userExists = AuthService.userExists("vithushan@gmail.com");

        if (!userExists) {
            System.out.println("User does not exist");
            return;
        }

        String token = AuthService.authenticate("vithushan@gmail.com", "vithushan01");

        User fetchedUser = AuthService.fetchUser(token);
        System.out.println("Fetched user: " + fetchedUser);

        System.out.println("User exists: " + userExists);

        System.out.println("Authentication token: " + token);

        System.out.println("Session: " + SessionManager.getInstance());

    }

}
