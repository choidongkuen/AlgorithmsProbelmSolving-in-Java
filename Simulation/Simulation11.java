// 문제 : 되돌아오기
// 날짜 : 2022/08/21
// 문제 설명 : (0, 0)에서 시작하여 총 N번 움직여보려고 합니다.
// N번에 걸쳐 움직이려는 방향과 움직일 거리가 주어지고, 1초에 한 칸씩 움직인다고 했을 때,
// 몇 초 뒤에 처음으로 다시 (0, 0)에 돌아오게 되는지를 판단하는 프로그램을 작성해보세요.

// 입력 형식
// 첫 번째 줄에 정수 N이 주어집니다.
//두 번째 줄부터는 N개의 줄에 걸쳐 각 줄마다 이동방향과 이동한 거리가 공백을 사이에 두고 주어집니다.
// 방향은 W, S, N, E중에 하나이며 각각 서, 남, 북, 동쪽으로 이동함을 의미합니다.
//1 ≤ N ≤ 100
//1 ≤ 한 번에 움직이는 거리 ≤ 10

// ===============================================================
// 입력 예시
// 6
// N 3
// E 2
// S 3
// W 4
// S 5
// E 8

// ===============================================================
// 출력 예시
// 10

package Simulation;
import java.util.*;

public class Simulation11 {
    public static int x = 0, y = 0; // 초기 위치
    public static final int ASCII = 128; // 아스키 문자
    public static final int MAX_N = 100; // 최대 N의 갯수
    public static int n,t; // 총 명령 개수와 이동 거리
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static char dir; // 방향 문자
    public static int ans = 0; // 경과한 시간

    public static char[] mapper = new char[ASCII];
    public static boolean simulate(){
        for(int i = 0 ; i < t; i++){ // t초 만큼
            x += dx[mapper[dir]];
            y += dy[mapper[dir]];
            ans ++;
            if(x == 0 && y == 0){
                System.out.println(ans);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        mapper['N'] = 0;
        mapper['E'] = 1;
        mapper['W'] = 3;
        mapper['S'] = 2;

        boolean comeBack = false; // 돌아온지 여부 확인하는 부울 변수

        for(int i = 0; i < n; i++){
            dir = sc.next().charAt(0); // 이동 방향
            t = sc.nextInt(); // 이동 횟수
            boolean result = simulate(); // 함수 호출
            if(result){
                comeBack = true;
                break;
            }
        }
        if(!comeBack)
            System.out.println(-1);
    }
}