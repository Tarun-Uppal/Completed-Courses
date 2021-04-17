package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4));
    }

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        int bigCountPerKg = bigCount * 5;
        int smallCountPerKg = smallCount * 1;
        int requiredbigCount = bigCountPerKg-goal / 5;
        int requiredsmallCount = smallCountPerKg - goal % 5;
        int requiredgoal = requiredbigCount - requiredsmallCount;

        if ((bigCount >= 0) && (smallCount >= 0) && (goal >= 0)) {
            if (requiredgoal == 0) {
                return true;
            }
            if(requiredgoal>0){
                if(goal%5!=0){
                    bigCount--;
                    requiredbigCount = bigCountPerKg-goal / 5;
                    requiredsmallCount = smallCountPerKg - goal % 5;
                    requiredgoal = requiredbigCount - requiredsmallCount;
                    if(requiredgoal>=0){
                        return true;
                    }
                    else{
                        return false;
                    }


                }
                else{
                    return false;
                }
            }

        }
        return false;
    }
    public static boolean canPack(int bigCount, int  smallCount, int goal) {
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }
        int actualBigCount = 0;
        int actualSmallCount = 0;
        int requiredBigCount = goal / 5;

        if (requiredBigCount <= bigCount) {
            actualBigCount = requiredBigCount;
        } else {
            actualBigCount = bigCount;
        }

        int requiredSmallCount = goal - (actualBigCount * 5);

        if (requiredSmallCount <= smallCount) {
            actualSmallCount = requiredSmallCount;
        } else {
            actualSmallCount = smallCount;
        }

        if ((actualBigCount * 5) + actualSmallCount == goal) {
            return true;
        }

        return false;
    }

}
