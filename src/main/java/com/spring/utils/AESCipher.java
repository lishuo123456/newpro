package com.spring.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;
import java.util.UUID;

import static javax.crypto.Cipher.getInstance;


public class AESCipher {

        private static final String IV_STRING = "bef1075ODfADd5ac";
        private static final String charset = "UTF-8";

        public static String en(String content, String key) {
            try {
                byte[] contentBytes = content.getBytes(charset);
                byte[] keyBytes = key.getBytes(charset);
                byte[] encryptedBytes = aesEncryptBytes(contentBytes, keyBytes);
                Base64.Encoder encoder = Base64.getEncoder();

                return encoder.encodeToString(encryptedBytes);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static String de(String content, String key)  {
            try {
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] encryptedBytes = decoder.decode(content);
                byte[] keyBytes = key.getBytes(charset);
                byte[] decryptedBytes = aesDecryptBytes(encryptedBytes, keyBytes);
                return new String(decryptedBytes, charset);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static byte[] aesEncryptBytes(byte[] contentBytes, byte[] keyBytes)  {
            return cipherOperation(contentBytes, keyBytes, Cipher.ENCRYPT_MODE);
        }

        public static byte[] aesDecryptBytes(byte[] contentBytes, byte[] keyBytes) {
            return cipherOperation(contentBytes, keyBytes, Cipher.DECRYPT_MODE);
        }

        private static byte[] cipherOperation(byte[] contentBytes, byte[] keyBytes, int mode) {

            try {

                SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

                byte[] initParam = IV_STRING.getBytes(charset);
                IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);

                Cipher cipher = getInstance("AES/CBC/PKCS5Padding");
                cipher.init(mode, secretKey, ivParameterSpec);

                return cipher.doFinal(contentBytes);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (InvalidAlgorithmParameterException e) {
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            }
            return null;

        }

        public static String getKey() {
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            StringBuffer buff = new StringBuffer();
            buff.append(uuid).append(IV_STRING).append(uuid).append(IV_STRING);
            Random random = new Random();
            int start = random.nextInt(buff.length());
            int end = (start + 16) < buff.length() ? start + 16 : start - 16;
            if (end > start) {
                return buff.substring(start, end);
            }
            return buff.substring(end, start);
        }

    }

