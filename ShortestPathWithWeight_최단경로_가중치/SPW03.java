// 날짜 : 2022/10/04
// 문제 : 이동 가능한 점들의 쌍

// 문제 설명 :
// 1부터 N까지 번호가 붙은 N개의 서로 다른 점들과 이 점들 중 임의의 두 점을 잇는 M개의 길이 있습니다.
// N개의 점 중 1번부터 P번까지의 점은 빨간점입니다. 모든 길은 한 방향으로만 이동할 수 있으며, 특정 두 점을 잇고 특정 방향으로 이동 가능한 길은 최대 1개만 존재합니다.
// M개의 길들을 이용해 주어진 점A으로부터 점B까지 최소 비용으로 이동하려고 합니다. 이때, 출발점과 도착점을 포함해 이동 경로 내에 적어도 하나 이상의 빨간점이 포함되어 있어야 합니다.
// 또한 한 개의 점을 여러 번 방문해도 괜찮고, 각 길을 통해 이동할 때 드는 비용은 상이하며 이 비용 값은 주어집니다. 주어진 출발점과 도착점들 쌍 P개 중 빨간색 점을 최소 하나 이상 지나 갈 수 있는 경우가 몇 개인지를 구하고,
// 가능한 경우에 대해 각 최소 비용의 총 합을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 N, M, P, Q가 공백을 사이에 두고 차례대로 주어집니다.
// 두 번째 줄부터 M개의 줄에 걸쳐 각 줄에 길의 출발점 번호, 길의 도착점 번호, 길을 가는데 필요한 비용이 공백을 사이에 두고 차례대로 주어집니다.
// M+2번째 줄부터 Q개의 줄에 걸쳐 각 줄에 출발점과 도착점의 번호가 공백을 사이에 두고 차례대로 주어집니다.
// 1 ≤ N ≤ 200
// 1 ≤ M ≤ 10,000
// 1 ≤ P ≤ 100, P ≤ N
// 1 ≤ Q ≤ 10,000

// 입력 예시 01:
// 3 3 1 3
// 3 1 10
// 1 3 10
// 1 2 7
// 3 2
// 2 3
// 1 2

// 입력 예시 02:
// 2
// 24
package ShortestPathWithWeight_최단경로_가중치;


import java.util.Scanner;

public class SPW03 {
    public static final int MAX_N = 200;

    public static int n,m,p,q;
    public s
    tatic long minCost
            , cnt;
    // 1 ~ p 점은 빨간 점
    // q는 질의 개수
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];
    public static Scanner sc = new Scanner(System.in);


    public static void floydWarshall(){

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

        for(int k = 1; k <= n; k ++){
            for(int i = 1; i <= n; i ++){
                for(int j = 1; j <= n; j++){
                    dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        } // 플로이드 워셜 알고리즘을 통해 모든 정점에 대한 각 정점까지의 최단 거리를 구함
    }

    public static void main(String[] args) {

        n = sc.nextInt();
        m = sc.nextInt();
        p = sc.nextInt();
        q = sc.nextInt();

        floydWarshall();

        while(q -- > 0) { // q개의 질의

            int start = sc.nextInt();
            int end = sc.nextInt();

            // start - end 사이에 p점이 여러개 더라도
            // 최소 비용으로 이동해야 한다.
            int distance = (int)1e9;

            for (int point = 1; point <=  p; point++) {
                distance = Math.min(distance,dist[start][point] + dist[point][end]);
            }
            if(distance  >= (int)1e9)
                continue; // 중간에 빨간점 존재 x
            cnt ++;
            minCost += distance;

        }

        System.out.println(cnt);
        System.out.println(minCost);

    }
}
