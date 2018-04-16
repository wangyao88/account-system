package com.sxkl.webapp.logincenter.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * Created by wangyao
 * Date 2017/12/4.
 */
public class DESUtil {

    private static final String sKey = "des@#$12";;

    private static Cipher makeCipher() throws Exception{
        return Cipher.getInstance("DES");
    }

    private static SecretKey makeKeyFactory() throws Exception{
        SecretKeyFactory des = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = des.generateSecret(new DESKeySpec(sKey.getBytes()));
        return secretKey;
    }

    public static String encrypt(String text){
        try{
            Cipher cipher = makeCipher();
            SecretKey secretKey = makeKeyFactory();
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return new String(Base64.encodeBase64(cipher.doFinal(text.getBytes())));
        }catch(Exception e){
            return "";
        }
    }

    public static String decrypt(String text) throws Exception{
        try{
            Cipher cipher = makeCipher();
            SecretKey secretKey = makeKeyFactory();
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.decodeBase64(text.getBytes())));
        }catch(Exception e){
            return "";
        }
    }
}
