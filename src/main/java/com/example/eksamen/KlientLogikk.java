package com.example.eksamen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class KlientLogikk {
    private Socket clientSocket;
    public List<String> hentEksamensSett(String tjenerAdresse, int tjenerPort) {
        try {
            clientSocket = new Socket(tjenerAdresse, tjenerPort);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Klienten er koblet til tjeneren");


            String examSetString = in.readLine();


            List<String> examSetList = Arrays.asList(examSetString.split(","));

            return examSetList;
        } catch (IOException e) {
            System.out.println("Feil ved oppkobling til tjener: " + e.getMessage());
        }

        return null;
    }
}