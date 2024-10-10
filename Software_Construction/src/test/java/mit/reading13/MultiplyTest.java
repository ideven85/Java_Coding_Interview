package mit.reading13;


import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;


public class MultiplyTest {
    // covers a is positive, b is negative,
    //        a fits in long value, b fits in long value,
    //        a and b have different signs
    @Test
    public void testDifferentSigns() {
        assertEquals(BigInteger.valueOf(-146), BigInteger.valueOf(73).multiply(BigInteger.valueOf(-2)));
    }

    // covers a = 1, b != 1, a and b have same sign
    @Test
    public void testIdentity() {
        assertEquals(BigInteger.valueOf(33), BigInteger.valueOf(1).multiply(BigInteger.valueOf(33)));
    }
}
