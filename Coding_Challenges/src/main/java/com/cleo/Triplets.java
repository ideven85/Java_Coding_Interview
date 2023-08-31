package com.cleo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Triplets {

    public static int findSum(int[] first, int[] second, int[] third){
        Arrays.sort(first);
        Arrays.sort(second);
        Arrays.sort(third);
        int sum1=0,sum2=0,sum=0;
        int min = Math.min(first.length,Math.min(second.length,third.length));
        for (int i = 0; i < min; i++) {

            if(first[i]<=second[i])
                sum1=first[i]+second[i];
            if(third[i]<second[i])
                sum2=second[i]+third[i];
            sum+=sum1*sum2;
        }
        return sum;
    }
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        int firstLength = in.nextInt();
        int secondLength = in.nextInt();
        int thirdLength = in.nextInt();
        int[] first = new int[firstLength];


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
