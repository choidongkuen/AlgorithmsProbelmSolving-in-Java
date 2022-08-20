// 문제 : 최대로 겹치는 지점
// 날짜 : 2022/08/18
// 설명 : 1차원 직선 상에 n개의 선분이 놓여 있습니다.
// 가장 많이 겹치는 곳에서는, 몇 개의 선분이 겹치는지를 구하는 프로그램을 작성해보세요.
// 단, 끝점에서 닿는 경우에도 겹치는 것으로 봅니다.

// 입력 형식
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄부터는 n개의 줄에 걸쳐 선분의 정보 (x1, x2)가 공백을 사이에 두고 주어집니다.
// 2 ≤ n ≤ 100
// 1 ≤ x1 < x2 ≤ 100

// 입력 예시
// ===============================================================
//3
// 1 5
// 4 6
// 2 4

// 출력 예시
// ===============================================================
// 3

package Simulation;
import java.util.Scanner;

public class Simulation03{
    public static final int MAX_X = 100;
    public static final int MAX_N = 100;

    public static int n;
    public static int[] a = new int[MAX_N + 1];
    public static int[] b = new int[MAX_N + 1];

    public static int[] blocks = new int[MAX_X + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        // 블럭을 특정 구간에 쌓아준다.
        for(int i = 1; i <= n; i++)
            for(int j = a[i]; j <= b[i]; j++)
                blocks[j]++;

        // 최댓값을 구한다.
        int max = 0;
        for(int i = 1; i <= 100; i++)
            if(blocks[i] > max)
                max = blocks[i];

        System.out.print(max);
    }
}
