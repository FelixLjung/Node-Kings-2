package com.almasb.fxglgames;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    public Client(String addr, int port) {
        try {
            s = new Socket(addr, port);
            System.out.println("Connected!");
            
            in = new DataInputStream(System.in);

            // Sends output to the socket
            out = new DataOutputStream(s.getOutputStream());

        } 

        catch(UnknownHostException u) {
            System.out.println(u);
            return;
        } 
        catch(IOException e) {
            System.out.println(e);
            return;
        }

    }

    public void NextTurn() {
        try {
            String message = "Client says hi!";
            out.writeUTF(message);
        } catch (IOException i) {
            System.out.println(i);
        }
    }



}
