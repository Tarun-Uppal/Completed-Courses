package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String challenge1 = "I want a bike.";
        System.out.println("Challenge 1 matches = "+challenge1.matches("I want a bike."));

        String regEXp = "I want a \\w+.";
        System.out.println(challenge1.matches(regEXp));
        String challenge2 = "I want a ball.";
        System.out.println(challenge2.matches(regEXp));

        Pattern challenge3Pattern =Pattern.compile(regEXp);
        Matcher challenge3Matcher = challenge3Pattern.matcher(challenge1);
        System.out.println(challenge3Matcher.matches());
        challenge3Matcher = challenge3Pattern.matcher(challenge2);
        System.out.println(challenge3Matcher.matches());

        String challenge4 = "Replace all the blanks with underscores.";
        challenge4 = challenge4.replaceAll(" ","_");
        System.out.println(challenge4);

        String challenge5 = "aaabcccccccccddefffg";
        System.out.println(challenge5.matches("aaabcccccccccddefffg$"));

        String challenge7 = "abcd.135";
        System.out.println("55.12a".toLowerCase().matches("[a-z]*.[1-9]*$"));
        System.out.println("kjisl.22".toLowerCase().matches("[a-z]*.[1-9]*$"));
        System.out.println(challenge7.toLowerCase().matches("[a-z]*.[1-9]*$"));


        String challenge8 = "abcd.135uvqz.7tzik.999";
        Pattern pattern8 = Pattern.compile("[a-zA-Z]+\\.(\\d+)");
        Matcher matcher8 = pattern8.matcher(challenge8);

        while (matcher8.find()){
            System.out.println("Occourence : " + matcher8.group(1));
        }

        System.out.println("********************");

        String challenge9 = "abcd.135\tuvaqz.7\ttzik.999\n";
        Pattern pattern9 = Pattern.compile("[a-zA-Z]+\\.(\\d+)+\t");
        Matcher matcher9 = pattern9.matcher(challenge9);

        while (matcher9.find()){
            System.out.println("Occourence : " + matcher9.group(1));
        }

        Pattern pattern9pt2 = Pattern.compile("[a-zA-Z]+\\.(\\d+)+\n");
        Matcher matcher9pt2 = pattern9pt2.matcher(challenge9);

        while (matcher9pt2.find()){
            System.out.println("Occourence : " + matcher9pt2.group(1));
        }

        String challenge10 = "abcd.135\tuvaqz.7\ttzik.999\n";
        Pattern pattern10 = Pattern.compile("[a-zA-Z]+\\.(\\d+)+\\s");
        Matcher matcher10 = pattern10.matcher(challenge10);

        int count = 0;
        while (matcher10.find()){
            count++;
            System.out.println("Occourence : " + count + " : "+ matcher10.start(1) + " to " + matcher10.end(1));
        }


        String challenge11 = "{0,2},{0,5},{1,3},{2,4}";
        Pattern pattern11 = Pattern.compile("\\{[+0-9]\\,[+0-9]\\}");
        Matcher matcher11 = pattern11.matcher(challenge11);

        count = 0;
        while (matcher11.find()){
            count++;
            System.out.println("Occourence : " + matcher11.group().
                    replaceAll("\\{","").replaceAll("\\}",""));
        }

        System.out.println("===============");

        String challenge12 = "11111";
        System.out.println(challenge12.matches("^[0-9]{5}$"));

        String challenge13 = "11111-1111";
        System.out.println(challenge13.matches("^[0-9]{5}-[0-9]{4}$"));

        String challenge14 = "11111-1111";
        System.out.println(challenge14.matches("(^[0-9]{5}-[0-9]{4}$)|(^[0-9]{5}$)"));
    }
}
