package com.cleo.revision.asynchannels;



import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


@Slf4j
public class FileReading {

    public static void main(String[] args) {
        try {
            String path =System.getProperty("user.dir")+"/src/main/resources/data.txt";

            try(FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.txt"); ZipOutputStream zip = new ZipOutputStream(new FileOutputStream("data.zip"));FileInputStream fileToZip = new FileInputStream(new File(path))){
                System.out.println(fis.toString());
                ZipEntry zipEntry = new ZipEntry(new File(System.getProperty("user.dir")+"/src/main/resources/data.txt").getName());
                zip.putNextEntry(zipEntry);
                byte[] bytes = new byte[1024];
                int length;
                while((length=fis.read(bytes))>=0){
                    zip.write(bytes,0,length);

                }
                log.info("File zipped with name: "+   zipEntry.getName());
            }

            BufferedReader br = new BufferedReader(new FileReader(path));
            File file = new File(path);
            System.out.println(file.getPath());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
