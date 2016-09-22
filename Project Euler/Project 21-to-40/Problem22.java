/*
    Names scores
    Problem 22
        Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.

        For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.

        What is the total of all the name scores in the file?
*/

import java.io.*;
import java.util.*;
import java.io.File;

public class Problem22 {

    public static void main(String[] args) throws IOException {
        long begin = System.currentTimeMillis();
		
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z' };
        ArrayList<Character> al_alphabet = new ArrayList<Character>();
        for (int i = 0; i < alphabet.length; i++) {
            al_alphabet.add(alphabet[i]);
        }

        File file = new File("names.txt");
        InputStream in = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int data = in.read();
            if (data == -1) {
                in.close();
                break;
            } else {
                sb.append((char) data);
            }
        }
        String file_content = sb.toString();

        String[] names = file_content.split(",");
        Arrays.sort(names);

        int scores_sum = 0;
        for (int i = 0; i < names.length; i++) {

            String name = names[i];
            name = name.substring(1, name.length() - 1);
            name = name.toLowerCase();

            int worth_sum = 0;
            for (int j = 0; j < name.length(); j++) {
                char letter = name.charAt(j);
                int letter_worth = al_alphabet.indexOf(letter) + 1;
                worth_sum += letter_worth;
            }

            int score = (i + 1) * worth_sum;
            scores_sum += score;
        }

        System.out.println(scores_sum);
        long end = System.currentTimeMillis();
		System.out.println(end-begin + "ms");
    }

}