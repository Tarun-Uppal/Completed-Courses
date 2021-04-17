package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        InetAddress address = null;
        try {
            address = InetAddress.getByName("Tarun-Uppal");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try (Socket socket = new Socket(address,5000)){
            socket.setSoTimeout(50000);
            BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(),true);

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.print("Enter String to be echoed: ");
                echoString = scanner.nextLine();

                stringToEcho.println(echoString);
                if (!echoString.equals("exit")){
                    response = echoes.readLine();
                    System.out.println(response);
                }
            }while (!echoString.equals("exit"));

        }catch (SocketTimeoutException e){
            System.exit(0);
        }catch (UnknownHostException e) {
            System.out.println("Unkown host " + e.getMessage());
        }catch (IOException e) {
            System.out.println("IO exception " + e.getMessage());
        }
    }
}
