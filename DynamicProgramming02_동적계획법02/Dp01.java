package DynamicProgramming02_동적계획법02;

import java.util.Arrays;
import java.util.Scanner;

public class Dp01 {

    public static final int MAX = 100; // 격자의 최대 크기
    public static final int MAX_NUM = 100; // 주어지는 숫자의 최대 값
    public static final int DIR = 2; // 오른쪽 or 밑
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static int n;
    public static int[][] arr = new int[MAX + 1][MAX + 1];
    public static int[][] dp ;

    public static int[] dx = {1,0};
    public static int[] dy = {0,1};
    public static int lowerBound;

    public static int ans = INT_MAX;
    public static int upperBound = INT_MAX;

    public static void initialize(){

        dp = new int[MAX + 1][MAX + 1];

        for(int[] sub : dp){
            Arrays.fill(sub,INT_MAX);
        }
        dp[1][1] = arr[1][1];

        for (int i = 2; i <= n ; i++) {
            dp[1][i] = Math.max(dp[1][i - 1], arr[1][i]);

        } // 1행

        for (int i = 2; i <= n ; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], arr[i][1]);

        } // 1열

    }

    public static int solve(){

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(arr[i][j] < lowerBound){
                    arr[i][j] = INT_MAX;
                    // lowerbound는 점점 증가할것임으로, 직접 arr를 변경해도 된다.
                    // 점점 lowerbound 보다 작은 값이 증가 할 것
                }
            }
        }

        initialize();

        for (int i = 2; i <= n ; i++) {
            for (int j = 2; j <= n ; j++) {

                dp[i][j] = Math.max(Math.min(dp[i - 1][j], dp[i][j - 1]),arr[i][j]);
            }
        }

        return dp[n][n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        } // 격자 원소 입력

        for (int i = 1; i <= MAX_NUM ; i++) {

            lowerBound = i;
            int upperBound = solve();

            if(upperBound == INT_MAX)
                continue;

            ans = Math.min(ans, upperBound - lowerBound);

        }
        System.out.println(ans);
    }
}
