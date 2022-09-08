// 날짜 : 2022/09/08
// 문제 : 3개의 선 2
// 문제 설명 :
// 좌표평면 위에 서로 다른 N개의 점이 주어졌을 때,
// x축 혹은 y축에 평행한 직선 3개로 주어진 모든 점들을 전부 지나게 할 수 있는지를 판단하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 좌표의 개수 N이 주어집니다.
// 두 번째 줄부터는 N개의 줄에 걸쳐 각 줄마다 좌표의 x와 y값이 공백을 사이에두고 N번만큼 주어집니다.
// 1 ≤ N ≤ 20
// 0 ≤ x, y ≤ 10

// 입력 예시 :
// 6
// 1 7
// 0 0
// 1 2
// 2 0
// 1 4
// 3 4

// 출력 예시 :
// 1

package ExhaustiveSearch02_완전탐색02;
import java.util.Scanner;

public class ES13 {
    public static final int MAX_X = 10;
    public static final int MAX_N = 20;

    public static int n;
    public static int[] x = new int[MAX_N];
    public static int[] y = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int ans = 0;

        // 모든 직선에 대해 전부 시도해 봅니다.
        for(int i = 0; i <= MAX_X; i++)
            for(int j = 0; j <= MAX_X; j++)
                for(int k = 0; k <= MAX_X; k++) {
                    // success : 직선 3개로 모든 점을 지나게 할 수 있으면 true
                    boolean success = true;
                    // x축에 평행한 직선 3개로
                    // 모든 점을 지나게 할 수 있는 경우
                    for(int l = 0; l < n; l++) {
                        // 해당 점이 직선에 닿으면 넘어갑니다
                        if(x[l] == i || x[l] == j || x[l] == k)
                            continue;

                        success = false;
                    }
                    if(success)
                        ans = 1;

                    // x축에 평행한 직선 2개와 y축에 평행한 직선 1개로
                    // 모든 점을 지나게 할 수 있는 경우
                    success = true;
                    for(int l = 0; l < n; l++) {
                        // 해당 점이 직선에 닿으면 넘어갑니다
                        if(x[l] == i || x[l] == j || y[l] == k)
                            continue;

                        success = false;
                    }
                    if(success)
                        ans = 1;

                    // x축에 평행한 직선 1개와 y축에 평행한 직선 2개로
                    // 모든 점을 지나게 할 수 있는 경우
                    success = true;
                    for(int l = 0; l < n; l++) {
                        // 해당 점이 직선에 닿으면 넘어갑니다
                        if(x[l] == i || y[l] == j || y[l] == k)
                            continue;

                        success = false;
                    }
                    if(success)
                        ans = 1;

                    // y축에 평행한 직선 3개로
                    // 모든 점을 지나게 할 수 있는 경우
                    success = true;
                    for(int l = 0; l < n; l++) {
                        // 해당 점이 직선에 닿으면 넘어갑니다
                        if(y[l] == i || y[l] == j || y[l] == k)
                            continue;

                        success = false;
                    }
                    if(success)
                        ans = 1;

                }

        System.out.print(ans);
    }
}