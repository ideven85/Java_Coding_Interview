package com.cleo.skillTest1;

public class RectangularPattern {

    //Pattern for N = 4
    //4444444
    //4333334
    //4322234
    //4321234
    //4322234
    //4333334
    //4444444

    //Sample Input :
    //3
    //Sample Output :
    //33333
    //32223
    //32123
    //32223
    //33333

    public static void innerPattern(int n)
    {
        // Pattern Size

    }

    // function to Print pattern
    public static void print(int[][] a, int size)
    {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public static void print(int n) {
        //Write your code here

        int size = 2 * n - 1;
        int front = 0;
        int back = size - 1;
        int[][] a = new int[size][size];
        while (n != 0) {
            for (int i = front; i <= back; i++) {
                for (int j = front; j <= back;
                     j++) {
                    if (i == front || i == back ||
                            j == front || j == back)
                        a[i][j] = n;
                }
            }
            ++front;
            --back;
            --n;
        }
        print(a, size);

    }
    public static void printV2(int n) {
        //Write your code here
        int s = 2 * n - 1;

        // Upper Half
        for (int i = 0;
             i < (s / 2) + 1; i++)
        {
            int m = n;

            // Decreasing part
            for (int j = 0; j < i; j++)
            {
                System.out.print(m);
                m--;
            }

            // Constant Part
            for (int k = 0;
                 k < s - 2 * i; k++)
            {
                System.out.print(n - i);
            }

            // Increasing part.
            m = n - i + 1;
            for (int l = 0; l < i; l++)
            {
                System.out.print(m);
                m++;
            }

            System.out.println();
        }

        // Lower Half
        for (int i = s / 2 - 1;
             i >= 0; i--)
        {

            // Decreasing Part
            int m = n;
            for (int j = 0; j < i; j++)
            {
                System.out.print(m);
                m--;
            }

            // Constant Part.
            for (int k = 0;
                 k < s - 2 * i; k++)
            {
                System.out.print(n - i);
            }

            // Decreasing Part
            m = n - i + 1;
            for (int l = 0; l < i; l++)
            {
                System.out.print(m);
                m++;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
printV2(4);
    }
}
