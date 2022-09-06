// 날짜 : 2022/09/07
// 문제 : 최고의 33위치
// 문제 설명 :
// N * N 크기의 격자 정보가 주어집니다. 이때 해당 위치에 동전이 있다면 1, 없다면 0이 주어집니다.
// N * N 격자를 벗어나지 않도록 3 * 3 크기의 격자를 적절하게 잘 잡아서 해당 범위 안에 들어있는 동전의 개수를 최대로 하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 격자의 크기를 나타내는 N이 주어집니다.
// 두 번째 줄부터는 N개의 줄에 걸쳐 격자에 대한 정보가 주어집니다. 각 줄에는 각각의 행에 대한 정보가 주어지며,
// 이 정보는 0또는 1로 이루어진 N개의 숫자로 나타내어지며 공백을 사이에 두고 주어집니다.
// 3 ≤ N ≤ 20

// 입력 예시 :
// 3
// 1 0 1
// 0 1 0
// 0 1 0

// 출력 예시 :
// 6

package Simulation02_시뮬레이션02;

import java.util.*;

public class Simulation02 {
    public static final int MAX_N = 20; // n의 최대값
    public static int[][] arr = new int[MAX_N][MAX_N]; // 동전의 유무 정보가 담긴 2차원 배열
    public static int n; // 실제 주어지는 n 값

    public static int getNumOfCoins(int rowS, int rowE, int colS, int colE){ // 3 x 3 부분에서의 동전의 갯수를 구해주는 메서드

        int numOfCoins = 0;

        for(int row = rowS; row < rowE; row++){
            for(int col = colS; col < colE; col++){
                numOfCoins += arr[row][col];
            }
        }
        return numOfCoins; // 결과 반환
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt(); // 0 or 1 입력
        } // 2차원 배열 입력 완료

        int maxCoins = 0; // 최대 동전의 개수

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(i + 3 > n || j + 3 > n)
                    continue; // 범위 벗어나는 경우

                int numOfCoins = getNumOfCoins(i, i + 3, j, j + 3);

                maxCoins = Math.max(maxCoins, numOfCoins); // 동전의 최대 갯수 업데이트
            }
        }
        System.out.println(maxCoins); // 출력
    }
}