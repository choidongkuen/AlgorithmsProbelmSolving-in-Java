// 날짜 : 2022/11/10
// 문제 : 정수 k개의 연속 구간합의 최대
// 문제 설명 :
// 크기가 n인 수열이 주어졌을 때, 이 중 연속하는 k개의 원소들의 합 중 가장 큰 합을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n과 k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 정수가 공백을 두고 차례대로 주어집니다.
// 2 ≤ n ≤ 100,000
// 1 ≤ k ≤ n
//-100 ≤ 원소의 크기 ≤ 100

// 입력 예시 01 :
// 5 2
// -10 10 -4 4 1

// 출력 예시 01 :
// 6

package ShortenTimeTechnique.prefixSum;

import java.util.Scanner;

public class Ps01 {

    public static final int MAX_N = 100000;

    public static int n,k;
    public static int[] arr = new int[MAX_N + 1];
    public static int[] prefixSum = new int[MAX_N + 1];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        arr[0] = 0;
        for (int i = 1; i <= n ; i++) {
            arr[i] = sc.nextInt();
        }

        prefixSum[0] = arr[0];
        for (int i = 1; i <= n ; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = k; i <= n ; i++) {
            ans = Math.max(ans, prefixSum[i] - prefixSum[i - k]);
        }

        System.out.println(ans);

    }
}

/*
완전탐색으로 해결할 시
for(int i = 0; i <= n - k + 1; i ++){
    int val = 0;
    for(int j = i; j < i + k; j ++){
        val += arr[j];
    }

    ans = Math.max(ans,val);
}

=> O(N^2)
*/
