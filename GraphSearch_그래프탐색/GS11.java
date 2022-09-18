// 날짜 : 2022/09/18
// 문제 : 갈 수 있는 곳들 DFS ver
// 문제 설명 : GS10과 동일
// 입력 형식 : GS10과 동일


package GraphSearch_그래프탐색;

// DFS.ver
import java.util.*;

public class GS11 {
    public static final int MAX = 100; // 최대 크기
    public static int[][] info = new int[MAX][MAX]; // 정보 배열
    public static boolean[][] visited = new boolean[MAX][MAX]; // 방문 기록용 2차원 배열
    public static int ans = 0;

    public static final int DIR_NUM = 4;
    public static int n,k;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1}; // 상 - 하 - 좌 - 우

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){

        if(!checkRange(x,y)) // 범위 벗어난 경우
            return false;

        if(info[x][y] == 1 || visited[x][y]) // 해당 위치에 뱀이 있거나, 방문한 적 있을 때
            return false;

        return true;
    }


    public static void DFS(int x, int y){

        for(int i = 0 ; i < DIR_NUM; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i]; // 다음 위치

            if(canGo(nextX,nextY)){
                visited[nextX][nextY] = true;
                DFS(nextX,nextY); // 재귀적 호출
            }
        }

    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                info[i][j] = sc.nextInt();

        for(int i = 0; i < k; i++){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1; // 시작 위치

            if(!visited[x][y]){
                visited[x][y] = true; // 방문 기록
                DFS(x,y); // DFS 메소드 호출
            }
        }

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(visited[i][j])
                    ans++;

        System.out.println(ans); // 출력
    }
}