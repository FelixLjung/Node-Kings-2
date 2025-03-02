package com.almasb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.almasb.fxgl.entity.Entity;

public class UI {
    private Socket s = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    public UI(Socket s, DataInputStream in, DataOutputStream out) {
        this.s = s;
        this.in = in;
        this.out = out;

    }
    public static void NextTurn(Entity player) {
        
    }
}
