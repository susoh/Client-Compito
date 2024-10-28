package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Hello world!");
        Socket mySocket = new Socket("127.0.0.1", 3645);

        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream());
        String outputString;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Inserisci la stringa: ");
            outputString = sc.nextLine();
            out.writeBytes(outputString + "\n");
            String stringInput = in.readLine();
            System.out.println("stringa ricevuta: " + stringInput);
        } while (!outputString.equals("!"));
        System.out.println("Chiusura della connessione a seguito di invio di ! o di un'eccezzione");
        sc.close();
        mySocket.close();

    }
}