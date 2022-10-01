// 그래프에 가중치가 있는 경우 :
// # 가중치가 전부 동일한 경우 -> BFS(가까운 지점부터 방문)
// 문제 : nxm 행렬이 주어질 때, 각 지점까지의 최단 거리를 구하시오.
// 문제 설명 :
// 시작 지점 : 좌측 상단

package GraphSearch_그래프탐색;

import java.util.*;

public class GS15 {
    public static final int DIR_NUM = 2;

    public static int n,m;
    public static int[][] step; // 각 지점까지의 최단거리를 기록할 2차원 배열
    public static boolean[][] visited; // 방문 기록용 2차원 배열
    public static Queue<Point> q = new LinkedList<>(); // Point 인스턴스를 저장할 큐

    public static int[] dx = {1,0};
    public static int[] dy = {0,1}; // 아래와 오른쪽 이동

    static class Point{
        int x;int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void push(int x, int y, int s){
        visited[x][y] = true;
        step[x][y] = s + 1;
        q.add(new Point(x,y));
    }
    // push 메소드의 역할
    // 1. 방문 처리
    // 2. 최단거리 기록
    // 3. 큐에 push

    public static void bfs(){
        while(!q.isEmpty()){

            Point currP = q.poll();

            for (int d = 0; d < DIR_NUM ; d++) {
                int nextX = currP.x + dx[d];
                int nextY = currP.y + dy[d];

                if(checkRange(nextX,nextY) && !visited[nextX][nextY]){
                    push(nextX,nextY,step[currP.x][currP.y]);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        step = new int[n][m];
        visited = new boolean[n][m];

        Point start = new Point(0,0);
        push(start.x,start.y,-1);
        bfs();

        System.out.println(Arrays.deepToString(step));
    }
}
