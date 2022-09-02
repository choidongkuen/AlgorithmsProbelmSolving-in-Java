// 날짜 : 2022/09/03
// 문제 : 체크판위에서 2
// 문제 설명 : R * C 크기인 직사각형의 각 칸이 W, B로 표현되어 있습니다. W는 하얀색으로, B는 검은색으로 칸이 채워져 있는것을 뜻합니다.
// 왼쪽 상단에서 출발하여 우측 하단으로 이동할 때, 특정 룰을 만족하면서 이동에 성공할 수 있는 경우의 수를 구하는 프로그램을 작성해보세요. 아래가 특정 룰입니다.
// 이동은 항상 점프를 통해서만 가능합니다. 또, 점프 진행시 항상 현재 위치에 적혀있는 색과, 점프한 이후의 칸에 적혀있는 색이 달라야만 합니다.
// 점프 진행시 현재 위치에서 적어도 한칸 이상 오른쪽에 있는 위치이며 동시에 현재 위치에서 적어도 한칸 이상 아래쪽에 있는 위치인 곳으로만 점프가 가능합니다.
// 정확히 시작, 도착 지점을 제외하고 점프하며 도달한 위치가 정확히 2곳 뿐이어야 합니다.

// 입력 형식 :
// 첫 번째 줄에 R, C가 공백을 사이에 두고 주어집니다. (R은 직사각형의 세로변, C는 가로변을 뜻합니다)
//두 번째 줄부터 R * C크기의 직사각형이 W B로 주어집니다.
//5 ≤ R, C ≤ 15

// 입력 예시 :
// 5 5
// W W W W W
// W W W W W
// W B W W W
// W W W W W
// W W W W B

// 출력 예시 :
// 2
package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES05{
    public static final int MAX = 15;
    public static char[][] checkBoard = new char[MAX][MAX]; // 2차원 배열

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt(); // 행,열 입력

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                checkBoard[i][j] = sc.next().charAt(0);
            }
        }

        int ans = 0;

        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < m - 1; j ++){
                for(int k = i + 1; k < n - 1; k ++){
                    for(int s = j + 1; s < m - 1; s ++){
                        if(checkBoard[0][0] != checkBoard[i][j] &&
                                checkBoard[i][j] != checkBoard[k][s] &&
                                checkBoard[k][s] != checkBoard[n - 1][m - 1])
                            ans ++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}