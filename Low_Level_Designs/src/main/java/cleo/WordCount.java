package cleo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class WordCount {
    private static final String FILE= Objects.requireNonNull(WordCount.class.getResource("./rural.txt")).getFile();
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

        long count=0;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            while(br.readLine()!=null){
                var line = Arrays.stream(br.readLine()
                                .split(" "))
                        .count();
                count+=line;
            }
        }
        System.out.println(count);
    }
    public static String processFile(modernjavainaction.chap03.WordCount.BufferedReaderProcessor p) throws IOException {
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
