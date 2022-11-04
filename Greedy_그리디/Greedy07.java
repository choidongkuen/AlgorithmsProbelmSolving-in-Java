// 날짜 : 2022/11/04
// 문제 : 수 채우기
// 문제 설명 :
// 주어진 금액을 2원과 5원 동전을 이용해서만 만들려고 합니다.
// 사용하는 동전의 총 개수를 최소로 하려고 할 때, 2원 동전과 5원 동전은 총 몇 개가 필요한지를 구하는 프로그램을 작성하세요.

// 입력 형식 :
// 첫 번째 줄에는 금액 n이 주어집니다.
// 1 ≤ n ≤ 100,000

// 입력 예시 01 :
// 14
// 출력 예시 01 :
// 4

// 아이디어 :
// 동전의 가치가 주어질 때, 금액 m을 맞추기 위한 최소 동전의 수
// try 1 : 그리디
// try 2 : 동적 계획법

// try 2 인 경우
// 일반적인 그리디로 푸는 동전의 최소 개수로 접근하면 안됨(배수 관계가 아님)
// 일단 5원으로 거슬러 줄 수 있을 때까지 거슬러 주고, 나머지 금액을 2원으로 거슬러주는 동전의 갯수를 구하자.

package Greedy_그리디;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Greedy07 {


    // 주어질 수 있는 최대 금액
    public static final int MAX_N = 100000;
    public static Integer[] coins = new Integer[]{2,5};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 내림차순 정렬
        Arrays.sort(coins, Collections.reverseOrder());

//        System.out.print(Arrays.toString(coins));

        int ans = MAX_N;
        for (int i = 0; i < MAX_N ; i++) {
            // 주어지는 금액 n에서 5의 배수를 뺀 나머지금액을 구한다.
            // i : 5원의 개수
            int remainder = n - 5 * i;

            if(remainder >= 0 && remainder % 2 == 0){
                // 나머지 금액이 존재하며, 2의 배수 일때 2원으로 거슬러 주면 된다.
                ans = Math.min(ans , i + (remainder / 2));
            }

        }
        System.out.print(ans == MAX_N ? -1 : ans);
    }
}
