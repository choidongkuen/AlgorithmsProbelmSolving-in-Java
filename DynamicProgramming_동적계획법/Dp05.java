// 문제 : 숫자 암호 만들기
// 날짜 : 2022 / 08 / 27
// 문제 설명 : 숫자가 1,2,3,4 주어질때, 특정 숫자를 이용하여 숫자 암호를 만들어보자
// 예시
// 예를 들어, 4를 활용하면
//1 + 1 + 1 + 1 → 1111
//1 + 1 + 2 → 112
//1 + 2 + 1 → 121
//2 + 1 + 1 → 211
//1 + 3 → 13
//2 + 2 → 22
//3 + 1 → 31
//4 → 4
//와 같이 8개의 암호를 만들 수 있습니다.

// dp[i] 는 합이 i 일때, 만들 수 있는 모든 숫자 암호 경우의 수

package DynamicProgramming_동적계획법;
import java.util.Scanner;

public class Dp05 {
    public static int[] numbers = {1,2,3,4};
    public static int target; // 활용하고자 하는 숫자
    public static int[] dp; // dp 배열(dp[target])을 구해야 함.
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("활용하고자 하는 숫자 입력: ");
        target = sc.nextInt(); // 활용하고자 하는 숫자 입력 받음
        dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target ; i++) {
            dp[i] = 0;
            for (int j = 0; j < numbers.length; j++) {
                if(i >= numbers[j])
                    dp[i] += dp[i - numbers[j]];
            }
        }
        System.out.println(dp[target]);
    }
}
