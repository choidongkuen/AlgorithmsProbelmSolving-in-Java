// 문제 : 정수 사각형 최솟값의 최대
// 날짜 : 2022 / 08 / 26

// 입력 형식 :
// 첫째 줄에는 N이 주어집니다.
//두 번째 줄 부터 N개의 줄에 각각 각 행에 해당하는 N개의 정수 값이 공백을 사이에 두고 주어집니다.
//1≤N≤100
//1≤ 행렬에 주어지는 숫자 ≤1,000,000

// 입력 예시 :
// 3
// 5 2 3
// 3 2 1
// 1 2 4

// 출력 예시 :
// 2

package DynamicProgramming_동적계획법;
import java.util.*;

import java.util.*;
// arr[i][j] 가 dp[i - 1][j] 와 dp[i][j - 1]보다 작다면  상관없이 arr[i][j]로 업데이트
// arr[i][j] 가 dp[i - 1][j] 와 dp[i][j - 1]보다 크다면 둘 중 최대값으로 업데이트

public class Dp03 {
    public static final int MAX = 100; // 최대 원소 수
    public static int[][] arr = new int[MAX][MAX]; // 2차원 Dp 배열
    public static int[][] dp = new int[MAX][MAX]; // 2차원 arr 배열
    public static int n; // n 값
    public static void initialize(){ // 초기화 메서드
        dp[0][0] = arr[0][0];

        for(int i = 1; i < n; i++)
            dp[i][0] = Math.min(dp[i - 1][0], arr[i][0]); // 0 열 초기화
        for(int i = 1; i < n; i++)
            dp[0][i] = Math.min(dp[0][i - 1], arr[0][i]); // 0 행 초기화
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            } // 2차원 배열 원소 입력
        }

        initialize(); // 초기화 메서드 호출

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(Math.max(dp[i - 1][j],dp[i][j - 1]),arr[i][j]);
            }
        }
        System.out.println(dp[n-1][n-1]); // 출력
    }
}