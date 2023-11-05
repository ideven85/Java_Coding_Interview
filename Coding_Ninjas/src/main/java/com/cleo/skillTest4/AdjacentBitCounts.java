package com.cleo.skillTest4;

import java.util.Scanner;

public class AdjacentBitCounts {
    /*code in c++ *****************************************************

#include <iostream>
using namespace std;
typedef long long ll;
#define m 1000000007
ll dp[101][101][2];
ll f(int n, int k, int start)
{
    if (dp[n][k][start] >= 0)
    {
        return dp[n][k][start];
    }
    if (n == 1)
    {
        if (k == 0)
        {
            dp[n][k][start] = 1;
            return 1;
        }
        else
        {
            dp[n][k][start] = 0;
            return 0;
        }
    }
    if (k < 0)
    {
        dp[n][k][start] = 0;
        return 0;
    }
    if (start == 1)
    {
        ll sum1 = f(n - 1, k - 1, 1);
        ll sum2 = f(n - 1, k, 0);
        dp[n][k][start] = (sum1 + sum2) % m;
    }
    else
    {
        ll sum1 = f(n - 1, k, 1) % m;
        ll sum2 = f(n - 1, k, 0) % m;
        dp[n][k][start] = (sum1 + sum2) % m;
    }
    return dp[n][k][start];
}
ll adjbc(int n, int k)
{
    ll sum1 = f(n, k, 1) % m;
    ll sum2 = f(n, k, 0) % m;
    return (sum1 + sum2) % m;
}
int main()
{
    int p;
    cin >> p;
    for (int i = 0; i <= 101; i++)
    {
        for (int j = 0; j <= 101; j++)
        {
            for (int k = 0; k < 2; k++)
            {
                dp[i][j][k] = -1;
            }
        }
    }
    while (p--)
    {
        int dataset_number, n, k;
        cin >> dataset_number >> n >> k;
        cout << dataset_number << " " << adjbc(n, k) << endl;
    }
    return 0;
}

     */
    /*
* For a string of n bits x1, x2, x3, …, xn the adjacent bit count of the string (AdjBC(x)) is given by



 x1x2 + x2x3 + x3x4 + … + xn-1xn



which counts the number of times a 1 bit is adjacent to another 1 bit. For example:



AdjBC(011101101) = 3

AdjBC(111101101) = 4

AdjBC(010101010) = 0

Write a program which takes as input integers n and k and returns the number of bit strings x of n bits (out of 2ⁿ) that satisfy AdjBC(x) = k. For example, for 5 bit strings, there are 6 ways of getting AdjBC(x) = 2:



11100, 01110, 00111, 10111, 11101, 11011



Input: A decimal integer giving the number (n) of bits in the bit strings, and a decimal integer (k) giving the desired adjacent bit count. The number of bits (n) will not be greater than 100 and the parameters n and k will be chosen so that the result will fit in a signed 32-bit integer.


Output: the number of n-bit strings with adjacent bit count equal to k.

    O(n ^ 2)
    O(n ^ 2)
* */



        public static int getAdjBCStringCountDP(int n, int k) {
            int[][] rightZero = new int[n + 1][k + 1];
            int[][] rightOne = new int[n + 1][k + 1];
            //base case
            rightZero[1][0] = 1;
            rightOne[1][0] = 1;
            //induction rule
            for (int size = 2; size <= n; size++) {
                rightZero[size][0] = rightZero[size - 1][0] + rightOne[size - 1][0];
                rightOne[size][0] = rightZero[size - 1][0];
            }

            for (int size = 2; size <= n; size++) {
                for (int bit = 1; bit <= k; bit++) {
                    rightZero[size][bit] = rightZero[size - 1][bit] + rightOne[size - 1][bit];
                    rightOne[size][bit] = rightZero[size - 1][bit] + rightOne[size - 1][bit - 1];
                }
            }

            return rightZero[n][k] + rightOne[n][k];
        }

        public static int getAdjBCStringCountRecursion(int n, int k) {
            return rightZero(n, k) + rightOne(n, k);
        }

        private static int rightZero(int n, int k) {
            //base case
            if (n == 1) {
                if (k == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (k > n - 2) { // 11111 0 -> n = 6, max = 4
                return 0;
            }
            return rightZero(n - 1, k) + rightOne(n - 1, k);
        }

        private static int rightOne(int n, int k) {
            //bae case
            if (n == 1) {
                if (k == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (k > n - 1) {// 11111 1 -> n = 6, max = 5
                return 0;
            }
            return rightZero(n - 1, k) + rightOne(n - 1, k - 1);
        }

        public static int getAdjBCStringCountBruteForce(int n, int k) {
            int[] sol = new int[1];
            helper(n, k, 1, 0, 233, sol);
            return sol[0];
        }

        private static void helper(int n, int k, int index, int oneCount, int prev, int[] count) {
            //base case
            if (index > n) {
                if (oneCount == k) count[0]++;
                return;
            }

            //0 at this index
            if (index == 1) {
                helper(n, k, index + 1, oneCount, 0, count);
                helper(n, k, index + 1, oneCount, 1, count);
            } else {
                if (prev == 1) {
                    //take 0
                    helper(n, k, index + 1, oneCount, 0, count);
                    //take 1
                    helper(n, k, index + 1, oneCount + 1, 1, count);
                } else {//prev = 0
                    //take 0
                    helper(n, k, index + 1, oneCount, 0, count);
                    helper(n, k, index + 1, oneCount, 1, count);
                }
            }
        }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T= in.nextInt();
        while(T-->0){
            int N= in.nextInt(),K= in.nextInt();
            System.out.println(getAdjBCStringCountBruteForce(N,K));


        }

    }
    }

