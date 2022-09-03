// 날짜 : 2022 / 09 / 04
// 문제 :  구간에서 최대값의 최소값 구하기
// 문제 설명 : n개의 숫자중 k개의 숫자를 골라 최대값의 최소값을 구해보자.
// 예시 : n = 6, k = 4 , arr = {1,5,2,6,8,9}
// 예시 답 : 6

package ExhaustiveSearch01_완전탐색01;
import java.util.Scanner;

public class ES09 {
    public static final int MAX_INT = Integer.MAX_VALUE; // 정수의 최대값
    public static final int MAX_N = 100; // 원소의 최대 개수
    public static int[] arr = new int[MAX_N]; // 주어지는 숫자를 원소로 갖는 배열 선언
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 원소의 개수
        int k = sc.nextInt(); // 고르는 숫자 갯수

        int ans = MAX_INT; // 최대값의 최소값

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i <= n - k; i++){
            int maxVal = 0;
            for(int j = i; j < i + k; j++){
                maxVal = Math.max(maxVal, arr[j]); // 최대값 업데이트
            }

            ans = Math.min(ans , maxVal);
        }
        System.out.println(ans);
    }
}
