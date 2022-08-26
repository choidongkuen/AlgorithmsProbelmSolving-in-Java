// 문제 : 정수 사각형 최소 합
// 날짜 : 2022 / 08 / 25

// 문제 설명 :
// N×N 행렬이 주어졌을 때, (1,N)에서 시작하여 왼쪽 혹은 밑으로만 이동하여 (N,1)로 간다고 했을 때
// 거쳐간 위치에 적혀있는 숫자의 합을 최소로 하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫째 줄에는 N이 주어집니다.
// 두 번째 줄 부터 N개의 줄에 각각 각 행에 해당하는 N개의 정수 값이 공백을 사이에 두고 주어집니다.
// 1≤N≤100
// 1≤ 행렬에 주어지는 숫자 ≤1,000,000

// 입력 예시 :
// 3
// 5 2 1
// 1 9 1
// 1 8 9

// 출력 예시 :
// 10
package DynamicProgramming_동적계획법;
import java.util.*;

public class Dp02 {
    public static final int MAX = 100; // 최대 n 값
    public static final int INT_MAX = Integer.MAX_VALUE; // 정수의 최대값(최소 값을 구하기 위함)
    public static int[][] arr = new int[MAX][MAX]; // 2차원 arr 배열
    public static int[][] dp = new int[MAX][MAX]; // 2차원 Dp 배열
    public static int n; // n 값

    public static void initialize(){ // 초기화 메서드
        dp[0][n-1] = arr[0][n-1];

        for(int i = 1; i < n; i++){
            dp[0][n - 1 -i] = dp[0][n- 1 - (i - 1)] + arr[0][n - 1 - i];
        } // 0 행 초기화

        for(int i = 1; i < n; i++){
            dp[i][n-1] = dp[i - 1][n - 1] + arr[i][n - 1];
        } // n - 1 열 초기화
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n입력

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt(); // arr 배열 채워주기

        initialize(); // 초기화 메서드

        for(int i = 1; i < n ; i++)
            for(int j = n - 2; j >= 0; j--)
                dp[i][j] = Math.min(dp[i][j + 1], dp[i - 1][j]) + arr[i][j];
        // 2차원 dp 배열 채우기

        System.out.println(dp[n-1][0]); // 숫자의 합의 최소값 출력
    }
}