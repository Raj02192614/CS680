package umbcs680.prime;

import java.util.Iterator;
import java.util.LinkedList;

public class SingletonPrimeGenerator {
    protected long from, to;
    protected LinkedList<Long> primes = new LinkedList<Long>();

    private static SingletonPrimeGenerator instance = null;

    private SingletonPrimeGenerator(long from, long to) {
        setRange(from, to);
    }

    public static SingletonPrimeGenerator getInstance(long from, long to) {
        if (instance == null) {
            instance = new SingletonPrimeGenerator(from, to);
        } else {
            instance.setRange(from, to);
        }
        return instance;
    }

    private void setRange(long from, long to) {
        if (from >= 1 && to > from) {
            this.from = from;
            this.to = to;
            primes.clear();
        } else {
            throw new RuntimeException("Wrong input values: from=" + from + " to=" + to);
        }
    }

    public LinkedList<Long> getPrimes() {
        return primes;
    }

    protected boolean isEven(long n) {
        return n % 2 == 0;
    }

    protected boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n > 2 && isEven(n)) return false;

        long sqrt = (long) Math.sqrt(n);
        for (long i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public void generatePrimes() {
        primes.clear();
        for (long n = from; n <= to; n++) {
            if (isPrime(n)) {
                primes.add(n);
            }
        }
    }
}
