// 날짜 : 2022/09/16
// 문제 : 안전 지대
// 문제 설명 :
// N×M 크기의 격자로 구성된 마을이 있습니다. 격자마다 한 집을 의미하며, 각 집의 높이는 1이상 100이하의 숫자로 이루어져 있습니다.
// 이런 상황에서 만약 비가 K(K≥1)만큼 온다고 한다면, 마을에 있는 집들 중 높이가 K 이하인 집들은 전부 물에 잠기게 되기 때문에,
// 대책을 세우기 위해 미리 각 K에 따라 안전 영역의 개수가 어떻게 달라지는지를 보려고 합니다. 여기서 안전 영역이란 잠기지 않은 집들로 이루어져 있으며,
// 잠기지 않은 집들끼리 서로 인접해 있는 경우 동일한 안전 영역에 있는 것으로 봅니다.

// 입력 형식 :
// 첫 번째 줄에는 N과 M이 공백을 사이에 두고 주어지고,
// 두 번째 줄부터는 N개의 줄에 걸쳐 각 행에 위치한 M개의 마을의 높이 정보가 공백을 사이에 두고 주어집니다.
// 1≤N,M≤50
// 1≤ 각 집의 높이 ≤100

// 입력 예시 1:
// 4 5
// 1 2 4 7 5
// 4 2 5 5 2
// 5 7 3 2 6
// 6 7 4 5 1

// 출력 예시 1:
// 4 4

// 입력 예시 2:
// 3 2
// 1 2
// 2 2
// 1 1

// 출력 예시 2:
// 1 1

package GraphSearch_그래프탐색;

import java.util.*;
/*
public class GS06 {
    public static final int MAX = 50; // 최대 격자 크기
    public static final int DIR_NUM = 4; // 남 - 동 - 북 - 서
    public static final int MAX_K = 100; // 집의 최대 높이
    public static int[][] info = new int[MAX][MAX]; // n X m 크기의 집 높이 정보
    public static boolean[][] visited = new boolean[MAX][MAX]; // 방문 기록용 2차원 배열
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};


    public static int n,m; // 주어지는 격자 크기
    public static int height; // 높이

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y){

        if(!checkRange(x,y))
            return false;

        if(info[x][y] <= height || visited[x][y]) // 해당 위치가 높이 이하이거나, 방문한적 있다면
            return false;

        return true;
    }

    public static void initialization(){
        for(int i = 0; i < n; i++)
            for(int j = 0 ; j < m; j++)
                visited[i][j] = false;
    }

    public static void DFS(int x, int y){

        for(int dir = 0; dir < DIR_NUM; dir ++){
            int newX = x + dx[dir];
            int newY = y + dy[dir];

            if(canGo(newX,newY)){
                visited[newX][newY] = true;
                DFS(newX,newY); // 재귀 호출
            }
        }
    }
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt(); // 격자 크기 입력

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                info[i][j] = sc.nextInt();
        // 격자 정보 입력

        int maxCnt = -1; // 안전영역의 최대 갯수
        int minK = 0; // 안전영역이 최대 갯수 일 때, k값

        for(int k = 1; k <= MAX_K; k++){ // 높이가 k 일 때
            height = k; // 높이 설정
            initialization(); // 매 높이 마다 방문 기록용 배열 초기화
            int cnt = 0; // 해당 높이 일때, 안전 영역의 수

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(info[i][j] > k && !visited[i][j]){ // 해당 위치가 높이보다 높으면서 방문한적 없는 경우
                        cnt ++; // 갯수 증가
                        DFS(i,j); // 해당 위치에서 DFS 메소드 호출
                    }
                }
            }
            ////////////////////////////////////////////////////////
            if(cnt > maxCnt){
                maxCnt = cnt;
                minK = k;
            }
        }

        System.out.println(minK+" "+maxCnt); // 안전 역역의 수가 최대가 될때의 k와 안전 영역의 수 출력
    }
}
*/
public class GS06{

    public static final int MAX_N = 50;
    public static final int MAX_M = 50;
    public static final int MAX_H = 100;
    public static final int DIR_NUM = 4;

    public static int[][] vileges = new int[MAX_N][MAX_M]; // 각 집의 높이 정보
    public static boolean[][] visited;
    public static int safeArea = -1; // 최대 안전영역의 수
    public static int height = 0;// 최대 안전영역일때 높이
    public static int n,m;

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    public static boolean canGo(int x, int y, int h){
        return checkRange(x,y) && !visited[x][y] && vileges[x][y] > h;
    }

    public static void backtracking(int x, int y, int h){
        visited[x][y] = true;

        for (int d = 0; d < DIR_NUM ; d++) {
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(canGo(nextX,nextY,h)){
                backtracking(nextX,nextY,h);
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                vileges[i][j] = sc.nextInt();
            }
        }

        for (int k = 1; k <= MAX_H ; k++) {

            int cnt = 0; // 높이가 k 일때 안전영역의 수
            visited = new boolean[n][m]; // 높이마다 방문 배열 초기화

            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < m ; j++) {

                    if(vileges[i][j] > k && !visited[i][j]){
                        cnt++; // 안전영역의 수 증가
                        backtracking(i,j,k);
                    }
                }
            }

            if(safeArea < cnt){ // 이전의 안전영역의 수보다 많다면
                safeArea = cnt; // 안전영역의 수 업데이트
                height = k; // 높이 업데이트
            }
        }
        System.out.println(height +" " + safeArea);
    }
}

