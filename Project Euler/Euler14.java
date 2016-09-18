import java.util.LinkedList;
public class Euler14 {

     public static void main(String [] arg) {

          long begin = System.currentTimeMillis();

          LinkedList<Long> list = new LinkedList<Long>();
          long length = 0;

          int rest = 0;

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