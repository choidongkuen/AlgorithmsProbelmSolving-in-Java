// 날짜 : 2022/10/07
// 문제 : 사각형 채우기
// 문제 설명 :
// 2 × n 크기의 사각형을 1 × 2, 2 × 1 크기의 사각형들로 채우는 방법의 수를 구하는 프로그램을 작성해보세요
// 예로 n = 3 3가지 방법 가능

// 점화식 : dp[i] = dp[i - 2] + dp[i - 1]
// dp[i] 는 2 x i 칸일 때 조건에 맞게 채우는 방법의 수

package DynamicProgramming_동적계획법;

import java.util.Scanner;

public class DP08 {
    public static final int MAX_N = 1000;
    public static int n;

    public static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n ; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        System.out.println(dp[n]);

    }
}
