// 날짜 : 2022/10/01
// 문제 : 최소 경로로 탈출 하기

// 문제 설명 :
// n * m 크기의 이차원 영역의 좌측 상단에서 출발하여 우측 하단까지 뱀에게 물리지 않고 탈출하려고 합니다.
// 이동을 할 때에는 반드시 상하좌우에 인접한 칸으로만 이동할 수 있으며, 뱀이 있는 칸으로는 이동을 할 수 없습니다.
// 탈출 가능한 경로의 최단 거리를 출력하는 코드를 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어지고,
// 두 번째 줄부터 (n+1)번째 줄까지는 각 행에 뱀이 없는 경우 1, 뱀이 있는 경우 0이 입력으로 공백을 사이에 두고 주어집니다.
// 시작과 끝 지점에는 뱀이 주어지지 않는다고 가정해도 좋습니다.
// 2 ≤ n, m ≤ 100

// 입력 예시01 :
// 5 5
// 1 0 1 1 1
// 1 0 1 0 1
// 1 0 1 1 1
// 1 0 1 0 1
// 1 1 1 0 1

// 출력 예시01 :
// 12

// 입력 예시02 :
// 5 5
// 1 1 1 1 1
// 1 0 1 0 1
// 1 1 1 1 1
// 1 0 1 0 1
// 1 1 1 0 1

// 출력 예시02 :
// 8

package GraphSearch_그래프탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GS16 {

    public static final int MAX = 100;
    public static final int DIR_NUM = 4;

    public static int n,m;
    public static int[][] arr = new int[MAX][MAX]; // 주어지는 정보 기록
    public static boolean[][] visited = new boolean[MAX][MAX]; // 방문 기록
    public static int[][] shortest = new int[MAX][MAX]; // 각 지점까지의 최단 거리 기록
    public static Queue<Point> q = new LinkedList<>();

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};

    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void step(int x, int y, int s){
        shortest[x][y] = s;
        visited[x][y] = true;
        q.add(new Point(x,y));
    }

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y){
        return checkRange(x,y) && !visited[x][y] && arr[x][y] != 0;
    }

    public static void bfs(){

        while(!q.isEmpty()){

            Point currP = q.poll();

            int currX = currP.x;
            int currY = currP.y;

            for (int i = 0; i < DIR_NUM ; i++) {
                int nextX = currX + dx[i];
                int nextY = currY + dy[i];

                if(canGo(nextX,nextY)){ // 해당 방향으로 갈 수 있다면
                    step(nextX,nextY,shortest[currX][currY] + 1); // 해당 지점의 최단거리 + 1
                }
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Point start = new Point(0,0); // 초기 지점
        step(start.x,start.y,0);
        bfs(); // 깊이우선탐색 실행

        System.out.println(shortest[n - 1][m - 1] == 0 ? -1 : shortest[n - 1][m - 1]); // 출력
    }
}
