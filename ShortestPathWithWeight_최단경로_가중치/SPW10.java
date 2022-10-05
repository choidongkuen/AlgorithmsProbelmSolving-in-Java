// 날짜 : 2022/10/05
// 문제 : 중앙교통통제소

// 문제 설명 :
// 주어진 그래프를 통해 모든 정점에 대한 각 정점으로의 최단 거리를 구하세요.

package ShortestPathWithWeight_최단경로_가중치;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Spliterator;

public class SPW10 {

    static class Node{
        int from;
        int to;
        int weight;

        Node(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static int[][] dist;
    public static ArrayList<Node> graph;
    public static int v; // 정점 수
    public static int e; // 간선 수

    public static void floydWarShall(){

        for (int i = 1; i <= v ; i++) {
            for (int j = 1; j <= v; j++) {
                if(i != j){
                    dist[i][j] = (int)1e9;
                }
            }
        }

        for (int i = 0; i < graph.size() ; i++) {
            dist[graph.get(i).from][graph.get(i).to] = graph.get(i).weight;
            dist[graph.get(i).to][graph.get(i).from] = graph.get(i).weight;
        }


        for (int k = 1; k <= v ; k++) {
            for (int i = 1; i <= v ; i++) {
                for (int j = 1; j <= v ; j++) {
                    dist[i][j] = Math.min(dist[i][j] , dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    public static void main(String[] args) {

        v = 6;
        e = 10;
        dist = new int[v + 1][v + 1]; // 2차원 거리 배열
        graph = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(e -- > 0){

            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph.add(new Node(from,to,weight));
        }

       floydWarShall();

        System.out.print("   ");
        for (int i = 1; i <= v ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 1; i <= v ; i++) {
            System.out.print(i + "  ");
            for (int j = 1; j <= v ; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
