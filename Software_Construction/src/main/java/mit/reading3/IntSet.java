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

    public int pickRandomly(Set<Integer> set){
            return 0;

    }

    public Set<Integer> intersect(Set<Integer> that) {
        throw new RuntimeException("not implemented yet");
    }
}
