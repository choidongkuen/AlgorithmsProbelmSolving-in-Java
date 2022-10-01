package GraphSearch_그래프탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GS14다시 {

    public static final int MAX_N = 100; // n의 최대값
    public static final int DIR_NUM = 4; // 상하좌우

    public static int n,m,k;
    public static int ans;
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];
    public static int[][] arr = new int[MAX_N][MAX_N]; // 돌의 정보를 담을 2차원 배열(1 : 돌, 0 : 돌x)


    public static ArrayList<Point> stonePos = new ArrayList<>();
    public static ArrayList<Point> selectedStones = new ArrayList<>();
    public static ArrayList<Point> sPos = new ArrayList<>();
    public static Queue<Point> q = new LinkedList<>();

    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};

    static class Point{

        int x,y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    /////////////////////////////////////////////////////
    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){
        return checkRange(x,y) && !visited[x][y] && arr[x][y] == 0;
    }

    public static void BFS(){

        while(!q.isEmpty()){

            Point p = q.poll();

            int curX = p.x;
            int curY = p.y;

            for (int d = 0; d < DIR_NUM ; d++) {
                int nextX = curX + dx[d];
                int nextY = curY + dy[d];

                if(canGo(nextX,nextY)){
                    visited[nextX][nextY] = true;
                    q.add(new Point(nextX,nextY));
                }
            }
        }
    }
    /////////////////////////////////////////////////////

    /////////////////////////////////////////////////////

    public static int calc(){ // m개의 돌 선택 후,

        for (int i = 0; i < m ; i++) {
            int x = selectedStones.get(i).x;
            int y = selectedStones.get(i).y;
            // 제거하기로 선택된 돌의 x죄표,y좌표
            arr[x][y] = 0;
        }

        for(int i = 0; i < n; i ++){
            for (int j = 0; j < n ; j++) {
                visited[i][j] = false;
            }
        } // 방문 기록 초기화

        for (int i = 0; i < k ; i++) {
            q.add(sPos.get(i));
            visited[sPos.get(i).x][sPos.get(i).y] = true;
            // k개의 시작위치 방문 처리
        }

        BFS();

        for (int i = 0; i < m ; i++) {
            int x = selectedStones.get(i).x;
            int y = selectedStones.get(i).y;
            // 제거하기로 선택된 돌의 x죄표,y좌표
            arr[x][y] = 1;
        }

        int cnt = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(visited[i][j]){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public static void backtracking(int idx, int cnt){
        if(idx == stonePos.size()){
            if(cnt == m){
                ans = Math.max(ans,calc());
            }
            return;
        }

        selectedStones.add(stonePos.get(idx));
        backtracking(idx + 1, cnt + 1);
        selectedStones.remove(selectedStones.size() - 1);

        backtracking(idx + 1,cnt); // 현재 idx 번째를 고르지 않고 진행
    }
    /////////////////////////////////////////////////////


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 격자 크기
        k = sc.nextInt(); // 시작점 수
        m = sc.nextInt(); // 치워야 할 돌의 개수

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = sc.nextInt();
                if(arr[i][j] == 1){
                    stonePos.add(new Point(i,j)); // 돌의 위치
                }
            }
        }
        while(k -- > 0){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            sPos.add(new Point(x,y)); // 시작 위치
        }

        backtracking(0,0);
        System.out.println(ans);
    }
}
