package com.cleo.test7;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class BobAndHisString {

        private static int maxCharactersBetweenSameCharacters(String s) {
            // Map<Character,Integer> map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i)) == false) {
                    map.put(s.charAt(i), i);
                } else {
                    int distance = i - map.get(s.charAt(i));
                    if (distance > max) {
                        max = distance;
                    }
                }
            }
            if (max == Integer.MIN_VALUE) {
                return -1;
            } else {
                return max - 1;
            }
        }


        public static void main(String[] args) {
            /* Your class should be named Main.
             * Read input as specified in the question.
             * Print output as specified in the question.
             */

            // Write your code here
            InputStream inputStream = System.in;
            InputReader in = new InputReader(inputStream);
            int N = in.nextInt();
            while(N-->0){
                String s = in.next();
                System.out.println(maxCharactersBetweenSameCharacters(s));
            }

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


