// 날짜 : 2022/10/02
// 문제 : k개의 벽 없애기

// 문제 설명 :
// 숫자 0, 1로만 이루어진 n * n 격자가 주어졌을 때,
// k개의 벽을 적절하게 없애 시작점으로부터 상하좌우 인접한 곳으로만 계속 이동하여 도착점까지 도달하는 데 걸리는 시간을 최소로 하는 프로그램을 작성해보세요.
// 숫자 0은 해당 칸이 이동할 수 있는 곳임을, 숫자 1은 벽이 있어 해당 칸이 이동할 수 없는 곳임을 의미합니다.
// 한 칸을 이동하는 데에는 정확히 1초의 시간이 소요됩니다.

// 입력 형식 :
// 첫 번째 줄에는 격자의 크기를 나타내는 n과 없애야 할 벽의 개수 k가 각각 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 행에 해당하는 n개의 숫자가 순서대로 공백을 사이에 두고 주어집니다.
// 그 다음 줄에는 시작점의 위치 (r1, c1)과 도착점의 위치 (r2, c2)가 각각 공백을 사이에 두고 주어집니다.
// 이는 r1행 c1열에서 출발하여 r2행 c2열로 도착해야 함을 의미합니다. 시작 위치와 도착 위치에는 항상 숫자 0이 주어진다고 가정해도 좋습니다.
// 3 ≤ n ≤ 100
// 0 ≤ k ≤ 입력으로 주어지는 초기 벽의 개수 ≤ 8

// 입력 예시 01:
// 4 2
// 0 0 0 0
// 0 1 1 1
// 1 1 1 1
// 0 1 0 0
// 1 1
// 4 4

// 출력 예시 01:
// 6

// 입력 예시 02:
// 4 2
// 0 1 0 0
// 1 0 0 1
// 0 0 1 1
// 0 1 1 0
// 1 1
// 4 4

// 출력 예시 02:
// -1

// 아이디어 :
// 모든 벽의 위치를 wallPos 배열리스트에 저장
// wallPos.size() 개의 벽중 k를 선택하기(n개 중 k개 선택) -> 선택한 위치는 0으로 변경
// 변경 후, bfs() 메소드 호출해서 시작 지점에서 도착 지점까지의 최단 거리를 구함

package ShortestPath_최단경로;

import java.util.*;

public class SP04 {

    public static final int MAX_N = 100; // 격자의 최대 크기
    public static final int DIR_NUM = 4; // 4 방향으로 이동 가능

    public static int[][] arr = new int[MAX_N][MAX_N]; // 벽의 정보를 원소로 하는 2차원 배열
    public static boolean[][] visited = new boolean[MAX_N][MAX_N]; // 방문 기록을 위한 2차원 배열
    public static int[][] shortest = new int[MAX_N][MAX_N]; // 특정 위치로 부터 각 지점마다의 최다 거리를 원소로 하는 2차원 배열

    public static Queue<Point> q = new LinkedList<>();
    public static ArrayList<Point> wallPos = new ArrayList<>(); // 벽의 위치를 갖는 배열 리스트
    public static ArrayList<Point> selectedWall = new ArrayList<>(); // 선택된 k개의 벽의 정보를 담은 배열 리스트

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int n,k,m;
    public static int ans = Integer.MAX_VALUE; // 도착지점까지의 최단 거리
    public static Point start,end; // 시작지점과 끝지점

    static class Point{
        int x,y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){
        return checkRange(x,y) && !visited[x][y] && arr[x][y] == 0;

    }

    public static void initialize(){

        for(boolean[] sub : visited){
            Arrays.fill(sub,false);
        }

        for(int[] sub : shortest){
            Arrays.fill(sub ,0);
        }
    }

    public static void push(Point p, int s){
        q.add(p);
        visited[p.x][p.y] = true;
        shortest[p.x][p.y] = s;
    }

    public static void bfs(){
        while(!q.isEmpty()){

            Point curP = q.poll();

            int curX = curP.x;
            int curY = curP.y;

            for (int d = 0; d < DIR_NUM ; d++) {
                int nextX = curX + dx[d];
                int nextY = curY + dy[d];

                if(canGo(nextX,nextY)){
                    push(new Point(nextX,nextY), shortest[curX][curY] + 1);
                }
            }
        }
    }

    public static int calc(){
        for (int i = 0; i < k; i++) {
            int removedX = selectedWall.get(i).x;
            int removedY = selectedWall.get(i).y; // 제거될 벽의 위치

            arr[removedX][removedY] = 0; // 제거될 위치를 0으로 변경
        }

        bfs();

        for(int i = 0; i < selectedWall.size() ; i++) {
            int removedX = selectedWall.get(i).x;
            int removedY = selectedWall.get(i).y; // 복구할 벽의 위치

            arr[removedX][removedY] = 1; // 복구할 위치를 1으로 변경
        }

        if(visited[end.x][end.y]){
            return shortest[end.x][end.y];
        }
        return Integer.MAX_VALUE;
        // 도착지점까지의 최단 거리가 0이란 뜻은 도달하지 못한 것을 의미
    }
    public static void backtracking(int idx, int cnt){

        if(idx == wallPos.size()){
            if(cnt == k){ // r개의 벽중 k개 선택
                initialize();
                ans = Math.min(ans,calc());
            }
            return;
        }

        selectedWall.add(wallPos.get(idx));
        backtracking(idx + 1, cnt + 1);
        selectedWall.remove(selectedWall.size() - 1);

        backtracking(idx + 1, cnt); // idx 번째 벽을 제외하고 다음으로 백트랙킹
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 주어지는 격자 크기
        k = sc.nextInt(); // 시작점의 갯수

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1){
                    wallPos.add(new Point(i,j));
                }
            }
        }

        int s1 = sc.nextInt() - 1;
        int e1 = sc.nextInt() - 1;

        int s2 = sc.nextInt() - 1;
        int e2 = sc.nextInt() - 1;

        start = new Point(s1, e1); // 시작 위치
        end = new Point(s2, e2); // 끝 위치

        push(start,0);
        backtracking(0,0);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
