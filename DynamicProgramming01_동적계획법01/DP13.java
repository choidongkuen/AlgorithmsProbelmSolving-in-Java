package DynamicProgramming01_동적계획법01;

import java.util.Scanner;

public class DP13 {
    public static final int MAX_N = 100;
    public static final int DIR = 2; // 오른쪽 or 아래

    public static int n;
    public static int[][] arr = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] dp = new int[MAX_N + 1][MAX_N + 1];
//    public static int[] dx = {0,1};
//    public static int[] dy = {1,0};

    public static void initialize() {
        // 진행하기 위한 dp 배열 설정하는 메소드
        dp[1][1] = arr[1][1];

        for (int i = 2; i <= n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], arr[i][1]);
            // 1 열 처리
        }

        for (int i = 2; i <= n; i++) {
            dp[1][i] = Math.max(dp[1][i - 1], arr[1][i]);
        }

    }

    public static int solution(){
        for (int i = 2; i <= n ; i++) {
            for (int j = 2; j <= n ; j++) {
                dp[i][j] = Math.max(arr[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]));
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
        }

        initialize();
        System.out.println(solution());

        System.out.println(" dp 테이블 : ");
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}
