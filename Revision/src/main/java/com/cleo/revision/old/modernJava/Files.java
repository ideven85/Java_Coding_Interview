package com.cleo.revision.old.modernJava;


import java.io.File;
import java.io.FileFilter;
import java.util.List;


public class Files {

    //Making du-ak
    public static void main(String[] args) {
        File[] files = new File(System.getProperty("user.home")+"/Developer").listFiles(File::exists);

        
        assert files!=null;
        System.out.println(List.of(files));
        //log.info(List.of(files)+" ");
        System.out.println();

        var file = new File(".").listFiles(File::isDirectory);
        if(file!=null)
            System.out.println(List.of(file));
    }
}
