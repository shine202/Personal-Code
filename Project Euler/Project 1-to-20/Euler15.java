/*
	Lattice paths
	Problem 15
		Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.

		How many such routes are there through a 20×20 grid?
*/

public class Euler15 {

    public static long binomialCoefficient(int n, int k) {
		/* N-choose-k combinatorics: (n! / (k! * (n-k)!)
		 * Where:
		 * 		n is the number of moves,
		 * 		k is the number of down and right moves required (20 each) */
 
		if (k > (n-k))
			k = n - k;
		
		long c = 1;
		
		for (int i = 0; i < k; i++)
		{
			c = c * (n-i);
			c = c / (i+1);			
		}
		
		return c;
        
	}

    public static long factorial(int n) {
        long sum  = 1;
        for(int i = 1; i<=n; i++) {
            sum *= i;
        }
        return sum;
    }

    public static void main(String [] arg) {

        long begin = System.currentTimeMillis();
		
		System.out.println(binomialCoefficient(40,20));
		
		long end = System.currentTimeMillis();
		System.out.println(end-begin + "ms");	
    }

    
}