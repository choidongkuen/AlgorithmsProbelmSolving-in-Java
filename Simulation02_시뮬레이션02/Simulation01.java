// 날짜 : 2022/09/07
// 문제 : 최고의 1 x 3 위치
// 문제 설명 : N x N 격자에 돈이 있는 곳은 1, 돈이 없는 곳은 0으로 표시되어 있다.
// 1 x 3 격자를 잘 잡아 최대로 얻을 수 있는 금액은 얼만지 구하여라.

// 예시 : n = 5, arr = {{0,0,0,0,0},{0,1,0,0,0},{0,0,1,0,1},{0,0,0,0,0},{0,0,0,1,0}}
// 답 : 2

package Simulation02_시뮬레이션02;
import java.util.Scanner;

public class Simulation01 {
    public static final int MAX_N = 100; // n의 최대값
    public static int[][] arr = new int[MAX_N][MAX_N]; // 동전의 유무 정보가 담긴 2차원 배열 선언

    public static int getCoins(int row,int colS, int colE){ // 특정 1 x 3 구간에 있는 동전의 금액 구하는 메서드
        int numOfCoins = 0;
        for(int col = colS; col <= colE; col ++){
            numOfCoins += arr[row][col];
        }

        return numOfCoins; // 특정 1 x 3 구간에 있는 동전의 금액 반환
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = sc.nextInt(); // 0 or 1
            }
        } // 2차원 배열 완성

        int maxGold = 0; // 최대 금액

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if(j + 2 >= n) // 범위 벗어남으로, 체크 불가
                    continue;

                int numOfCoins = getCoins(i,j,j + 2);
                maxGold = Math.max(maxGold, numOfCoins); // 최대 금액 업데이트
            }
        }
        System.out.println(maxGold); // 출력
    }
}
