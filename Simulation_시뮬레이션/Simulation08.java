// 날짜 : 2022/09/03
// 문제 : 빙빙 돌며 숫자 사각형 채우기 2
// 문제 설명 : n * m 크기의 직사각형에 숫자 1부터 순서대로 증가시키며 달팽이 모양으로 채우는 코드를 작성해보세요.
// 달팽이 모양이란 왼쪽 위 모서리에서 시작해서, 아래, 오른쪽, 위쪽, 왼쪽 순서로 더 이상 채울 곳이 없을 때까지 회전하는 모양을 의미합니다.
// n : 행(row), m : 열(column)을 의미합니다.

// 입력 형식 : n과 m이 공백을 사이에 두고 주어집니다.
// 1 ≤ n, m ≤ 100

// 입력 예제 :
// 4 4

// 출력 예제 :
// 1 12 11 10
//2 13 16 9
//3 14 15 8
//4 5 6 7

package Simulation_시뮬레이션;

import java.util.*;
import java.io.*;

public class Simulation08{
    public static final int MAX = 100; // 사각형의 최대 행 or 열
    public static int[][] arr = new int[MAX][MAX]; // 2차원 배열

    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1}; // 남 동 북 서
    public static int dirNum = 0; // 초기 방향
    public static int row = 0, col = 0; // 초기 위치
    public static int n,m;

    public static boolean checkRange(int row, int col){ // 범위 체크하는 메서드
        return row >= 0 && row < n && col >= 0 && col < m;
    }
    public static void main(String[] args)throws IOException {
        // Your Program Goes Here

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 입력

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());



        for(int i = 1; i <= m*n; i++){

            arr[row][col] = i;

            int rowTest = row + dx[dirNum];
            int colTest = col + dy[dirNum];

            if(!checkRange(rowTest,colTest) || arr[rowTest][colTest] != 0){
                dirNum = (dirNum + 1) % 4;
            }

            row = row + dx[dirNum];
            col = col + dy[dirNum];
        }
        // 출력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
