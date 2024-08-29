package cleo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class WordCount {

    public static boolean isAlpha(String s){
        //boolean b = true;
        for(char c: s.toCharArray()){
            if(!Character.isAlphabetic(c))
                return false;
        }
        return true;
    }

    private static final String FILE= Objects.requireNonNull(WordCount.class.getResource("./1.txt")).getFile();
    public static void main(String[] args) throws Exception {
        //InputStream inputStream = new FileInputStream(String.valueOf(Paths.get(FILE)));
        // BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));

        /*InputReader in = new InputReader(inputStream);
        int words=0;
        //Brute Force
        while(in.next()!=null){
            words++;
            in.next();
        }
        System.out.println(words);

         */
        System.out.println(FILE.length());
        //System.out.println(Arrays.stream(FILE.split(" ")).filter(c->c.equals("PM")).toList());
        String s = " I like  girls";
        System.out.println(Arrays.stream(s.split(" ")).filter(c->c.startsWith("girls")).toList());
        long count=0;
        var list = new ArrayList<String>();
        //Counting Lines with only alphabetic characters
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            while(br.read()!=-1){
                var line = Arrays.stream(br.readLine()
                                .split(" "))
                       .filter(c->c.length()>1 && isAlpha(c))
                        .distinct()
                        .peek(x-> System.out.print(x + " "))
                        .toList();
                list.add(line.toString());
                //count+=line;
            }
        }
        list.stream().limit(10).forEach(System.out::println);
        //Total Lines-> 152317
        //Total lines without numbers and special characters->129231
        System.out.println(count);
    }
    public static String processFile(WordCount.BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            return p.process(br);
        }
    }
    public interface BufferedReaderProcessor {

        String process(BufferedReader b) throws IOException;

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
