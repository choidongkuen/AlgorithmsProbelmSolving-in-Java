// 날짜 : 2022/09/29
// 문제 : 1차원 윷놓이
// 문제 설명 :
// 1번부터 m번까지 번호 순서대로 연결되어 있는 1차원 윷놀이 판에서 게임을 진행해보려고 합니다. m이 6인 경우 윷놀이 판의 모습은 다음과 같습니다.
// 처음에는 k개의 말이 1번 지점에 놓여있으며, n번의 턴에 숫자가 주어지고 각 턴마다 하나의 말을 선택하여 해당 숫자만큼 앞으로 나아갈 수 있습니다.
// 말은 앞으로 나아갈 때 한 칸 단위로 움직이며, 이때 앞으로 나아가던 말이 숫자 m번에 도달하게 되면 1점을 얻게 됩니다.
// 숫자 m에 도달한 말을 또 선택할 수는 있지만 이 경우에는 아무런 변화가 나타나지 않습니다.

// 입력 형식 :
// 첫 번째 줄에는 턴의 수를 나타내는 n과 윷놀이 판의 상태를 나타내는 m, 그리고 말의 수를 나타내는 k가 각각 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다. 이 숫자들은 각 턴마다 나아갈 수 있는 거리를 의미합니다. (1 ≤ 주어지는 숫자 ≤ 100)
// 1 ≤ n ≤ 12
// 2 ≤ m ≤ 100
// 1 ≤ k ≤ 4

// 입력 예시 01:
// 4 6 3
// 2 4 2 4

// 출력 예시 01:
// 2

// 입력 예시 02:
// 6 10 3
// 5 3 2 2 3 3

// 출력 예시 02:
// 2

package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BT08 {
    public static final int MAX_N = 12; // 턴의 최대 수
    public static final int MAX_K = 4; // 최대 말의 수

    public static int n,k,m;
    public static int ans = 0; // 최대 얻을 수 있는 점수
    public static int[] canGo = new int[MAX_N + 1]; // n턴에 갈 수 있는 칸 수를 원소로 갖는 1차원 배열
    public static int[] yuts = new int[MAX_K + 1]; // 각 말의 위치를 원소로 갖는 1차원 배열

    public static int cal(){
        int point = 0;
        for (int i = 1; i <= k ; i++) {
            if(yuts[i] >= m) // i칸의 말이 m 위치 이상인 경우
                point ++;
        }
        return point;
    }


    public static void backtracking(int currNum){ // n번 턴중 currNum 번째 처리
        ans = Math.max(ans,cal());

        if(currNum == n + 1){
            ans = Math.max(ans,cal());
            return;
        }
        // 모든 턴의 갈 수 있는 거리를 모든 k개의 돌에게 적용해보기
        for (int i = 1; i <= k ; i++) {
            yuts[i] += canGo[currNum];
            backtracking(currNum + 1);
            yuts[i] -= canGo[currNum];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 주어지는 턴의 수
        m = sc.nextInt(); // 윷판의 크기
        k = sc.nextInt(); // 말의 갯수

        for (int i = 1; i <= k ; i++) {
            yuts[i] = 1;
        }

        for (int i = 1; i <= n ; i++) {
            canGo[i] = sc.nextInt();
        } // 턴마다 갈 수 있는 칸의 크기 입력

        backtracking(1);
        System.out.println(ans);
    }
}
