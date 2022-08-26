// 문제 : 1이 3개 이상 있는 위치
// 날짜 : 2022/08/21
// 문제 설명 :숫자 0과 1로만 이루어진 n * n 크기의 격자 상태가 주어집니다.
// 각 칸 중 상하좌우로 인접한 칸 중 숫자 1이 적혀 있는 칸의 수가 3개 이상인 곳의 개수를 세는 프로그램을 작성해보세요.
// 단, 인접한 곳이 격자를 벗어나는 경우에는 숫자 1이 적혀있지 않은 것으로 생각합니다.

// 입력 형식
// 첫 번째 줄에 n이 주어집니다.
// 두 번째 줄부터는 n개의 줄에 걸쳐 각 줄마다 각각의 행에 해당하는 n개의 숫자가 공백을 사이에 두고 주어집니다.
// 전부 0과 1로 이루어져 있다고 가정해도 좋습니다.
// 1 ≤ n ≤ 100

// ===============================================================
// 입력 예시
// 4
// 0 1 0 1
// 0 0 1 1
// 0 1 0 1
// 0 0 1 0
// ===============================================================
// 출력 예시
// 4
package dxdyTechniques_dxdy테크닉;
import java.util.*;
// 격자에서의 x,y(x좌표,y좌표)와 행렬에서의 x,y(행,열)은 다르다.
public class dxdy03 {
    public static final int MAX = 100; // nXn의 최대
    public static int[][] arr = new int[MAX][MAX]; // 2차원 배열
    public static int n; // nxn
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1}; // 북 - 동 - 남 - 서

    public static boolean checkRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int adjacent(int x,int y){
        int cnt = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(checkRange(nx,ny) && arr[nx][ny] == 1){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt(); // 입력
            }
        }
        int ans = 0; // 상하좌우의 1이 3개 이상 존재하는 (i,j) 개수

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){ // arr[i][j]
                if(adjacent(i,j) >= 3)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}