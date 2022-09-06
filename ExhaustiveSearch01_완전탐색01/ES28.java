// 날짜 : 2022/09/07
// 문제 : 스승의 은혜2

// 문제 설명 :
// 선생님이 N명의 학생에게 B만큼의 예산으로 선물을 주려고 합니다. 학생 i가 원하는 선물의 가격 P(i)가 있고, 선생님에게는 선물 하나를 정해서 반값으로 할인받을 수 있는 쿠폰이 있습니다.
// 선생님이 선물 가능한 학생의 최대 명수를 구하는 프로그램을 작성해보세요. 단, 선물의 가격은 항상 짝수입니다.

// 입력 형식:
// 첫 번째 줄에 학생 수 N과 예산 B가 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터 각 줄마다 학생 N명이 원하는 선물의 가격 P(i)가 주어집니다.
// 1 ≤ N ≤ 1,000
// 1 ≤ B ≤ 1,000
// 0 ≤ P(i) ≤ 1,000

// 입력 예시 :
// 5 18
// 4
// 2
// 8
// 6
// 12

// 출력 예시 :
// 4
package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES28 {
    public static final int MAX = 1000; // 모든 정보의 최대값
    public static int[] want = new int[MAX]; // n명의 학생의 희망 가격


    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 주어지는 학생 수
        int m = sc.nextInt(); // 주어지는 예산

        for(int i = 0; i < n; i++){
            want[i] = sc.nextInt(); // 학생들의 각 원하는 예산
        }

        Arrays.sort(want,0,n); // 오름 차순 정렬

        int ans = 0; // 선물 가능한 최대 명수
        for(int i = 0; i < n; i++){
            want[i] /= 2; // i번째 학생의 예산에 50프로 할인 쿠폰 적용

            int total = 0, cnt = 0; // 지불 금액, 선물 가능한 명수

            for(int j = 0; j < n; j++){
                if(total + want[j] > m) // 해당 금액 포함시, 예산을 넘어간다면
                    break;

                total += want[j];
                cnt++;
            }

            ans = Math.max(ans , cnt);
            want[i] *= 2; // 다시 원상 복구
        }

        System.out.println(ans); // 출력
    }
}