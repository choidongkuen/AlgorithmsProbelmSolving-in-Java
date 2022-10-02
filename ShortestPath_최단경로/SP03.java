// 날짜 : 2022/10/01
// 문제 : 비를 피하기
// 문제 설명 :
// 숫자 0, 1, 2, 3로만 이루어진 n * n 격자에서 사람이 h명 겹치지 않게 서 있고,
// 비를 피할 수 있는 공간의 위치 m개가 주어졌을 때 각 사람마다 비를 피할 수 있는 가장 가까운 공간까지의 거리를 구하는 프로그램을 작성해보세요.
// 숫자 0은 해당 칸이 이동할 수 있는 곳임을, 숫자 1은 벽이 있어 해당 칸이 이동할 수 없는 곳임을 의미합니다. 숫자 2는 해당 칸에 사람이 서있음을 의미하고,
// 숫자 3는 해당 공간이 비를 피할 수 있는 공간임을 의미합니다.
// 사람은 상하좌우 인접한 곳으로만 움직 일 수 있으며 한 칸 움직이는 데 정확히 1초가 소요됩니다. 벽이 아닌 곳은 전부 이동이 가능합니다.

// 입력 형식 :
// 첫 번째 줄에 격자의 크기를 나타내는 n과 사람의 수를 나타내는 h 그리고 비를 피할 수 있는 공간의 수를 나타내는 m이 각각 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 행에 해당하는 n개의 숫자가 순서대로 공백을 사이에 두고 주어집니다.
// 2 ≤ n ≤ 100
// 1 ≤ h ≤ n * n
// 1 ≤ m ≤ n * n

// 입력 예시 01:
// 3 1 1
// 1 2 0
// 3 1 0
// 0 0 0

// 출력 예시 01:
// 0 6 0
// 0 0 0
// 0 0 0

// 입력 예시 02:
// 4 5 2
// 1 2 0 1
// 3 1 1 2
// 2 1 2 0
// 2 0 0 3

// 출력 예시 02:
// 0 -1 0 0
// 0 0 0 2
// 1 0 2 0
// 2 0 0 0

package ShortestPath_최단경로;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SP03{
    public static final int MAX_N = 100;
    public static final int DIR_NUM = 4;

    public static int n,h,m;
    public static int[][] arr = new int[MAX_N][MAX_N];
    public static int[][] shortest = new int[MAX_N][MAX_N]; // 특정 사람을 이동시킬 때, 각 지점까지의 최단 거리
    public static boolean[][] visited = new boolean[MAX_N][MAX_N]; // 방문기록을 저장할 2차원 배열

    public static int[][] answer = new int[MAX_N][MAX_N]; // h명의 사람을 이동시킨 결과
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
    public static void push(Point p, int s){
        int x = p.x;
        int y = p.y;

        visited[x][y] = true;
        q.add(p);
        shortest[x][y] = s;
    }

    public static void initialize(){ // 필요한 배열을 초기화 하는 메소드

        for(boolean[] sub : visited){
            Arrays.fill(sub,false);
        }

        for(int[] sub : shortest){
            Arrays.fill(sub, 0);
        }

        q.clear(); // 큐를 초기화!
    }

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){
        return checkRange(x,y) && !visited[x][y] && arr[x][y] != 1;
    }

    public static int bfs(){
        while(!q.isEmpty()){

            Point currP = q.poll();
            int curX = currP.x;
            int curY = currP.y;

            for (int d = 0; d < DIR_NUM; d++) {
                int nextX = curX + dx[d];
                int nextY = curY + dy[d];

                if (canGo(nextX, nextY)) { // 다음 위치로 갈 수 있을 때,
                    if (arr[nextX][nextY] == 3) { // 만약 다음 위치가 비를 피할 수 있는 위치라면
                        return shortest[curX][curY] + 1; // 현재까지의 최단 거리 + 1 을 리턴
                    } else {
                        push(new Point(nextX, nextY), shortest[curX][curY] + 1);
                    }
                }
            }
        }
        return -1;
    }

    public static int avoid(int x, int y){

        initialize(); // avoid 메소드 호출 마다 초기화
        Point start = new Point(x,y); // x,y 지점을 start 지점으로 설정
        push(start,0); // push 메소드 호출

        int dist = bfs(); // bfs 메소드를 통해 해당 위치에서 가장 가까운 피할 수 있는 위치 get
        return dist; // x,y 지점에서 가장 가까운 비를 피할 수 있는 지점까지의 거리 리턴
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        } // 배열 정보 입력


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 2){
                    answer[i][j] = avoid(i,j); // 해당 위치에 사람 존재
                }
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println(); // 결과 출력
        }
    }
}

// 내가 해당 문제를 풀면서 오래 걸린 이유:
// 2가 나왔을 때, 그것을 처리하기 위해 avoid 메소드를 호출할때, 3이나오자마자, bfs() 메소드는 종료하게 된다.
// 이때 큐가 그대로 남아있게 됨 따라서 initialize() 메소드에 '큐를 초기화하는 부분'을 추가해야 한다.(해당 부분을 추가하지 않음)