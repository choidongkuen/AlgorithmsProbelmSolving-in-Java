// 문제 : 최소 동전 수 구하기
// 날짜 : 2022/ 08 / 26
// 문제 설명 : 가치가 1, 4, 5, 9인 4개의 동전이 주어졌을 때, 금액 21을 거슬러 주기 위해 필요한 최소 동전의 수를 구해보려고 합니다.

// 입력 형식 따로 없음.
package DynamicProgramming_동적계획법;
public class Dp04{
    public static final int MAX = 100; // 최대 배열 원소 수
    public static final int total = 21; // 만들고자 하는 총합
    public static int[] coins = {1,4,5,9}; // 주어지는 동전 수(복수 개 사용가능)
    public static int[] dp = new int[MAX]; // 1차원 dp 배열

    public static void main(String[] args){
        dp[0] = 0;
        // 점화식 : dp[i] = min(dp[i - coins[j]]  if(i >= coins[j]), 0<=j<coins.length
        for (int i = 1; i <= total ; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length ; j++) {
                if(i >= coins[j])
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] + 1);
            }
        }
        System.out.println("== dp 배열 출력 == ");
        for (int i = 0; i <= total ; i++) {
            System.out.print(dp[i]+" ");
        }
    }
}
