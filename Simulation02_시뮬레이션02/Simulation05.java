// 날짜 : 2022/09/08
// 문제 : 금 채굴하기
// 문제 설명 :
// n×n크기의 이차원 영역에 파묻힌 금을 손해를 보지 않는 선에서 최대한 많이 채굴하려고 합니다. 채굴은 반드시 [그림 1, 2]과 같은 마름모 모양으로 단 한 번 할 수 있으며,
// 마름모 모양을 지키는 한 [그림 3]와 같이 이차원 영역을 벗어난 채굴도 가능하지만 이차원 영역 밖에 금은 존재하지 않습니다.
// 여기서 마름모 모양이란 특정 중심점을 기준으로 K번 이내로 상하좌우의 인접한 곳으로 이동하는 걸 반복했을 때 갈 수 있는 모든 영역이 색칠되어 있는 모양을 의미합니다.
// [그림 1]은 K가 1일때의 마름모 모양이고, [그림 2]는 K가 2일때 마름모 모양입니다. K가 0인 경우는 지점 한 곳에서만
// 채굴하는 것을 의미하며 이 역시 올바른 마름모 모양이라 할 수 있습니다. 올바르지 않은 마름모 모양을 이용해서는 채굴이 불가능합니다.
// 이 때 채굴에 드는 비용은 마름모 안의 격자 갯수만큼 들어가며, 이는 K∗K+(K+1)∗(K+1)로 계산될 수 있습니다. 금 한 개의 가격이 m일 때, 손해를 보지 않으면서 채굴할 수 있는 가장 많은 금의 개수를 출력하는 코드를 작성해보세요.
// 단 한 개의 격자 안에는 최대 한 개의 금만 존재합니다

// k = 1
//    1
//  1 1 1
//    1

// k = 2
//     1
//   1 1 1
// 1 1 1 1 1
//   1 1 1
//     1

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어지고,
// 두 번째 줄부터 (n+1)번째 줄까지는 각 행에 금이 있는 경우 1, 없는 경우 0으로 입력이 공백을 사이에 두고 주어집니다.
// 1≤n≤20
// 1≤m≤10

// 입력 예시 :
// 5 5
// 0 0 0 0 0
// 0 1 0 0 0
// 0 0 1 0 1
// 0 0 0 0 0
// 0 0 0 1 0

// 출력 예시 :
// 3

package Simulation02_시뮬레이션02;
import java.util.*;

public class Simulation05 {
    public static final int MAX_N = 20; // n의 최대값
    public static int[][] arr = new int[MAX_N][MAX_N]; // 금의 정보가 담긴 2차원 배열 선언
    public static int n,m;
    public static int k; // k = (n - 1) * 2

    public static int getGold(int x, int y){
        int maxGold = 0; // 해당 x,y를 중심점으로 했을때, 손해를 보지 않으면서 얻을 수 있는 금의 최대 갯수

        for(int i = 0; i <= k; i++){
            // boolean isPossible = true; // 채굴 비용보다 금으로 인한 이득이 크면 true (maxGold 일 가능성이 존재)
            int golds = 0; // k 마름모로 캤을 경우 얻는 금의 갯수
            int cost = (i * i) + (i + 1) * (i + 1); // 채굴 비용


            for(int s = 0; s < n; s++){
                for(int j = 0; j < n; j++){
                    if(Math.abs(x - s) + Math.abs(y - j) <= i)
                        golds += arr[s][j];
                }
            }

            if(cost <= golds * m) // 손해보지 않는 경우
                maxGold = Math.max(maxGold, golds);
        }
        return maxGold;
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 주어지는 2차원 배열의 크기
        m = sc.nextInt(); // 금의 가치
        k = (n - 1) * 2;


        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt(); // 배열 원소 채우기(0 or 1)


        int maxGold = 0; // 손해보지 않으면서 캘 수 있는 금의 최대 갯수

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                maxGold = Math.max(maxGold, getGold(i,j)); // 최대 갯수 업데이트


        System.out.println(maxGold);
    }
}