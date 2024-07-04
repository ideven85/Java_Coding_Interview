package com.cleo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        Gson gson = new Gson();
        try(Reader reader = new FileReader("Steve_Jones.json")) {
            Staff staff = gson.fromJson(reader, Staff.class);
            System.out.println(staff);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}