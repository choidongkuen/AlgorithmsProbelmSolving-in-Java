// 날짜 : 2022/09/03
// 문제 : 격자 위에서의 가장 좋은 위치
// 문제 설명 :
// N * N 크기의 격자 정보가 주어집니다. 이때 해당 위치에 동전이 있다면 1, 없다면 0이 주어집니다.
// N * N 격자를 벗어나지 않도록 1 * 3 크기의 격자를 적절하게 잘 잡아서 해당 범위 안에 들어있는 동전의 개수를 최대로 하는 프로그램을 작성해보세요

// 입력 형식 :
// 첫 번째 줄에는 격자의 크기를 나타내는 N이 주어집니다.
// 두 번째 줄부터는 N개의 줄에 걸쳐 격자에 대한 정보가 주어집니다. 각 줄에는 각각의 행에 대한 정보가 주어지며,
// 이 정보는 0또는 1로 이루어진 N개의 숫자로 나타내어지며 공백을 사이에 두고 주어집니다.
// 3 ≤ N ≤ 20

// 입력 예제 :
// 3
// 1 0 1
// 0 1 0
// 0 0 0

// 출력 예제 :
// 2

package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES04 {
    public static final int MAX_N = 20; // 행,열의 최대값
    public static int[][] arr = new int[MAX_N][MAX_N]; // 2차원 배열
    public static int ans = 0; // 최대값

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 격자 크기 입력

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        } // 배열 입력

        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n - 2; j++){
                ans = Math.max(ans, arr[i][j] + arr[i][j + 1] + arr[i][j + 2]);
            }
        }
        System.out.println(ans);
    }
}