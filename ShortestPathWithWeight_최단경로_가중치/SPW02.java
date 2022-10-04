// 날짜 : 2022/10/04
// 문제 : 최단 거리

// 문제 설명 :
// 1번부터 n번까지의 장소 사이를 이동하려 합니다.
// 각 장소마다 직접적으로 연결된 도로가 있고, 이 도로의 정보가 행렬로 주어져 있습니다. 장소와 이 도로 정보로부터 단방향 그래프가 만들어집니다.
// i 번 장소에서 j 번 장소까지 경유 없이 이동하면 i 행 j 열의 숫자만큼의 시간이 걸리고, 다른 장소를 경유하여 이동하는 것이 더 짧은 시간이 걸릴 수 있습니다.
// m개의 질의에 대해 a 번 장소에서 b 번 장소까지 도달하기 위한 최단시간을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 1번부터 n번까지의 장소 사이를 이동하려 합니다.
// 각 장소마다 직접적으로 연결된 도로가 있고, 이 도로의 정보가 행렬로 주어져 있습니다. 장소와 이 도로 정보로부터 단방향 그래프가 만들어집니다.
// i 번 장소에서 j 번 장소까지 경유 없이 이동하면 i 행 j 열의 숫자만큼의 시간이 걸리고, 다른 장소를 경유하여 이동하는 것이 더 짧은 시간이 걸릴 수 있습니다.
// m개의 질의에 대해 a 번 장소에서 b 번 장소까지 도달하기 위한 최단시간을 구하는 프로그램을 작성해보세요.

// 입력 예시01 :
// 5 8
// 0 4 4 8 7
// 7 0 7 7 4
// 1 4 0 5 4
// 5 2 2 0 7
// 1 4 1 6 0
// 1 3
// 2 4
// 4 1
// 1 5
// 3 2
// 4 5
// 5 3
// 1 4

// 출력 예시01 :
// 4
// 7
// 3
// 7
// 4
// 6
// 1
// 8

// 아이디어 :
// m개의 질의에 대해 (i,j) 까지의 최단 경로를 구해야 함으로, 모든 정점에 대해 각 정점까지의 최단거리를 모두 구해야한다.
// 즉 플로이드 워셜 알고리즘을 사용하자

package ShortestPathWithWeight_최단경로_가중치;
import java.util.Scanner;

public class SPW02 {

    public static final int MAX_N = 100; // 정점의 최대 갯수
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1]; // 거리 배열
    public static int n,m;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                dist[i][j] = sc.nextInt();
            }
        } // dist 배열 1차 초기화

        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        } // dist 배열 2차 초기화

        while(m -- > 0){
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println(dist[row][col]);

        }
    }
}
