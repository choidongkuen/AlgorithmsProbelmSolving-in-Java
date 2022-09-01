// 날짜 : 2022/09/01
// 문제 : 모이자
// 문제 설명 : n개의 집이 x = 1에서 x = n까지 순서대로 놓여있고, 각각 Ai 명의 사람이 살고 있습니다.
// 이들은 회의를 위해 n개의 집 중 한 곳에 전부 모이려고 합니다. 적절한 집을 선택하여 모든 사람들의 이동 거리의 합이 최소가 되도록 하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 n이 주어집니다.
// 두 번째 줄에는 각 지점에 살고 있는 사람 수에 해당하는 n개의 숫자가 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 100
// 1 ≤ Ai ≤ 100

// 입력 예시 :
// 5
// 1 2 3 2 6

// 출력 예시 :
// 16

package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES01 {
    public static final int MAX = 100; // 집의 최대 수
    public static final int MAX_VALUE = Integer.MAX_VALUE; // 정수의 최대값(최소값 구하기 위해 설정)
    public static int[] homes = new int [MAX]; // 각 집의 인원 정보가 있는 homes 배열 선언

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 집의 갯수
        int ans = MAX_VALUE;

        for(int i = 0; i < n; i++){
            homes[i] = sc.nextInt(); // 각 집 거주인원 입력
        }

        for(int i = 0; i < n; i++){
            int sumDiff = 0;

            for(int j = 0 ; j < n; j++){
                if(i == j)
                    continue;
                sumDiff = sumDiff + (Math.abs(j - i)*homes[j]);
            }
            ans = Math.min(ans , sumDiff); // 최소값 업데이트
        }
        System.out.println(ans); // 출력
    }
}
