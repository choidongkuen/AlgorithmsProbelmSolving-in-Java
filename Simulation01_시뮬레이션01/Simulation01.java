
package Simulation01_시뮬레이션01;
import java.util.Scanner;
// n이 주어지고 n 줄에 걸쳐 각 줄마다 x1,y1,x2,y2 가 주어진다.
// 입력
/*
 * 2
0 1 4 5
2 2 6 4
 */

// 출력
/* 20
 */
class Simulation01{
    public static final int MAX_N = 10;
    public static final int MAX_R = 200;
    public static final int OFFSET = 100;

    public static int n;
    public static int[] x1 = new int[MAX_N];
    public static int[] y1 = new int[MAX_N];
    public static int[] x2 = new int[MAX_N];
    public static int[] y2 = new int[MAX_N];

    public static int[][] checked = new int[MAX_R + 1][MAX_R + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();

            // OFFSET을 더해준다.
            x1[i] += OFFSET;
            y1[i] += OFFSET;
            x2[i] += OFFSET;
            y2[i] += OFFSET;
        }

        // 직사각형을 칠해준다.
        // 격자 단위로 진행하는 문제이므로
        // x2, y2에 등호가 들어가지 않음에 유의하기
        for (int i = 0; i < n; i++)
            for (int x = x1[i]; x < x2[i]; x++)
                for (int y = y1[i]; y < y2[i]; y++)
                    checked[x][y]++;

        // 직사각형 넓이의 총 합을 구한다.
        int area = 0;
        for (int x = 0; x <= MAX_R; x++)
            for (int y = 0; y <= MAX_R; y++)
                if (checked[x][y] > 0)
                    area++;

        // 출력
        System.out.print(area);
    }
}
