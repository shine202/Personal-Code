import java.math.BigInteger;

public class Euler20 {

     public static void main(String [] arg) {

          long start = System.currentTimeMillis();

          BigInteger n = bigFactorial(100);

          int factorial = addDigits(n);


          System.out.println("The sum is: "+factorial);

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

     public static BigInteger bigFactorial(int n) {

          BigInteger result = BigInteger.valueOf(1);

          for (int i=1; i<=n; i++) {
               result = result.multiply(BigInteger.valueOf(i));
          }

          return result;
     }
}