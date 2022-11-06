// 날짜 : 2022/11/04
// 문제 : 상한 귤
// 문제 설명 :
// 숫자 0, 1, 2로만 이루어진 n * n 격자에서 0초에 k개의 상한 귤로부터 시작하여 1초에 한 번씩 모든 상한 귤로부터 인접한 곳에 있는 귤이 동시에 전부 상하게 될때,
// 각 귤마다 최초로 상하게 되는 시간을 구하는 프로그램을 작성해보세요.
// 숫자 0은 해당 칸에 아무것도 놓여있지 않음을, 숫자 1은 해당 칸에 귤이 놓여있음을, 숫자 2는 해당 칸에 상한 귤이 처음부터 놓여 있음을 의미합니다.

// 입력 형식 :
// 첫 번째 줄에 격자의 크기를 나타내는 n과 초기에 상해있는 귤의 수를 나타내는 k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 행에 해당하는 n개의 숫자가 순서대로 공백을 사이에 두고 주어집니다.
// 2 ≤ n ≤ 100
// 1 ≤ k ≤ n * n

// 입력 예시 01 :
// 3 1
// 1 1 1
// 1 0 1
// 1 0 2

// 출력 예시 01 :
// 4 3 2
// 5 -1 1
// 6 -1 0

// 아이디어 :
// 최초 위치라는 것은 최단 거리
// for 문을 돌며 상하지 않은 귤(1) 이 나오면
// 상한 귤(2) 까지의 최단 거리를 구하자.
// 만약 다 돌고 나서도 answer 배열에 값이 갱신되지 않는다면
// -2 값 대입

package GraphSearch_그래프탐색;

import java.util.*;

public class GS18 {

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int MAX_N = 100;
    public static final int DIR = 4;

    public static int n,k;
    public static Point startP;
    public static int [][] arr = new int[MAX_N][MAX_N];
    // 밑에 3가지 자원은 매 턴마다 초기화 되어야 함
    public static boolean[][] visited;
    public static int[][] shortest;
    public static int[][] answer = new int[MAX_N][MAX_N];
    public static Queue<Point> q;

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){

        return checkRange(x,y) && !visited[x][y] && arr[x][y] != 0;
    }

    public static void lastProcessing(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {

                if(arr[i][j] == 0)
                    answer[i][j] = -1;
                if(arr[i][j] == 2)
                    answer[i][j] = 0;
            }
        }
    }


    public static void initialize(){

        shortest = new int[n][n];
        q = new LinkedList<Point>();
        visited = new boolean[n][n];

    }
    // push -> 방문 처리, 큐에 삽입, 최단 거리 기록
    public static void push(int x, int y, int s){

        shortest[x][y] = s;
        visited[x][y] = true;
        q.add(new Point(x,y));

    }
    public static void bfs(){

        while(!q.isEmpty()){

            Point curP = q.poll();

            int curX = curP.x;
            int curY = curP.y;

            int curS = shortest[curX][curY];

            for (int d = 0; d < DIR ; d++) {

                int nextX = curX + dx[d];
                int nextY = curY + dy[d];

                if(canGo(nextX,nextY)){

                    if(arr[nextX][nextY] == 2){
                        answer[startP.x][startP.y] = curS + 1;
                        return;
                    }else{
                        push(nextX,nextY,curS + 1);
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 격자 크기
        n = sc.nextInt();
        // 상한 귤의 개수
        k = sc.nextInt();

        // 배열 입력 받기
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {

                if(arr[i][j] == 1){
                    startP = new Point(i,j); // 상하지 않은 귤의 시작 위치
                    initialize(); // 필요 자원 초기화
                    push(i,j,0);
                    bfs();

                    if(answer[i][j] == 0){
                        answer[i][j] = -2;
                    }
                }
            }
        }

        lastProcessing();

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }

    }
}
