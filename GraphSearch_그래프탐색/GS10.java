// 날짜 : 2022/09/16
// 문제 : 갈 수 있는 곳들
// 문제 설명 :
// 숫자 0, 1로만 이루어진 n * n 격자가 주어졌을 때, k개의 시작점으로부터 상하좌우 인접한 곳으로만 이동하여 도달 가능한 칸의 수를 구하는 프로그램을 작성해보세요.
// 숫자 0은 해당 칸이 이동할 수 있는 곳임을, 숫자 1은 해당 칸이 이동할 수 없는 곳임을 의미합니다.

// 입력 형식 :
// 첫 번째 줄에는 격자의 크기를 나타내는 n과 시작점의 수를 나타내는 k 값이 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 행에 해당하는 n개의 숫자가 순서대로 공백을 사이에 두고 주어집니다.
// 그 다음 줄 부터는 k개의 줄에 걸쳐 각 시작점의 위치 (r, c)가 공백을 사이에 두고 주어집니다. (r, c)는 r행 c열 위치가 시작점 중 하나임을 의미합니다. 모든 시작점의 위치에 적혀있는 숫자는 0이고,
// 시작점끼리 서로 겹치지 않게 주어진다고 가정해도 좋습니다. (1 ≤ r ≤ n, 1 ≤ c ≤ n)
// 1 ≤ n ≤ 100
// 1 ≤ k ≤ n * n

// 입력 예시 1 :
// 3 2
// 0 0 0
// 0 0 1
// 1 0 0
// 1 1
// 1 2

// 출력 예시 1 :
// 7

// 입력 예시 2 :
// 4 2
// 0 1 0 0
// 0 1 0 0
// 0 1 1 1
// 0 1 0 0
// 1 4
// 4 4

// 출력 예시 2 :
// 6

package GraphSearch_그래프탐색;
import java.util.*;

class Coordinate{
    int x,y;

    Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
} // 좌표 클래스

public class GS10 {
    public static final int MAX_N = 100; // 격자의 최대 크기
    public static int[][] info = new int[MAX_N][MAX_N]; // 정보를 기록할 2차원 배열
    public static boolean[][] visited = new boolean[MAX_N][MAX_N]; // 방문 기록용 2차원 배열
    public static Queue<Coordinate> q; // BFS를 위한 큐 선언
    public static int n,k;

    public static final int DIR_NUM = 4; // 4 방향
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static int ans = 0; // 도달 가능한 칸 수

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){
        if(!checkRange(x,y) || info[x][y] == 1 || visited[x][y])
            return false; // 격자를 벗어난 경우 or 이동할 수 없는 칸이거나 or 방문한 적 있는 칸이거나

        return true;
    }


    public static void BFS(){
        while(!q.isEmpty()){
            Coordinate currV = q.poll(); // pop

            int x = currV.x;
            int y = currV.y;

            for(int i = 0; i < DIR_NUM; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i]; // 다음 위치

                if(canGo(nextX,nextY)){
                    ans ++;
                    visited[nextX][nextY] = true; // 방문 기록
                    q.add(new Coordinate(nextX,nextY));
                }
            }
        }
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n 입력
        k = sc.nextInt(); // k 입력

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                info[i][j] = sc.nextInt(); // 배열 정보 입력 받음

        for(int i = 0; i < k; i++){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            q = new LinkedList<>(); // k마다 큐 선언
            if(!visited[x][y]){ // 방문한 적이 없을때
                visited[x][y] = true; // 방문 기록
                ans++; // 해당 칸 도달 = +1
                q.add(new Coordinate(x,y)); // push
                BFS(); // BFS 메소드 호출
            }
        }
        System.out.println(ans); // 결과 출력
    }
}