package com.cleo.fullTest3;

import java.util.Scanner;

public class Calculator {
    public static int findMin(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            if (Y % 2 == 1)
                Y++;
            else
                Y /= 2;
        }
        return ans + X - Y;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(findMin(x,y));
    }
}
