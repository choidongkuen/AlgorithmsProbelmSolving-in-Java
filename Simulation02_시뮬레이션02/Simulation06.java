// 날짜 : 2022/09/08
// 문제 : 기울어진 직사각형
// 문제 설명 :
// 1이상 100이하의 숫자로만 이루어져 있는 n * n 크기의 격자 정보가 주어집니다.
// 이때, 이 격자 내에 있는 기울어진 직사각형들을 살펴보려고 합니다.
// 기울어진 직사각형이란, 격자내에 있는 한 지점으로부터 체스의 비숍처럼 대각선으로 움직이며 반시계 순회를 했을 때 지나왔던 지점들의 집합을 일컫습니다.
// 이 때 반드시 아래에서 시작해서 1, 2, 3, 4번 방향순으로 순회해야하며 각 방향으로 최소 1번은 움직여야 합니다. 또한, 이동하는 도중 격자 밖으로 넘어가서는 안됩니다.
// 1 (북동쪽) , 2(북서쪽) , 3(남서쪽) , 4(남동쪽)

// 가능한 기울어진 직사각형들 중 해당 직사각형을 이루는 지점에 적힌 숫자들의 합이 최대가 되도록 하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 격자의 크기를 나타내는 n이 주어집니다.
// 두 번째 줄부터는 n개의 줄에 걸쳐 격자에 대한 정보가 주어집니다. 각 줄에는 각각의 행에 대한 정보가 주어지며,
// 이 정보는 1이상 100이하의 숫자로 각각 공백을 사이에 두고 주어집니다.
// 3 ≤ n ≤ 20

// 입력 예시 :
// 5
// 1 2 2 2 2
// 1 3 4 4 4
// 1 2 3 3 3
// 1 2 3 3 3
// 1 2 3 3 3

// 출력 예시 :
// 21

// 입력 예시 :
// 3
// 1 2 3
// 4 5 6
// 7 8 8

// 출력 예시 :
// 20

package Simulation02_시뮬레이션02;

import java.util.*;

public class Simulation06 {
    public static final int MAX_N = 20; // 격자의 최대 크기
    public static final int DireNum = 4; // 4방향
    public static int[][] arr = new int[MAX_N][MAX_N]; // 주어지는 2차원 배열
    public static int n; // 주어지는 격자 크기
    public static int[] dx = {-1,-1,1,1};
    public static int[] dy = {1,-1,-1,1};

    public static boolean checkRange(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < n;
    }
    /*
    public static int getSum(int row, int col){
        int sum = arr[row][col]; // 시작점

        boolean isPossible = true; // 4방향 이동 가능하면 true, 아니면 false
        for(int i = 0; i < 4; i++){
            boolean canGo = true; // 특정 방향으로 한칸이라도 이동 가능하면 true, 아니면 false

            int cnt = 0; // 해당 i 방향으로 몇번 이동했는지

            while(canGo){
                int nRow = row + dx[i];
                int nCol = col + dy[i]; // 이동

                if(!checkRange(nRow,nCol)){
                    canGo = false;
                }else{
                    row = nRow;
                    col = nCol;

                    sum += arr[row][col];
                    cnt ++;
                }
            }
            if(cnt == 0){
                isPossible = false;
                break;
            }
        }
        if(isPossible)
            return sum;
        else
            return 0;
    }
    */
    public static int getSum(int x, int y, int k, int s){

        int partSum = 0;
        int[] info = {k,s,k,s}; // 1 - 3(높이) && 2 - 4(너비)

        for(int d = 0; d < DireNum; d++){
            // info[i] 번 이동하며, 각 이동할 때마다, 범위 벗어났는지 체크
            // 범위 벗어나면 0 리턴 벗어나지 않으면 sum 업데이트
            for(int q = 0; q < info[d]; q++){
                x = x + dx[d]; y = y + dy[d];

                if(!checkRange(x,y))
                    return 0; // 격자를 벗어남으로 의미 x

                partSum += arr[x][y]; // sum 업데이트
            }
        }
        return partSum; // 범위 벗어나지 않은 상태에서 sum 구함
    }
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        } // 2차원 배열 원소 입력 받음

        int maxSum = 0; // 적힌 숫자들의 최대 합

        for(int i = 0; i < n; i++){ // 행
            for(int j = 0; j < n; j++){ // 열
                for(int k = 1; k < n; k++){ // 높이이 크기
                    for(int s = 1; s < n; s++){ // 너비의 크기

                        int sum = getSum(i,j,k,s);
                        maxSum = Math.max(maxSum, sum); // 최대값 업데이트
                    }
                }
            }
        }

        System.out.println(maxSum); // 최대합 출력
    }
}