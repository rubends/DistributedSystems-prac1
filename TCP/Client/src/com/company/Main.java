package com.company;

import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws Exception {
        //D:\Ruben\Documents\EI\3-Distributed systems\Practica\labo2-10.dockx
        int serverPort = 7896;
        String host = "localhost";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file name: ");
        System.out.flush();
        String filename = scanner.nextLine();
        File file = new File(filename);

        Socket clientSocket = new Socket(host, serverPort);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        byte[] fileArray = Files.readAllBytes(file.toPath());
        outToServer.write(fileArray);
        System.out.println("FROM SERVER: " + inFromServer.readLine());
        clientSocket.close();
    }
}
