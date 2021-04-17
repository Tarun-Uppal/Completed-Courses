package com.company;

class UtilitiesTest {

    private Utilities utilities = new Utilities();

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        char[] chars = new char[5];
        chars[0] = 'h';
        chars[1] = 'e';
        chars[2] = 'l';
        chars[3] = 'l';
        chars[4] = 'o';
        chars = utilities.everyNthChar(chars,2);
        System.out.println(chars);
        chars = new char[5];
        chars[0] = 'h';
        chars[1] = 'e';
        chars[2] = 'l';
        chars[3] = 'l';
        chars[4] = 'o';
        chars = utilities.everyNthChar(chars,30);
            System.out.println(chars);
    }

    @org.junit.jupiter.api.Test
    void removePairsA() {

        String string = utilities.removePairs("AABCDDEFF");
        System.out.println(string);
        System.out.println(utilities.removePairs("ABCCABDEEFF"));
        System.out.println(utilities.removePairs(null));
        System.out.println(utilities.removePairs("AA"));

    }

    @org.junit.jupiter.api.Test
    void converter() {
        System.out.println(utilities.converter(10,5));
        System.out.println(utilities.converter(10,0));
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        System.out.println(utilities.nullIfOddLength("ASDFG"));
        System.out.println(utilities.nullIfOddLength("QWER"));
    }
    @org.junit.jupiter.api.Test
    void removePairsB() {
        System.out.println(utilities.removePairs("ABCDEFF"));
        System.out.println(utilities.removePairs("AB88EFFG"));
        System.out.println(utilities.removePairs("112233445566"));
        System.out.println(utilities.removePairs("ZYQQB"));
        System.out.println(utilities.removePairs("A"));
    }
}