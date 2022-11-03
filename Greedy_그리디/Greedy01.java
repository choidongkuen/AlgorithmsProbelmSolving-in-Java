// 그리디(greedy Algorithm)은 현재 상황에서 항상 최선을 고르는 방법 but, 모든 문제에서 최적의 해는 아니다.
// but 매우 간단함으로, 쓰기 편하다.

// 날짜 : 2022/11/03
// 문제 : 동전 더하기
// 문제 설명 :
// 서로 다른 동전 n 종류로 금액 k를 완성시키기 위해 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하세요.
// 단, << 2번째부터 주어지는 동전의 가치값은 항상 바로 전 동전의 가치의 배수 >> 로 주어집니다.

// 입력 형식 :
// 첫 번째 줄에 동전의 종류 개수 n과 금액 k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터 n개의 줄에 걸쳐 각 동전의 가치가 작은 동전부터 큰 동전까지 순서대로 주어집니다.
// 1 ≤ n ≤ 10
// 1 ≤ k ≤ 100,000,000
// 1 ≤ 동전의 가치 ≤ 1,000,000
// 단, 주어진 동전들로 k원을 만들지 못하는 입력은 주어지지 않습니다.

// 입력 예시 01 :
// 5 3800
// 1
// 5
// 100
// 500
// 1000

// 출력 예시 01 :
// 7


package Greedy_그리디;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy01 {
    public static final int MAX = 10;

    public static int[] arr = new int[MAX + 1];
    public static int n,k;


    public static int dynamic(){

       int[] dp = new int[k + 1];
       Arrays.fill(dp,Integer.MAX_VALUE);
       // dp[i] = 총 금액이 i 일때 주어진 동전으로 필요한 최소 동전 개수

        dp[0] = 0;

        for (int i = 1; i <= k ; i++) {
            for (int j = 1; j <= n ; j++) {

                if(i >= arr[j]){
                    if(dp[i - arr[j]] == Integer.MAX_VALUE)
                        continue;
                    // j번째 동전을 이용해서 거슬러 줄 수 없음

                    dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
                    // i원을 거슬러줄 때 마지막으로 j원을 사용했을 때
                }
            }
        }

        return dp[k];

    }


    public static int greedy(){
        // 동전의 가치가 배수 관계임으로 그리디 가능
        // 동전의 가치가 작은 동전부터 주어진다.
        int ans = 0;

        for (int i = n; i >= 1 ; i --) {

            ans += k / arr[i];
            k %= arr[i];
        }

        return ans;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("그리디 기법 : ");
        System.out.println(greedy());
        System.out.print("다이나믹 프로그래밍 기법 : ");
        System.out.println(dynamic());
    }
}
