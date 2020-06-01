package com.aaa.shiro;

import com.aaa.util.MyConstants;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.util.DigestUtils;

import java.util.UUID;


public class ShiroUtil {

    public static  String getciphertext(String phertext){
        String ciphertext = DigestUtils.md5DigestAsHex(phertext.getBytes());
        return ciphertext;
    }


    public static String  encryptionBySalt(String salt,String message){
        //String algorithmName 加密算法, Object source 明文, Object salt 盐值, int hashIterations 加密次数
        String algorithmName= MyConstants.algorithmName;
        int hashIterations=MyConstants.hashIterations;
        SimpleHash simpleHash=new SimpleHash(algorithmName,message,salt,hashIterations);
        return simpleHash.toString();
    }

    public static void main(String[] args) {
        String message="123456";
        String s = getciphertext(message);
        System.out.println(s);

        String salt= "9ed6610c-6132-4d0c-a8a4-5011080ba754";

        String encryption = encryptionBySalt(salt, message);
        System.out.println(encryption);

    }
}
