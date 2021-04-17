package com.company;

public class StringUtilities {
    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder,char c){
        sBuilder.append(c);
        charsAdded++;
    }

    public String upperAndPrefix(String string){
        return "Prefix_" + string;
    }

    public String addSuffix(String str){
        return str + "_Suffix";
    }

}
