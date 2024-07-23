package com.cleo.revision.old.interview_preparation;

import java.util.*;

public class StringProblems {

    public static String reverseWords(String s) {
        if(s==null||s.length()==0)
            return s;
        //s = s.toLowerCase();
        //s = s.stripLeading();


       Stack<String> stack = new Stack<>();
        StringBuilder sb= new StringBuilder();
        for(char c: s.toCharArray()){
           if(c!=' ')
                sb.append(c);
           else{
               stack.push(sb.toString());
               sb = new StringBuilder();
               stack.push(String.valueOf(c));
           }

       }
        stack.push(sb.toString());


        StringBuilder answer = new StringBuilder();

        while(!stack.isEmpty()){
            answer.append(stack.pop());
        }
        return answer.toString();

    }

    public static String removeConsecutiveDuplicates(String str) {
        // Your code here

        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)!=str.charAt(i-1))
                result.append(str.charAt(i));

        }
        return result.toString();
    }
    public static String removePair(String str) {
        // your code here
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(str.charAt(i));
            }
            else if(stack.peek()==str.charAt(i))
                stack.pop();
            else
                stack.push(str.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
    public static boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int n = s.length();
        if(n==1)
            return true;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i <n; i++) {
            char c = s.charAt(i);
            if(c>=97&&c<=122||(c>='0'&&c<='9')){
                str.append(c);
            }
        }
        s = str.toString();
        n = s.length();
        if(n==0)
            return true;
        System.out.println(str);
        String s1 = str.reverse().toString();
        return s.equals(s1);

    }
    public int firstUniqChar(String s) {

        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c: s.toCharArray()){
            map.compute(c,(k,v)->v==null?1:++v);
        }
        for(var x:map.entrySet()){
            if(x.getValue()==1)
                return x.getKey();
        }
        return -1;

    }


    /**
     *
     * @param s Given a string s
     * @return the lexicographically smallest subsequence of s that contains all the
     * distinct characters of s exactly once.
     */
    public static String smallestSubsequence(String s) {
        /*
      Map<Character,Integer> map = new LinkedHashMap<>();

      for(char c:s.toCharArray()){
          map.compute(c,(k,v)->v==null?1:++v);
      }
      StringBuilder answer = new StringBuilder();
      for(var c: map.entrySet()){
          if(c.getValue()==1)
              answer.append(c.getKey());
      }
      return answer.toString();

        */
        int smallest = 65;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(answer.indexOf(String.valueOf(s.charAt(i)))==-1){
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();

    }
    static int longestSubstrDistinctChars(String S){
        // code here
        //  int[] dp = new int[S.length()+1];
        //    dp[0]=0;
        int count=1,length=1,max=0;
        StringBuilder str = new StringBuilder();
        //  str.append(S.charAt(0));
        for(char c:S.toCharArray()){
            if(str.indexOf(String.valueOf(c))==-1) {
                // str = new StringBuilder();
                str.append(c);
                length=str.length();
                if(max<=length)
                    max=length;
                //       dp[count++]=1+dp[count-1];
            }
            else {
                str = new StringBuilder();
                str.append(c);
                length=1;

                //     dp[count++]=dp[count-1];
            }
        }
        return max;

    }

    static int longestSubString(String s){
        Map<Character,Integer> map = new LinkedHashMap<>();
        int max=0,length=0;
        for(char c: s.toCharArray()){
            if(map.get(c)==null){
                map.put(c,1);
                length++;
                if(max<=length)
                    max=length;
            }else{
                map.clear();
                map.put(c,1);
                length=1;
            }
        }
        return max;
    }

    static String subStringSearch(String str, String pattern){
        return null;
    }
    public static long countSub(String str) {
        // Your code goes here
        long index = 0;
        int n = str.length();
        long openings = 0, closing = 0;
        for (int i = 0; i < n/2; i++) {
            if(str.charAt(i)=='(')
                openings++;
        }
        for (int i = n-1; i >=n/2 ; i--) {
            if(str.charAt(i)==')')
                closing++;
            if(openings==closing)
                return i;
        }
        return index;

    }
    static int atoi(String str) {
        // Your code here
        int value = 0;
        // str = str.toLowerCase();
        String s1 = "";boolean flag = false;
        if(str.charAt(0)=='-') {
            s1 = str.substring(1);
            flag=true;
        }
        else
            s1 = str;
        int size = s1.length();
        for(int i=0; i<size; i++) {
            char ch = s1.charAt(i);
            if(!Character.isDigit(ch)&&ch!='-') {

                return -1;
            }
            value = (value << 3) + (value << 1) + (ch - '0');
        }
        if(flag)
            return -value;
        return value;
    }

    public int myAtoi(String s) {
        int value = 0;
        boolean flag=false,flag1=false;

        int size = s.length();
        for(int i=0; i<size; i++) {
            char ch = s.charAt(i);
            if(ch=='-'&&(i+1<size)&&Character.isDigit(s.charAt(i+1)))
                flag = true;
            if(!Character.isDigit(ch)&&!flag1)
                return 0;
            else  if(Character.isDigit(ch)) {
                flag1=true;
                value = (value << 3) + (value << 1) + (ch - '0');
                if(value>=Integer.MAX_VALUE&&!flag)
                    return Integer.MAX_VALUE;
                else if(flag&&value>=Integer.MAX_VALUE)
                    return Integer.MIN_VALUE;


            }

        }
        if(flag)
            return -value;
        return value;

    }
    public static boolean isAnagram(String a,String b) {
        if(a.length()!=b.length())
            return false;
        int n = a.length();
        Map<Character,Integer> map = new HashMap<>();
        for(char c: a.toCharArray()){
            map.merge(c, 1, Integer::sum);
        }

        for(char c: b.toCharArray()){
            if(map.get(c)==null)
                return false;
            else{
                map.put(c,map.get(c)-1);
            }
        }

        for(Map.Entry<Character,Integer> m:map.entrySet()){
            if(m.getValue()!=0)
                return false;
        }
        return true;



    }

    public static int longestPalindrome(String s) {
        if(s.length()==1)
            return 1;
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char c: s.toCharArray()){
            map.compute(c,(k,v)->v==null?1:++v);
        }
        int length = 0;
        boolean flag = false;
        int temp =0;
        for(var c:map.entrySet()){
            if(c.getValue()>1){
                length+=c.getValue();
                //flag=true;
            }else if(c.getValue()==1)
                temp+=1;

        }
        if(temp>1)
            return length;
        return length+1;




    }





    public static void main(String[] args) {
        String str = "abccbccba";
        System.out.println(removeConsecutiveDuplicates(str));
        System.out.println(removePair(str));
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s2 =  "abccccdd";
        System.out.println(isPalindrome("0P"));
        System.out.println(smallestSubsequence("cbacdcbc"));
        StringBuilder sb = new StringBuilder("abcd");
        System.out.println(sb.indexOf("e"));
        System.out.println(s1.length());
        System.out.println(longestPalindrome(s1));
        System.out.println(s2.length());
        System.out.println(longestPalindrome(s2));
        System.out.println(longestPalindrome(str));
        System.out.println(longestPalindrome("bananas"));
        System.out.println(longestPalindrome("aaabb"));
        System.out.println(longestSubstrDistinctChars("aldshflasghdfasgfkhgasdfasdgvfyweofyewyrtyefgv"));
        System.out.println(longestSubstrDistinctChars("aaa"));
        System.out.println(longestSubstrDistinctChars("deven"));
        System.out.println(longestSubstrDistinctChars("aewergrththy"));
        System.out.println(longestSubString("aewergrththy"));
        System.out.println(atoi("-123"));
        System.out.println(isAnagram("allergy","allergic"));
        System.out.println(reverseWords("aaa    i  have   a car    "));
        System.out.println(reverseWords(s));
        System.out.println(reverseWords(" "));
        System.out.println(countSub("(())))("));
    }
}
