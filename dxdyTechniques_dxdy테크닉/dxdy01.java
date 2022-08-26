// 문제 : 방향에 맞춰 이동
// 날짜 : 2022/08/21
// 문제 설명 : (0, 0)에서 시작하여 총 N번 움직여보려고 합니다.
// N번에 걸쳐 움직이려는 방향과 움직일 거리가 주어졌을 때, 최종 위치를 출력하는 프로그램을 작성해보세요.
// 단, dx, dy 테크닉을 활용하여 문제를 해결해주세요.

// 입력 형식
// 첫 번째 줄에 정수 N이 주어집니다.
//두 번째 줄부터는 N개의 줄에 걸쳐 각 줄마다 이동방향과 이동한 거리가 공백을 사이에 두고 주어집니다. 방향은 W, S, N, E중에 하나이며 각각 서, 남, 북, 동쪽으로 이동함을 의미합니다.
//1 ≤ N ≤ 100
//1 ≤ 한 번에 움직이는 거리 ≤ 10
// ===============================================================
// 입력 예시
// 4
// N 3
// E 2
// S 1
// E 2
// ===============================================================
// 출력 예시
// 4 2
package dxdyTechniques_dxdy테크닉;
import java.util.Scanner;
public class dxdy01 {

    // 북,동,남,서 순으로 dx, dy를 정의한다.
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0};
    public static int x = 0;
    public static int y = 0; // 초기 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        int n = sc.nextInt();
        // n번 진행
        for(int i = 0 ; i < n; i++){
            // 방향과 거리 입력
            char dir = sc.next().charAt(0);
            int dis = sc.nextInt();

            int direction; // 방향
            if(dir == 'N')
                direction = 0;
            else if(dir == 'E')
                direction = 1;
            else if(dir == 'S')
                direction = 2;
            else
                direction = 3;

            x += dx[direction] * dis;
            y += dy[direction] * dis;
        }
        System.out.println(x+" "+y);
    }
}