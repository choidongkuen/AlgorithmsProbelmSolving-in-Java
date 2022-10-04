// 날짜 : 2022/10/04
// 문제 : practice03
// 문제 설명 :
// n 개의 도시와 한 도시에서 출발하여 다른 도시에 도착하는 m 개의 버스가 있다.
// 각 버스는 한 번 사용할 때 필요한 비용이 있다.
// 모든 도시의 쌍 (A,B) 에 대해서 도시 A 에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

// 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있음.
// 갈수 없는 경로는 0을 출력하시오.

// 입출력 예시
// 입력 :
    // city : 5
    // bus : 14
    // busInfo = {{1,2,3},{1,3,3},{1,4,1},{1,5,10},{2,4,2},{3,4,1},{3,5,1},{4,5,3},{3,5,10},{3,1,8},{1,4,2},{5,1,7},{3,4,2},{5,2,4}}

// 출력 :
// 0 2 3 1 4
// 12 0 15 2 5
// 8 5 0 1 1
// 10 7 13 0 3
// 7 4 10 6 0

package ShortestPathWithWeight_최단경로_가중치;

public class SPW09 {
    public static int[][] dist;

    public static void floydWarShell(int v){

        for (int k = 1; k <= v  ; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void solution(int city, int bus, int[][] busInfo){

        dist = new int[city + 1][city + 1];

        for (int i = 1; i <= city ; i++) {
            for (int j = 1; j <= city ; j++) {
                if(i != j)
                    dist[i][j] = (int)1e9;
            }
        }

        for (int i = 0 ; i < busInfo.length ; i++) {
            dist[busInfo[i][0]][busInfo[i][1]] = Math.min(dist[busInfo[i][0]][busInfo[i][1]],busInfo[i][2]);
            // 동일한 간선 정보가 있음으로, 가장 작은 값으로 업데이트
        }
        floydWarShell(city);

        for (int i = 1; i <= city ; i++) {
            for (int j = 1; j <= city ; j++) {
                if(dist[i][j] == (int)1e9)
                    System.out.printf("%5d",0);
                else
                    System.out.printf("%5d",dist[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

       int[][] busInfo = {{1,2,3},{1,3,3},{1,4,1},{1,5,10},{2,4,2},{3,4,1},{3,5,1},{4,5,3},{3,5,10},{3,1,8},{1,4,2},{5,1,7},{3,4,2},{5,2,4}};
       int v = 5;
       int e = 14;

       solution(v,e,busInfo);
    }

}
