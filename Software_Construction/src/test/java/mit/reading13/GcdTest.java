package mit.reading13;

import org.junit.Test;

import static mit.reading3.Gcd.gcd;
import static org.junit.Assert.assertEquals;

public class GcdTest {
    @Test
    public void gcdTest() {
        assertEquals(-24, gcd(-24, 24));
    }
}
