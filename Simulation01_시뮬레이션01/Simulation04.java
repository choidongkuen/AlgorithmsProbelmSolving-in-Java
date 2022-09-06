// 문제 : 색종이의 총 넓이
// 날짜 : 2022/08/22
// 문제 설명 : 좌표평면위에 가로세로 길이가 8이고 넓이가 64인 색종이가 N장 주어집니다.
// 이 N장 색종이의 각 좌측하단의 꼭지점이 주어졌을 때 모든 색종이가 붙여진 이후의 총 넓이를 구하는 프로그램을 작성해보세요.
// 단, 모든 색종이는 좌표평면위에서 (-100, -100)을 좌측하단으로 (100, 100)을 우측상단으로 하는 정사각형 범위를 벗어나지 않는다고 가정해도 좋습니다.
// 또한 겹치는 영역은 단 한번만 넓이에 포함시킵니다.

// 입력 형식
// 첫 번째 줄에는 정수 N이 주어집니다.
//두 번째 줄부터 각 줄마다 정사각형 크기인 색종이의 좌측하단 꼭지점의 위치가 총 N번 주어집니다.
//1 ≤ N ≤ 100

// 입력 예제
// ===============================================================
// 3
// 0 0
// 4 0
// 0 4
// 출력 예제
// ===============================================================
// 128

package Simulation01_시뮬레이션01;

import java.util.Scanner;

public class Simulation04 {
    public static final int OFFSET = 100;
    public static final int MAX_R = 200;
    public static final int MAX_N = 100;

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

        for(int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = x1[i] + 8;
            y2[i] = y1[i] + 8;

            // OFFSET을 더해줍니다.
            x1[i] += OFFSET;
            y1[i] += OFFSET;
            x2[i] += OFFSET;
            y2[i] += OFFSET;
        }

        // 직사각형을 칠해줍니다.
        // 격자 단위로 진행하는 문제이므로
        // x2, y2에 등호가 들어가지 않음에 유의합니다.
        for(int i = 0; i < n; i++)
            for(int x = x1[i]; x < x2[i]; x++)
                for(int y = y1[i]; y < y2[i]; y++)
                    checked[x][y] = 1;

        // 직사각형 넓이의 총 합을 구합니다.
        int area = 0;
        for(int x = 0; x <= MAX_R; x++)
            for(int y = 0; y <= MAX_R; y++)
                if(checked[x][y] > 0)
                    area++;

        System.out.print(area);
    }
}
