/*
    Non-abundant sums
    Problem 23
        A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

        A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.

        As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.

        Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/

import java.util.*;

public class Problem23 {

    public static void main(String args[]){
         
        long start = System.currentTimeMillis();
         
        List<Integer> aN = new ArrayList<Integer>(Abundant_numbers());
        Collections.sort(aN);
         
        Collection<Integer> abundant_sums = new ArrayList<Integer>(Abundant_sums(aN));
        Collection<Integer> all_integers = new ArrayList<Integer>(All_integers());
         
        all_integers.removeAll(abundant_sums);
         
        System.out.println(sum_Answer(all_integers));
         
        long stop = System.currentTimeMillis();
        System.out.println((stop - start) + " ms");
    }
     
    public static Integer sum_Answer(Collection<Integer> list) {
         Integer sum= 0;
         if(list == null){
             return 0;
         }
         for (Integer i:list)
             sum = sum + i;
         return sum;
    }
     
    public static Set<Integer> All_integers(){
        Set<Integer> All_integers = new HashSet<Integer>();
        for(int i = 1; i < 28123; i ++){
            All_integers.add(i);
        }
        return All_integers;
    }
     
     
    public static Set<Integer> Abundant_numbers(){
        Set<Integer> Abundant_numbers = new HashSet<Integer>();
        for(int i = 1; i <= 28123; i ++){
            List<Integer> x = proper_divisors(i);
            if(sum(x) > i){
                Abundant_numbers.add(i);
            }
        }
        return Abundant_numbers;
    }
     
    public static Set<Integer> Abundant_sums(List<Integer> aN){
        Set<Integer> Abundant_sums = new HashSet<Integer>();
        for (int i = 0; i < aN.size(); i++) {
            Integer x = aN.get(i);
            for(int j = 0; j < aN.size(); j++){
                int y = aN.get(j);
                int zzz = x + y;
                if(zzz < 28123){
                    Abundant_sums.add(zzz);
                }
            }
        }
        return Abundant_sums;
    }
 
    public static List<Integer> proper_divisors(int number){
        List<Integer> L = new ArrayList<Integer>();
        if(number == 1){
            L = null;
            return L;
        }
        if(number == 2){
            L.add(1);
            return L;
        }
        for(int i = 1; i <= ((number / 2) + 1); i ++){
            if(number % i == 0){
                L.add(i);
            }
        }
        return L;
    }
     
    public static Integer sum(List<Integer> list) {
         Integer sum= 0;
         if(list == null){
             return 0;
         }
         for (Integer i:list)
             sum = sum + i;
         return sum;
    }
}