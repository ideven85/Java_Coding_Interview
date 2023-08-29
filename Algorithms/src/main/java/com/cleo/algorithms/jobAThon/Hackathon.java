package com.cleo.algorithms.jobAThon;

public class Hackathon {

    public long gcd(long a, long b){
        if(a==0)
            return b;
        return gcd(b%a,a);
    }
    public long meetThem(long A, long B, long C){
        long time=0,i=0,counter=0;
        long GCD = gcd(A,B);
        long LCM=A*B/GCD;

       /* if(A>B)
            while(i<C){
                var temp = C/A;

                i+=temp;
                counter+=1;
            }
        else if(A==B){
            counter=C/A;
        }else{
            while(i<C){
                var temp=C/B;
               // System.out.println(temp+"L"+i);

                counter+=1;

                i+=temp;
            }

        }

        */
        counter=C/LCM;

        return counter;


    }

    public static void main(String[] args) {
        Hackathon hackathon = new Hackathon();
        System.out.println(hackathon.meetThem(1,3,14));
    }
}
