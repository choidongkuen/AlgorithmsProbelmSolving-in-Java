// 날짜 : 2022/10/04
// 문제 : 최단 왕복

// 문제 설명 :
// n개의 정점과 m개의 간선에 대한 정보로, 간선의 양 끝 정점과 해당 간선에 주어진 가중치가 주어질 때,
// 임의의 서로 다른 두 정점 사이를 왕복하는데 드는 비용이 가장 낮은 경우를 하는 프로그램을 작성해보세요.
// 이때, 주어진 n개의 정점과 m개의 간선으로 만들어지는 그래프는 방향그래프가 됩니다.

// 입력 형식 :
// 첫 번째 줄에 정점의 개수 n, 간선의 개수 m 이 공백을 두고 주어집니다.
// 두 번째 줄부터 m개의 줄에 걸쳐 각 간선을 연결하는 두 정점의 번호, 해당 간선에 주어진 가중치가 공백을 사이에 두고 주어집니다.
// 동일한 간선은 여러 번 주어지지 않는다고 가정해도 좋습니다.
// 1 ≤ n ≤ 100
// 1 ≤ m ≤ n * (n-1)
// 1 ≤ 간선의 길이 ≤ 10,000

// 입력 예시 01 :
// 3 4
// 1 2 1
// 3 2 1
// 1 3 5
// 2 3 2

// 출력 예시 01 :
// 3

package ShortestPathWithWeight_최단경로_가중치;

import java.util.Scanner;

public class SPW06 {

    public static final int MAX_N = 100;

    public static int n,m;
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];

    public static void floydWarShall(Scanner sc){

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(i != j)
                    dist[i][j] = (int)1e9;
            }
        }

        while(m -- > 0){

            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            dist[from][to] = cost;
        }

        for(int k = 1; k <= n; k ++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        floydWarShall(sc);
        int ans = (int)1e9;

        for (int i = 1; i <= n ; i++) {
            for (int j = i; j <= n ; j++) {
                if(i == j)
                    continue;
                ans = Math.min(ans,dist[i][j] + dist[j][i]);
            }
        }
        System.out.println(ans);
    }
}
