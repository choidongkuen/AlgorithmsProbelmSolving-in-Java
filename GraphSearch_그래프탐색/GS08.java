// 날짜 : 2022/09/16
// 문제 : 뱀을 피해 가보자(GS03 BFS.ver)
// 문제 설명 : GS03과 동일

// BFS 특징 : 큐를 이용하여, 해당 정점이 방문 기록이 없다면 방문 기록 하고 큐에 add -> 해당 노드 순서가 peek(맨 앞) 에 오면 poll 하면서 근처에 있는 노드를 방문 기록 하면서 큐에 다시 add(반복)

package GraphSearch_그래프탐색;
/*
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class GS08 {
    public static int MAX_N = 100; // 최대 격자 크기
    public static int DIR_NUM = 2; // 아래 위
    public static int[][] info = new int[MAX_N][MAX_N]; // 뱀의 정보가 담긴 2차원 배열
    public static int[] dx = {1,0};
    public static int[] dy = {0,1};
    public static int n; // 주어지는 격자 크기
    public static int order = 1; // 방문 순서

    public static int[][] answer = new int[MAX_N][MAX_N]; // 방문 순서를 기록할 2차원 배열
    public static boolean[][] visited = new boolean[MAX_N][MAX_N]; // 방문 여부를 기록할 2차원 배열
    public static Queue<Pair> q = new LinkedList<>(); // BFS 를 위한 큐 선언

    // 격자마다 해야 할 일 : 1. 방문 기록 2. 큐에 집어 넣기 3. 방문 순서 기록

    public static void push(int x, int y){

        visited[x][y] = true; // 방문 기록
        q.add(new Pair(x,y)); // queue push
        answer[x][y] = order++; // 방문 순서 기록

    }
    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){

        if(!checkRange(x,y))
            return false;

        if(info[x][y] == 0 || visited[x][y])
            return false;
        // 뱀이 있거나, 방문 했거나

        return true;
    }

    public static void BFS(){
        while(!q.isEmpty()){
            Pair currV = q.poll();

            int x = currV.x;
            int y = currV.y;
            for(int i = 0; i < DIR_NUM; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i]; // 다음 위치
                if (canGo(nextX, nextY)) { // 해당 위치로 갈 수 있으면
                    push(nextX, nextY); // push 메소드 호출
                }
            }
        }
//        System.out.println(q);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("격자 크기 입력 : ");
        n = sc.nextInt(); // 격자 크기 입력

        System.out.println("뱀 정보 입력 : ");
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                info[i][j] = sc.nextInt();

        // info 배열 완성
        push(0,0);
        BFS(); // BFS 메소드 호출

        System.out.println("===== 결과 출력 =====");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println(); // 결과 출력
        }
    }
}
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 큐에 x,y 그대로 넣을래?...
// 클래스 하나 만들자.

class Pair{
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class GS08{
    public static final int MAX_N = 100;
    public static final int MAX_M = 100;
    public static final int DIR_NUM = 4;

    public static int n,m;
    public static int[][] arr = new int[MAX_N][MAX_M];
    public static boolean[][] visited = new boolean[MAX_N][MAX_M];
    public static Queue<Pair> q = new LinkedList<>();

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y){
        return checkRange(x,y) && arr[x][y] == 1 && !visited[x][y];
    }
    public static void bfs(){

        while(!q.isEmpty()){
            Pair p = q.poll();

            int curX = p.x;
            int curY = p.y;

            for (int d = 0; d < DIR_NUM ; d++) {
                int nextX = curX + dx[d];
                int nextY = curY + dy[d];

                if(canGo(nextX,nextY)){
                    visited[nextX][nextY] = true; // 방문 기록
                    q.add(new Pair(nextX,nextY));
                }
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        visited[0][0] = true;
        q.add(new Pair(0,0));
        bfs();
        System.out.println((visited[n - 1][m - 1])? 1 : 0);
    }
}