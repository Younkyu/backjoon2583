package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] arr = new int[M][N];
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            for (int j = sx; j < ex; j++) {
                for (int k = sy; k < ey; k++) {
                    arr[k][j] = 1;
                }
            }
        }
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == 0) {
                    int area = bfs(arr, i,j);
                    list.add(area);
                }
            }
        }

        list.sort(null);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

    }

    public static int bfs(int[][] arr, int x, int y) {
        int M = arr.length;
        int N = arr[0].length;
        if( x == -1 || y == -1 || x == M || y == N) return 0;
        if(arr[x][y] > 0) return 0;
        arr[x][y] = 2;
        return 1 + bfs(arr, x+1,y) + bfs(arr, x-1,y) + bfs(arr, x,y+1) + bfs(arr, x,y-1);
    }
}
