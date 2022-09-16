import java.util.*;

import java.util.*;
/*
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_M = 100; // 최대 크기
    public static final int DIR_NUM = 4; // 4방향
    public static int[][] info = new int[MAX_N][MAX_M]; // 주어지는 뱀의 정보를 위한 2차원 배열(뱀이 있으면 0, 없으면 1)
    public static boolean[][] visited = new boolean[MAX_N][MAX_M]; // 방문 기록을 위한 2차원 배열
    public static Queue<Pair> q = new LinkedList<>(); // BFS 구현을 위한 큐 선언
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
        while(!q.isEmpty()){
            Pair currV = q.poll(); // 해당 노드 처리

            int x = currV.x;
            int y = currV.y;
            for(int i = 0 ; i < DIR_NUM; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i]; // 다음 위치

                if(canGo(nextX,nextY)){
                    visited[nextX][nextY] = true;
                    q.add(new Pair(nextX,nextY));
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

        Pair initP = new Pair(0,0); // 처음 격자
        visited[initP.x][initP.y] = true; // 방문 기록
        q.add(initP); // 큐 push

        BFS(); // BFS 메소드 호출

        if(visited[n - 1][m - 1])
            System.out.println(1); // 탈출 가능
        else
            System.out.println(0); // 탈출 불가능
    }
}
*/

// DFS.ver
public class Test{
    public static final int MAX_N = 50;
    public static final int MAX_M = 50;
    public static final int DIR_NUM = 4;
    public static int[][] info = new int[MAX_N][MAX_M];
    public static boolean[][] visited = new boolean[MAX_N][MAX_M];

    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int n,m;

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    public static boolean canGo(int x, int y){

        if(!checkRange(x,y))
            return false;

        if(info[x][y] == 0 || visited[x][y])
            return false;

        return true;
    }

    public static void DFS(int x, int y){
        for(int d = 0; d < DIR_NUM; d++){
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(canGo(nextX,nextY)){
                visited[nextX][nextY] = true; // 방문 기록
                DFS(nextX,nextY); // 재귀적 호출
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 격자 크기 입력
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                info[i][j] = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(info[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true; // 방문 기록
                    DFS(i,j); // BFS 메소드 호출
                }

        if(visited[n - 1][m - 1])
            System.out.println(1);
        else
            System.out.println(0);

    }
}