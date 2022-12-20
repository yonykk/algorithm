package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class bj14719 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(); // 벽 최대 높이
        int w = sc.nextInt(); // 벽의 개수

        sc.nextInt();

        int[] arr = new int[w]; // 벽 높이 배열
        int result = 0; // 총 빗물 값

        for (int i = 0; i < w; i++) {
            arr[i] = sc.nextInt();
        }


        for (int i = 0; i < w; i++) {
            int sum = 0; //현재 구간의 빗물 합
            int max = i + 1; // 가장 높은 벽의 인덱스값
            Stack<Integer> stack = new Stack<>(); //칸마다 고이는 빗물 양이 담긴 스택
            for (int j = max; j < w; j++) {
                if (arr[i] <= arr[j]) { // j번째 벽이 현재 기준인 i번째 벽보다 높을 경우
                    result += sum; // 현재까지 구한 빗물 양을 result에 반영
                    i = j - 1; // 기준점을 j로 변경
                    max = w;
                    break;
                }

                stack.push(arr[i] - arr[j]); // 고일 수 있는 빗물 값을 stack에 push
                sum += stack.peek(); // 현재 합계에 빗물 값 더하기
                if (arr[j] >= arr[max]) // 만약 max값보다 더 큰 높이를 가진 벽이라면 max값 갱신
                    max = j;
            }
            if (max < w && (max - i) * (arr[i] - arr[max]) > 0) { // max가 배열을 벗어나지 않았으며, 현재 벽 높이보다 높은 벽이 나타나지 않았을 때
                while (!stack.isEmpty() && stack.peek() != arr[i] - arr[max]) // max값 뒤에 계산된 빗물 값 빼주기
                    sum -= stack.pop();
                result += sum - (max - i) * (arr[i] - arr[max]); //현재 벽 높이와 최대 높이의 차이만큼 더 계산된 빗물 양을 제외하고 result에 더해주기
                i = max - 1; // 기준점을 max로 변경
            }
        }

        System.out.println(result);
    }
}
