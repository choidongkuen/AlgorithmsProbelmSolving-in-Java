// 날짜 : 2022/09/16
// 문제 : 뱀을 피해 이동하자.(GS04 BFS ver)
// 문제 설명 :

// n * m 크기의 이차원 영역의 좌측 상단에서 출발하여 우측 하단까지 뱀에게 물리지 않고 탈출하려고 합니다.
// 이동을 할 때에는 반드시 아래와 오른쪽 2방향 중 인접한 칸으로만 이동할 수 있으며, 뱀이 있는 칸으로는 이동을 할 수 없습니다.
// 예를 들어 뱀이 배치 되어 있는 경우 실선과 같은 경로로 탈출을 할 수 있습니다.
// 이 때 뱀에게 물리지 않고 탈출 가능한 경로가 있는지 여부를 판별하는 코드를 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어지고,
// 두 번째 줄부터 (n+1)번째 줄까지는 각 행에 뱀이 없는 경우 1, 뱀이 있는 경우 0이 입력으로 공백을 사이에 두고 주어집니다.
// 시작 칸과 끝 칸에는 뱀이 주어지지 않는다고 가정해도 좋습니다.
// 2 ≤ n, m ≤ 100

// 입력 예시 1 :
// 5 5
// 1 0 1 1 1
// 1 0 1 0 1
// 1 0 1 1 1
// 1 0 1 0 1
// 1 1 1 0 1

// 출력 예시 1 :
// 0

// 입력 예시 2 :
// 5 5
// 1 0 1 1 1
// 1 0 1 0 1
// 1 1 1 0 1
// 1 0 1 1 1
// 0 1 1 0 1

// 출력 예시 2 :
// 1

package GraphSearch_그래프탐색;

import java.util.*;

class Point{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class GS09 {
    public static final int MAX_N = 100;
    public static final int MAX_M = 100; // 최대 크기
    public static final int DIR_NUM = 4; // 4방향
    public static int[][] info = new int[MAX_N][MAX_M]; // 주어지는 뱀의 정보를 위한 2차원 배열(뱀이 있으면 0, 없으면 1)
    public static boolean[][] visited = new boolean[MAX_N][MAX_M]; // 방문 기록을 위한 2차원 배열
    public static Queue<Point> queue = new LinkedList<>(); // BFS 구현을 위한 큐 선언
    public static int n,m; // 주어지는 격자 크기

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y){

        if(!checkRange(x,y)) // 범위 벗어난 경우
            return false;

        if(info[x][y] == 0 || visited[x][y]) // 해당 위치에 뱀이 있거나, 방문한 적 있을 때
            return false;

        return true;
    }

    public static void BFS(){
        while(!queue.isEmpty()){
            Point currV = queue.poll(); // 해당 노드 처리

            int x = currV.x;
            int y = currV.y;
            for(int i = 0 ; i < DIR_NUM; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i]; // 다음 위치

                if(canGo(nextX,nextY)){
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX,nextY));
                }
            }
        }
    }
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                info[i][j] = sc.nextInt(); // 정보 배열 기록

        Point initP = new Point(0,0); // 처음 격자
        visited[initP.x][initP.y] = true; // 방문 기록
        queue.add(initP); // 큐 push

        BFS(); // BFS 메소드 호출

        if(visited[n - 1][m - 1])
            System.out.println(1); // 탈출 가능
        else
            System.out.println(0); // 탈출 불가능
    }
}