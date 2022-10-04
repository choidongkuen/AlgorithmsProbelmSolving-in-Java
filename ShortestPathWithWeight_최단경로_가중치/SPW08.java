// 날짜 : 2022/10/04
// 문제 : practice02

// 문제 설명 : n개의 우주가 있고, n개의 우주 사이에 M 개의 포탈과 W개의 웜홀이 있다.
// 각 포털에는 시간 비용이 있고, 포탈을 통해 우주를 이동했을 때 시간이 흘러 있다.(+가중치)
// 웜홀에도 시간 비용이 있는데, 웜홀을 통해 우주를 이동하는 경우는 시간이 거꾸로 흘러 있다.(-가중치)
// n 개의 우주를 포탈과 웜홀을 통해 이동 한다고 했을 때,
// 출발 했을 때보다 시간이 거꾸로 흘러가 있는 경우가 있는지 판별하는 프로그램을 작성하세요. -> 음수 싸이클 판단 여

// 거꾸로 흘러가 있는 경우가 있으면 false, 있으면 true 를 출력하세요.

// 입출력 예시
// 입력 :
// n : 3 / m : 3 / w : 1
// portal : {{1,2,2},{1,3,4},{2,3,1}}
// wormhole = {{3,1,3}}

package ShortestPathWithWeight_최단경로_가중치;

public class SPW08 {
    static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static final int INF = (int)1e9;
    public static Edge[] edges;
    public static int[] dist;

    public static void solution(int n, int m, int w, int[][] portal, int[][] wormhole) {
        edges = new Edge[m + w]; // 포털의 개수 + 웜홀의 개수(모든 간선 정보)

        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(portal[i][0], portal[i][1], portal[i][2]);
        }

        for (int i = 0 ; i < w ; i++) {
            edges[i + m] = new Edge(wormhole[i][0], wormhole[i][1], -wormhole[i][2]);
        }
        // 모든 간선 정보를 인스턴스 배열에 인스턴스화 해서 저장

        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
        } // dist 배열 초기화

        System.out.println(bellmanFord(n, n + w));
    }

    public static boolean bellmanFord(int v, int e) {
        // O(EV)
        boolean minusCycle = false;
        for (int i = 1; i <= v; i++) {
            for (int j = 0; j < e; j++) {
                Edge cur = edges[j];
                if (dist[cur.from] == INF) {
                    continue;
                }
                if (dist[cur.to] > dist[cur.from] + cur.weight) {
                    dist[cur.to] = dist[cur.from] + cur.weight;
                    if (i == v) { // 마지막 정점
                        minusCycle = true;
                    }
                }
            }

        }
        return minusCycle;
    }


    public static void main(String[] args) {

        int n = 3;
        int m = 3;
        int w = 1;
        int[][] portal = {{1, 2, 2}, {1, 3, 4}, {2, 3, 1}};
        int[][] wormhole = {{3, 1, 3}};

        solution(n, m, w, portal, wormhole);
    }
}
