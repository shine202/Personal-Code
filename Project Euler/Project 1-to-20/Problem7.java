
public class Problem7 {

    public static void main(String [] arg) {
        System.out.println(nthPrime(10001));
    }

    public static long nthPrime(long n) {
        int number = 0;
        long prime = 1;

        while(number < n) {
            prime++;
            if(isPrime(prime)) {
                number++;
            }
        }

        return prime;
    }

    public static boolean isPrime(long n) {
        if(n < 2){
            return false;
        } 
        else if(n == 2) {
            return true;
        }
        for(int i = 2; i < Math.pow(n, 0.5) + 1; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}