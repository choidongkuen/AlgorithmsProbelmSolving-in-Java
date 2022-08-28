// 문제 : knapsack
// 날짜 : 2022 / 08 / 27
// 문제 설명 : 도둑 가방의 크기는 k이며, 이보다 더 많은 양의 무게에 해당하는 보석들을 담아 나올 수는 없습니다.
// 또한, 보석은 종류별로 단 하나씩만 있습니다. 이 도둑방에 있는 보석의 무게와 가격은 다음과 같습니다.
// 번호 무게 가격
// 1   3	4
// 2   1	1
// 3   4	2
// 4   5	6
// 5   2	3
// k가 주어질 때, 도둑이 훔칠 수 있는 보석의 최대 가격은 ?
// dp[i][j] = i 번째까지의 보석을 고려하고, j 무게를 맞출때, 얻을 수 있는 보석의 최대 가격

package DynamicProgramming_동적계획법;

import java.util.Scanner;

public class Dp06 {
    public static final int numbers = 5; // 보석 수 + 1
    public static int[] weights = {0,2,6,2,3,4};
    public static int[] values = {0,3,5,4,2,3};
    public static int[][] dp;
    public static int k; // 가방의 크기 - > dp[numbers][k] 를 구하는 것이 목표
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("가방의 크기 입력: ");
        k = sc.nextInt(); // 가방의 크기 입력

        dp = new int[100][100]; // dp 배열 크기 설정
        dp[0][0] = 0;


        for (int i = 1; i <= numbers; i++) {
            for (int j = 0; j <= k; j++) {
                if (j >= weights[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.printf("%d크기 가방으로 가져갈 수 있는 보석의 최대치는 ", k);
        System.out.println(dp[numbers][k]);

        System.out.println(" == dp 배열 ==");
        for (int i = 1; i <= numbers ; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
