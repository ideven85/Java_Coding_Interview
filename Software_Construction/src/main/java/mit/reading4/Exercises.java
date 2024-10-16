package mit.reading4;

import java.util.ArrayList;
import java.util.List;

public class Exercises {
    /**
     * Compute the hailstone sequence.
     * See http://en.wikipedia.org/wiki/Collatz_conjecture#Statement_of_the_problem
     * @param n starting number of sequence; requires n > 0.
     * @return the hailstone sequence starting at n and ending with 1.
     *         For example, hailstone(3)=[3,10,5,16,8,4,2,1].
     */
    public static List<Integer> hailstoneSequence(int n) {
        List<Integer> list = new ArrayList<>();
        if(n==1){
            list.add(n);

        }else if(n%2==0){
            hailstoneSequence(n/2);
            list.add(n);


        }else{
            hailstoneSequence(n*3+1);
            list.add(n);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(hailstoneSequence(3));
    }
}
