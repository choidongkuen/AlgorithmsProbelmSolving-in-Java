// 날짜 : 2022/10/06
// 문제 : 최대 점프 횟수 구하기
// 문제 설명 :
// n개의 정점에 대한 점프 가능한 거리가 주어 질 때, 최대 점프 횟수를 구하세요.

// 처음 정점에서 시작해서 특정 정점까지의 최대 점프수를 다 구해보고
// 마지막에 최대값을 구한다.
// dp[i] 는 시작점에서 i번째 정점까지의 최대 점프 횟수

package DynamicProgramming01_동적계획법01;

import java.util.Scanner;
/*
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
        // 예를 들어 특정 i 인덱스 기준으로
        // i 이전에 존재하는 조건을 만족하는 j 가 있었다고 할 때,
        // j까지 도달하지 못하는 상황인데 만약 조건을 만족한다 해서, dp[j] + 1
        // 을 하게 되면 잘못된 값 도출 -> Integer.MIN_VALUE 로 설정해야 함.
        dp[0] = 0; // 첫 위치

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
*/