/*
    1000-digit Fibonacci number
    Problem 25
        The Fibonacci sequence is defined by the recurrence relation:

        Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
        Hence the first 12 terms will be:

        F1 = 1
        F2 = 1
        F3 = 2
        F4 = 3
        F5 = 5
        F6 = 8
        F7 = 13
        F8 = 21
        F9 = 34
        F10 = 55
        F11 = 89
        F12 = 144
        The 12th term, F12, is the first term to contain three digits.

        What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
*/
import java.math.*;

public class Problem25 {

    public static void main(String [] arg) {
        long begin = System.currentTimeMillis();
        
        int i = 0;
        int count = 2;
        BigInteger limit = (new BigInteger ("10")).pow(999);
        BigInteger [] fib = new BigInteger [3];

        fib[0] = BigInteger.ONE;
        fib[2] = BigInteger.ONE;

        while((fib[i]).compareTo(limit) < 0) {
            i = (i + 1) % 3;
            count++;
            fib[i] = fib[(i + 1) % 3].add(fib[(i + 2) % 3]);
        }
        System.out.printf("Fibonacci %d has 1000 digits\n", count);

        long end = System.currentTimeMillis();
        System.out.println(end-begin + "ms");
    }
}