package baekjoon;

import java.util.*;

public class bj1012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for (int t = 0; t < tc; t++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int count = 0;

            boolean[][] arr = new boolean[m][n];
            for (int i = 0; i < k; i++) {
                arr[sc.nextInt()][sc.nextInt()] = true;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j]){
                        count ++;

                        //bfs 풀이
                        Queue<Location> q = new LinkedList<>();
                        q.offer(new Location(i,j));
                        arr[i][j] = false;
                        while (!q.isEmpty()) {
                            Location l = q.poll();

                            if(l.x + 1 < m && arr[l.x+1][l.y]) {
                                q.offer(new Location(l.x+1, l.y));
                                arr[l.x+1][l.y] = false;
                            }
                            if(l.x -1 >= 0 && arr[l.x-1][l.y]) {
                                q.offer(new Location(l.x-1, l.y));
                                arr[l.x-1][l.y] = false;
                            }
                            if(l.y + 1 < n && arr[l.x][l.y+1]) {
                                q.offer(new Location(l.x, l.y+1));
                                arr[l.x][l.y+1] = false;
                            }
                            if(l.y -1 >= 0 && arr[l.x][l.y-1]) {
                                q.offer(new Location(l.x, l.y-1));
                                arr[l.x][l.y-1] = false;
                            }


                        }
                    }

                }
            }
            System.out.println(count);
        }
    }

    //dfs 풀이
    public static void dfs(boolean[][] arr, int x, int y){
        arr[x][y] = false;

        if(x + 1 < arr.length && arr[x+1][y]) {
            dfs(arr, x+1, y);
        }
        if(x -1 >= 0 && arr[x-1][y]) {
            dfs(arr, x-1, y);
        }
        if(y + 1 < arr[x].length && arr[x][y+1]) {
            dfs(arr, x, y+1);
        }
        if(y -1 >= 0 && arr[x][y-1]) {
            dfs(arr, x, y-1);
        }

    }
}

class Location{
    int x;
    int y;

    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

