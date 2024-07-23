package com.cleo.revision.old.forkJoin;

import org.apache.commons.io.Charsets;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Decompressing {

    public static void main(String[] args) throws IOException {
        GZIPInputStream inputStream = new GZIPInputStream(new FileInputStream(Paths.get("data.txt.gz").toFile()));
        GZIPOutputStream outputStream = new GZIPOutputStream(new FileOutputStream("data2.txt"));
        outputStream.write(inputStream.readAllBytes());
       // new GZIPOutputStream(new FileOutputStream("data1.txt")).write(inputStream.readAllBytes());
        //outputStream.write(inputStream.readAllBytes());
    }
}
