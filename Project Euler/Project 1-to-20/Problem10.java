
public class Problem10 {

    public static void main(String [] arg) {
        long bellow = 2000000;
        long sum = 0;

        for(int i = 1; i<=bellow; i++) {
            if(isPrime(i)) {
                sum += i;
            }
        }

        System.out.println("The sum of all the primes under 2Million is: "+sum);
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