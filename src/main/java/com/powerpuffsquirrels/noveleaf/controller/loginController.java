/*
    This will handle all the UI stuff
    Then we store that string in database to back end
    we're going to use MD5
    database management
    Creates User Database, User Object, and Hashed Password for storing
     */
package com.powerpuffsquirrels.noveleaf.controller;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
public class loginController {

    public static void main (String[] args) {
        Scanner inputPass = new Scanner(System.in);
        // receive input from user
        System.out.println("Enter password: ");
        String userPass = inputPass.nextLine();
        String hashedPass = null;
        // now hash that string
        try {
            // create message digest for md5
            // Warning!! MD5 not collision resistant!
            MessageDigest md = MessageDigest.getInstance("MD5");

            // get bytes from the password
            md.update(userPass.getBytes());

            // get hash bytes
            byte[] bytes = md.digest();
            // convert from decimal to hexadecimal
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            // now we got the password, store this in the database
            hashedPass = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println(hashedPass);
    }
/*
use JPA database to check it
 */






}
