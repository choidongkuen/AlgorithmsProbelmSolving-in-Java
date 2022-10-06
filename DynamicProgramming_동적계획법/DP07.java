// 날짜 : 2022/10/06
// 문제 : 계단 오르기
// 문제 설명 :
// n층 높이의 계단을 오르려고 합니다. 한 번에 정확히 2계단 혹은 3계단 단위로만 올라갈 수 있다고 했을 때, n층 높이의 계단에 올라가기 위한 서로 다른 방법의 수를 구하는 프로그램을 작성해보세요.
// 단, 항상 2계단 혹은 3계단 단위로만 올라갈 수 있기에 n층까지 정확히 1계단이 남은 상황에서는 n층으로 올라갈 수 있는 방법이 전혀 없음에 유의합니다.
// 예로 n = 5일 때는 다음과 같이 2가지 방법이 가능합니다.

package DynamicProgramming_동적계획법;

import java.util.*;

public class DP07 {
    public static final int MAX_N = 1000;
    public static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 계단의 높이

        dp[0] = dp[1] = dp[2] = dp[3] = 1;

        for (int i = 4; i <= n ; i++) {
            dp[i] = (dp[i - 2] + dp[i - 3]) % 10007;
        }

        System.out.println(dp[n]);
        System.out.println(Arrays.toString(dp));
    }
}
