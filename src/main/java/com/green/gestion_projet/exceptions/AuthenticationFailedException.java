package com.green.gestion_projet.exceptions;

public class AuthenticationFailedException extends Exception {
    public AuthenticationFailedException() {
        super("Authentication failed.");
    }
}

