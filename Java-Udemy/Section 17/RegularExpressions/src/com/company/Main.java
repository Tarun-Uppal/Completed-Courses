package com.company;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string , yes I am";
        System.out.println(string);
        String yourString = string.replaceAll("I","you");
        System.out.println(yourString);

        String alphaNumeric = "abcDeeF12Ghhiiiijkl99z";
        System.out.println(alphaNumeric.replaceAll(".","y"));

        System.out.println(alphaNumeric.replaceAll("^abcDee","YYY"));

        String secondString = "abcDeeF12abcDeeGhhiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDee","YYY"));

        System.out.println(alphaNumeric.matches("^hello"));
        System.out.println(alphaNumeric.matches("^abcDee"));
        System.out.println(alphaNumeric.matches("abcDeeF12Ghhiiiijkl99z"));

        System.out.println(alphaNumeric.replaceAll("ijkl99z$","THE END"));
        System.out.println(alphaNumeric.replaceAll("[aei]","X"));
        System.out.println(alphaNumeric.replaceAll("[aei]","I replaced this letter"));
        System.out.println(alphaNumeric.replaceAll("[aei][Fj]", "X"));
        System.out.println("harry".replaceAll("[Hh]arry","Harry"));

        String newAlphaNumeric = "abcDeeF12Ghhiiiijkl99z";

        System.out.println(newAlphaNumeric.replaceAll("[^ej]","x"));
        System.out.println(newAlphaNumeric.replaceAll("[abcdef345678]","X"));
        System.out.println(newAlphaNumeric.replaceAll("[a-fA-F3-8]","X"));
        System.out.println(newAlphaNumeric.replaceAll("(?i)[a-f3-8]","X"));
        System.out.println(newAlphaNumeric.replaceAll("[0-9]","X"));
        System.out.println(newAlphaNumeric.replaceAll("\\d","X"));
        System.out.println(newAlphaNumeric.replaceAll("\\D","X"));


        String hasWhiteSpace = "I have blanks and\ta tab,and also a new line\n";
        System.out.println(hasWhiteSpace);
        System.out.println(hasWhiteSpace.replaceAll("\\s",""));
        System.out.println(hasWhiteSpace.replaceAll("\t","x"));
        System.out.println(hasWhiteSpace.replaceAll("\\S",""));

        System.out.println(newAlphaNumeric.replaceAll("\\w","X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w","X"));

        System.out.println(hasWhiteSpace.replaceAll("\\b","X"));

        String thirdAlphaNumericString =alphaNumeric;
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe{2}","YYY"));
        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe+","YYY"));

        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe*","YYY"));


        System.out.println(thirdAlphaNumericString.replaceAll("^abcDe{2,5}","YYY"));
        System.out.println(thirdAlphaNumericString.replaceAll("h+i*j","Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>sub-heading</h2>");
        htmlText.append("<p>this is a paragraph about something</p>");
        htmlText.append("<p>this is another paragraph about something else</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>here is the summary.</p>");

        String h2Pattern = "(<h2>)";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count = 0;
        while (matcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        matcher.reset();

        int groupCount = 0;
        while (groupMatcher.find()){
            groupCount++;
            System.out.println("Occurrence " +  groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while (h2TextMatcher.find()){
            System.out.println("Occurrence " + h2TextMatcher.group(2));
        }

        System.out.println("harry".replaceAll("[H|h]arry","Larry"));
        System.out.println("Harry".replaceAll("[H|h]arry","Larry"));

        String tvTest = "tstvtkt";
//        String tNotVRegExpression = "t[^v]";
        String tNotVRegExpression = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExpression);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);
        count = 0;
        while (tNotVMatcher.find()){
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        String phone1 = "1234567890";
        String phone2 = "(123) 456-7890";
        String phone3 = "123 456-7890";
        String phone4 = "(123)456-7890";


        System.out.println("Phone 1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("Phone 2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("Phone 3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("Phone 4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));


        String visa1 = "4444444444444";
        String visa2 = "5444444444444";
        String visa3 = "4444444444444444";
        String visa4 = "4444";

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));





    }
}
