// 문제 : 빙빙 돌며 숫자 적기
// 날짜 : 2022/08/21
// 문제 설명 :
// n * m 크기의 직사각형에 숫자 1부터 순서대로 증가시키며 달팽이 모양으로 채우는 코드를 작성해보세요.
// 달팽이 모양이란 왼쪽 위 모서리에서 시작해서, 오른쪽, 아래쪽, 왼쪽, 위쪽 순서로 더 이상 채울 곳이 없을 때까지 회전하는 모양을 의미합니다.
// n : 행(row), m : 열(column)을 의미합니다.

// 입력 형식
// n과 m이 공백을 사이에 두고 주어집니다.
//1 ≤ n, m ≤ 100

// ===============================================================
// 입력 예시
// 4 4
// ===============================================================
// 출력 예시
// 1 2 3 4
// 12 13 14 5
// 11 16 15 6
// 10 9 8 7

package dxdyTechniques;
import java.util.*;

public class dxdy04 {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int[][] arr;
    public static int x = 0, y = 0; // 초기 인덱스
    public static int dirNum = 1; // 초기 방향
    public static int n,m;

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        arr[x][y] = 1;
        for(int i = 2; i <= n*m; i++){
            int nx = x + dx[dirNum];
            int ny = y + dy[dirNum]; // for test

            if(!checkRange(nx,ny) || arr[nx][ny] != 0){
                dirNum = (dirNum + 1) % 4;
            } // 범위를 벗어나거나, 이미 원소가 그 자리에 존재하는 경우
            x = x + dx[dirNum];
            y = y + dy[dirNum]; // 다음 인덱스
            arr[x][y] = i;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println(); // 출력
        }
    }
}
