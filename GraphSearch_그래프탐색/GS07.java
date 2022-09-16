// 날짜 : 2022/09/16
// 문제 : 뿌요뿌요
// 문제 설명 :
// n * n 크기의 격자에 1이상 100이하의 숫자가 각 칸에 하나씩 주어집니다. 이때 상하좌우로 인접한 칸끼리 같은 숫자로 이루어져 있는 경우 하나의 블럭으로 생각하며,
// 블럭을 이루고 있는 칸의 수가 4개 이상인 경우 해당 블럭은 터지게 됩니다.
//초기 상태가 주어졌을 때 터지게 되는 블럭의 수와, 최대 블럭의 크기를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 격자의 크기를 나타내는 n이 주어집니다.
// 두 번째 줄부터는 n개의 줄에 걸쳐 각 행에 해당하는 n개의 숫자가 순서대로 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 100
// 1 ≤ 주어지는 숫자 ≤ 100

// 입력 예시 1:
// 3
// 1 1 1
// 2 1 2
// 1 1 1

// 출력 예시 1:
// 1 7

// 입력 예시 2:
// 3
// 1 2 2
// 1 2 2
// 1 1 1

// 출력 예시 2:
// 2 5

package GraphSearch_그래프탐색;

import java.util.*;
public class GS07 {

    public static final int MAX_N = 100; // 격자의 최대 크기
    public static final int DIR_NUM = 4; // 4방향
    public static final int BOMB = 4; // 터지는 기준
    public static int[][] info = new int[MAX_N][MAX_N]; // 정보를 담고 있는 2차원 배열
    public static boolean[][] visited = new boolean[MAX_N][MAX_N]; // 방문 기록을 저장하는 2차원 배열
    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {1,0,-1,0}; // 동 - 북 - 서 - 남

    public static int n; // 주어지는 격자 크기
    public static int val;
    // public static int currBlockNum;

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    } // 범위를 체크하는 메소드

    public static boolean canGo(int x, int y){
        if(!checkRange(x,y))
            return false;

        if(info[x][y] != val || visited[x][y])
            return false;

        return true;
    } // 해당 방향으로 갈 수 있는지 체크하는 메소드

    public static int DFS(int x, int y){
        int cnt = 1;
        for(int d = 0; d < DIR_NUM; d++){
            int newX = x + dx[d];
            int newY = y + dy[d]; // 다음 위치

            if(canGo(newX,newY)){
                visited[newX][newY] = true; // 방문 기록
                cnt += DFS(newX,newY);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 격자 크기 입력

        for(int i = 0; i < n; i ++)
            for(int j = 0; j < n; j ++)
                info[i][j] = sc.nextInt();

        int maxSize = 1; // 최대 블럭의 크기
        int blockCnt = 0; // 터지는 블럭의 수

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(!visited[i][j]){
                    visited[i][j] = true; // 방문 기록
                    val = info[i][j]; // 해당 격자의 값

                    int size = DFS(i,j); // 방문한적 없을때, DFS 메소드 호출
                    maxSize = Math.max(maxSize,size);

                    if(size >= BOMB)
                        blockCnt ++; // 격자의 크기가 4이상이면
                }

        System.out.println(blockCnt + " " + maxSize); // 터지는 블록의 수와 최대 블록의 크기 출력
    }
}