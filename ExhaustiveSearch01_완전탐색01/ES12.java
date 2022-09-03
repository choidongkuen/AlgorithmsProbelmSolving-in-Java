// 날짜 : 2022/09/04
// 문제 : 인접하지 않은 2개의 숫자
// 문제 설명 : n개의 숫자가 주어졌을 때, 인접하지 않은 2개의 숫자를 적절하게 골라 합이 최대가 되도록 하는 프로그램을 작성해보세요.
// 입력 형식 : 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다.
// 3 ≤ n ≤ 100
// 1 ≤ 주어지는 숫자 ≤ 100

// 입력 예시 :
// 6
// 2 1 6 2 7 8

// 출력 예시 :
// 14
package ExhaustiveSearch01_완전탐색01;
import java.util.*;

public class ES12 {
    public static final int MAX_N = 100; // 원소의 최대 개수
    public static int[] arr = new int[MAX_N]; // n개의 숫자를 원소로 갖는 1차원 배열
    public static int MIN_INT = Integer.MIN_VALUE; // 정수의 최소 값

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 원소개수 입력

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        } // 원소 입력
        int ans = MIN_INT;

        for(int i = 0; i <= n - 2; i++){
            for(int j = i + 2; j < n; j++){
                int sum = arr[i] + arr[j];
                ans = Math.max(ans , sum);
            }
        }

        System.out.println(ans);
    }
}