package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //사람의 수
        int[] arr = new int[n]; //사람마다 인출하는데 걸리는 시간이 담긴 배열

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt(); //시간 입력받기

        Arrays.sort(arr); //오름차순으로 정렬

        int sum = 0; //모든 사람이 기다린 시간 총합
        int tmp = 0; //개인이 기다린 시간

        for (Integer x : arr) {
            tmp += x; //개인이 인출하는 만큼 대기시간 증가
            sum += tmp; //현재 사람이 기다린 대기시간을 총합에 더하기
        }
        System.out.println(sum);
    }
}