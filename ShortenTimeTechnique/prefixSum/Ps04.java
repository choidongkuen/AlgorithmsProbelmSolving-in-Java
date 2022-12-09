// 날짜 : 2022/11/10
// 문제 : 연속한 k개의 숫자

// 문제 설명 :
// 1부터 N까지의 숫자들 중 B개 숫자들이 빠져 있습니다. 여기에 연속한 K개의 숫자들이 최소 한 세트는 존재하게 하려 할 때,
// 현재 없는 B개의 숫자들 중 추가해야 하는 숫자 개수의 최솟값을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 N, K, B가 공백을 사이에 두고 차례대로 주어집니다.
// 두 번째 줄부터 B개의 줄에 걸쳐 없는 숫자들이 각 줄에 하나씩 주어집니다.
// 1 ≤ B, K ≤ N
// 1 ≤ N ≤ 100,000

// 입력 예시 01 :
// 10 6 5
// 2
// 10
// 1
// 5
// 9

// 출력 예시 01 :
// 1

// 아이디어 :
// k개의 연속 구간이 존재해야 하며, 이를 위해 없는 b개의 원소 중 최소 원소를 추가하여 최소 하나의 k길이의 연속 구간을 구할 때
// 추가하는 원소의 최소 개수를 구하는 것이 핵심이다.

// 구간 합 챕터임으로, 구간 합 방향으로 생각해보자
// 구간 합은 prefixSum 배열을 구하여, 구간[a,b] 가 주어질 때 s[b] - s[a - 1]을 통해 구간 합을 O(1) 만에 구할 수 있다.
// 결국 연속하는 k개의 구간 합을 모두 구한다? .... 그러나
// 주어지지 않은 b개의 원소를 고려해야 함으로, 없는 부분에 1 삽입 있는 원소는 0 삽입
// 결국 특정 연속 k의 구간합 자체가 1의 개수이고 이는 존재하지 않는 원소의 개수이다.
// 따라서 특정 연속 k길이의 구간의 합의 최소값을 구하자.

package ShortenTimeTechnique.prefixSum;

import java.util.Scanner;

public class Ps04 {

    public static final int MAX = 100000;
    public static int n, k, b;

    // HashSet 탐색,삽입,삭제 : O(1)
    public static int[] arr = new int[MAX + 1];
    public static int[] prefixSum = new int[MAX + 1];

    public static int getPartSum(int s, int e){
        return prefixSum[e] - prefixSum[s - 1];
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        b = sc.nextInt();

        while(b --> 0){
            // b개의 존재하지 않은 원소 입력
            int x = sc.nextInt();
            arr[x] = 1;

        }

        // prefixSum 배열을 만들자
        for (int i = 1; i <= n ; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // 모든 k길이의 구간 합을 구하자.
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n - k + 1 ; i++) {
            ans = Math.min(ans, getPartSum(i,i + k - 1));
        }
        System.out.println(ans);
    }
}