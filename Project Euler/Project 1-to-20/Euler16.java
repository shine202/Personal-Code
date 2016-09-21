import java.math.BigInteger;

public class Euler16 {

    public static void main(String [] arg) {
        long start = System.currentTimeMillis();

        BigInteger n = bigNumberTwo(2, 1000);

        System.out.println("The BigInteger is: "+n);

        int value = addDigits(n);

        System.out.println("The sum is: "+value);
        //System.out.println("The sum of 32768 is: "+addDigits(32768));

        long stop = System.currentTimeMillis();

        System.out.println(stop-start + "ms");
    }

    public  static int addDigits(BigInteger sum) {

          int result = 0;
          String strSum = sum.toString();

          for(int i = 0;i < strSum.length(); i++) {
               result += Integer.parseInt(strSum.charAt(i) + "");
          }
          return result;
     }

     public  static int addDigits(int sum) {

          int result = 0;
          String strSum = Integer.toString(sum);

          for(int i = 0;i < strSum.length(); i++) {
               result += Integer.parseInt(strSum.charAt(i) + "");
          }
          return result;
     }

    
    
    public static BigInteger bigNumberTwo(int k, int n) {

          BigInteger result = BigInteger.valueOf(k);

          for (int i=1; i<n; i++) {
               result = result.multiply(BigInteger.valueOf(k));
          }

          return result;
     }
}