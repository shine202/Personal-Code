/*
    Amicable numbers
    Problem 21
        Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
        If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

        For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

        Evaluate the sum of all the amicable numbers under 10000.
*/


import java.util.ArrayList;
import java.util.Iterator;

public class Problem21 {

	private static int MSum;
	private static int NSum;
	
	private static int sumList(ArrayList<Integer> list) {
		int sum = 0;
		
		for (Iterator<Integer> iter = list.iterator(); iter.hasNext();)
		{
			sum += iter.next();
		}
		
		return sum;
	}
	
	private static ArrayList<Integer> createList(int n) {
		long root = Math.round(Math.sqrt(n)) + 1;

		ArrayList<Integer> test = new ArrayList<Integer>();
		test.add(1);
		
		for (int i = 2; i <= root; i++)
		{
			if (n % i == 0)
			{
				test.add(i);		// Add the divisor & its complement
				test.add(n/i);
			}
		}
		
		return test;
	}
	
	private static boolean isAmicable(int n) {

		ArrayList<Integer> NList = new ArrayList<Integer>(createList(n));		
		
		NSum = sumList(NList);
		
		ArrayList<Integer> MList = new ArrayList<Integer>(createList(NSum));
		
		MSum = sumList(MList);
		
		if ((MSum == n) && (MSum != NSum))
			return true;	
		
		return false;
	}
	
	public static void main(String[] args) 	{
		long begin = System.currentTimeMillis();
		
		int sum = 0;
		for (int i = 0; i < 10000; i++)
		{
			if (isAmicable(i))
			{
				sum += NSum;
			}
		}
		
		System.out.println(sum);
		
		long end = System.currentTimeMillis();
		System.out.println(end-begin + "ms");
	}
}