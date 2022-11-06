// 날짜 : 2022/11/06
// 문제 : 연속 부분 합의 최댓값 구하기
// 문제 설명 :
// n개의 정수가 입력으로 주어지고, 이 중 연속한 부분 수열에 속한 원소들의 합이 최대가 될 때의 값을 출력하는 코드를 작성해보세요. (단, 부분 수열은 최소 한 개 이상의 원소를 포함합니다.)

// 입력 형식 :
// 첫 번째 줄에는 원소의 개수 n이 주어지고, 두 번째 줄에는 n개의 정수가 공백을 사이에 두고 주어집니다.
// −1,000≤정수≤1,000
// 1≤n≤100,000

// 입력 예시 01 :
// 7
// 4 -1 2 -19 3 6 9

// 출력 예시 01 :
// 18

// 아이디어 :
// dp[i] : Math.max(dp[i - 1] + arr[i], arr[i])
// 그리디로도 풀 수 있음
package DynamicProgramming02_동적계획법02;

import java.util.Arrays;
import java.util.Scanner;

public class Dp15 {

    public static final int MAX_N = 100000;

    public static int n;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[1] = arr[1];
        for (int i = 2; i <= n ; i++) {

            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n ; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);

    }
}
