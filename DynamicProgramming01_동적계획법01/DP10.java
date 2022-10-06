// 날짜 : 2022/10/06
// 문제 : 사각형 채우기2

// 문제 설명 :
// 2 × n 크기의 사각형을 1 × 2, 2 × 1, 2 x 2 크기의 사각형들로 채우는 방법의 수를 구하는 프로그램을 작성해보세요.
// 예로 n = 2일 때는 다음과 같이 3가지 방법이 가능합니다.

// 입력 형식 :
// 첫 번째 줄에 n이 주어집니다.
// 1 ≤ n ≤ 1,000

// 입력 예시 01:
// 2

// 출력 예시 01 :
// 3

// 입력 예시 02 :
// 8

// 입력 예시 02 :
// 171

package DynamicProgramming01_동적계획법01;

import java.util.Scanner;

public class DP10 {
    public static final int MAX_N = 1000;
    public static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n ; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}
