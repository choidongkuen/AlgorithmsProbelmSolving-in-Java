// 문제 : 격자 위의 편안한 상태
// 날짜 : 2022/08/25
// 문제 설명 :
// N * N 크기의 격자 위에 총 M번에 걸쳐 색칠을 진행합니다.
// 한 번에 한 칸만 색칠하며, 색칠을 한 직후 해당 칸이 '편안한 상태'에 놓여 있는지를 확인하려 합니다.
// ‘편안한 상태’란 방금 막 칠해진 칸을 기점으로 위 아래 양옆으로 인접한 4개의 칸 중 격자를 벗어나지 않는 칸에 색칠되어 있는 칸이 정확히 3개인 경우를 뜻합니다.
// 색칠할 칸이 주어질 때마다 해당 칸을 칠한 직후 막 칠한 칸이 편안한 상태에 있는지를 계속 알아내는 프로그램을 작성해보세요.

// 입력 예시 :
// 4 8
// 1 2
// 2 1
// 2 3
// 2 2
// 3 3
// 4 2
// 3 2
// 4 3

// 출력 예시 :
// 0
// 0
// 0
// 1
// 0
// 0
// 1
// 0

package dxdyTechniques_dxdy테크닉;
import java.util.*;

public class dxdy07 {
    public static final int MAX_N = 100; // n의 최대 값
    public static final int Alldire = 4; // 0 - 3
    public static int n,m; // nxn & m번 색칠
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1}; // 동서남북을 확인해야 함 -> dxdy 테크닉 사용하자
    public static int[][] arr = new int[MAX_N][MAX_N]; // 2차원 배열

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    } // 범위 체크하는 메서드

    public static int comfortableState(int x, int y){
        int cnt = 0; // 편안한 상태 개수
        for(int i = 0; i < Alldire; i++){ // 동서남북 확인
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(checkRange(nx,ny) && arr[nx][ny] == 1) // 조건 체크
                cnt++; // 편안한 상태 +1
        }
        return cnt;
    } // 편안한 상태 개수 구하는 메서드

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++){ // m개의 질의

            int row = sc.nextInt();
            int col = sc.nextInt(); // 주어지는 칸의 행,열
            arr[--row][--col] = 1; // 해당 칸 색칠

            int result = (comfortableState(row,col) == 3)? 1:0;
            System.out.println(result); // 출력
        }
    }
}