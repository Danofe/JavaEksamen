package com.example.tjener;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class EksamenSettFinner {
    private String path;
    public File[] files;

    public static ArrayList<String> eksamenSett;

    public EksamenSettFinner(String path) {
        this.path = path;
    }
    public List<String> finnEksamensett() {
        File mappe = new File(path);
        files = mappe.listFiles();
        eksamenSett = new ArrayList<String>();

        if(files != null)
            for(File file : files) {
                if(file.isFile()) {
                    eksamenSett.add(file.getName());
                }
            }

        return eksamenSett;
    }
}
