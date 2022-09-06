// 날짜 : 2022/09/06
// 문제 : 운행되고 있는 시간
// 문제 설명 :
// 회사에서 N명의 개발자가 일을 하고 있습니다. 회사에서는 직원이 한 명이라도 일하고 있으면 ‘운행 되고 있는 시간’이라고 합니다.
// 만약에 N 명중 정확히 한 명을 해고해야 할 때, ‘운행 되고 있는 시간’이 최대가 되도록 하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 정수 N이 주어집니다.
// 두 번째 줄부터는 N개의 줄에 걸쳐 한 줄에 하나씩 각 개발자가 일하는 시간인 A, B가 공백을 사이에 두고 주어집니다.
// 입력으로 주어지는 모든 시간은 전부 유일함을 가정해도 좋습니다.
// 1 ≤ N ≤ 100
// 1 ≤ A < B ≤ 1,000

// 입력 예시 :
// 3
// 5 9
// 1 4
// 3 7

// 출력 예시 :
// 7

package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES26 {
    public static final int MAX_N = 100; // 개발자의 최대 수
    public static final int MAX_TIME = 1000; // 최대 일하는 시간

    public static int[][] arr = new int[MAX_N][2]; // 개발자의 일하는 시간을 기록할 2차원 배열 선언
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 주어지는 개발자 수

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        } // n명의 개발자 정보 입력

        int ans = 0;

        for(int i = 0; i < n ; i++){ // i번째 개발자 제외
            int[] workingTime = new int[MAX_TIME + 1]; // 1 - 1000

            for(int j = 0; j < n; j++){
                if(i == j)continue;

                int start = arr[j][0];
                int end = arr[j][1];

                for(int k = start ; k < end; k++){ // end 제외
                    workingTime[k]++; // 시간 기록
                }

            }
            int maxTime = 0;
            for(int j = 0; j < MAX_TIME; j++){

                if(workingTime[j] != 0)
                    maxTime++; // 0이 아니다 -> 한명이라도 일하고 있다.
            }
            ans = Math.max(ans , maxTime); // 최대 운행 시간 업데이트
        }
        System.out.println(ans); // 출력
    }
}