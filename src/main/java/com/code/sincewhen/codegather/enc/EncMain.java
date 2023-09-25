package com.code.sincewhen.codegather.enc;

import org.jasypt.util.text.BasicTextEncryptor;
public class EncMain {
    public static void main(String[] args) {
        EncMain enc = new EncMain();
        System.out.println(enc.encrypt("root","salt"));
        System.out.println(enc.decrypt("lXm7VhDYU3clyeu35iBYRg==","salt"));
    }

    /**
     *
     * @param source
     * @param salt
     * @return
     */
    public String encrypt(String source,String salt) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(salt);
        return textEncryptor.encrypt(source);
    }

    /**
     *
     * @param source
     * @param salt
     * @return
     */
    public String decrypt(String source,String salt) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(salt);
        return textEncryptor.decrypt(source);
    }
}
