// 날짜 : 2022/11/03
// 문제 : 양수 직사각형의 최대 크기
// 문제 설명 :
// n * m크기의 이차원 영역의 각 위치에 정수 값이 하나씩 적혀있습니다. 이 영역 안에서 가능한 양수 직사각형 중 최대 크기를 구하려고 합니다.
// 양수 직사각형이란, 직사각형의 변들이 주어진 격자 판에 평행하면서, 직사각형 내에 있는 숫자들이 전부 양수인 직사각형을 의미합니다. 최대 크기의 양수 직사각형을 찾는 프로그램을 작성해보세요.
// 예를 들어 다음 그림의 경우에는, 크기가 6인 양수 직사각형을 찾을 수 있습니다.


// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어지고, 두 번째 줄부터 (n+1)번째 줄까지는 각 행의 숫자가 공백을 사이에 두고 주어집니다.
// 1 ≤ n, m ≤ 20
// -1,000 ≤ 정수 값 ≤ 1,000

// 입력 예시 01 :
// 3 3
// 1 2 3
// 3 4 5
// 6 7 8

// 출력 예시 01 :
// 9
package Simulation02_시뮬레이션02;

import java.util.Scanner;

public class Simulation12 {

    public static final int MAX = 20;
    // n,m의 max 값이 작음으로, 시뮬레이션(완전탐색) 충분히 가능
    public static int[][] arr = new int[MAX][MAX];
    public static int n,m;
    public static int maxSize = Integer.MIN_VALUE;


    public static boolean isPossible(int x1, int y1, int x2, int y2){

        for (int i = x1; i <= x2  ; i++) {
            for (int j = y1; j <= y2 ; j++) {
                if(arr[i][j] <= 0) // 0은 양수 포함  x
                    return false;
            }
        }
        return true;
    }
    public static void getMaxSize(int x1, int y1, int x2, int y2){

        if(isPossible(x1,y1,x2,y2)){
            maxSize = Math.max(maxSize, (x2 - x1 + 1) * (y2 - y1 + 1));

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();


        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                for (int k = i ; k < n ; k++) {
                    for (int l = j; l < m ; l++) {

                        getMaxSize(i,j,k,l);

                    }
                }
            }
        }

        System.out.println(maxSize == Integer.MIN_VALUE? -1 : maxSize);
    }
}
