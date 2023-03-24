package tests;

import org.apache.commons.lang3.RandomStringUtils;

public class test {
    public static String generatingRandomString(int length) {
//        boolean useLetters = true;
//        boolean useNumbers = false;
//        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        return RandomStringUtils.random(length);
    }

    public static void main(String[] args) {

    }
}
