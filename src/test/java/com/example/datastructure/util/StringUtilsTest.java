package com.example.datastructure.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void generateRandomString() {
        System.out.println(StringUtils.generateRandomString());
        System.out.println(Arrays.toString(StringUtils.generateRandomStringArr()));
        System.out.println(StringUtils.generateRandomName());
        System.out.println(Arrays.toString(StringUtils.generateRandomNameArr()));
    }
}