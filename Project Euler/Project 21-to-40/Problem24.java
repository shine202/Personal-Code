import java.util.ArrayList;
import java.util.Collections;
 
public class Problem24 {
        
    static ArrayList<Long> numPermutations = new ArrayList<Long>();
    
    public static void main(String args[]) {
        long start = System.currentTimeMillis();

        System.out.println();
        permutation("","0123456789");

        Collections.sort(numPermutations);
        System.out.println(numPermutations.get(1000000-1)); 

        
        long stop = System.currentTimeMillis();
        System.out.println((stop - start) + " ms");
    }
    
    
    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            numPermutations.add(Long.parseLong(prefix));
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }
}