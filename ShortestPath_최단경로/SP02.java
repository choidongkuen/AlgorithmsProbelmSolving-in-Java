// 날짜 : 2022/10/01
// 문제 : 나이트
// 문제 설명 :
// 나이트는 다음과 같이 노란색 위치를 기준으로 검은색 8곳으로 움직임이 가능합니다.
// n * n 격자 위에서 격자를 벗어나지 않고 나이트가 시작점에서 도착점까지 가는 데 걸리는 최소 이동 횟수를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 격자의 크기를 나타내는 n이 주어집니다.
// 두 번째 줄에는 나이트의 시작 위치 (r1, c1)와 끝 위치 (r2, c2)가 각각 공백을 사이에 두고 주어집니다.
// 이는 r1행 c1열 에서 r2행 c2열로 이동해야 함을 의미합니다. (1 ≤ r1, c1, r2, c2 ≤ n)
// 1 ≤ n ≤ 100

// 입력 예시 01:
// 5
// 3 3 3 2

// 출력 예시 01:
// 3

// 입력 예시 02:
// 3
// 3 3 1 1

// 출력 예시 02:
// 4

package ShortestPath_최단경로;
import java.util.*;

public class SP02 {
    public static final int MAX_N = 100; // 격자 크기의 최대값
    public static final int DIR_NUM = 8; // 8방향

    public static int n; // 주어지는 격자의 크기
    public static int[][] shortest = new int[MAX_N][MAX_N]; // 각 지점의 최단거리를 기록할 2차원 배열
    public static boolean[][] visited = new boolean[MAX_N][MAX_N]; // 방문 기록을 위한 2차원 배열
    public static Queue<Point> q = new LinkedList<>(); // 각 지점의 좌표를 저장할 큐
    public static Point start,end; // 시작지점, 끝지점

    public static int[] dx = {-2,-2,-1,-1,1,1,2,2};
    public static int[] dy = {-1,1,-2,2,-2,2,-1,1};

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void push(Point p, int s){
        int x = p.x;
        int y = p.y;

        shortest[x][y] = s;
        visited[x][y] = true;
        q.add(p);
    }

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){
        return checkRange(x,y) && !visited[x][y];
    }

    public static void bfs(){

        while(!q.isEmpty()){

            Point curP = q.poll();
            int x = curP.x;
            int y = curP.y;

            for (int i = 0; i < DIR_NUM ; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(canGo(nextX,nextY)){
                    push(new Point(nextX,nextY),shortest[x][y] + 1);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        start = new Point(x1 - 1,y1 - 1);
        end = new Point(x2 - 1,y2 - 1);

        for(int[] sub : shortest){
            Arrays.fill(sub,-1);
        }

        push(start,0);
        bfs();

        System.out.println(shortest[end.x][end.y]);
    }
}
