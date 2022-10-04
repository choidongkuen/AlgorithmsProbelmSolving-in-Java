// 문제 : 행렬로 주어진 간선

// 문제 설명 :
// n개의 정점이 존재하는 그래프에서 각 간선의 정보가 행렬로 주어집니다.
// i 행의 j 열에 해당하는 정수가 1이라면, 정점 i에서 정점 j로 가는 간선이 놓여있다는 뜻 입니다.
// 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 정점의 개수 n이 주어집니다.
// 두 번째 줄부터 n개의 줄에 걸쳐 간선의 정보가 행렬로 주어집니다. 각 줄마다 각 행에 해당하는 정보가 공백을 사이에 두고 주어집니다.
// i 행의 j 열에 해당하는 정수가 1이라면, 정점 i에서 정점 j로 가는 간선이 놓여있다는 뜻 이고, 0이라면, 정점 i에서 정점 j로 직접 연결된 간선이 없다는 뜻 입니다.
// 1 ≤ n ≤ 100

// 입력 예시01 :
// 3
// 0 1 0
// 0 0 1
// 1 0 0

// 출력 예시01 :
// 1 1 1
// 1 1 1
// 1 1 1

// 아이디어 :
// i,j 가 연결되어 있는 것을 판단하는 것이 중요
// 즉 모든 정점에 대해 각 정점으로 도달 가능한지 판단하는 것 => 플로이드 워셜 알고리즘( 모든 정점에 대해 각 정점까지로의 최단 거리 )

package ShortestPathWithWeight_최단경로_가중치;

import java.util.Scanner;

public class SPW01 {
    public static final int MAX_N = 100;

    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];
    public static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(i == j)
                    dist[i][j] = 1;
            }
        } // 1차 초기화

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                int x = sc.nextInt();
                if(x == 1)
                    dist[i][j] = 1;
            }
        } // 2차 초기화

        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    if(dist[i][k] == 1 && dist[k][j] == 1)
                        dist[i][j] = 1;
                }
            }
        } // 3차 초기화

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
