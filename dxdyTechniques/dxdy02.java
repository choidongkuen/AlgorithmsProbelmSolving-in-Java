// 문제 : 문자에 따른 명령 2
// 날짜 : 2022/08/21
// 문제 설명 : 좌표평면 위 (0, 0)에서 북쪽을 향한 상태에서 움직이는 것을 시작하려 합니다. N개의 명령에 따라 총 N번 움직이며,
// 명령 L이 주어지면 왼쪽으로 90도 방향 전환을, 명령 R이 주어지면 오른쪽으로 90도 방향전환을 하고,
// 명령 F가 주어지면 바라보고 있는 방향으로 한칸 이동하려고 합니다. 이동 이후 최종 위치를 출력하는 프로그램을 작성해보세요.
// 입력 형식

// 첫 번째 줄에 문자 ‘L', ‘R', 그리고 'F’로만 이루어진 문자열이 하나 주어집니다.
//1 ≤ 명령의 길이 ≤ 100,000

// ===============================================================
// 입력 예시
// LF
// ===============================================================
// 출력 예시
// -1 0
package dxdyTechniques;
import java.util.*;

public class dxdy02 {
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {1,0,-1,0}; // 북 - 동 - 남 - 서
    public static int x = 0,y = 0;
    public static int dirNum = 0; // 북쪽에서 시작

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String command = sc.next(); // 문자열 명령 주어진다.

        for(int i = 0; i < command.length(); i++){
            if(command.charAt(i) == 'L'){
                dirNum = (dirNum - 1 + 4) % 4;
            }

            else if(command.charAt(i) == 'R'){
                dirNum = (dirNum + 1) % 4;
            }

            else{
                x += dx[dirNum];
                y += dy[dirNum];
            } // F명령어 일때 보고있는 방향으로 한칸 이동
        }
        System.out.println(x+" "+y);
    }
}
