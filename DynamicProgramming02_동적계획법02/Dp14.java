// 날짜 : 2022/11/06
// 문제 : 배낭 채우기 2

// 문제 설명 :
// N개의 보석의 정보가 주어졌을 때, 보석을 적절하게 골라 무게의 합이 M을 넘지 않도록 하면서 가치의 합은 최대가 되도록 하는 프로그램을 작성해보세요. 단, << 동일한 보석을 여러 개 고르는 것 역시 가능합니다. >>
// 예를 들어 N=4,M=22, 보석의 종류가 다음과 같이 주어졌다고 생각해봅시다.
// 1번 보석을 3개 고르게 되면 무게가 M을 넘지 않으면서 60만큼의 가치를 얻게 됩니다.
// 2번 보석 2개와 4번 보석 1개를 고르게 되면 무게가 M을 넘지 않으면서 총 61만큼의 가치를 얻게 됩니다.

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
// 12

// 아이디어 :
// 일반적인 knapsack 문제와 달리 보석을 중복 선택하는 것이 가능하다.
// Dp13 문제 참고하기


package DynamicProgramming02_동적계획법02;

import java.util.Arrays;
import java.util.Scanner;

public class Dp14 {

    public static final int MAX_N = 100;
    public static final int MAX_M = 10000;

    public static int n,m;
    public static int[] weights = new int[MAX_N + 1];
    public static int[] values = new int[MAX_N + 1];
    public static int[] dp = new int[MAX_M + 1];

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n ; i++) {

            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();

        }

        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n ; i++) {
            int curW = weights[i];

            for (int j = 0; j <= m ; j++) {

                if(curW > j)
                    continue;

                dp[j] = Math.max(dp[j], dp[j - curW] + values[i]);
            }
        }

        int ans = Arrays.stream(dp).max().getAsInt();
        System.out.println(ans);
    }
}
