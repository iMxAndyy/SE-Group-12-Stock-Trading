package com.company;


import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        Socket clientSocket = new Socket("192.168.0.108",5000);

        while(true)
        {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        }
    }

}
