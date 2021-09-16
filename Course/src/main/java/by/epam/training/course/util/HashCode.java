package by.epam.training.course.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashCode {

    public static final String getHash(String value) {
        String hash = "";
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] input = value.getBytes("UTF-8");
            byte[] result = messageDigest.digest(input);
            hash = bytesToHex(result);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            
        }
        return hash;
    }
    
    private static final String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}