package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class bj12789 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //변수 선언
        int n = Integer.parseInt(br.readLine());    //줄 서있는 사람의 수
        int num = 1;                                //현재 입장할 번호표의 숫자
        String s = br.readLine();                   //줄 서있는 사람들의 번호표를 담은 문자열
        Stack<Integer> line = new Stack<>();        //현재 줄 서있는 사람들의 번호표를 담은 stack
        Stack<Integer> space = new Stack<>();       //임시공간에 빠져있는 사람들의 번호표를 담은 stack

        String[] arr = s.split(" ");

        //줄 서있는 사람 번호표 입력
        for (int i = n-1; i >= 0; i--) {
            line.push(Integer.parseInt(arr[i]));
        }

        while (!line.isEmpty()) {
            //임시 공간에 빠져있는 맨 앞 사람이 가지고 있는 번호표가 입장할 순서인지 체크
            while (!space.isEmpty() && space.peek() == num) {
                space.pop();
                num++;
            }

            //줄 서있는 사람이 입장할 순서인지 체크하고 순서가 아니라면 임시 공간으로 보내기
            int x = line.pop();

            if(num == x)
                num++;
            else
                space.push(x);

        }

        //임시 공간 번호표 검사
        while (!space.isEmpty()) {
            int x = space.pop();

            //입장할 순서가 아니라면 순서가 꼬인 상태이므로 sad 출력하기
            if (num == x) {
                num++;
            }
            else {
                System.out.println("Sad");
                num = 0;
                break;
            }
        }

        if(num != 0) {
            System.out.println("Nice");
        }
    }
}