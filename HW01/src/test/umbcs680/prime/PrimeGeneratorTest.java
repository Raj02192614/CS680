package umbcs680.prime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {

    @Test
    public void testGeneratePrimesInRange() {

            PrimeGenerator gen = new PrimeGenerator(1, 10);
            gen.generatePrimes();
            Long[] expected = {2L, 3L, 5L, 7L};
            assertArrayEquals(expected, gen.getPrimes().toArray());

    }

    @Test
    public void testGeneratePrimesInLongRange() {

        PrimeGenerator gen = new PrimeGenerator(5, 23);
        gen.generatePrimes();
        Long[] expected = {5L, 7L, 11L, 13L, 17L, 19L, 23L};
        assertArrayEquals(expected, gen.getPrimes().toArray());

    }


    @Test
    public void testGeneratePrimesSmallRange() {

            PrimeGenerator gen = new PrimeGenerator(2, 3);
            gen.generatePrimes();
            Long[] expected = {2L, 3L};
            assertArrayEquals(expected, gen.getPrimes().toArray());

    }


    @Test
    public void testGenerateNoPrimes() {
        try {
            PrimeGenerator gen = new PrimeGenerator(14, 16);
            gen.generatePrimes();
            assertTrue(gen.getPrimes().isEmpty());
        } catch (RuntimeException ex) {
            fail("Unexpected exception for valid input");
        }
    }


    @Test
    public void testInvalidSameFromTo() {
        long from = 2;
        long to = 2;
        try {
            PrimeGenerator gen = new PrimeGenerator(from, to);
            fail("Exception expected but not thrown for same from and to values");
        } catch (RuntimeException ex) {
            String expected = "Wrong input values: from=" + from + " to=" + to;
            assertEquals(expected, ex.getMessage());
        }
    }

    @Test
    public void testNegativeFrom() {
        long from = -10;
        long to = 10;
        try {
            PrimeGenerator gen = new PrimeGenerator(from, to);
            fail("Exception expected but not thrown for negative 'from'");
        } catch (RuntimeException ex) {
            String expected = "Wrong input values: from=" + from + " to=" + to;
            assertEquals(expected, ex.getMessage());
        }
    }


    @Test
    public void testFromGreaterThanTo() {
        long from = 100;
        long to = 1;
        try {
            PrimeGenerator gen = new PrimeGenerator(from, to);
            fail("Exception expected but not thrown for 'from' > 'to'");
        } catch (RuntimeException ex) {
            String expected = "Wrong input values: from=" + from + " to=" + to;
            assertEquals(expected, ex.getMessage());
        }
    }
}
