package GraphSearch_그래프탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GS19 {

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int MAX_N = 100;
    public static final int DIR = 4;

    // n : 격자의 크기
    // h : 사람의 수
    // m : 비를 피할 수 있는 영역의 개수
    public static int n,h,m;
    public static Point startP;
    public static int[][] arr = new int[MAX_N][MAX_N];
    public static boolean[][] visited;
    public static int[][] shortest;
    public static Queue<Point> q = new LinkedList<>();
    public static int[][] answer = new int[MAX_N][MAX_N];

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static boolean checkRange(int x, int y){

        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){

        return checkRange(x,y) && !visited[x][y] && arr[x][y] != 1;
    }

    public static void initialize(){

        shortest = new int[n][n];
        visited = new boolean[n][n];
        q.clear();
    }

    // 해당 지점까지의 최단거리를 기록하는 메소드
    // 1. 방문 기록
    // 2. 큐에 집어넣고
    // 3. 최단거리 기록하고
    public static void push(int x, int y, int s){

        visited[x][y] = true;
        q.add(new Point(x,y));
        shortest[x][y] = s;
    }

    public static void bfs(){

        while(!q.isEmpty()){

            Point curP = q.poll();

            int x = curP.x;
            int y = curP.y;
            int curS = shortest[x][y];

            for (int d = 0; d < DIR ; d++) {
                int nextX = x + dx[d];
                int nextY = y + dy[d];
                if(canGo(nextX,nextY)){

                    // 다음위치가 비를 피할 수 있는 지역(3) 이라면
                    if(arr[nextX][nextY] == 3){
                        answer[startP.x][startP.y] = curS + 1;
                        return; // 함수 종료
                    }else {
                        push(nextX, nextY, curS + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        h = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {

                if(arr[i][j] == 2){
                    startP = new Point(i,j); // 시작 지점 저장
                    initialize(); // 자원 초기화
                    push(i,j,0); // 현재 위치 시작
                    bfs();

                    if(answer[i][j] == 0)
                        answer[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
