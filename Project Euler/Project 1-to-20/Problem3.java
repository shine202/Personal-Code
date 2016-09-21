/*
    Largest prime factor
    Problem 3
        The prime factors of 13195 are 5, 7, 13 and 29.

        What is the largest prime factor of the number 600851475143 ?
*/

public class Problem3 {
  
    public static void main(String[] args) {
        long n= 600851475143L; //this is a large prime number 
        long i = 2L;
        int test = 0;

        while (n > 1)
        {
            while (n % i == 0)
            {
                n /= i;     
            }

            i++;

            if(i*i > n && n > 1) 
            {
                System.out.println(n); //prints n if it's prime
                test = 1;
                break;
            }
        }

        if (test == 0)  
            System.out.println(i-1); //prints n if it's the largest prime factor
    }
}
    