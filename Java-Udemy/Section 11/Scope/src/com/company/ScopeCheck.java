package com.company;

public class ScopeCheck {
    public int publicVar = 0;
    private int var1 = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + " privateVar= " + var1);
    }

    public int getVar1() {
        return var1;
    }

    public void timeTwo(){
        int privateVar = 2;
        for (int i=0;i<10;i++){
            System.out.println(i + " times two is " + i * privateVar);
        }
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("var 3 from outer class " + innerClass.var3);
    }

    public class InnerClass{
        private int var3 = 3;

        public InnerClass() {
            System.out.println("InnerClass created , private var is  " + var3);
        }

        public void timeTwo(){
            for (int i=0;i<10;i++){
                System.out.println(i + " times two is " + i * var3);
            }
        }
    }
}
