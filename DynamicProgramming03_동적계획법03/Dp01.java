// 날짜 : 2022/11/06
// 문제 : 격자안에서 겹치지 않은 위치의 최대값
// 문제 설명 :
// 매 시행마다 단 하나의 숫자를 선택하여 합을 최대로 만들어보려고 합니다. 단, 연속으로 같은 위치에 있는 숫자를 고를 수는 없다고 했을 때 가능한 합의 최댓값을 구하는 프로그램을 작성하시오.

// 입력 예시 01 :
// 3 3
// 1 5 3
// 2 8 5
// 3 3 3

// 출력 예시 01 :
// 14

// 아이디어 :
// dp[i][j] : i번째 행의 원소를 j 열에 넣을 때 얻을 수 있는 최대 합
// j 이전(k) 열과 겹치면 안되게 점화식을 세운다.
// dp[i][j] = max(dp[i - 1][k],dp[i][j]) 단 j != k

package DynamicProgramming03_동적계획법03;

import java.util.Arrays;
import java.util.Scanner;

public class Dp01 {

    public static final int MAX = 100;
    public static int n,m;

    public static int[][] dp = new int[MAX + 1][MAX + 1];
    public static int[][] arr = new int[MAX + 1][MAX + 1];

    public static void initialize(){

        for (int i = 1; i <= n ; i++) {
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }

        for (int i = 1; i <= m ; i++) {
            dp[1][i] = arr[1][i];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();


        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        initialize();

        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                // 해당 dp[i][j] 위치를 구하는 경우

                for (int k = 1; k <= m ; k++) {
                    if(j != k){
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + arr[i][j]);
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= m ; i++) {
            ans = Math.max(ans, dp[n][i]);
        }
        System.out.println(ans);
    }
}
