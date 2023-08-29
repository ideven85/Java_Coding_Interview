package com.cleo.interview_preparation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class EditDistance{

    public int minDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int k;
        int[][] dp = new int[n+1][m+1];
        dp[0][0]=0;
        for (int i = 1; i <= n; i++) {
            dp[i][0]=i;

        }
        for (int i = 1; i <= m; i++) {
            dp[0][i]=i;

        }
        for(int[] row:dp){
            System.out.print(Arrays.toString(row)+ "\t");

        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=m ; j++) {
                k = word1.charAt(i-1)==word2.charAt(j-1)?0:1;
                dp[i][j]=Math.min(Math.min(dp[i-1][j-1]+k,dp[i-1][j]+1),dp[i][j-1]+1);
            }
        }
        return dp[n][m];
    }

}





class EditDistance1 {

    //Max speed
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);

        return f(n,m,word1,word2,dp);
    }

    public int f(int i,int j,String word1, String word2,int dp[][] ){
        if(i==0) return j;
        if(j==0) return i;
        if(dp[i][j]!=-1)return dp[i][j];

        if(word1.charAt(i-1)==word2.charAt(j-1))
            return dp[i][j]= f(i-1,j-1,word1,word2,dp);

        int insert = 1+f(i,j-1,word1,word2,dp);
        int delete = 1+f(i-1,j,word1,word2,dp);
        int replace = 1 + f(i-1,j-1,word1,word2,dp);

        return  dp[i][j]= Math.min(insert,Math.min(delete,replace));
    }
    //Min Memory Usage
    public int minDistanceV2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;

                else if (j == 0)
                    dp[i][j] = i;

                else if (word1.charAt(i - 1)
                        == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                else
                    dp[i][j] = 1
                            + Math.min(dp[i][j - 1],
                            Math.min(dp[i - 1][j],
                                    dp[i - 1]
                                            [j - 1]));
            }
        }
        return dp[m][n];
    }
}

class HouseRobber{

    private Map<Integer,Integer> memo = new HashMap<>();
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]); // Recurrence relation
        }

        return dp[nums.length - 1];
    }
    public int robV2(int[] nums){
        int N = nums.length;
        if(N==0)
            return 0;
        if(N==1)
            return nums[0];

        int[] dp = new int[N+1];
        dp[N]=0;
        dp[N-1]=nums[N-1];
        for (int i = N-2; i >=0 ; --i) {
            dp[i]=Math.max(dp[i+1],dp[i+2]+nums[i]);

        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public int robMemoised(int[] nums){
        int N = nums.length;
        if(N==1)
            return nums[0];

        return robMemoisedFrom(nums,0);
    }
    public int robMemoisedFrom(int[] nums, int position){
        if(position>=nums.length)
            return 0;
        if(memo.get(position)!=null)
            return memo.get(position);

        int answer = Math.max(robMemoisedFrom(nums,position+1),robMemoisedFrom(nums,position+2)+nums[position]);
        memo.put(position,answer);
        System.out.println(memo+ " " + answer);
        return answer;
    }

}


class LongestCommonSubsequence{

    public int longestCommonSubsequence(String str1, String str2){
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1][n2];
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i][j-1],Math.max(dp[i-1][j-1],dp[i-1][j]));
            }

        }
        return dp[n1-1][n2-1];
    }
}




class CoinChange {

    //Greedy Approach
    //Does not work in all cases
    public int minimumCoins(int[] coins, int amount){
        int n = coins.length;
        if(n==1){
            if(amount%coins[0]==0)
                return amount/coins[0];
            else
                return -1;
        }
        int minCoins=0;
        Arrays.sort(coins);
        System.out.println(Arrays.toString(coins));
        for (int i = n-1; i >=0 ; i--) {

            if(amount==0)
                return minCoins;
            else{
                if(coins[i]<=amount && amount>0){
                    int coins1 = amount/coins[i];
                    minCoins+=(amount/coins[i]);
                    amount=amount-(coins1*coins[i]);
                    System.out.println(minCoins+ " "+amount);
                }
            }


        }
        return -1;
    }


    public int minimumCoinsDP(int[] coins, int amount){
        int n = coins.length;
        if(n==1){
            if(amount%coins[0]==0)
                return amount/coins[0];
            else
                return -1;
        }
        int minCoins=0;
        Arrays.sort(coins);//O(n(log(n))

        int[] dp = new int[n];
        int s = 0,min_s=0,current=amount;
        if(coins[n-1]<amount) {
            dp[0] = amount / coins[n - 1];
            current-=dp[0]*(amount%coins[n-1]);
        }

        int j=1;
        for (int i = n-2; i >=0 ; i--) {
            min_s=current/coins[i];
            s = amount/coins[i];

        }
        return minCoins;

    }


    public static void main(String[] args) {
        int[] coins = {3,4,5};
        int amount = 16;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.minimumCoins(coins,amount));
    }
}


public class DynamicProgramming {

    int sum = 0;

    //Recurrence Relation=
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int paths=0;
        if(m==1&&n==1)
            return 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0)
                    dp[i][j]=j;
                else if(j==0)
                    dp[i][j]=i;
                else{
                    dp[i][j]=1+Math.max(dp[i-1][j],dp[i][j-1]);
                    paths+=1;

                }



            }
        }
        paths+=dp[m-1][n-1];
        System.out.println(paths);
        Arrays.stream(dp).forEach(n1 -> System.out.println(Arrays.toString(n1)));
        return dp[m-1][n-1];



    }


    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        //   int sum = 2;
        //  int a=0,b=1,c=2,d=0;
        int[] dp = new int[n+1];
        dp[0]=0;dp[1]=1;dp[2]=1;
        for (int i = 3; i <= n; i++) {

            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];


        }
        //  System.out.println(Arrays.toString(dp));
        return dp[n];

    }
    public int deleteAndEarn(int[] nums) {
        if(nums.length==1)
            return nums[0];
        Arrays.sort(nums);
        int n = nums.length,j=1;
        int[] dp = new int[n+1];
        boolean flag = false;
        System.out.println(Arrays.toString(nums));
        dp[0]=nums[n-1];
        for (int i = n-2; i >=0 ; i--) {

            for (int k = 0; k <= j; k++) {
                flag= (nums[ i ] - 1) != dp[ k ] && (nums[ i ] + 1) != dp[ k ];

            }
            if(flag){
                dp[j]=dp[j-1]+nums[i];
                j+=1;
                flag=false;
            }else{
                dp[j]=dp[j-1];
                j+=1;
            }
            System.out.println(Arrays.toString(dp));
        }

        return dp[n];

    }

    public int minPathSum(int[][] cost) {
        int[][] T = new int[ cost.length][cost[0].length];
        int sum=0,max_sum=0;

        int M = cost.length,N = cost[0].length;
        // fill the matrix in a bottom-up manner
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                T[i][j] = cost[i][j];

                // fill the first row (there is only one way to reach any cell
                // in the first row from its adjacent left cell)
                if (i == 0 && j > 0) {
                    T[0][j] += T[0][j - 1];
                }

                // fill the first column (there is only one way to reach any cell
                // in the first column from its adjacent top cell)
                else if (j == 0 && i > 0) {
                    T[i][0] += T[i - 1][0];
                }

                // fill the rest with the matrix (there are two ways to reach any
                // cell in the rest of the matrix, from its adjacent
                // left cell or adjacent top cell)
                else if (i > 0 && j > 0) {
                    T[i][j] += Integer.min(T[i - 1][j], T[i][j - 1]);
                }
            }
        }

        return T[M-1][N-1];

    }

    public static void main(String[] args) {

        /**
         * Edit Distance Problem
         */


        System.out.println("Edit Distance:\n");
        String word1="horse",word2="horse";
        EditDistance1 distance = new EditDistance1();
        System.out.println(distance.minDistance(word1,word2));
        System.out.println(distance.minDistanceV2(word1,word2));

        DynamicProgramming dp = new DynamicProgramming();
        System.out.println(dp.uniquePaths(3,7));
        int[] cost = {10,8,6,6,20};
        int[] cost1 = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(dp.tribonacci(25)+"25th tribonacci");
        int[] nums ={2,2,3,3,3,4};
        System.out.println(dp.deleteAndEarn(nums));

        /**
         * House Robber
         */

        System.out.println("\n\n House Robber:\n");
        HouseRobber houseRobber = new HouseRobber();
        int[] nums1 =new int[]{2,1,7,9,1};
        System.out.println(houseRobber.rob(nums1));
        System.out.println(houseRobber.robV2(nums1));
        System.out.println(houseRobber.robMemoised(nums1));



        String s1 = "horses";
        String s2 = "horse";
        EditDistance distance1 = new EditDistance();
        System.out.println(distance1.minDistance(s1,s2));


        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "deven";
        String str2 = "eve";
        String s11 = "ZXVVYZW";
        String s22 = "XKYKZPW";
        System.out.println(lcs.longestCommonSubsequence(str1,str2));
        System.out.println(lcs.longestCommonSubsequence(s11,s22));
    }
}

