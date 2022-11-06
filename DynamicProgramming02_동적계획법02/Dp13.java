// 날짜 : 2022/11/06
// 배낭 채우기(1차원 배열 ver)
// 문제 설명 :
// Dp11 과 동일

// 입력 형식 :
// Dp11 과 동일

// 기존 점화식 : dp[i][j] -> i번째 보석까지 고려, 최대 j 무게일때 얻을 수 있는 최대 가치
// 1차원 배열을 이용한 점화식 :
// dp[j] -> 최대 j 무게를 담을 수 있을 때 얻을 수 있는 최대 가치
// 위 방식의 특징 -> i가 증가(고려 대상이 되는 보석 개수) 함에 따라 계속 dp[j] 가 업데이트 된다.

package DynamicProgramming02_동적계획법02;


import java.util.Arrays;
import java.util.Scanner;

public class Dp13{
    public static final int MAX_N = 10000;
    public static final int MAX_M = 100;

    public static int[] dp = new int[MAX_M + 1];
    public static int n,m;

    public static int[] weights = new int[MAX_N + 1];
    public static int[] values = new int[MAX_N + 1];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n ; i++) {

            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }

        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n ; i++) {

            // j가 i번째 보석의 무게까지 고려함으로, j < weights[i] 발생할 일이 없다.
            for (int j = m; j >= weights[i] ; j --) {
                dp[j] = Math.max(dp[j],dp[j - weights[i]] + values[i]);
            }
        }

        int ans = 0;

        for (int i = 0; i <= m ; i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);

        for (int i = 0; i <= m ; i++) {
            System.out.print(dp[i] + " ");
        }

    }
}

