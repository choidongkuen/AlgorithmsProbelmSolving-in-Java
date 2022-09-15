// GS01을 인접리스트로 구현 해보기
package GraphSearch_그래프탐색;

import java.util.*;

public class GS02 {
    public static final int MAX = 1000; // 정점의 최대 갯수
    public static int n,m;
    public static int cnt = 0; // 1에서 출발했을 때, 도달 할 수 있는 서로 다른 정점의 수

    public static ArrayList<Integer>[] adList = new ArrayList[MAX + 1]; // 연결 리스트
    public static boolean[] visited = new boolean[MAX + 1]; // 방문 기록용 1차원 배열

    public static void DFS(int vertex){
        for(int i = 0; i < adList[vertex].size(); i++){
            int currv = adList[vertex].get(i);

            if(!visited[currv]){
                visited[currv] = true; // 방문 기록
                cnt ++; // 도달 할 수 있는 정점의 수 증가
                DFS(currv); // 재귀 호출
            }
        }
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점의 수
        m = sc.nextInt(); // 간선의 수

        for(int i = 1; i <= n; i++){
            adList[i] = new ArrayList<>();
        } // 인접 리스트 초기화 완료

        while(m -- > 0){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adList[v1].add(v2);
            adList[v2].add(v1); // 양방향
        } // 인접 리스트 완성

        int rootVertex = 1; // 시작 정점
        visited[rootVertex] = true; // 기록
        DFS(rootVertex); // DFS 메소드 호출

        System.out.println(cnt); // 결과 출력
    }
}