package com.bc.lottery.common.util;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringEncryptUtils {
    /**
     * 对字符串加密,加密算法使用MD5,SHA-1,SHA-256,默认使用SHA-256
     *
     * @param strSrc
     *            要加密的字符串
     * @param encName
     *            加密类型
     * @return
     */
    public static String encrypt(String strSrc, String encName) {
        try {
            if (encName == null || encName.equals("")) {
                encName = "SHA-256";
            }
            MessageDigest md = MessageDigest.getInstance(encName);
            md.update(strSrc.getBytes());
            return bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }

    public static void main(String args[]){
        String str = "汪业培sdfsdfsed";
        String s= StringEncryptUtils.encrypt(str, "MD5");
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(DigestUtils.md5DigestAsHex(str.getBytes()));
    }
}
