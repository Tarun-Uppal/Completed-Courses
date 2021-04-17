package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int myIntValue = 10;
        int anotherIntValue = myIntValue;

        anotherIntValue++;
        System.out.println(myIntValue);
        System.out.println(anotherIntValue);

        int[] myIntArray = new int[5];
        int[] anotherIntArray = myIntArray;

        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherIntArray));

        anotherIntArray[0] = 1;

        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherIntArray));

        anotherIntArray = new int[]{5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(myIntArray));
        System.out.println(Arrays.toString(anotherIntArray));

    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;

            for (int i = 0; i < sortedArray.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
