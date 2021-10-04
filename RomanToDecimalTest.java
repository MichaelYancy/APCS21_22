/**
 * Tests the arguments for program RomanToDecimal
 * @version 10/03/2021
 * @author 22yancy
 */

import static org.junit.Assert.*;

public class RomanToDecimalTest {

    @org.junit.Test
    /**
     * Tests args for class RTD
     */
    public void testRomanToDecimalTest() {
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("IXIX"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("MCIX"), 1109);
        assertEquals(RomanToDecimal.romanToDecimal("CM"), 900);
        assertEquals(RomanToDecimal.romanToDecimal("CL"), 150);
        assertEquals(RomanToDecimal.romanToDecimal("XXII"), 22);
        assertEquals(RomanToDecimal.romanToDecimal("XLVI"), 46);
        assertEquals(RomanToDecimal.romanToDecimal("IX"), 9);
        assertEquals(RomanToDecimal.romanToDecimal("CD"), 400);
        assertEquals(RomanToDecimal.romanToDecimal("DCL"), 650);

        assertEquals(RomanToDecimal.romanToDecimal("Ur mom"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("Whoopsies"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("Gosling"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("JAMES"), -1);

        assertEquals(RomanToDecimal.romanToDecimal("ICM"), 901);
        assertEquals(RomanToDecimal.romanToDecimal("IVIVIV"), 16);
        assertEquals(RomanToDecimal.romanToDecimal("ID"), 501);
        assertEquals(RomanToDecimal.romanToDecimal("IIIX"), 11);

        assertNotEquals(RomanToDecimal.romanToDecimal("Joe"), 20);
        assertNotEquals(RomanToDecimal.romanToDecimal("ur mom"), 20);
    }
}
