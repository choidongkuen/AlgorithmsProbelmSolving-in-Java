// 날짜 : 2022/11/02
// 문제 : 동전 거슬러주기
// 문제 설명 :
// N개의 동전의 종류가 주어졌을 때, 금액 M을 거슬러주기 위해 필요한 최소 동전의 수를 구해주는 프로그램을 작성해보세요.
// 단, 같은 종류의 동전을 여러 번 사용하여 거슬러 줄 수 있습니다.
// 예를 들어 N=3,M=8, 동전의 종류는 1,4,5 일때
// 8=1+1+1+5 이렇게 거슬러주면 총 4개의 동전이 필요하지만
// 8=4+4 이렇게 거슬러 주면 총 2개의 동전으로 돈을 거슬러 줄 수 있습니다.

// 입력 형식 :
// 첫째 줄에는 N과 M이 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 동전의 종류에 해당하는 N개의 숫자가 공백을 사이에 두고 주어집니다. 각 숫자는 겹치지 않게 주어진다 가정해도 좋습니다.
// 1≤N≤100
// 1≤M≤10,000
// 1≤ 동전의 금액 ≤10,000

// 입력 예시 01 :
// 3 8
// 1 4 5


// 출력 예시 01 :
// 2


package DynamicProgramming02_동적계획법02;


import java.util.Arrays;
import java.util.Scanner;

public class Dp06 {

    public static final int MAX_N = 100;
    public static final int MAX_M = 10000;

    public static int n,m;
    public static int[] coins = new int[MAX_N + 1]; // 동전의 정보를 담을 1차원 배열
    public static int[] dp = new int[MAX_M + 1];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 동전의 개수
        m = sc.nextInt(); // 만들 총 금액

        for (int i = 0; i < n ; i++) {
            coins[i] = sc.nextInt();
        }

        Arrays.fill(dp,Integer.MAX_VALUE); // 초기값 = 정수의 최대값(최소 동전의 갯수를 구하기 위함)
        

        dp[0] = 0;
        for (int i = 1; i <= m ; i++) {

            for (int j = 0; j < n ; j++) {

                if(i >= coins[j]){

                    if(dp[i - coins[j]] == Integer.MAX_VALUE)
                        continue; // j번째 동전을 뺀 금액을 만들 수가 없음.

                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        System.out.println(dp[m] == Integer.MAX_VALUE? -1 : dp[m]);
    }

}
