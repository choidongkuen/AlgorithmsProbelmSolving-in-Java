// 날짜 : 2022/09/08
// 문제 : 좌표평면 위의 균형 2
// 문제 설명 :
// 좌표평면 위에 N개의 점이 있습니다. x축과 y축에 평행한 직선을 정확히 1개씩 그어 좌표평면을 4군데로 분할하여 균형 있게 나누려고합니다.
// 균형 있게 나눈다는 것은 4군데 중 가장 많은 점의 수가 최소가 되도록 하는 것을 의미합니다.
// 가장 많은 수의 점이 있는 구역의 점의 개수를 M이라고 할 때, 가능한 M의 최소값을 구하는 프로그램을 작성해보세요.
// 단, x축과 y축에 평행한 직선은 항상 짝수에 그어집니다.

// 입력 형식 :
// 번째 줄에는 정수 N이 주어집니다.
// 두 번째 줄부터는 N개의 줄에 걸쳐 각 점의 위치 (x, y)가 공백을 사이에 두고 주어집니다.
// x, y는 모두 홀수이며, 점의 위치가 겹쳐져 주어지는 경우는 없다고 가정해도 좋습니다.
// 1 ≤ N ≤ 100
// 1 ≤ 주어지는 x, y ≤ 100

// 입력 예시 :
// 7
// 7 3
// 5 5
// 9 7
// 3 1
// 7 7
// 5 3
// 9 1

// 출력 예시 :
// 2

package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES14 {
    public static final int MAX_N = 100; // 주어지는 점의 최대 갯수
    public static final int MAX_A = 100; // 좌표의 최대 값
    public static int[][] arr = new int[MAX_A][MAX_A]; // n개의 점의 정보를 담을 2차원 배열
    public static int n; // 주어지는 n

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n입력

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt(); // x 좌표
            arr[i][1] = sc.nextInt(); // y 좌표
        }

        int ans = MAX_N; // 가장 많은 수의 점의 최소값

        for(int i = 0; i <= MAX_A; i+=2){ // y축 평행한 직선
            for(int j = 0; j <= MAX_A; j+=2){ // x축 평행한 직선

                int[] points = new int[5]; // 1 ~ 4 사분면

                for(int k = 0; k < n; k++){
                    int x = arr[k][0];
                    int y = arr[k][1];

                    if(x > i && y > j)
                        points[1]++; // 1사분면
                    if(x < i && y > j)
                        points[2]++; // 2사분면
                    if(x < i && y < j)
                        points[3]++; // 3사분면
                    if(x > i && y < j)
                        points[4]++; // 4사분면
                }

                int maxVal = 0; // 한 구역에 있는 가장 많은 점
                for(int k = 1; k < 5; k++){
                    maxVal = Math.max(maxVal, points[k]);
                }

                ans = Math.min(ans, maxVal); // 업데이트
            }
        }
        System.out.println(ans); // 출력
    }
}