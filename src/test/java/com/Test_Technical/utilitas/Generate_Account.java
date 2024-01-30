package com.Test_Technical.utilitas;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Generate_Account {

    public static String createPassword(){
        String allowChar = "abcdefghijklmnopqrstuvwxyz" + "123456789";
        String firstName = "";
        for (int i = 0; i < 8; i++) {
            firstName += allowChar.charAt(new Random().nextInt(allowChar.length()));
        }
        return firstName;
    }
    public static String createEmail(){
        String surel = "";
        String generd = RandomStringUtils.randomAlphanumeric(12);
        surel = generd + "@gmail.com";
        return surel;
    }
}
