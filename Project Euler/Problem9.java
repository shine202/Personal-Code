
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