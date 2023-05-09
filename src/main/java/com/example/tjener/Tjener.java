package com.example.tjener;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


public class Tjener {
    private int port;

    public Tjener(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Eksamenstjener startet på port" + port);

            while (true) {
                Socket klientSocket = serverSocket.accept();
                System.out.println("Eksamensklient tilkoblet");


                sendArray(klientSocket);
            }

        } catch (IOException e) {
            System.out.println("Feil med oppstart av Eksamenstjener: " + e.getMessage());
        }
    }

    private void sendArray(Socket klientSocket) {
        EksamenSettFinner finn = new EksamenSettFinner("src/main/java/com/example/tjener/eksamensett");
        List<String> eksamenSettList = finn.finnEksamensett();

        try {
            PrintWriter out = new PrintWriter(klientSocket.getOutputStream(), true);
            String examSetString = String.join(",", eksamenSettList);
            out.println(examSetString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}