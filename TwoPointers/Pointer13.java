// 날짜 : 2022/09/27
// 문제 : 정수 두 개의 합2
// 문제 설명 :
// n개의 정수가 주어졌을 때, 이 중 두 개의 원소를 골라 그 합이 k 이하가 되는 경우의 수를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 정수 n의 개수와 k가 주어집니다.
// 두 번째 줄부터 n개의 줄에 걸쳐 n개의 정수가 주어집니다.
// 2 ≤ n ≤ 100,000
// 1 ≤ k ≤ 1,000,000
// 1 ≤ 정수의 크기 ≤ 1,000,000

// 입력 예시01 :
// 5 4
// 1
// 2
// 3
// 4
// 5

// 출력 예시01 :
// 2

package TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class Pointer13 {

    public static final int MAX = 100000; // 최대 원소 갯수
    public static int[] arr;
    public static int n, k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } // 원소 입력

        Arrays.sort(arr); // 오름차순 정렬

        int ans = 0; // 두 수에 대한 합이 m 이하인 경우의 수
        int p2 = n - 1; // p2 를 왜 한번만 설정해줄까 잘 생각해보자.
        // 오름차순으로 정렬되어 있기 때문에, 예를 들어 특정 p1을 검사할 때, 이전에 검사한 p1 - 1 일때, p2 가 도달한 위치를 그대로 사용하면 된다.
        // 이유 : 어차피 arr[p1] 은 arr[p1 - 1] 보다 크거나 같기 때문에 p2를 n - 1부터 다시 검사할 필요 없음.
        for (int p1 = 0; p1 < n; p1++) {

            while(p1 < p2 && arr[p1] + arr[p2] > k){
                p2 --;
            } // arr[p1] + arr[p2] <= k 인 지점에서 p2 는 위치해 있을 것임

            if(p1 == p2){
                break;
            }

            ans += p2 - p1;
        }
        System.out.println(ans);
    }
}
