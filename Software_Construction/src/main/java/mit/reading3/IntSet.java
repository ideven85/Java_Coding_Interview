package mit.reading3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class IntSet {
    /**
     * Intersects two sets of integers.
     *
     * @param that   another set of integers
     * @return { x : x is in both this and that }
     * For example, {1, 5}.intersect({5, -2}) returns {5}.
     */
    private final Set<Integer> set;

    public IntSet() {
        this.set = new HashSet<>();

    }

    public static int pickRandomly(Set<Integer> set){
           int x = new Random(set.size()).nextInt();
        //System.out.println(x);
        int i=0;
        for(var z:set){
            if(i==x)
                return z;
        }
        return set.iterator().next();

    }

    public Set<Integer> intersect(Set<Integer> that) {
        Set<Integer> result = new HashSet<>();
        if(this.set.isEmpty()||that.isEmpty()){
            return result;
        }
        for(var x:this.set){
            if(that.contains(x))
                result.add(x);
        }
        return result;
    }
}
