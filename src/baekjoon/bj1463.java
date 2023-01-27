package baekjoon;

import java.util.Scanner;

public class bj1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[1] = 0;

        //2부터 n까지 최소 횟수를 저장하며 계산
        for (int i = 2; i <= n; i++) {
            int min = n; //최소 횟수. 최대 횟수인 n으로 시작

            if (i % 3 == 0) //3으로 나눠떨어진다면 3으로 나눈 배열의 값을 최소 횟수로 저장
                min = dp[i / 3];

            if (i % 2 == 0) //2로 나누어떨어지고 min 값보다 dp[i/2]값이 더 작으면 min 갱신
                if(min > dp[i / 2])
                min = dp[i / 2];

            if(min > dp[i-1]) //min 값보다 dp[i-1]값이 더 작으면 min 갱신
                min = dp[i-1];

            dp[i] = min + 1; //도달할 수 있는 최소 횟수에 count +1 반영한 값 저장
        }

        System.out.println(dp[n]);
    }
}