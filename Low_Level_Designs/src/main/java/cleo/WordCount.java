package cleo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Counting alphabetic words in a string, removing punctuations
 */
public class WordCount {
   // private static final List<String> STOP_WORDS = Arrays.asList("i me my myself we our ours ourselves you you're you've you'll you'd your yours yourself yourselves he him his himself she she's her hers herself it it's its itself they them their theirs themselves what which who whom this that that'll these those am is are was were be been being have has had having do does did doing a an the and but if or because as until while of at by for with about against between into through during before after above below to from up down in out on off over under again further then once here there when where why how all any both each few more most other some such no nor not only own same so than too very s t can will just don don't should should've now d ll m o re ve y ain aren aren't couldn couldn't didn didn't doesn doesn't hadn hadn't hasn hasn't haven haven't isn isn't ma mightn mightn't mustn mustn't needn needn't shan shan't shouldn shouldn't wasn wasn't weren weren't won won't wouldn wouldn't".split(" "));

    public static boolean isAlpha(String s){
        //boolean b = true;
        for(char c: s.toCharArray()){
            if(!Character.isAlphabetic(c))
                return false;
        }
        return true;
    }

    private static final String FILE= Objects.requireNonNull(WordCount.class.getResource("./1.txt")).getFile();
    public static final List<String> STOP_WORDS = Arrays.stream(Objects.requireNonNull(WordCount.class.getResource("./stopwords.txt")).getFile().split(" ")).toList();

    public static void main(String[] args) throws Exception {

        System.out.println(FILE.length());
        //System.out.println(Arrays.stream(FILE.split(" ")).filter(c->c.equals("PM")).toList());
        String s = " I like  girls";
        System.out.println(Arrays.stream(s.split(" ")).filter(c->c.startsWith("girls")).toList());
        long count=0;
        var list = new ArrayList<String>();
        Set<String> legitimate = new HashSet<>();
        //Counting Lines with only alphabetic characters
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            while(br.read()!=-1){
                var line = Arrays.stream(br.readLine()
                                .split(" "))
                       .filter(c->c.length()>1 && !STOP_WORDS.contains(c) && isAlpha(c))
                        .distinct()
                        //.peek(x-> System.out.print(x + " "))
                        .toList();
                list.add(line.toString());
               legitimate.addAll(line);
            }
        }
       // list.stream().limit(5).forEach(System.out::println);
        //Total Lines-> 152317
        //Total lines without numbers and special characters->129231
        System.out.println(list.size());
        System.out.println(count);
        System.out.println("Total Legitimate words in the file:"+legitimate.stream().limit(10).toList());
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
