// 날짜 : 2022/11/10
// 문제 : 부분 수열의 합이 K

// 문제 설명 :
// n개의 정수로 이루어진 수열에서 연속된 구간의 합을 구하려합니다.
// 모든 연속된 구간의 합 중에서 합이 k인 것의 개수를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 n과 k가 공백을 두고 주어집니다.
// 두 번째 줄에 n개의 정수가 공백을 두고 주어집니다.
// 3 ≤ n ≤ 1,000
// 1 ≤ k ≤ 1,000,000
// 1 ≤ 주어진 숫자 ≤ 1,000,000

// 입력 예시 01 :
// 4 3
// 1 2 1 2

// 출력 예시 01 :
// 3

package ShortenTimeTechnique.prefixSum;

import java.util.*;

public class Ps03 {

    public static final int MAX_N = 1000;

    public static int n,k;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] s = new int[MAX_N + 1];

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i ++){
            arr[i] = sc.nextInt();
        }

        // prefixSum 배열을 채워넣기
        for(int i = 1; i <= n; i ++){
            s[i] = s[i - 1] + arr[i];
        }

        int cnt = 0;

        for(int i = 1; i <= n; i ++){
            for(int j = i; j <= n; j ++){
                int sum = s[j] - s[i - 1];
                if(sum == k){
                    cnt ++;
                }
            }
        }
        System.out.println(cnt);
    }
}