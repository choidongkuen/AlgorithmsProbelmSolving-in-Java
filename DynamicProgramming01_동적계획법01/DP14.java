// 날짜 : 2022/10/06
// 문제 : 최대 점프 횟수 구하기
// 문제 설명 :
// n개의 정점에 대한 점프 가능한 거리가 주어 질 때, 최대 점프 횟수를 구하세요.

// 처음 정점에서 시작해서 특정 정점까지의 최대 점프수를 다 구해보고
// 마지막에 최대값을 구한다.
// dp[i] 는 시작점에서 i번째 정점까지의 최대 점프 횟수

package DynamicProgramming01_동적계획법01;

import java.util.Scanner;

public class DP14 {

    public static final int MAX_N = 100;

    public static int[] jumps = new int[MAX_N];
    public static int[] dp = new int[MAX_N];
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            jumps[i] = sc.nextInt();
        }

        for (int i = 0; i < n ; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i < n ; i++) {
            for (int j = 0; j < i ; j++) {
                if(dp[j] == Integer.MIN_VALUE)
                    continue;

                if(j + jumps[j] >= i){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n ; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);

    }
}
