
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