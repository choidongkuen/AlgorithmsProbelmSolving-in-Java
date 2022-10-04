// 날짜 : 2022/10/04
// 문제 : practice01

// 문제 설명 :
// 2차원 배열 data에 그래프 데이터가 주어진다.
// 무방향이고 간선에 가중치 값이 있는 그래프이다.
// 1번 정점에서 N번 정점으로 최단 경로로 이동하려고 하는데,
// 두 정점을 경유해서 가려고 한다.
// 1번 정점에서 출발하여 두 정점을 경유하여 N 번 정점으로 가는 최단 경로는?

// 입출력 예시
// 입력 :
    // data : {{1,2,3},{1,3,5},{1,4,4},{2,3,3},{2,4,5},{3,4,1}}
    // start : 1
    // n = 4
    // via1 = 2
    // via2 = 3
// 출력 : 7

// 아이디어 :
// 1 -> "2" -> "3" -> 4 의 최단 거리는
// 1 -> 2 의 최단거리 + 2 -> 3의 최단거리 + 3 -> 4의 최단거리 or
// 1 -> 3의 최단거리 + 3 -> 2의 최단거리 + 2 -> 4의 최단거리

package ShortestPathWithWeight_최단경로_가중치;



import java.util.ArrayList;
import java.util.PriorityQueue;

public class SPW07 {
    public static ArrayList<ArrayList<Node>> graph;
    static class Node{
        int to;
        int weight;
        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    public static int dijkstra(int v,int start,int end){
        // 우선순위 큐 + 인접 리스트이용하는 다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        int[]dist = new int[v + 1];

        for (int i = 1; i <= v ; i++) {
            dist[i] = (int)1e9;
        }
        dist[start] = 0;

        pq.add(new Node(start,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for(int i = 0; i < graph.get(cur.to).size(); i ++){
                Node adjNode = graph.get(cur.to).get(i);
                // 현재 노드 cur과 연결되어 있는 노드
                if(dist[adjNode.to] > dist[cur.to] + adjNode.weight){
                    dist[adjNode.to] = dist[cur.to] + adjNode.weight;
                    pq.add(new Node(adjNode.to,adjNode.weight));
                }
            }
        }
        return dist[end];
    }

    public static void solution01(int[][] data, int start, int n, int via1, int via2){
        // solution 부분에서 graph 생성하자
        graph = new ArrayList<>();

        for (int i = 0; i < data.length ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1],data[i][2]));
            // data 저장되어 있는 내용을 인스턴스화 해서 저장
        }

        int case1 = dijkstra(n,start,via1) + dijkstra(n,via1,via2) + dijkstra(n,via2,n);
        // start ~ via1 ~ via2 ~ end
        int case2 = dijkstra(n,start,via2) + dijkstra(n,via2,via1) + dijkstra(n,via1,n);
        // start ~ via2 ~ via1 ~ end
        // 만약 한번에 start ~ end 까지 하게 되면 차이가 없음
        int ans = Math.min(case1, case2);
        System.out.println(ans);
    }
    public static void floydWarshall(int start, int v, int via1, int via2){
        int[][] dist = new int[v + 1][v + 1];

        for (int i = 1; i <= v ; i++) {
            for (int j = 1; j <= v ; j++) {
                if(i != j)
                    dist[i][j] = (int)1e9;
            }
        } // dist 배열 1차 초기화

        for (int i = 1; i <= v ; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                Node node = graph.get(i).get(j);
                dist[i][node.to] = node.weight;
            }
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v ; i++) {
                for (int j = 1; j <= v ; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int case1 = dist[start][via1] + dist[via1][via2] + dist[via2][v];
        int case2 = dist[start][via2] + dist[via2][via1] + dist[via1][v];

        int ans = Math.min(case1, case2);
        System.out.println(ans);
    }
    public static void solution02(int[][] data, int start, int v, int via1, int via2){

        graph = new ArrayList<>();

        for (int i = 0; i < data.length ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1],data[i][2]));
            // data 저장되어 있는 내용을 인스턴스화 해서 저장
        }
        floydWarshall(start,v,via1,via2);
    }
    public static void main(String[] args) {

        int[][] data  = {{1,2,3},{1,3,5},{1,4,4},{2,3,3},{2,4,5},{3,4,1}};
        int start = 1;
        int n = 4;
        int via1 = 2;
        int via2 = 3;

        solution01(data,start,n,via1,via2); // dijkstra
        solution02(data,start,n,via1,via2); // floydWarShall
    }
}
