// 날짜 : 2022/10/06
// 문제 : 최대 점프 횟수 구하기
// 문제 설명 :
// n개의 정점에 대한 점프 가능한 거리가 주어 질 때, 최대 점프 횟수를 구하세요.

// 처음 정점에서 시작해서 특정 정점까지의 최대 점프수를 다 구해보고
// 마지막에 최대값을 구한다.
// dp[i]  = 시작점에서 i번째 정점까지의 최대 점프 횟수

package DynamicProgramming01_동적계획법01;
import java.util.Arrays;
import java.util.Scanner;

public class DP14{
    public static final int MAX = 1000;
    public static int[] jump;
    public static int[] dp;
    public static int n;
    public static int solution(){
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[1] = 0;

        for (int i = 2; i <= n  ; i++) {

            for (int j = 1; j < i ; j++) {
                if(dp[j] == Integer.MIN_VALUE)
                    continue;

                if(jump[j] + j >= i){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt(); // 최대값(어떤 지점이던 최대 점프 가능 횟수)
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        jump = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            jump[i] = sc.nextInt();
        }
        System.out.println(solution());
    }
}