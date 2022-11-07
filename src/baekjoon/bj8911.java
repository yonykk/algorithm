package baekjoon;

import java.io.*;
public class bj8911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //테스트케이스 개수
        int tc = Integer.parseInt(br.readLine());
        //방향에 따라 x, y에 더할 값을 담은 배열
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int t = 0; t < tc; t++) {
            String s = br.readLine();

            //max, min값의 x, y좌표를 담을 값
            int minX = 0;
            int maxX = 0;
            int minY = 0;
            int maxY = 0;

            //현재 좌표의 x, y값과 방향값 n
            int x = 0;
            int y = 0;
            int n = 0;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == 'F') { //전진
                    x += directions[n%4][0];
                    y += directions[n%4][1];
                }
                else if(c == 'B') { //후진
                    x -= directions[n%4][0];
                    y -= directions[n%4][1];
                }
                else if(c == 'L') //왼쪽으로 회전
                    n += 3;

                else //오른쪽으로 회전
                    n++;

                //max, min 값 비교 후 갱신
                if(x > maxX)
                    maxX = x;
                else if(x < minX)
                    minX = x;

                if(y > maxY)
                    maxY = y;
                else if(y < minY)
                    minY = y;

            }
            System.out.println((maxX-minX)*(maxY-minY));
        }
    }

}

