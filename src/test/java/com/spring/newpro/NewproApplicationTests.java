package com.spring.newpro;

import com.spring.utils.TimeUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
class NewproApplicationTests {

    @Test
    void contextLoads() throws NoSuchAlgorithmException {
        int max = 59;
        int min = 0;
        Random random = new Random();

        int s = random.nextInt(max)%(max-min+1) + min;
        String s1 = String.valueOf(s);
        String s2=s1;
        if(s1.length()==1){
            s2 = "0"+s1;
        }

        System.out.println(s2);

    }

}
