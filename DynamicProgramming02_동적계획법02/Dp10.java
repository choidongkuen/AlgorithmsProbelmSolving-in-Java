package DynamicProgramming02_동적계획법02;

import java.util.Arrays;
import java.util.Scanner;
public class Dp10{

    public static final int MAX_N = 100;
    public static final int MAX_M = 10000;

    public static int[] arr = new int[MAX_N + 1];
    // dp[i][j] : i번째 원소까지 고려시 j 합을 만들 수 있는지 여부
    public static boolean[][] dp = new boolean[MAX_N + 1][MAX_M + 1];
    public static int n,m;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            arr[i] = sc.nextInt();
        }

        // 0번째 원소까지 이용해서 0을 만들 수 있는지 여부 ? true
        dp[0][0] = true;

        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= m ; j++) {

                // case 1 : i 번째 원소를 선택하는 경우

                if(j >= arr[i] && dp[i - 1][j - arr[i]])
                    dp[i][j] = true;

                // case 2 : i번째 원소를 선택하지 않는 경우
                if(dp[i - 1][j])
                    // ex) dp[1][0] ( 1번째 원소까지 고려해서 0을 만들 수 있는지 여부 )
                    // -> dp[0][0] = true

                    dp[i][j] = true;
            }
        }

        System.out.println(!dp[n][m]? "No": "Yes");

        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < m ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }

}
