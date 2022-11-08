package DynamicProgramming03_동적계획법03;

import java.util.Arrays;
import java.util.Scanner;

public class Dp02 {
    public static final int MAX = 200;

    public static int n,m;

    // n개의 옷의 입을 수 있는 기간을 나타내는 배열
    public static int[] start = new int[MAX + 1];
    public static int[] end = new int[MAX + 1];
    // n개의 옷의 만족도를 나타내는 배열
    public static int[] values = new int[MAX + 1];

    // dp[i][j] : i번째 날에 j번째 옷을 입을 때 얻는 최대 합
    // dp구성시 행렬 주의
    public static int[][] dp = new int[MAX + 1][MAX + 1];

    public static void initialize(){

        for (int i = 1; i <= n ; i++) {

            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }

        // j번째 옷에 대해
        // 첫째날에 입을 수 있다면 0
        for (int j = 1; j <= m ; j++) {

            if(start[j] == 1){
                dp[1][j] = 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        n = sc.nextInt(); // 옷의 개수
        m = sc.nextInt(); // 총 기간

        for (int i = 1; i <= n ; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }


        // dp[i][j] 에 대해
        for (int i = 2; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                for (int k = 1; k <= n; k++) {

                    // k번째 옷이 i - 1 번째 날에 입을 수있어야 하며
                    // j번째 옷이 i 번째 날에 입을 수 있어야 한다.
                    if (start[j] <= i && end[j] >= i && start[k] <= i - 1 && end[k] >= i - 1) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Math.abs(values[j] - values[k]));
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n ; i++) {
            ans = Math.max(ans,dp[m][i]);
        }

        System.out.println(ans);

//        for (int i = 1; i <= m ; i++) {
//            for (int j = 1; j <= n ; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

}
