package com.cleo.revision.asynchannels;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class LoadData {

    public static void main(String[] args) {
        int width=3024/2;
        int height = 3780/2;
        BufferedImage image = null;
        try{
            File input_file = new File("resources/img/Deven.jpeg");
            image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(input_file);
            System.out.println("Read input file:" + input_file.getName());

        }catch (IOException ie){
            ie.printStackTrace();
        }
        try{
            File output = new File("resources/static/Deven.png");
            ImageIO.write(image,"png",output);
            System.out.println("Wrote File");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
