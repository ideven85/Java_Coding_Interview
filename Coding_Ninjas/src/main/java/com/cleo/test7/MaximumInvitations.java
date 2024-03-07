package com.cleo.test7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

public class MaximumInvitations {
    private static int perimeter(int width, int height){
        return width*2+height*2;
    }
    private static int calculateMaxAreaOfTable(char[][] room, int n, int m) {
        int[] count = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == '.') {
                    count[j]++;
                } else {
                    count[j] = 0;
                }

            }
            for (int j = 0; j < m; j++) {
                int h = count[j];
                int w = 1;
                if (h > 0) {
                    for (int k = j + 1; k < m; k++) {
                        if (count[k] < h)
                            break;
                        w++;

                    }
                    for (int k = j - 1; k > 0; k--) {
                        if (count[k] < h)
                            break;
                        w++;
                    }
                }
                max = Math.max(max, perimeter(w,h));
            }

        }
        return max - 1;

    }

    public static void main(String[] args) {
        /* Your class should be named Main.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */

        // Write your code here
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        int n = in.nextInt();
        int m= in.nextInt();
      char[][] room=new char[n][m];
        for (int i = 0; i < n; i++) {
           room[i]=in.next().toCharArray();
        }
        System.out.println(calculateMaxAreaOfTable(room,n,m));



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
