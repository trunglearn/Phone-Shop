/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author ACERR
 */
public class EncodePass {

    public static String EncodeMD5(String str) {
        byte[] defaultBytes = str.getBytes();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String hex = Integer.toHexString(0xFF & messageDigest[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            str = hexString + "";
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String toSHA1(String str) {
        String salt = "asjrlkmcoe&^%$^%%fsd&sfddsfsdfsdsd';das;f;fasq';eqw1jurVn";// Làm cho mật khẩu phức tap
        String salt1 = "gfdfvxcvbcndfb$%^&*fssdfewqw1jurVn";// Làm cho mật khẩu phức tap
        String result = null;

        str = str + salt + salt1;
        try {
            byte[] dataBytes = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = Base64.encodeBase64String(md.digest(dataBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
