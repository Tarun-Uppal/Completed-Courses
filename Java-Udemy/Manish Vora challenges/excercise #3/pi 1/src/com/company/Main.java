package com.company;

import javax.lang.model.element.AnnotationMirror;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a number");
        int number = scanner.nextInt();
        scanner.close();
        double sum = 0;
        double pi=0;
        for (int i = 0; i < number; i++) {
            sum += Math.pow(-1, i) / (2 * i + 1);

        }
        pi = sum * 4;
        System.out.println(pi);
    }
}
