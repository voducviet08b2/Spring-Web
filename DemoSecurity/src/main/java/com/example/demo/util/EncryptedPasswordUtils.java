package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptedPasswordUtils {
    public static String encrupt(String password){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    public static void main(String[] args) {
        String password="123";
        String pass=encrupt(password);
        System.out.println("Password: "+pass);
    }
}
