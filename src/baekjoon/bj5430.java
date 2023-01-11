package baekjoon;

import java.io.*;
import java.util.*;

public class bj5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine()); //테스트케이스 개수

        for (int i = 0; i < tc; i++) {
            String p = br.readLine(); //연산
            int n = Integer.parseInt(br.readLine()); //입력받을 배열의 크기
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s.substring(1, s.length() - 1), ","); //[] 안에있는 숫자들을 ,를 기준으로 구분
            Deque<Integer> deque = new LinkedList<>(); //입력받은 수
            while (st.hasMoreTokens())
                deque.add(Integer.parseInt(st.nextToken()));
            System.out.println(AC(p, deque));
        }
    }

    //입력받은 연산대로 처리하는 메서드
    public static String AC(String p, Deque<Integer> deque) {
        boolean reverse = false; //뒤집은 상태인가?
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == 'R') //뒤집기 연산의 경우 reverse값 변경
                reverse = !reverse;
            else {
                if (deque.isEmpty()) //비어있는데 D 연산을 입력한 경우
                    return "error";
                else if(!reverse) //뒤집혀있지 않은 상태라면 앞에서부터 원소 제거
                    deque.poll();

                else //뒤집혀있다면 뒤에서부터 원소 제거
                    deque.removeLast();
            }
        }
        StringBuilder sb = new StringBuilder("[");
        if (deque.isEmpty())
            sb.append("]");
        else {
            if(!reverse) { //뒤집혀있지 않다면 앞에서부터 출력
                while (deque.size() > 1)
                    sb.append(deque.poll()).append(",");
                sb.append(deque.poll()).append("]");
            }
            else{ //뒤집혀있다면 뒤에서부터 출력
                while (deque.size() > 1)
                    sb.append(deque.removeLast()).append(",");
                sb.append(deque.removeLast()).append("]");
            }
        }

        return sb.toString();
    }
}