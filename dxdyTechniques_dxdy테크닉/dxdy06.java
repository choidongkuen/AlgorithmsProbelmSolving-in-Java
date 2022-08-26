// 문제 : 되돌아오기 2
// 날짜 : 2022/08/21
// 문제 설명 : 좌표평면 위 (0, 0)에서 북쪽을 향한 상태에서 움직이는 것을 시작하려 합니다.
// N개의 명령에 따라 총 N번 움직이며, 명령 L이 주어지면 왼쪽으로 90도 방향 전환을, 명령 R이 주어지면 오른쪽으로 90도 방향전환을 하고,
// 명령 F가 주어지면 바라보고 있는 방향으로 한칸 이동하려고 합니다. 1초에 한 칸씩 움직이며, 회전에도 1초의 시간이 걸린다 했을 때,
// 몇 초 뒤에 처음으로 다시 (0, 0)에 돌아오게 되는지를 판단하는 프로그램을 작성해보세요.

// 입력 형식
// 첫 번째 줄에 문자 ‘L', ‘R', 그리고 'F’로만 이루어진 문자열이 하나 주어집니다.
// 단, 첫 번째 문자는 항상 'F'로 주어짐을 가정해도 좋습니다.
// 1 ≤ 명령의 길이 ≤ 100,000

// ===============================================================
// 입력 예제
// FFFRFFRFFFRFFFFFF
// ===============================================================
// 출력 예제
// 13
package dxdyTechniques_dxdy테크닉;
import java.util.*;

public class dxdy06 {
    public static int x = 0, y = 0; // 초기 위치
    public static int dirNum = 0; // 초기 북쪽
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1}; // 북 - 동 - 남 - 서
    public static char c; // 각 명령어
    public static int elpasedTime = 0; // (0,0)까지의 경과 시간

    public static boolean simulation(){
        if(c == 'L'){
            dirNum = (dirNum - 1 + 4) % 4;
        }
        else if(c == 'R'){
            dirNum = (dirNum + 1) % 4;
        }
        else{
            x += dx[dirNum];
            y += dy[dirNum];
        } // F인 경우
        elpasedTime++; // 회전 및 이동에 따른 시간 증가

        if(x == 0 && y == 0){
            System.out.println(elpasedTime);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String command = sc.next(); // n개의 명령어
        boolean comeBack = false;
        for(int i = 0; i < command.length(); i++){
            c = command.charAt(i); // 각 명령어
            if(simulation()){ // 함수 호출
                comeBack = true;
                System.exit(0); // 종료
            }
        }
        if(!comeBack)
            System.out.println(-1);
    }
}