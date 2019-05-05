package com.bc.lottery.common.util;

import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class TokenUtils {

    public static String generateValue() {
        String uuid = UUID.randomUUID().toString();
        return DigestUtils.md5DigestAsHex(uuid.getBytes());
    }

}
