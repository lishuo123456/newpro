package com.spring.newpro;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootTest
class NewproApplicationTests {

    @Test
    void contextLoads() throws NoSuchAlgorithmException {
        String orgCode = "89003";
        String salt  = "77889910";
        String requesttime = "20211015152035";
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        String s = DigestUtils.md5Hex(orgCode+requesttime+salt);
        System.out.println(s);





    }

}
