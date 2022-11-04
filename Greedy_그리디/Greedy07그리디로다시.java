package Greedy_그리디;

import java.util.Arrays;
import java.util.Scanner;

public class Greedy07그리디로다시 {
    public static final int MAX_N = 100000;

    public static int[] coins = new int[]{2,5};
    public static int[] dp ;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];

        int ans = 0;
//
//        Integer [] newCoins = Arrays.stream(coins).boxed().toArray(Integer[] :: new);
//        Arrays.sort(newCoins, Collections.reverseOrder());
//        // 내림차순 정렬
//
//        for (int i = 0; i < newCoins.length ; i++) {
//
//            if(n >= newCoins[i]){
//                ans += n / newCoins[i];
//                n %= newCoins[i];
//            }
//        }
//
//        System.out.println(n != 0 ? -1 : ans);
//    }
        Arrays.fill(dp,1,n + 1,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n ; i++) {

            for (int j = 0; j < 2 ; j++) {
                if(i >= coins[j]) {
                    if (dp[i - coins[j]] == Integer.MAX_VALUE)
                        continue;
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);

    }

}
