// 날짜 : 2022/11/02
// 문제 : 1,2,5 더하기
// 문제 설명 :
// 정수 n을 1, 2, 5 의 합으로 나타내는 방법을 수를 구하는 프로그램을 작성해보세요. 단, 더해지는 순서가 다르면 다른 조합이라 생각합니다.
//예를 들어 5는 다음과 같이 9가지 방법으로 나타낼 수 있씁니다.

// 입력 형식 :
// 첫 번째 줄에 정수 n이 주어집니다.
// 1 ≤ n ≤ 1,000

// 입력 예시 01 :
// 5
// 출력 예시 01 :
// 9

package DynamicProgramming02_동적계획법02;

import java.util.Scanner;

public class Dp08 {

    public static int n;
    public static int[] arr = new int[]{1,2,5};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        // 아무 수도 고르지 않은 경우 - > 1가지
        //dp[i] : i를 1,2,5 로 만들 수 있는 경우의 수

        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j < 3 ; j++) {

                if(i >= arr[j]){
                    dp[i] = (dp[i] + dp[i - arr[j]]) % 10007;
                }
            }
        }

        System.out.println(dp[n]);

    }

}
