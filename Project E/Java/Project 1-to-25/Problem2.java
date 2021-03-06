/*
    Even Fibonacci numbers
    Problem 2
        Each new term in the Fibonacci sequence is generated by adding the previous two terms.
            By starting with 1 and 2, the first 10 terms will be:

        1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

        By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
*/
public class Problem2 {

    public static void main(String [] arg) {

        long sum = 2;
        long first = 1;
        long secon = 2;
        

        System.out.print(first + ", ");

        for (int i = 0; i<31; i++) {
            System.out.print(secon + ", ");
            long temp = secon;
            secon += first;
            first = temp; 
            
            if(secon%2==0) {
                sum += secon;
            }
        }
        System.out.println("\n\n\n\n Sum is: "+sum);
    }
}