package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj1157 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toLowerCase();
        int[][] count = new int[26][2];
        for (int i = 0; i < 26; i++) {
            count[i][0] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a'][1]++;
        }

        Arrays.sort(count, (o1, o2) -> o2[1]-o1[1]);
        if(count[0][1] == count[1][1])
            System.out.println("?");
        else
            System.out.println((char)(count[0][0]+'A'));
    }
}