package com.cleo.revision.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Salting {

    private static byte[] createSalt(){
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return salt;
    }

    private static String getSecurePassword(String passwordToHash, byte[] generatedSalt){
        String generatedPassword=null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(generatedSalt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString(( aByte & 0xff ) + 0x100, 16).substring(1));
            }
            generatedPassword=sb.toString();
        }catch (NoSuchAlgorithmException ne){
            ne.printStackTrace();
        }
        return generatedPassword;
    }
    public static void main(String[] args) {
        String passwordToHash="My_Password";
        byte[] salt = createSalt();
        String securePassword = getSecurePassword(passwordToHash,salt);
        System.out.println(securePassword);
    }
}
