/*
    Special Pythagorean triplet
    Problem 9
        A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

        a2 + b2 = c2
        For example, 32 + 42 = 9 + 16 = 25 = 52.

        There exists exactly one Pythagorean triplet for which a + b + c = 1000.
        Find the product abc.
*/
public class Problem9 {

    public static void main(String [] arg) {
        
        int sum = 1000;
        int a;
        int product=0;
        for (a = 1; a <= sum/3; a++)
        {
            //System.out.print("A: "+a+", ");
            int b;
            for (b = a + 1; b <= sum/2; b++)
            {
                //System.out.print("B: "+b+", ");
                int c = sum - a - b;
                //System.out.print("c: "+c+", \n");
                if ( c > 0 && (a*a + b*b == c*c )) {
                    System.out.println("a="+a+", b="+b+", c="+c);
                    product = a * b * c;
                }
            }
        }

        System.out.println(product);

    }
}