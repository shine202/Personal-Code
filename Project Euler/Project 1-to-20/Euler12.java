
public class Euler12 {

    public static void main(String [] arg) {

        long start = System.currentTimeMillis();

        int j = 0;
        int n = 0;
        int numberOfDiv = 0;

        while(numberOfDiv <= 500) {

            numberOfDiv = 0;
            j++;
            n = triangleNumber(j);
            //System.out.print("\t"+":"+j+": "+n+" - "+Math.sqrt(n)+"\t\n");
            for(int i = 1; i <=Math.sqrt(n); i++) {
                if(n % i == 0) {
                    numberOfDiv++;
                }
            }

            numberOfDiv *= 2;
        }

        long finish = System.currentTimeMillis();
        
        System.out.println(j);
        System.out.println(n);
        System.out.println("Time taken: " + (finish - start) + " milliseconds");
    }

    public static int triangleNumber(int number) {
        int sum = 0;
        for(int i = 0; i <= number; i++) {
            sum += i;
        }
        return sum;
    }
}