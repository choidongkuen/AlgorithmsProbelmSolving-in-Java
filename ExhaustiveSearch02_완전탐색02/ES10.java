// 날짜 : 2022/09/08
// 문제 : 야바위
// 문제 설명 :
// 3개의 종이컵이 안쪽에 무엇이 들었는지 보이지 않도록 뒤집혀 있고, 셋 중 하나에 조약돌을 넣어 놓고 게임을 진행하려 합니다.
// N번에 걸쳐 a번 종이컵과 b번 종이컵을 교환한 뒤, c번 종이컵을 열어 그 안에 조약돌이 있으면 점수를 얻는 행동을 반복한다 할때,
// 처음 조약돌을 어디에 넣어야 가장 높은 점수를 얻을 수 있는지를 계산하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 N이 주어집니다.
// 그 다음 줄 부터는 N개의 줄에 걸쳐 한 줄에 하나씩 a, b, c값이 공백을 사이에 두고 주어집니다.
// 1 ≤ N ≤ 100
// 1 ≤ a, b, c ≤ 3, a ≠ b

// 입력 예시 :
// 3
// 1 2 1
// 3 2 1
// 1 3 1

// 출력 예시 :
// 2

package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES10 {
    public static final int MAX_N = 100; // n의 최대 값
    public static int[][] games = new int[MAX_N][3]; // n번의 게임 기록
    public static int n; // 주어지는 n값

    // a,b 교환하고 c 체크하고~
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n 입력

        for(int i = 0; i < n; i++)
            for(int j = 0; j < 3; j++)
                games[i][j] = sc.nextInt(); // n번 게임 기록

        int ans = 0; // 얻을 수 있는 최대 점수

        for(int i = 1; i < 4; i++){
            // 처음 i번째 컵에 조약돌을 넣을 때

            int score = 0; // i에서 시작할 때, 얻는 점수
            int loc = i; // 조약돌의 위치

            for(int row = 0; row < n; row ++){
                if(games[row][0] == loc) // 1번 컵에 있을 때,
                    loc = games[row][1];
                    // 위치 변화

                else if(games[row][1] == loc)
                    loc = games[row][0];
                // 위치 변화

                if(games[row][2] == loc) score++;
            }
            ans = Math.max(ans,score); // 얻을 수 있는 최대 점수 업데이트
        }

        System.out.println(ans); // 결과 출력

    }
}