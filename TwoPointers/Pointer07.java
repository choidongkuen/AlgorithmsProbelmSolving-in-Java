// 날짜 : 2022/09/26
// 문제 : 가장 짧은 부분합
// 문제 설명 :
// 원소가 n개 들어 있는 수열에 특정 구간을 잡았을 때 그 합이 s 이상이 되는 것 중, 가장 짧은 구간의 길이를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 n과 s가 공백을 두고 주어집니다.
// 두 번째 줄에 수열의 각 원소가 공백을 두고 차례대로 주어집니다.
// 1 ≤ n ≤ 100,000
// 1 ≤ s ≤ 10
// 9
// 1 ≤ 원소 값 ≤ 10,000

// 입력 예시01 :
// 10 15
// 5 1 3 5 10 7 4 9 2 8

// 아이디어 :
// 만약 sum 이 주어진 s보다 작다면 p2값을 더하고 p2 ++
// 만약 sum 이 주어진 s보다 크거나 같다면 길이 갱신 하고 p1 ++

package TwoPointers;

import java.util.Scanner;
public class Pointer07 {

    public static final int MAX = 100000;
    public static int[] arr = new int[MAX];
    public static int n,s;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int ans = 100000;
        boolean find = false;
        while(p2 < n){

            if(sum < s) {
                sum += arr[p2++];
            }
            else{ // sum >= s
                ans = Math.min(ans, p2 - p1 + 1);
                sum -= arr[p1++];
                find = true;
            }
        }

        if(!find)
            ans = -1;
        System.out.println(ans);


    }
}
