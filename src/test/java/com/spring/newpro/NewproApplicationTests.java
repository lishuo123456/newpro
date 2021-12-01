package com.spring.newpro;

import com.spring.utils.TimeUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class NewproApplicationTests {

    @Test
    void contextLoads() throws NoSuchAlgorithmException, ParseException {
        System.out.println(UUID.randomUUID().toString());
    }

}
