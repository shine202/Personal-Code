
public class Problem6 {

    public static void main(String [] arg) {

        int squaresSum = 0;
        int sumSquare = 0;

        for(int i = 1; i <= 100; i++) {
            squaresSum += i*i;
        }
        for(int i = 1; i <= 100; i++) {
            sumSquare += i;
        }

        System.out.println("Sum of Squares is: "+squaresSum);
        System.out.println("Square of the sum is: "+sumSquare*sumSquare);
        System.out.println("Difference is: "+((sumSquare*sumSquare) -squaresSum));
        
    }
}