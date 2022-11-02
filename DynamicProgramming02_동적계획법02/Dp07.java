// 날짜 : 2022/11/02
// 문제 : 부분 수열의 합이 m
// 문제 설명 :
// n개의 원소로 이루어진 수열 A가 주어졌을 때, 수열 A의 부분 수열 내 원소의 합이 m이 되는 경우 중 가능한 최소 수열의 길이를 구하는 프로그램을 작성해보세요. 수열의 길이란, 수열 내 원소의 개수를 의미합니다.
// 부분 수열이란 수열에서 순서대로 원소를 골랐을 때 나올 수 있는 수열을 뜻합니다. 예를 들어 A = [5, 1, 20, 3, 4] 일 때, [1, 5, 3]은 1 5 3이 수열 A에 차례대로 존재하지 않으므로 부분 수열이 아니지만,
// [5, 1, 4]는 5 1 4가 차례대로 수열 A에 존재하므로 부분 수열입니다.
// A = [5, 2, 4, 1, 6], n = 5, m = 12인 경우에 대해 생각해보겠습니다.
// 부분 수열 [5, 2, 4, 1]은 원소들의 합이 12이면서 길이가 4 이지만,
// 부분 수열 [2, 4, 6]은 원소들의 합이 12이면서 길이가 3이기에 최소 길이가 됩니다.

// 입력 형식 :
// 첫 번째 줄에는 수열 A의 원소의 개수 n과 만들고자 하는 합 m이 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 수열 A의 원소 n개가 공백을 사이에 두고 주어집니다. 주어진 모든 수는 다름을 가정해도 좋습니다.
// 1 ≤ n ≤ 10
// 1 ≤ m ≤ 10,000
// 1 ≤ 원소 값 ≤ 10,000

// 입력 예시 01:
// 5 12
// 5 2 4 1 6

// 출력 예시 01:
// 3

package DynamicProgramming02_동적계획법02;

import java.util.Arrays;
import java.util.Scanner;

public class Dp07 {

    public static final int MAX_N = 100;
    public static final int MAX_M = 10000;

    public static int n,m;
    public static int[] arr = new int[MAX_N];
    public static int[] dp = new int[MAX_M + 1];
    // dp[i] = 합이 i 인 값을 만들기 위한 최소 부분 수열의 길이(원소 중복 x)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        // 일반적인 동전의 최소 갯수 구하기와 반대 과정(자연스레 부분 수열을 보장할 수 있음)
        for (int i = 0; i < n ; i++) {
            for (int j = m; j >= 0 ; j--) {
                // m이 거꾸로 가기 때문에 연속(차례)성 보장
                // outer for문이 각 원소이기 때문에 중복 방지

                if(j >= arr[i]){

                    if(dp[j - arr[i]] == Integer.MAX_VALUE)
                        continue;

                    dp[j] = Math.min(dp[j],dp[j - arr[i]] + 1);
                }
            }
        }

        System.out.println(dp[m] == Integer.MAX_VALUE? -1 : dp[m]);

        for (int i = 0; i <= m ; i++) {
            System.out.print(dp[i] + " ");
        }

    }
}
