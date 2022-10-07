// 날짜 : 2022/10/07
// 문제 : 2차원 최대 증가 수열
// 문제 설명 :
// n * m 크기인 직사각형의 각 칸에 수들이 하나씩 적혀있습니다. 왼쪽 상단 (1, 1)에서 출발한다고 헀을 때 특정 룰을 만족하면서 밟을 수 있는 칸의 최대 수를 구하는 프로그램을 작성해보세요.
// 아래는 특정 룰에 대한 설명입니다.
// - 룰 -
// 이동은 항상 점프를 통해서만 가능합니다. 또, 점프 진행시 항상 현재 위치에 적혀있는 수보다, 점프한 이후의 칸에 적혀있는 수가 더 커야만 합니다.
// 점프 진행시 현재 위치에서 "적어도 한칸 이상 오른쪽에 있는 위치이며 동시에 현재 위치에서 적어도 한칸 이상 아래쪽에 있는 위치"인 곳으로만 점프가 가능합니다.

// 입력 형식 :
// 첫 번째 줄에 n, m이 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터 n개의 줄에 걸쳐 각 행에 대한 m개의 수가 공백을 사이에 두고 주어집니다.
// 3 ≤ n, m ≤ 50
// 1 ≤ 주어지는 수 ≤ 10,000

// 입력 예시 01 :
// 4 4
// 1 1 1 1
// 1 1 1 3
// 1 4 5 2
// 1 1 2 5

// 출력 예시 01 :
// 3

// 입력 예시 02 :
// 5 5
// 1 2 3 4 5
// 5 4 3 2 1
// 1 2 3 4 5
// 5 4 3 2 1
// 1 2 3 4 3

// 출력 예시 02 :
// 4

// 아이디어 :
// dp[i][j] = (1,1) 에서 부터 시작해 해당 i,j 위치까지 밞을 수 있는 최대 칸의 수
// 오른쪽,아래쪽을 동시에 한 칸 이상 이동해야한다. (문제 잘 읽자...)


package DynamicProgramming01_동적계획법01;
import java.util.Arrays;
import java.util.Scanner;

public class DP16 {
    public static final int MAX = 50;
    public static int[][] dp;
    public static int[][] grid = new int[MAX + 1][MAX + 1];
    public static int n,m;

    public static int solution(){
        dp[1][1] = 1; // 시작 위치 : 밞을 수 있는 칸의 수는 1칸이다.

        // 1행,1열 설정(아래 or 오른쪽)

        // 1 열(오른쪽으로만 이동 가능)

        for (int i = 2; i <= n ; i++) {
            for (int j = 2; j <= m ; j++) {

                for (int k = 1; k < i ; k++) {
                    for (int l = 1; l < j; l++) {

                        if(dp[k][l] == Integer.MAX_VALUE)
                            continue;
                        if (grid[i][j] > grid[k][l]) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
                        }
                    }
                }

            }
        }
        int ans = 0;

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m ; j++) {
                ans = Math.max(ans,dp[i][j]);
            }
        }

        return ans;

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 행의 크기
        m = sc.nextInt(); // 열의 크기

        dp = new int[n + 1][m + 1];

        for(int[] subDp : dp)
            Arrays.fill(subDp,Integer.MIN_VALUE);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution());
//        System.out.println(Arrays.deepToString(dp));
    }
}
