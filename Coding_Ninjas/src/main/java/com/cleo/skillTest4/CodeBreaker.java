package com.cleo.skillTest4;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class CodeBreaker {
    static Trie root;

    static class Trie {
        Trie ch[] = new Trie[26];
        int id;
        int Minval;
        boolean isEnd;

        Trie() {
            Minval = 1000001;
            isEnd = false;
            for (int i = 0; i < 26; i++)
                ch[i] = null;
            this.id = -1;
        }
    }

    static void insert(String value, int index) {
        Trie node = root;
        for (int i = 0; i < value.length(); i++) {
            int ind = value.charAt(i) - 'a';
            if (node.ch[ind] == null) {
                node.ch[ind] = new Trie();

                node.ch[ind].Minval = index;
            }

            node = node.ch[ind];
        }
        node.isEnd = true;
        if (node.id == -1)
            node.id = index;
    }

    static String search(String value, int r) {
        Trie node = root;
        String s = "";
        int ind = 0;
        for (int i = 0; i < value.length(); i++) {
            ind = value.charAt(i) - 'a';
            if (node.ch[ind] != null) {
                if (node.ch[ind].Minval <= r) {
                    s += value.charAt(i);
                } else
                    break;
            } else {
                break;

            }
            node = node.ch[ind];
        }

        while (node != null) {
            if (node.isEnd == true && node.id <= r)
                return s;
            else {
                for (int i = 0; i < 26; i++) {
                    if (node.ch[i] != null && node.ch[i].Minval <= r) {
                        node = node.ch[i];
                        s += (char) (i + 'a');
                        break;
                    }
                }
            }
        }

        return s;

    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception r) {
                    r.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception r) {
                r.printStackTrace();
            }
            return str;
        }
    }

    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) {
        FastReader in = new FastReader();
        root = new Trie();
        int n = in.nextInt();
        for (int i = 1; i <= n; i++)
            insert(in.next(), i);

        int q = in.nextInt();
        while (q-- > 0) {
            int r = in.nextInt();
            String s = in.next();
            System.out.println(search(s, r));

        }


    }

}
