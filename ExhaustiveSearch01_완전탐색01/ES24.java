// 날짜 : 2022/09/06
// 문제 : 좌표평면 위의 특정 구역2
// 문제 설명 :
// 좌표평면 위에 점 N개가 있습니다. 그 N개의 점들 중 정확히 하나의 점만 빼서,
// 뺀 후의 모든 점들을 포함하는 직사각형의 넓이를 최소로 하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 정수 N이 주어집니다.
//그 다음 줄부터는 N개의 줄에 걸쳐 한 줄에 하나씩 각 점의 위치 (x, y)가 공백을 사이에 두고 주어집니다.
//3 ≤ N ≤ 100
//1 ≤ x, y ≤ 40,000

// 입력 예시 :
// 4
// 2 4
// 1 1
// 5 2
// 17 25

// 출력 예시 :
// 12

package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES24 {
    public static final int MAX_N = 100; // N의 최대값(주어지는 점의 최대값)
    public static final int MAX_SCOPE = 40000; // 좌표의 최대 범위
    public static int[][] arr = new int[MAX_N][2]; // 주어지는 점의 정보가 담기는 2차원 배열

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 주어지는 n
        int ans = Integer.MAX_VALUE; // 정수의 최대값


        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        } // 주어지는 점들에 대한 정보 기록

        for(int i = 0; i < n; i++){ // i점을 제외
            int maxRow = 0, minRow = MAX_SCOPE, maxCol = 0, minCol = MAX_SCOPE;

            for(int j = 0; j < n; j++){
                if(i == j)continue;

                maxRow = Math.max(maxRow, arr[j][0]);
                minRow = Math.min(minRow, arr[j][0]);
                maxCol = Math.max(maxCol, arr[j][1]);
                minCol = Math.min(minCol, arr[j][1]);
            }

            int area = (maxRow - minRow) * (maxCol - minCol); // i 점을 제외 했을때 모든 점을 포함하는 너비
            ans = Math.min(ans , area);
        }
        System.out.println(ans); // 출력
    }
}