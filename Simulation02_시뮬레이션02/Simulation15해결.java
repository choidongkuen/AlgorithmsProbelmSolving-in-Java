package Simulation02_시뮬레이션02;

import java.util.Scanner;

public class Simulation15해결 {
    public static final int MAX = 100;
    public static final int DIR = 4;

    public static int[][] arr = new int[MAX][MAX];
    public static int n;
    public static int startRow, startCol;
    public static int[] dis = new int[DIR];

    public static int[] dx = {-1,-1,1,1};
    public static int[] dy = {1,-1,-1,1};
    // 방향이 정해져 있음
    // dir == 0(반시계), 1(시계)

    public static void simulate(){




    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        startRow = sc.nextInt();
        startCol = sc.nextInt();

        for (int i = 0; i < DIR ; i++) {
            dis[i] = sc.nextInt();
        } // 각 이동 거리 저장

        simulate();
    }
}
