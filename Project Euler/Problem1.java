
public class Problem1 {

    public static void main(String [] arg) {

        int sum = 0;

        for (int i = 0; i<1000; i++) {
            if(i%3==0 || i%5==0) {
                sum += i;
            }
        }

        System.out.println("The sum is: " +sum);
    }
}
 