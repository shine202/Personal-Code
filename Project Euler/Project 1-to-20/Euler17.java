/*
    Number letter counts
    Problem 17
        If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

        If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?


        NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
*/
public class Euler17 {

    public static String[] ones = {
       "","one","two","three","four","five","six","seven","eight","nine","ten",
      "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen" 
    };

    public static String[] tens = {
        "","ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"
    };

    public static String[] hundreds = {
        "","onehundred","twohundred","threehundred","fourhundred","fivehundred","sixhundred","sevenhundred","eighthundred","ninehundred"
    };

    public String word(int arg) {
        String withAnd = "";

        if(arg == 1000) {
            return "onethousand";
        } 

        if(arg < 20) {
            return ones[arg];
        }
        if(arg < 100) {
            return tens[arg/10] + word(arg%10);
        }

        withAnd = word(arg % 100);

        if(withAnd.length() > 0) {
            withAnd = "and" + withAnd;
        }

        return hundreds[arg/100] + withAnd;
    }

    public int letterCt(int arg) {
        //System.out.println(word(arg));
        //System.out.println(word(arg).length());
        return word(arg).length();
    }

    public static void main(String [] arg) {
        long start = System.currentTimeMillis();

        int result = 0;

        for(int i = 1; i <= 1000; i++) {
            //System.out.println("numWord: "+i);
            result += new Euler17().letterCt(i);
        }

        System.out.println("Result: "+result);


        long stop = System.currentTimeMillis();
        System.out.println(stop-start + "ms");
    }

}