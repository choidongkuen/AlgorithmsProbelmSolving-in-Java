// 날짜 : 2022/11/03
// 문제 : 막대기 나누기
// 문제 설명 :
// 길이가 n인 막대기가 하나 주어졌을 때, 막대기를 잘 쪼개어 최대 수익을 얻고자 합니다. 1부터 n까지 각각의 길이에 대해 팔았을 때 얻을 수 있는 수익 정보가 주어졌을 때, 최대 수익을 얻는 프로그램을 작성해보세요.
// 예를 들어 n = 4이며 다음과 같이 표가 주어진 경우에 대해 생각해보겠습니다.
// 길이	수익
// 1	2
// 2	9
// 3	10
// 4	11
// 막대기를 자르기 않고 팔면 길이 4 막대기 하나를 팔아 수익 11을 얻게 되고, 길이 1 / 길이 1 / 길이 1 / 길이 1 이렇게 4개로 나눠서 팔게 되면 수익 8을 얻게 됩니다.
// 길이 1 / 길이 3으로 나눠 팔게 되면 수익 12를 얻게 되만, 길이 2 / 길이 2로 나눠 팔게 되면 수익 18을 얻게 되어 최대가 됩니다.

// 입력 형식 :
// 첫 번째 줄에는 막대기의 길이 n이 주어집니다.
// 두 번째 줄에는 길이가 1인 막대기를 팔았을 때의 수익부터 길이가 n인 막대기를 팔았을 때의 수익까지 순서대로 n개의 수익 정보가 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 100
// 1 ≤ 주어지는 수익 값 ≤ 10,000

// 입력 예시 01 :
// 4
// 2 9 10 11

// 출력 예시 01 :
// 18

package DynamicProgramming02_동적계획법02;

import java.util.Scanner;

public class Dp12 {

    public static final int MAX = 100;

    public static int n;
    public static int[] dp = new int[MAX + 1];
    // dp[i] : 길이가 i인 막대기로 얻을 수 있는 최대 수익!
    // 1 ~ i번째 막대기까지 사용하는 상황(i번째 막대기를 사용할 수도 사용하지 않을 수도)

    public static int[] values = new int[MAX + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        dp[0] = 0;

        for (int i = 1; i <= n ; i++) {
            values[i] = sc.nextInt();
        }

        // dp[i] = 이전 j번째 막대기를 사용하느냐 마느냐

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {

                dp[i] = Math.max(dp[i - j] + values[j], dp[i]);

            }
        }

        System.out.println(dp[n]);
    }
}
