// 날짜 : 2022/11/03
// 문제 : 부분 수열의 합
// 문제 설명 :
// n개의 원소로 이루어진 수열 A가 주어졌을 때, 수열 A의 부분 수열 내 원소의 합이 m이 되는 경우가 있는지를 판단하는 프로그램을 작성해보세요. 부분 수열이란 수열에서 순서대로 원소를 골랐을 때 나올 수 있는 수열을 뜻합니다. 예를 들어 A = [5, 1, 20, 3, 4] 일 때,
// [1, 5, 3]은 1 5 3이 수열 A에 차례대로 존재하지 않으므로 부분 수열이 아니지만, [5, 1, 4]는 5 1 4가 차례대로 수열 A에 존재하므로 부분 수열입니다.
// A = [5, 2, 4, 9, 1], n = 5, m = 12인 경우에 대해 생각해보겠습니다.

// 이 경우 부분 수열 [5, 2, 4, 1]을 고르면 원소들의 합이 12가 됩니다.

// 입력 형식 :
// 첫 번째 줄에는 수열 A의 원소의 개수 n과 만들어야 하는 합 m이 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 수열 A의 원소 n개가 공백을 사이에 두고 주어집니다. 주어진 n개의 수는 모두 다름을 가정해도 좋습니다.
// 1 ≤ n ≤ 100
// 1 ≤ m ≤ 10,000
// 1 ≤ 원소 값 ≤ 10,000

// 입력 예시 01 :
// 5 12
// 5 2 4 9 1

// 출력 예시 01 :
// Yes
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
