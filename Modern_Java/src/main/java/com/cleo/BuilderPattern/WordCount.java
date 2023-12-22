package com.cleo.BuilderPattern;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.StringTokenizer;

public class WordCount {

  //  private static final String FILE= Objects.requireNonNull(WordCount.class.getResource("ch01/rural.txt")).getFile();
    public static void main(String[] args) throws FileNotFoundException {

        try {
            Path path = Path.of(("python.mp4"));
            File python=path.toFile();
            try(BufferedReader reader=new BufferedReader(new FileReader(python))){

            }
            FileTime creationTime = (FileTime) Files.getAttribute(path, "creationTime");
            System.out.println(creationTime);
        }catch (Exception e){
            e.printStackTrace();
        }
      /*  InputStream inputStream = new FileInputStream(String.valueOf(Paths.get(FILE)));
        InputReader in = new InputReader(inputStream);
        int words=0;
        //Brute Force
        while(in.next()!=null){
            words++;
            in.next();
        }
        System.out.println(words);
*/
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
}
