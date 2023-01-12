package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class bj1927 {
    public static void main(String[] args) throws IOException {
        //최솟값부터 내보내는 우선순위큐 생성
        PriorityQueue<Integer> min = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //읽을 숫자의 개수
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            //입력받는 숫자
            int num = Integer.parseInt(br.readLine());
            //0이면 최솟값을 출력하고 제거한다.
            if(num == 0) {
                //만약 큐가 비어있으면 0을 출력한다.
                if(min.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(min.poll());
            }
            //0이 아닌 숫자가 들어왔을 경우 큐에 삽입한다.
            else
                min.offer(num);
        }



    }
}