// 날짜 : 2022/09/06
// 문제 : 가장 가까운 두 점 사이의 거리

// 문제 설명 : 2차 평면 상에 n개의 점이 주어졌을 때,
// 가장 가까운 두 점 사이의 거리에 제곱을 한 값을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 점의 위치 (x, y) 정보가 공백을 사이에 두고 주어집니다.
// 모든 점의 위치는 다르게 주어짐을 가정해도 좋습니다.
// 2 ≤ n ≤ 100
// 0 ≤ x, y ≤ 1,000

// 입력 예시 :
// 3
// 0 0
// 3 3
// 1 1

// 출력 예시 :
// 2


package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES25 {
    public static final int MAX_N = 100; // 주어지는 점의 최대값
    public static final int MAX_SCOPE = 1000; // 좌표의 범위

    public static int[][] arr = new int[MAX_N][2]; // 주어지는 선분 정보를 담을 2차원 배열

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = Integer.MAX_VALUE; // 정수의 최대값(가장 가까운 거리를 구하기 위함)

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt(); // x
            arr[i][1] = sc.nextInt(); // y
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){ // 두 점을 설정
                int x1 = arr[i][0];
                int x2 = arr[j][0];
                int y1 = arr[i][1];
                int y2 = arr[j][1];

                // 두 점 사이의 거리의 제곱

                double dis = Math.pow((x2 - x1) , 2) + Math.pow((y2 - y1) , 2);
                ans = Math.min(ans, (int)dis);
            }
        }
        System.out.println(ans);
    }
}