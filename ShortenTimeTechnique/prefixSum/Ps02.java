// 2차원 배열에서 누적합
// prefixSum 배열을 만드는 점화식 : prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i][j] O(N^2)
// (x1,y1) ~ (x2,y2) 구간합 : prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1]

// 문제 : 2차원 배열에서의 최대 구간 합

// 문제 설명 :
// 1이상 100이하의 숫자로만 이루어진 n * n 크기의 2차원 격자 상태가 주어졌을 때,
// k * k 크기의 정사각형이 격자를 벗어나지 않게 잡았을 때 정사각형 내 숫자들의 합이 최대가 되도록 하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n과 k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 행에 해당하는 n개의 숫자가 공백을 두고 차례대로 주어집니다.
// 2 ≤ k ≤ n ≤ 500
// 1 ≤ 원소의 크기 ≤ 100

// 입력 예시 01 :
// 3 1
// 1 2 3
// 9 8 8
// 6 8 8

// 출력 예시 01 :
// 9
package ShortenTimeTechnique.prefixSum;

import java.util.Scanner;

public class Ps02 {

    public static final int MAX = 500;

    public static int n,k;
    public static int[][] arr = new int[MAX + 1][MAX + 1];
    public static int[][] s = new int[MAX + 1][MAX + 1];
    // x1 = startRow, y1 = startCol, x2 = endRow, y2 = endCol
    public static int getPartSum(int startRow, int startCol, int endRow, int endCol){

        int result = s[endRow][endCol] - s[startRow - 1][endCol] - s[endRow][startCol - 1] + s[startRow - 1][startCol - 1];
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        // n*n 격자 원소를 입력받음
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // prefixSum  배열의 원소를 채워넣기
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + arr[i][j];
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n - k + 1 ; i++) {
            for (int j = 1; j <= n - k + 1; j++) {
                ans = Math.max(ans,getPartSum(i,j,i+ k -1,j + k - 1));
            }
        }
        System.out.println(ans);
    }

}
