// 날짜 : 2022/09/16
// 문제 : 두 방형 탈출 가능 여부 판별하기
// 문제 설명 :
// n * m 크기의 이차원 영역의 좌측 상단에서 출발하여 우측 하단까지 뱀에게 물리지 않고 탈출하려고 합니다.
// 이동을 할 때에는 반드시 아래와 오른쪽 2방향 중 인접한 칸으로만 이동할 수 있으며, 뱀이 있는 칸으로는 이동을 할 수 없습니다.
// 예를 들어 뱀이 배치 되어 있는 경우 실선과 같은 경로로 탈출을 할 수 있습니다.
// 이 때 뱀에게 물리지 않고 탈출 가능한 경로가 있는지 여부를 판별하는 코드를 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어지고,
// 두 번째 줄부터 (n+1)번째 줄까지는 각 행에 뱀이 없는 경우 1, 뱀이 있는 경우 0이 입력으로 공백을 사이에 두고 주어집니다.
// 시작 칸과 끝 칸에는 뱀이 주어지지 않는다고 가정해도 좋습니다.
// 2 ≤ n, m ≤ 100

// 입력 예시 1 :
// 5 5
// 1 0 1 1 1
// 1 0 1 0 1
// 1 0 1 1 1
// 1 0 1 0 1
// 1 1 1 0 1

// 출력 예시 1 :
// 0

// 입력 예시 2 :
// 5 5
// 1 0 1 1 1
// 1 0 1 0 1
// 1 1 1 0 1
// 1 0 1 1 1
// 0 1 1 0 1

// 출력 예시 2 :
// 1


package GraphSearch_그래프탐색;

import java.util.*;

public class GS04 {
    public static final int MAX = 100; // 행,열의 최대값
    public static int[][] snakes = new int[MAX][MAX]; // 뱀의 정보가 담긴 2차원 배열(있으면 0, 없으면 1)
    public static boolean[][] visit = new boolean[MAX][MAX]; // 방문 기록하는 2차원 배열
    public static int[] dx = {1,0};
    public static int[] dy = {0,1}; // 아래,오른쪽
    public static int n,m; // 주어지는 행과 열

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    } // 범위 체크하는 메소드

    public static boolean canGo(int x, int y){
        if(!checkRange(x,y))
            return false;

        if(snakes[x][y] == 0 || visit[x][y]){
            return false;
        } // 해당 위치에 뱀이 있거나, 이미 방문 했으면

        return true;
    }

    public static void DFS(int x, int y){

        for(int i = 0; i < 2; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(canGo(newX,newY)){
                visit[newX][newY] = true; // 방문 기록
                DFS(newX,newY); // 재귀적 호출
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
                snakes[i][j] = sc.nextInt(); // 2차원 배열 입력

        visit[0][0] = true; // 방문기록
        DFS(0,0); // DFS 시작

        if(visit[n - 1][m - 1])
            System.out.println(1);
        else
            System.out.println(0);
    }
}