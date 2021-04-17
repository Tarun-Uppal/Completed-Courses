package com.company;

public class Main {

    public static void main(String[] args) {
        int[] Arrays = new int[]{2,4,7,9,8,100,335,66,7887,20};
        Arrays=reverse(Arrays);
        for (int i=0;i < Arrays.length;i++){
            System.out.println(Arrays[i]);
        }
    }

//    public static int[] reverse(int[] array) {
//        int[] sortedArray = Arrays.copyOf(array, array.length);
//        int temp;
//
//            for (int i = 0; i < sortedArray.length - 1; i++) {
//                temp = sortedArray[i];
//                sortedArray[i] = sortedArray[i + 1];
//                sortedArray[i + 1] = temp;
//
//            }
//         return sortedArray;
//    }

    public static int[] reverse(int a[]) {
        int[] b = new int[a.length];
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }

        return b;
    }

}
