package com.cleo.revision.old.java_coding_problems;

import java.io.File;
import java.util.Arrays;

public class ListingFiles {

    public static void main(String[] args) {

        var files = new File(System.getProperty("java.io.tmpdir")).listFiles(File::isDirectory);
        assert files != null;
        for(var e:files){
            if(e.isDirectory()){
                System.out.print(Arrays.toString(e.listFiles())+ " ");
            }else
                System.out.println(e);
        }
        System.out.println(Arrays.toString(files));

    }
}
