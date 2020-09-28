package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptPass {
    public static void main(String[] args) {
        System.out.println(encypt("123"));
    }
    public static String encypt(String password){
    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
    return encoder.encode(password);
    }
}
