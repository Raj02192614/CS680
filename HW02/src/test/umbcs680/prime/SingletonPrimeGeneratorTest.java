package umbcs680.prime;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SingletonPrimeGeneratorTest {

    @Test
    public void testSingletonPrime() {
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance(5,8);
        SingletonPrimeGenerator gen2 = SingletonPrimeGenerator.getInstance(7,13);
        assertEquals(gen1, gen2);
        assertEquals(gen1.hashCode(), gen2.hashCode());
    }
    @Test
    public void testNotNullInstance() {
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance(5,8);
        assertNotNull(gen1);
    }
    @Test
    public void testGeneratePrimesInRange() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(1, 10);
        gen.generatePrimes();
        Long[] expected = {2L, 3L, 5L, 7L};
        assertArrayEquals(expected, gen.getPrimes().toArray());
    }

    @Test
    public void testGeneratePrimesInLongRange() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(5, 23);
        gen.generatePrimes();
        Long[] expected = {5L, 7L, 11L, 13L, 17L, 19L, 23L};
        assertArrayEquals(expected, gen.getPrimes().toArray());
    }

    @Test
    public void testGeneratePrimesSmallRange() {
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(2, 3);
        gen.generatePrimes();
        Long[] expected = {2L, 3L};
        assertArrayEquals(expected, gen.getPrimes().toArray());
    }

    @Test
    public void testGenerateNoPrimes() {
        try {
            SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance(14, 16);
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
            SingletonPrimeGenerator.getInstance(from, to);
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
            SingletonPrimeGenerator.getInstance(from, to);
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
            SingletonPrimeGenerator.getInstance(from, to);
            fail("Exception expected but not thrown for 'from' > 'to'");
        } catch (RuntimeException ex) {
            String expected = "Wrong input values: from=" + from + " to=" + to;
            assertEquals(expected, ex.getMessage());
        }
    }

    @Test
    public void testSingletonIdentity() {
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance(1, 10);
        SingletonPrimeGenerator gen2 = SingletonPrimeGenerator.getInstance(10, 20);
        assertSame(gen1, gen2, "Instances are not the same (Singleton failed)");
    }
}
