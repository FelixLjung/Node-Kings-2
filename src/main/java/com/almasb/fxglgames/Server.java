package com.almasb.fxglgames;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket[] clients;
    private ServerSocket ss = null; // serversocket
    private DataInputStream[] in = null;  // stream

    public Server(int port, int numberOfClients) {
        clients = new Socket[numberOfClients];
        in = new DataInputStream[numberOfClients]; 
        try { // lägger in allt i ett try block ifall det strular
            ss = new ServerSocket(port);
            System.out.println("Server started");


            for (int c = 0 ; c < numberOfClients; c++) {
                System.out.println("Waiting for client nr " + c);
                clients[c] = ss.accept();
                System.out.println("Client accepted");

                in[c] = new DataInputStream(new BufferedInputStream(clients[c].getInputStream()));
            }

            System.out.println("All players have joined!");
           
            // in = new DataInputStream(
            //     new BufferedInputStream(s.getInputStream()));

            while (true) {
                try {

                    for (int c = 0; c < numberOfClients; c++) {
                        String m = in[c].readUTF();
                        System.out.println(c+m); 
                    }
   
                } catch(IOException i) {
                    System.out.println(i);
                }
            }
        }
        catch(IOException i) {
            System.out.println(i);
        }
    }
}
