package com.cleo.skillTest2;

import java.util.stream.IntStream;

public class JumpingNumbers {

    public static int fact(int n){
        if(n==0){
            return 1;
        }
        int smallOutput=fact(n-1);
        int output=n*smallOutput;
        return output;

    }
    public static int sumn(int n){
        if(n==0){
            return 0;
        }
        int smallOutput=sumn(n-1);
        int output=n+smallOutput;
        return output;


    }
    public static void print1ton(int n){
        if(n==0){
            return;
        }
        System.out.println(n);
        print1ton(n-1);

    }
    public static int fib(int n){
        if(n==1||n==2){
            return 1;
        }
        int fib_n_1=fib(n-1);
        int fib_n_2=fib(n-2);
        int output=fib_n_1+fib_n_2;
        return output;
    }
    public static boolean isSorted(int a[]){
        if(a.length==1){
            return true;
        }
        if(a[0]>a[1]){
            return false;
        }
        int smallArray[]=new int[a.length-1];
        for(int i=1;i<a.length;i++){
            smallArray[i-1]=a[i];
        }
        boolean isSmallArraySorted=isSorted(smallArray);
        return isSmallArraySorted;
    }
    public static boolean isSortedBetter(int a[],int si){
        if(si==a.length-1){
            return true;
        }
        if(a[si]>a[si+1]){
            return false;
        }
        boolean isSmallArraySorted=isSortedBetter(a,si+1);
        return isSmallArraySorted;
    }
    public static int firstIndex(int a[],int x){
        if(a.length==0){
            return -1;
        }
        if(a[0]==x){
            return 0;
        }
        int smallArray[]=new int[a.length-1];
        for(int i=1;i<a.length;i++){
            smallArray[i-1]=a[i];
        }
        int fi=firstIndex(smallArray,x);
        if(fi==-1){
            return -1;
        }else{
            return fi+1;
        }


    }
    public static int firstIndexBetter(int a[],int x,int si){
        if(si==a.length){
            return -1;
        }
        if(a[si]==x){
            return si;
        }
        return firstIndexBetter(a,x,si+1);

    }

    public static int firstIndex(int[] arr, int x,int curr){
        if(curr==arr.length)
            return -1;
        if(arr[curr]==x)
            return curr;
        return firstIndex(arr,x,curr+1);
    }

    private static int lastIndexHelper(int[] arr, int element, int N){
        if(N<0)
            return -1;
        if(arr[N]==element)
            return N;

        return lastIndexHelper(arr,element,N-1);
    }

    public static int lastIndex(int[] arr, int x){
        int n = arr.length;
        return lastIndexHelper(arr,x,n-1);
    }
    public static long power(int N,int R)
    {
        //Your code here
        if(R==0)
            return 1;
        else if(R==1)
            return N;
        return N*power(N,R-1)%(1000000007);

    }


    public static void main(String[] args){
        //System.out.println(fact(5));
        //System.out.println(sumn(4));
        //print1ton(5);
        int[] a = {1,3,4,2,5,7,5};
        System.out.println(firstIndex(a,5));
        System.out.println(lastIndex(a,5));
        int[] arr = IntStream.rangeClosed(1,10).toArray();
        System.out.println(firstIndex(arr,5));
        System.out.println(fib(5));
        System.out.println(power(123,10));

    }
}
