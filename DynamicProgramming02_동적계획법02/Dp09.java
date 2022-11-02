// 날짜 : 2022/11/02
// 문제 : 최대 동전 거슬러주기
// 문제 설명 :
// N개의 동전의 종류가 주어졌을 때, 금액 M을 거슬러주기 위한 방법 중 가능한 최대 동전의 수를 구해주는 프로그램을 작성해보세요.
// 단, 같은 종류의 동전을 여러 번 사용하여 거슬러 줄 수 있습니다.
// 예를 들어 N=3,M=10, 동전의 종류는 3,4,5 일때
// 10=5+5 이렇게 거슬러주면 총 2개의 동전이 사용되지만
// 10=3+3+4 이렇게 거슬러 주면 총 3개의 동전으로 돈을 거슬러 줄 수 있습니다.

// 입력 예시 01 :
// 3 10
// 3 4 5

// 출력 예시 01 :
// 3

package DynamicProgramming02_동적계획법02;

import java.util.Arrays;
import java.util.Scanner;

public class Dp09 {

    public static final int MAX_N = 100;
    public static final int MAX_M = 10000;

    public static int[] coins = new int[MAX_N];
    public static int[] dp = new int[MAX_M + 1];
    public static int n,m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            coins[i] = sc.nextInt();
        }


        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= m ; i++) {


            for (int j = 0; j < n ; j++) {
                if(i >= coins[j]){

                    if(dp[i - coins[j]] == Integer.MIN_VALUE)
                        continue;

                    dp[i] = Math.max(dp[i],dp[i - coins[j]] + 1);

                }
            }
        }

        System.out.println(dp[m] == Integer.MIN_VALUE? -1 : dp[m]);
        for (int i = 1; i <= m ; i++) {
            System.out.print(dp[i] + " ");
        }


    }
}
