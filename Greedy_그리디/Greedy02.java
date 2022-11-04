// 날짜 : 2022/11/03
// 문제 : 연속 부분 합의 최대값 구하기

// 문제 설명 :
// n개의 정수가 입력으로 주어지고, 이 중 연속한 부분 수열에 속한 원소들의 합이 최대가 될 때의 값을 출력하는 코드를 작성해보세요. (단, 부분 수열은 최소 한 개 이상의 원소를 포함합니다.

// 입력 형식 :
// 첫 번째 줄에는 원소의 개수 n이 주어지고, 두 번째 줄에는 n개의 정수가 공백을 사이에 두고 주어집니다.
// -1,000 ≤ 정수 ≤ 1,000
// 1 ≤ n ≤ 100,000

// 입력 예시 01 :
// 7
// 4 -1 2 -19 3 6 9

// 출력 예시 01 :
// 18

// 아이디어 :
// 연속 부분 수열의 합의 최대값을 구하는 문제
// 배열을 진행하면서 계속 최대값을 갱신하다가, 음수가 되는 순간 sum을 초기화
// 순간수간 최선의 선택을 하는 방 (그리디로 풀 수 있으면 대부분 DP로 풀 수 있다.)

package Greedy_그리디;

import java.util.Scanner;

public class Greedy02 {

    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        int ans = Integer.MIN_VALUE;
        int sum = 0;


        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n ; i++) {

            if(sum < 0)
                sum = arr[i];
            // 현재 순서에서 sum 이 음수라면 arr[i]을 더하면 arr[i]의 원래 값보다 무조건 작아짐

            else
                sum += arr[i];

            // sum 이 음수가 아니라면 arr[i]을 더해서 더 커질 수 있음(arr[i]가 음수가 아니라면..)

            ans = Math.max(ans,sum);
            // 계속 최대값 업데이트


        }
        System.out.println(ans);


    }
}
