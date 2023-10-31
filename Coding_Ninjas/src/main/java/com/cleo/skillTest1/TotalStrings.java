package com.cleo.skillTest1;

public class TotalStrings {
    static int countStrUtil(int[][][] dp, int n,
                            int bCount, int cCount)
    {

        // Base cases
        if (bCount < 0 || cCount < 0)
        {
            return 0;
        }
        if (n == 0)
        {
            return 1;
        }
        if (bCount == 0 && cCount == 0)
        {
            return 1;
        }

        // if we had saw this combination previously
        if (dp[n][bCount][cCount] != -1)
        {
            return dp[n][bCount][cCount];
        }

        // Three cases, we choose, a or b or c
        // In all three cases n decreases by 1.
        int res = countStrUtil(dp, n - 1, bCount, cCount);
        res += countStrUtil(dp, n - 1, bCount - 1, cCount);
        res += countStrUtil(dp, n - 1, bCount, cCount - 1);

        return (dp[n][bCount][cCount] = res);
    }

    // A wrapper over countStrUtil()
    static int countStr(int n, int bCount, int cCount)
    {
        int[][][] dp = new int[n + 1][2][3];
        for (int i = 0; i < n + 1; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                for (int k = 0; k < 3; k++)
                {
                    dp[i][j][k] = -1;
                }
            }
        }
        return countStrUtil(dp, n,bCount,cCount);
    }

    public static int countStrings(int n){

        // Write your code here
        //return countStr(n,1,2);
        long a = 1 + (n * 2L) + (n * (((long) n * n) - 1) / 2);
        long divisor=1000000007;
        return (int) (a%divisor);
    }

    public static void main(String[] args) {
        System.out.println(countStrings(190));
    }
}
