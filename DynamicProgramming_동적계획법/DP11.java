// 날짜 : 2022/10/06
// 문제 : 정수 사각형 최장 증가 수열
// 문제 설명 :
// n×n 크기의 격자 정보가 주어졌을 때,
// 시작점을 적절하게 잡아 상하좌우로 인접한 칸으로 계속 칸에 적혀있는 정수값이 커지도록
// 이동한다고 했을 때 밟고 지나갈 수 있는 최대 칸의 수를 구하는 프로그램을 작성해보세요.


// 입력 형식 :
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄부터 n개의 줄에 걸쳐 각 행에 해당하는 n개의 정수 값이 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 500
// 1 ≤ 주어지는 숫자 ≤ 10
// 9

// 입력 예시 01 :
// 3
// 2 2 1
// 3 1 2
// 4 1 2

// 출력 예시 01 :
// 3

// 입력 에시 02 :
// 3
// 5 1 3
// 6 1 4
// 7 2 3

// 출력 예시 02 :
// 4

// 아이디어 :
// dp[ix][jy] = 해당 i행 j열 일 때의 정수 사각형 최장 증가 수열의 길이
// 모든 점에서 시작 할 수 있음으로, 초기에 모든 dp는 1의 원소를 갖는다.
// 어떤 점에서 시작해야할지 막막...-> 다 해볼까? no 완전 탐색
// 일단 인스턴스화 헤서 각 좌표에 대한 원소를 기준으로 정렬해볼까?

package DynamicProgramming_동적계획법;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DP11 {
    static class Point{
        int x,y,element;

        Point(int x, int y, int element){
            this.x = x;
            this.y = y;
            this.element = element;
        }
    }
    public static final int MAX_N = 500; // 격자의 최대 크기
    public static final int DIR_NUM = 4; // 상하좌우

    public static int[][] arr = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] dp = new int[MAX_N + 1][MAX_N + 1]; // dp 테이블
    public static PriorityQueue<Point> pq = new PriorityQueue<>((x,y) -> x.element - y.element);
    // 격자에 들어있는 원소 기준 오름차순 정렬
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int n;

    public static boolean checkRange(int x, int y){
        return x > 0 && x <= n && y > 0 && y <= n;
    }

    public static void solution(){

        for(int[] sub : dp)
            Arrays.fill(sub,1);
        // 초기 dp 테이블 1로 초기화

        while(!pq.isEmpty()){
            Point cur = pq.poll();

            int curX = cur.x;
            int curY = cur.y;

            for (int d = 0; d < DIR_NUM; d++) {
                int nextX = curX + dx[d];
                int nextY = curY + dy[d];

                if(checkRange(nextX,nextY) && arr[nextX][nextY] > arr[curX][curY]){
                    dp[nextX][nextY] = Math.max(dp[nextX][nextY], dp[curX][curY] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
                pq.add(new Point(i, j, arr[i][j]));
            }
        }

        solution();
    }

}
