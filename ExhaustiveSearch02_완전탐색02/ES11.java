// 날짜 : 2022/09/08
// 문제 : 숫자 2배 후 하나 제거하기

// 문제 설명 :
// n개의 숫자가 주어졌을 때, 하나의 숫자를 선택해 2배를 한 후,
// 다시 하나의 숫자를 선택해 제거하여 남은 n - 1개의 원소 중 인접한 숫자간의 차의 합이 최소가 되도록 하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 정수 n이 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다.
// 3 ≤ n ≤ 100
// 1 ≤ 주어지는 숫자 ≤ 100

// 입력 예시 :
// 5
// 1 9 8 2 7

// 출력 예시 :
// 8

package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES11 {
    public static final int MAX_N = 100; // n의 최대값
    public static int[] numbers = new int[MAX_N]; // n개의 원소가 들어갈 1차원 배열
    public static final int MAX_INT = Integer.MAX_VALUE; // 정수의 최대값
    public static int n; // 주어지는 n값

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n 입력

        for(int i = 0; i < n; i++)
            numbers[i] = sc.nextInt(); // 원소 입력

        int ans = MAX_INT; // 인접한 숫자간의 차의 최소값

        for(int i = 0; i < n; i++){
            numbers[i] *= 2; // i 번째 원소를 2배

            for(int j = 0; j < n; j++){
                int[] sub = new int[n - 1]; // j번째 원소를 제거 한 후 배열
                int ind = 0;

                for(int k = 0; k < n; k ++){
                    if(j == k) continue; // j번째 원소이면 continue

                    sub[ind ++] = numbers[k];
                }

                int sumDiff = 0; // 조건을 모두 만족했을때, 인접한 숫자간의 차의 합
                for(int k = 1; k < ind; k ++){
                    sumDiff += Math.abs(sub[k] - sub[k - 1]);
                }

                ans = Math.min(ans , sumDiff); // 답 업데이트
            }

            numbers[i] /= 2; // i번째 원소 다시 복구
        }
        System.out.println(ans); // 출력
    }
}
