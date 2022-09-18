// 날짜 : 2022/09/18
// 문제 : k번 최댓값으로 이동하기(BFS ver)
// 문제 설명 : GS12와 동일
// GS12 BFS ver

package GraphSearch_그래프탐색;

import java.util.*;

class Point2{
    int x,y;

    Point2(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class GS13{

    public static final int MAX = 100; // 최대값
    public static int[][] info = new int[MAX][MAX]; // 주어지는 정보를 원소로 갖는 2차원 배열
    public static boolean[][] visited; // 매 k마다 초기화를 위해 선언만
    public static Queue<Point2> q;// BFS를 위한 큐 선언
    public static int n,k;

    public static final int DIR_NUM = 4;
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int curX,curY; // 특정 순간의 위치
    public static int curVal; // 특정 순간의 값

    public static boolean checkRange(int x, int y){

        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){

        if(!checkRange(x,y) || info[x][y] >= curVal || visited[x][y])
            return false;

        return true;
    }

    public static void findLoc(){ // 해당 위치에서 조건 만족하는 위치를 찾아주는 메소드
        int x = curX;
        int y = curY;

        int maxVal = 0;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(visited[i][j] && info[i][j] > maxVal){
                    maxVal = info[i][j];
                    x = i;
                    y = j;
                }

        curX = x;
        curY = y;
        curVal = maxVal; // 위치 및 값 업데이트
    }

    public static void BFS(){

        while(!q.isEmpty()){

            Point2 p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < DIR_NUM; i ++){

                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(canGo(nextX,nextY)){
                    visited[nextX][nextY] = true;
                    q.add(new Point2(nextX,nextY));

                }
            }
        }
    }

    public static void initialization(){
        visited = new boolean[MAX][MAX];
        q = new LinkedList<>();

        for(int d = 0; d < DIR_NUM; d ++){

            int nextX = curX + dx[d];
            int nextY = curY + dy[d];

            if(canGo(nextX,nextY)){
                visited[nextX][nextY] = true;
                q.add(new Point2(nextX,nextY));
            }
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j++)
                info[i][j] = sc.nextInt(); // 원소 정보 기록

        curX = sc.nextInt() - 1;
        curY = sc.nextInt() - 1; // 초기 위치 정보 입력
        curVal = info[curX][curY]; // 초기 값

        for(int i = 0; i < k; i ++){

            initialization(); // 초기화
            BFS(); // 해당 위치에서 이동 가능한 칸 모두 기록
            findLoc();
        }

        System.out.println((curX + 1)+" "+(curY + 1)); // 출력
    }
}