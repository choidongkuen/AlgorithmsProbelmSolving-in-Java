// 날짜 : 2022/09/06
// 문제 : 물체 세 개를 정하여 완전탐색
// 문제 설명 : n개의 선분 중, 3개를 제외시켜 최대로 겹치는 선분의 수가 최소가 되도록 하는 프로그램을 작성하시오.
// 예시 : n = 5, arr = [1,3],[2,4],[5,8],[6,9],[7,10]
// 예시 답: 1

package ExhaustiveSearch01_완전탐색01;

import java.util.Scanner;

public class ES23 {
    public static final int MAX_N = 100; // 주어지는 선분의 최대 수
    public static final int MAX_SCOPE = 100; // 좌표에 범위
    public static int[] x = new int[MAX_SCOPE + 1]; // x 좌표
    public static int[] y = new int[MAX_SCOPE + 1]; // y 좌표
    public static int ans = Integer.MAX_VALUE; // 정수의 최대값

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 주어지는 선분의 갯수

        for (int i = 0; i < n ; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            // 선분 기록
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n ; j++) {
                for (int k = j + 1; k < n; k++) { // i,j,k번 째 선분을 제외

                    int[] counting = new int[MAX_SCOPE + 1]; // 1 ~ 100
                    for (int l = 0; l < n ; l++) {
                        if(l == i || l == j || l == k)
                            continue;

                        int start = x[l];
                        int end = y[l]; // 시작점 - 끝점

                        for (int m = start; m <= end ; m++) {
                            counting[m]++;
                        } // 시작점 - 끝점 기록
                    }

                    int maxCnt = 0;
                    for (int l = 0; l <= MAX_SCOPE ; l++) {
                        maxCnt = Math.max(maxCnt, counting[l]);
                    }

                    ans = Math.min(ans, maxCnt);
                }
            }
        }
        System.out.println(ans);
    }
}
