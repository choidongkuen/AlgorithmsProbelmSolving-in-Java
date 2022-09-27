// 날짜 : 2022/09/27
// 문제 : 겹치는 숫자가 없는 최대 구간
// 문제 설명 :
// n개의 숫자가 주어졌을 때, 구간 내에 중복되는 숫자가 전혀 없는 경우중 가능한 최대 구간의 크기를 구하는 프로그럄을 작성하세요.

// 입력 형식 :
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다.
// 3 ≤ n ≤ 100,000
// 1 ≤ 주어지는 숫자 ≤ 100,000

// 입력 예시 :
// 5
// 1 3 1 2 3

// 출력 예시 :
// 3

// 아이디어 :
// 입력 형식의 n의 범위가 매우 크다. -> O(N^2) 불가
// 투포인터 & 방문 기록을 위해 countingArray 사용하여 해결해보자.
// 중복됨이 없다는 것은 방문 기록이 0이여야 한다.

package TwoPointers;

import java.util.Scanner;

public class Pointer10 {
    public static final int MAX = 100000;
    public static int[] arr;
    public static int[] countingArr = new int[MAX + 1];
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int p1 = 0;
        int p2 = 0;
        int ans = -1;

        while(p2 < arr.length){

            while(p2 < arr.length && countingArr[arr[p2]] < 1){
                // index outofRange 에러가 떴었다.
                // 그 이유는 멍청하게도 countingArr[arr[p2]] < 1 부터 검사하고, p2 < arr.length를 검사했다.
                // 주의하자.

                countingArr[arr[p2]] ++; // 해당 p2 포인터에 있는 원소 방문 기록
                p2 ++; // 다음 p2로 이동
            }

            ans = Math.max(ans, p2 - p1);
            countingArr[arr[p1]] --; // p1 포인터에 있는 원소 방문 기록 감소
            p1++;
        }

        System.out.println(ans);
    }
}
