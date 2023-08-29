package com.cleo.revision.modernJava.ch02;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Data
@Slf4j(topic = "")
public class ExecuteAround {

    private static final String FILE = "src/main/resources/data.txt";
    @FunctionalInterface
    public interface BufferedReaderProcessor{
        String process(BufferedReader b) throws IOException;
    }

    public String processFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(FILE))){
            return p.process(br);
        }
    }

    public static void main(String[] args) throws IOException{
        ExecuteAround around = new ExecuteAround();
        String oneLine = around.processFile(BufferedReader::readLine);
        String twoLines = around.processFile((BufferedReader br )-> br.readLine() + br.readLine());
        System.out.println(oneLine);
        System.out.println(twoLines);
    }
}
