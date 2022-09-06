// 날짜 : 2022/09/07
// 문제 : 개발자의 순위
// 문제 설명 :
// K번의 경기에 대해 N명의 개발자의 순위가 주어졌을 때,
// 항상 a번 개발자가 b번 개발자보다 더 높은 순위였던 서로 다른 (a, b) 쌍의 수를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 K와 N이 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터는 K개의 줄에 걸쳐 각 경기에 대한 결과인 N개의 정수값이 공백을 사이에 두고 주어집니다. 이 숫자는 각각의 개발자 번호를 의미하며, 먼저 입력으로 주어진 개발자의 순위가 더 높았음을 의미합니다.
// 한 경기에 대해 1부터 N까지의 숫자가 겹치지 않고 주어짐을 가정해도 좋습니다.
// 1 ≤ K ≤ 10
// 1 ≤ N ≤ 20

// 입력 예시 :
// 3 4
// 4 1 2 3
// 4 1 3 2
// 4 2 1 3

// 출력 예시 :
// 4

package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES30 {
    public static final int MAX_K = 10;
    public static final int MAX_N = 20;

    public static int[][] arr = new int[MAX_K][MAX_N];
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt(); // 대회 횟수
        int n = sc.nextInt(); // 개발자 수

        for(int i = 0; i < k; i ++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        // 경기 결과 기록

        int ans = 0; // 불변의 순위를 가지는 순서쌍 갯수
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) continue;

                boolean alwaysWin = true; // i vs j


                for(int s = 0; s < k; s ++){ // k번 대회 결과 분석
                    int iInd = 0, jInd = 0;

                    for(int l = 0; l < n; l++){
                        if(arr[s][l] == i)
                            break;
                        iInd++;
                    }

                    for(int l = 0; l < n; l++){
                        if(arr[s][l] == j)
                            break;
                        jInd++;
                    }

                    if(iInd > jInd){
                        alwaysWin = false;
                        break;
                    }
                }
                if(alwaysWin)
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
