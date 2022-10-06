// 날짜 : 2022/10/06
// 문제 : 사각형 채우기2
// 문제 설명 :
// 2 × n 크기의 사각형을 1 × 2, 2 × 1, 1 x 1 크기의 사각형들로 채우는 방법의 수를 구하는 프로그램을 작성해보세요.

// 입력 예시 01:
// 1
// 출력 예시 01:
// 2

// 입력 예시 02 :
// 2
// 출력 예시 02:
// 7

// 점화식 : dp[i] = dp[i - 2] * 3 + dp[i - 1] * 2

package DynamicProgramming_동적계획법;

import java.util.Scanner;

public class DP09 {
    public static final int MAX_N = 1000;
    public static long[] dp = new long[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp[1] = 2;
        dp[2] = 7;
        for (int i = 3; i <= n ; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3 + 2 * dp[i - 3]) % 1000000007;
            for (int j = i - 3; j >= 0  ; j--) {
                dp[i] = (dp[i] + dp[j] * 2) % 1000000007;
            }
        }

        System.out.println(dp[n]);
    }
}
