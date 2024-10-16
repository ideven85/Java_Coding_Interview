package mit.reading3;

public class HailStone {
        public static void main(String[] args) {
            int n = 1;
            while (n != 1) {
                if (n % 2 == 0) {
                    n = n / 2;
                    System.out.print(n + " ");
                } else {
                    n = 3 * n + 1;
                    System.out.print(n + " ");
                }
            }
           // System.out.println(n);
        }

    }

