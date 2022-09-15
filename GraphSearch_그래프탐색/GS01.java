// 날짜 : 2022/09/15
// 문제 : 그래프 탐색
// 문제 설명 :
// N개의 정점과 M개의 간선으로 이루어진 양방향 그래프가 주어졌을 때,
// 1번 정점에서 시작하여 주어진 간선을 따라 이동했을 때 도달 할 수 있는 서로 다른 정점의 수를 구하는 프로그램을 작성해보세요.
// (여기서 1번 정점 자기 자신에 도달하는 경우는 가지수에서 제외합니다.)

// 입력 형식 :
// 첫 번째 줄에는 N과 M이 공백을 사이에 두고 주어지고,
// 두 번째 줄부터는 M개의 줄에 걸쳐 (x,y)가 공백을 사이에 두고 주어집니다.
// (x,y)는 두 정점 x,y 가 연결되어 있음을 의미합니다. (x,y) 쌍이 동일한 연결관계가 두 번 이상 주어지는 경우는 없다고 가정해도 좋습니다. (1≤x,y≤N)
// 1≤N≤1,000
//0≤M≤min(10,000,N(N−1))

// 입력 예시 :
// 5 4
// 1 2
// 1 3
// 2 3
// 4 5

// 출력 예시 :
// 2

// 인접행렬로 구현해보기

package GraphSearch_그래프탐색;

import java.util.*;

public class GS01 {

    public static final int MAX_NUM = 1000; // 정점의 최대 갯수
    public static int n,m;
    public static int cnt = 0; // 1에서 출발했을 때, 도달 할 수 있는 서로 다른 정점의 수

    public static int[][] graph = new int[MAX_NUM + 1][MAX_NUM + 1]; // 인접행렬
    public static boolean[] visited = new boolean[MAX_NUM + 1]; // 방문 기록용 1차원 배열

    public static void DFS(int vertex){
        for(int currv = 1; currv <= n; currv ++){
            if(graph[vertex][currv] == 1 && !visited[currv]){
                visited[currv] = true; // 방문 기록
                cnt ++; // 도달 할 수 있는 정점의 수 증가
                DFS(currv); // 재귀적 호출
            }
        }
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점의 수
        m = sc.nextInt(); // 간선의 수

        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1; // 양뱡향 그래프
        } // 인접행렬 완성

        int rootVertex = 1; // 시작 정점
        visited[rootVertex] = true;
        DFS(rootVertex); // DFS 메소드 호출

        System.out.println(cnt); // 결과 출력
    }
}