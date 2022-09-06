// 날짜 : 2022 / 09 / 06
// 문제 : 겹치지 않은 선분 2
// 문제 설명 :
// N개의 선분이 주어졌을 때, 다른 선분과 전혀 겹치지 않는 선분의 수를 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 정수 N이 주어집니다.
// 그 다음 줄부터는 N개의 줄에 걸쳐 각 줄마다 x1과 x2가 공백을 사이에 두고 주어집니다. 이는 해당 선분의 끝점이 (x1, 0), (x2, 1)임을 의미합니다.
// 입력으로 주어지는 x1끼리는 겹쳐져 주어지지 않으며, x2끼리도 겹쳐져 주어지지 않음을 가정해도 좋습니다.
// 1 ≤ N ≤ 100
// -1,000,000 ≤ 주어지는 x의 값 ≤ 1,000,000

// 입력 예시 :
// 4
// -3 4
// 7 8
// 10 16
// 3 9

// 출력 예시 :
// 2

package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES27 {
    public static final int MAX_N = 100; // n의 최대값
    public static int[][] arr = new int[MAX_N][2]; // start - end

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n ;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        } // 2차원 배열 기록

        int ans = 0; // 겹치지 않는 선분의 수

        for(int i = 0; i < n; i++){ // i번째 선분이 교차하는 선분인지 판단
            boolean overlap = false;

            for(int j = 0 ; j < n; j++){ // 두개의 선분 pick
                if( i == j )continue;


                int x1 = arr[i][0]; // 3
                int y1 = arr[i][1]; // 9

                int x2 = arr[j][0]; // 7
                int y2 = arr[j][1]; // 8

                if((x1 <= x2 && y1 >= y2) || (x1 >= x2 && y1 <= y2)){
                    overlap = true;
                    break;
                }
            }
            if(overlap == false)
                ans++;
        }
        System.out.println(ans);
    }
}