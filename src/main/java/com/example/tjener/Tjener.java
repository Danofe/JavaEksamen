package com.example.tjener;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

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
                
            }


        } catch(IOException e) {
            System.out.println("Feil med oppstart av Eksamenstjener: " + e.getMessage());
        }
    }
}
