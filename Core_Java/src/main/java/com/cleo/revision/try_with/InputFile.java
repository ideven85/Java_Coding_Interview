package com.cleo.revision.try_with;

import java.io.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.StringTokenizer;


public class InputFile {

    public static String firstLineOfFile(InputStream path) throws IOException{
        /*if(path==null){
            System.out.print("Nothing Found ");
            return path.toString();
        }*/
        System.out.println(" ");
       InputReader reader = new InputReader(new BufferedInputStream(path));
       if(reader!=null) {
           return reader.next();
       }else{
           System.out.print(path.read()+" ");
       }
       return "hi";
    }
   static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
    public static String getDataFromFileC() throws IOException {
        String file = System.getProperties().get("user.dir").toString()+"/resources/hi.js";
        File f = new File(file);
        //boolean b =f.createNewFile();
        //LocalDateTime time = LocalDateTime.now().toLocalDate().;
       var  d = LocalDate.of(2001,1,3);
        Date date = new Date();
        var m=date.toInstant().getEpochSecond();
        System.out.println(m);
        boolean x=f.setLastModified(m);
        System.out.println("Changed modification time:"+x);

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.read() != -1) {
                System.out.println(reader.readLine());
            }
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return "Done";

    }
    public static void main(String[] args)  throws IOException {

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        //InputStream in = new BufferedInputStream(classloader.getResourceAsStream("resources/hi.js"));
        //System.out.print(in.readAllBytes()+" ");

        System.out.print(getDataFromFileC()+" ");;

    }


}
