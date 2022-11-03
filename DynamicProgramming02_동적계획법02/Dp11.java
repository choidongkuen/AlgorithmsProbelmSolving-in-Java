// 날짜 : 2022/ 11/ 03
// 문제 : 배낭 채우기(knap sack)
// 문제 설명 :
// N개의 보석의 정보가 주어졌을 때, 보석을 적절하게 골라 무게의 합이 M을 넘지 않도록 하면서 가치의 합은 최대가 되도록 하는 프로그램을 작성해보세요.
// 예를 들어 N=4,M=20, 보석의 종류가 다음과 같이 주어졌다고 생각해봅시다.
// 1,2번 보석을 고르게 되면 고른 보석 무게의 총 합이 25가 되어 M을 넘게 되므로 불가능합니다.
// 1,4번 보석을 고르게 되면 무게가 M을 넘지 않으면서 총 39만큼의 가치를 얻게 됩니다.
// 2,3번 보석을 고르게 되면 무게가 M을 넘지 않으면서 총 40만큼의 가치를 얻게 됩니다.

// 입력 형식 :
// 첫째 줄에는 N과 M이 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터는 N개의 줄에 걸쳐 보석의 정보 (w,v) 가 공백을 사이에 두고 주어집니다. w는 해당 보석의 무게를 의미하며, v는 해당 보석의 가치를 의미합니다. (1≤w≤10,000,1≤v≤10,000)
// 1≤N≤100
// 1≤M≤10,000


// 입력 예시 01 :
// 3 7
// 5 8
// 3 6
// 4 4

// 출력 예시 01 :
// 10

package DynamicProgramming02_동적계획법02;

import java.util.ArrayList;
import java.util.Scanner;

public class Dp11 {
    public static final int MAX_N = 100;
    public static final int MAX_M = 10000;

    public static int n,m;
    public static int[][] dp = new int[MAX_N + 1][MAX_M + 1];
    public static int[] weights = new int[MAX_N + 1];
    public static int[] values = new int[MAX_N + 1];


    public static int getNaxVal(){

        dp[0][0] = 0; // 0번째 보석까지 고려하면서 0무게를 담을 때 얻을 수 있는 최대 무게 = 0

        for (int i = 1; i <= n ; i++) {

            for (int j = 1; j <= m ; j++) {

                if(weights[i] > j)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                // i의 무게가 j보다 작다고 해서 모두 이식으로 통일 할 수 있는 이유
                // 만약 dp[i - 1][j - weights[i]] 가 업데이트가 되지 않았다면 0일 것이다.
            }

        }
        int ans = 0;

        for (int i = 0; i <= m ; i++) {
            ans = Math.max(ans, dp[n][i]);
        }

        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n ; i++) {

            int w = sc.nextInt();
            int v = sc.nextInt();
            weights[i] = w;
            values[i] = v;

        }

        int ans =  getNaxVal();
        System.out.println(ans);

        for (int i = 0; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                System.out.print(dp[i][j] + " ");

            }
            System.out.println();
        }

    }

}
