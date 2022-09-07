// 날짜 : 2022/09/08
// 문제 : 트로미노
// 문제 설명 :
// n * m크기의 이차원 영역의 각 위치에 자연수가 하나씩 적혀있습니다. 이 때 아래의 그림에 주어진 2가지 종류의 블럭 중 한 개를 블럭이 격자를 벗어나지 않도록
// 적당히 올려놓아 블럭이 놓인 칸 안에 적힌 숫자의 합이 최대가 될 때의 결과를 출력하는 프로그램을 작성해보세요.
// 단, 주어진 블럭은 자유롭게 회전하거나 뒤집을 수 있습니다.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어지고, 두 번째 줄부터 (n+1)번째 줄까지는 각 행의 숫자가 공백을 사이에 두고 주어집니다.
// 3 ≤ n, m ≤ 200
// 1 ≤ 자연수 ≤ 1,000

// 입력 예시 :
// 3 3
// 1 2 3
// 3 2 1
// 3 1 1

// 출력 예시 :
// 8

package Simulation02_시뮬레이션02;

import java.util.*;

public class Simulation04{
    public static final int MAX = 200; // n,m의 최대값
    public static int[][] arr = new int[MAX][MAX]; // 2차원 배열
    public static int n,m;
    public static int [][][] givenShapes = { // 주어지는 모양
            // 6가지의 모양을 확인하기 위해서는 공통된 크기의 이차원 배열을 사용해야 쉽게 답을 구할 수 있다.
            {{1,0,0},
                    {1,1,0},
                    {0,0,0}},

            {{0,1,0},
                    {1,1,0},
                    {0,0,0}},

            {{1,1,0},
                    {1,0,0},
                    {0,0,0}},

            {{1,1,0},
                    {0,1,0},
                    {0,0,0}},

            {{1,1,1},
                    {0,0,0},
                    {0,0,0}},

            {{1,0,0},
                    {1,0,0},
                    {1,0,0}}
    };
    // 매 row,col마다 6가지 모양 확인 후, 최대값 구함
    public static int getSum(int row ,int col){
        int maxSum = 0;

        for(int i = 0; i < 6; i++){
            boolean isPossible = true;

            int sum = 0;
            for(int dx = 0; dx < 3; dx ++){
                for(int dy = 0; dy < 3; dy++){

                    if(givenShapes[i][dx][dy] == 0)continue;
                    if(row + dx >= n || col + dy >= m)isPossible = false; // 해당 i번째 모양은 불가
                    else
                        sum += arr[row + dx][col + dy];
                }
            }
            if(isPossible) // 해당 i번째 모양은 가능하다.
                maxSum = Math.max(maxSum, sum); // 최대값 갱신

        }
        return maxSum; // 최대값 반환
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m; j++)
                arr[i][j] = sc.nextInt();
        } // 2차원 배열 완성

        int maxSum = 0;
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){

                int sum = getSum(i,j);
                maxSum = Math.max(maxSum , sum);
            }
        }

        System.out.println(maxSum);
    }
}