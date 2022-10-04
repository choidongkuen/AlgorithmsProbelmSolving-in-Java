// 날짜 : 2022/10/04
// 문제 : 저렴한 모임

// 문제 설명 :
// 두 사람 A, B는 n개의 정점과 m개의 간선으로 이루어져 있는 양방향 그래프에서 살고 있습니다. 사람 A는 정점 v1 사람 B는 정점 v2
// 에서 출발하여 정점 e로 이동하려고 합니다. 이동 방법은 택시를 이용하는 것이며, 각 간선마다 택시 이용시 추가로 부가되는 비용이 정해져 있습니다.
// 단, 사람 A와 사람 B가 원한다면 도중에 특정 지점에서 만나서 동일한 택시를 타고 함께 이동하는 것이 가능합니다. 동일한 거리를 여러 번 지나는 것 역시 가능하며 이때는 추가적으로 비용이 부과된다 했을 때,
// 두 사람이 정점 e에 도착하기 위해 지불해야 하는 비용 중 최소 비용을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 정점의 수 n과 간선의 개수 m이 주어집니다.
// 두 번째 줄에는 v1 v2,e값이 공백을 사이에 두고 주어집니다.
// 세 번째 줄 부터는 m개의 줄에 걸쳐 각 간선에 대한 정보 a, b, c가 공백을 사이에 두고 주어집니다.
// 이는 정점 a와 정점 b가 연결되어 있으며, 이 사이를 이동하는 데 비용이 c만큼 발생함을 뜻합니다.
// 특정 정점 쌍을 연결하는 간선이 2번 이상 주어지는 경우는 없다고 가정해도 좋습니다.

// 3 ≤ n ≤ 100
// 1 ≤ m ≤ n×(n−1) / 2
// 1 ≤ v1, v2, e ≤ n
// 1 ≤ a, b ≤ n, a = b
// 1 ≤ c ≤ 100,000

// 입력 예시 01 :
// 5 7
// 1 3 5
// 1 2 2
// 1 3 1
// 4 1 1
// 4 3 1
// 4 2 1
// 5 3 5
// 2 5 3

// 출력 예시 01 :
// 6

// 아이디어 :
// floyd-warshall 로 모든 지점에서 각 지점으로의 최소 비용을 구한다.
// 특정 k위치에서 같이 택시를 탄다고 가정하고, dist[start1][k] + dist[start2][k] + dist[k][e] 의 최소값을 구한다.
// 만약 start1 or start2에서 k로 도달할 수 없거나, k에서 e로 도달 못하면 (int)1e9로 유지될것이다.

// 넓게 생각하자. start1과 start2가 동시에 어떤 지점에서 같이 택시를 탄다고 생각하면 된다!
// 가장 헷갈렸던 건 택시를 안타는 경우는 어떻게 반영해야 할까 였는데 결국 k의 범위가 1부터 n까지임으로,
// k가 start1이나 start2라면 반영되는 꼴!
// 만약 dist[start1][e] dist[start2][e]만 1e9가 아닐 때는?
// k가 e랑 동일 할 때 반영된다.

package ShortestPathWithWeight_최단경로_가중치;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class SPW04 {
    public static final int MAX_N = 100;

    public static int n,m,start1,start2,e;
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];
    public static Scanner sc = new Scanner(System.in);

    public static void floydWarShall(){
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
            dist[to][from] = cost;
        }
        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        start1 = sc.nextInt(); // A의 시작 정점 번호
        start2 = sc.nextInt(); // B의 시작 정점 번호
        e = sc.nextInt(); // 도착해야할 정점 번호

        floydWarShall(); // dist 배열 완성

        int minCost = Integer.MAX_VALUE;
        for (int k = 1; k <= n ; k++) {
            minCost = Math.min(minCost, dist[start1][k] + dist[start2][k] + dist[k][e]);
        }
        // 동시에 만나는 것이 고려되지 않아 only 비용

        if(minCost == Integer.MAX_VALUE)
            minCost = -1;

        System.out.println(minCost);
    }

}
