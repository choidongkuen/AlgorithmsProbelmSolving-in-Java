// 날짜 : 2022/11/04
// 문제 : 자동차 단일 거래 이익 최대화 하기2

// 문제 설명 :
// 향후 n년 간의 자동차 가격 정보가 미리 주어졌을 때, 자동차를 단 한 번 사서 되팔 때의 이익을 최대화하고자 합니다.
// 낼 수 있는 최대 이익을 출력하는 프로그램을 작성해보세요. 단, 자동차를 사기 전에는 팔 수 없습니다.

// 입력 형식 :
// 첫 번째 줄에는 n이 주어지고, 두 번째 줄에는 n년 간 각 해의 자동차 가격이 공백을 사이에 두고 주어집니다.
// 0 ≤ 자동차 가격 ≤ 2
// 31
// −1
//1 ≤ n ≤ 100,000

// 입력 예시 01 :
// 5
// 9 10 2 3 6

// 츨력 예시 01 :
// 4

// 완전탐색 -> n의 범위가 10^5 불가
// 그리디 :
// 자동차를 파는 시점에 이전의 최소값과 비교하여 값 갱신

package Greedy_그리디;

import java.util.Scanner;

public class Greedy08 {
    public static final int MAX_N = 100000;

    public static int[] cars = new int[MAX_N];
    public static int n;
    public static int ans = -1;

    public static int solution(){

        int ans = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n ; i++) {

            ans = Math.max(ans,cars[i] - minPrice);
            minPrice = Math.min(minPrice,cars[i]);
        }

        return ans < 0 ? 0 : ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            cars[i] =  sc.nextInt();
        }

        System.out.print(solution());
    }
}
