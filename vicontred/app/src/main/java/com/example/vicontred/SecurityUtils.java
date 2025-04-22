package com.example.vicontred;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class SecurityUtils {

    public static String generarIndiceEncriptado() {
        try {

            String valorAleatorio = UUID.randomUUID().toString();

            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(valorAleatorio.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
