package baekjoon;

import java.util.Scanner;

public class bj2775 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[k][n+1];
            System.out.println(count(k,n, arr));

        }
    }


    public static int count(int k, int n, int[][] arr){
        int num = 0;
        if(k == 0){
            arr[k][n] = n;
            return n;
        }
        else
            for (int i = 1; i <= n; i++) {
                if(arr[k-1][i]==0)
                    num += count(k-1, i, arr);
                else
                    num += arr[k-1][i];
            }
            return num;
    }
}
