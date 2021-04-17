package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Contacts Contacts =new Contacts();

    public static void main(String[] args) {

        boolean quit =false;
        int choice = 0;
        MobilePhone.printInstructions();
        while (!quit){
            System.out.print("Enter your choices: ");
            choice = scanner.nextInt();

            switch (choice){
                case 0:
                    quit = true;
                    break;
                case 1:
                    Contacts.printContact();
                    break;
                case 2:
                    System.out.print("Please enter the contact name you want to add: ");
                    String contactName = scanner.next();
                    scanner.nextLine();
                        System.out.print("Please enter the contact number you want to add: ");
                        String contactNumber = scanner.next();
                        scanner.nextLine();
                            Contacts.addContact(contactName, contactNumber);
                    break;
                case 3:
                    System.out.print("Please enter the contact name you want to change: ");
                    String contactNameToModify = scanner.next();
                    scanner.nextLine();

                    System.out.print("Please enter the contact name you want to replace: ");

                    String newContactName = scanner.next();
                    scanner.nextLine();
                   Contacts.modifyContactName(contactNameToModify, newContactName);
                    break;
                case 4:
                    System.out.print("Please enter the contact number you want to change: ");
                    String contactKaNameToModify = scanner.next();
                    scanner.nextLine();

                    System.out.print("Please enter the contact number you want to replace with the previous number: ");
                    String ContactNumberToReplace = scanner.next();
                    scanner.nextLine();
                        Contacts.modifyContactNumber(contactKaNameToModify,ContactNumberToReplace);
                    break;
                case 5:
                    System.out.print("Please enter the contact name you want to remove: ");
                    String contactNameToRemove = scanner.next();
                    scanner.nextLine();

                    Contacts.removeContact(contactNameToRemove);
                    break;
                case 6:
                    System.out.print("Please enter the contact name you want to find: ");
                    String contactNameToFind = scanner.next();
                    scanner.nextLine();

                    Contacts.toLookForContact(contactNameToFind);
                    break;
            }
        }
	}
}
