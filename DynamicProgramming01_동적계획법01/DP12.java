// 날짜 : 2022/10/06
// 문제 : 정수 사각형 차이의 최소 2
// n×n 크기의 격자 정보가 주어졌을 때, (1, 1)에서 시작하여 오른쪽 혹은 밑으로만 이동하여 (n, n)으로 간다고 했을 때
// 거쳐간 위치에 적혀있는 수들 중 |최댓값-최솟값|을 최소로 만드는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄부터 n개의 줄에 걸쳐 각 행에 해당하는 n개의 정수 값이 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 100
// 1 ≤ 주어지는 숫자 ≤ 100

// 입력 예시 01 :
// 3
// 1 2 3
// 5 4 6
// 7 1 2

// 출력 예시 01 :
// 3


// 입력 예시 02 :
// 4
// 20 30 51 30
// 22 10 12 1
// 10 25 35 21
// 34 36 20 20

// 출력 예시 02 :
// 21

// 아이디어 :
// 해당 문제를 있는 그대로 접근하면 매우 복잡
// 주어지는 숫자의 범위가 최대 100이므로, 모든 가능한 최소값 각각을 가정하고 그 때 해당 최소값보다 큰 최대값의 최소를 구함.
// dp[i][j] = Math.max(Math.min(dp[i - 1][j],dp[i][j - 1]),arr[i][j])
// 해당 지점까지의 최대값의 최소값
// 정해진 최소값으로는 이동 못할 것을 감안해 모든 dp값을 초기에 INT_MAX 값으로 지정


package DynamicProgramming01_동적계획법01;

import java.util.Scanner;

public class DP12 {

    public static final int MAX = 100;
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static int[][] arr = new int[MAX + 1][MAX + 1];
    public static int[][] dp;
    public static int n;
    public static int ans = INT_MAX;

    public static void initialize(){

        dp = new int[MAX + 1][MAX + 1];


        dp[1][1] = arr[1][1];

        // 1 행
        for (int i = 2; i <= n ; i++) {
            dp[1][i] = Math.max(dp[1][i - 1],arr[1][i]);
        }
        // 1 열

        for (int i = 2; i <= n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1],arr[i][1]);
        }

    } // 필요한 자원을 초기화하는 메소드(매 최소값이 설정 될 때마다 호출)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            for (int j = 1;  j <= n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        for (int min = 1; min <= MAX ; min++) {

            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    if(arr[i][j] < min)
                        arr[i][j] = INT_MAX;
                    // 최소값보다 작은 값은 정수의 최대값으로 설정
                }
            }

            initialize();

            for (int row = 2; row <= n ; row++) {
                for (int col = 2; col <= n ; col++) {

                    dp[row][col] = Math.max(Math.min(dp[ row -  1][col], dp[row][col - 1]), arr[row][col]);
                }
            }

            int gap = dp[n][n] - min;
            ans = Math.min(ans, gap);
        }
        System.out.println(ans);

    }
}
