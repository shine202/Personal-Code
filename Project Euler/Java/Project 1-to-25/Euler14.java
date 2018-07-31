/*
    Longest Collatz sequence
    Problem 14
        The following iterative sequence is defined for the set of positive integers:

        n → n/2 (n is even)
        n → 3n + 1 (n is odd)

        Using the rule above and starting with 13, we generate the following sequence:

        13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
        It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

        Which starting number, under one million, produces the longest chain?

        NOTE: Once the chain starts the terms are allowed to go above one million.
*/

import java.util.LinkedList;

public class Euler14 {

     public static void main(String [] arg) {

          long begin = System.currentTimeMillis();

          LinkedList<Long> list = new LinkedList<Long>();
          long length = 0;

          int res = 0;

          for(int i = 10; i < 1000000; i++) {

               long j = i;
               while(j != 1) {
                    if(j % 2 == 0) {
                         j /= 2;
                         list.add(j);
                    }
                    else {
                         j = (3 * j) + 1;
                         list.add(j);
                    }
               }

               if(list.size() > length) {
                    length = list.size();
                    res = i;
               }

               list.clear();
          }

          long end = System.currentTimeMillis();
          System.out.println(res+" with chain size: "+ length);
          System.out.println(end-begin + "ms");
     }
}