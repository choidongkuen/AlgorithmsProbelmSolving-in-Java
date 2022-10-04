// 날짜 : 2022/10/04
// 문제 : 크기 비교

// 문제 설명 :
// 서로 다른 크기를 가진 정수 n개에 대해서, 1번부터 n번까지의 정수 중 임의의 두 정수의 크기를 비교한 결과가 m번 주어집니다.
// m번의 비교결과를 통해, i번 정수는 다른 몇 개의 정수와 크기 비교 결과를 알 수 없는지 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 정수의 개수 n, 크기 비교 결과의 개수 m 이 공백을 두고 주어집니다.
// 두 번째 줄부터 m개의 줄에 걸쳐 한 줄에 두 개의 정수가 공백을 두고 주어지는데, 앞의 정수가 뒤의 정수보다 숫자가 더 크다는 뜻 입니다.
// 5 ≤ n ≤ 100
// 0 ≤ m ≤ 2,000
// 모순된 입력은 없다고 가정해도 좋습니다

// 입력 예시 01 :
// 6 5
// 1 2
// 2 3
// 3 4
// 5 4
// 6 5

// 출력 예시 01 :
// 2
// 2
// 2
// 0
// 3
// 3

package ShortestPathWithWeight_최단경로_가중치;

import java.util.Arrays;
import java.util.Scanner;

public class SPW05 {
    public static final int MAX_N = 100;

    public static int n,m;
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];

    public static void floydWarShall(Scanner sc){

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(i != j)
                    dist[i][j] = Integer.MAX_VALUE;
            }
        } // 1차 초기화

        while(m -- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            dist[x][y] = 1; // x - y 로 경유 가능
        } // 2차 초기화(경유하지 않고 도달 가능한 정점)

        for(int k = 1; k <= n ;k ++){
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    if(dist[i][k] == 1 && dist[k][j] == 1)
                        dist[i][j] = 1; // k를 경유해서 이동 가능
                }
            }
        } // 3차 초기화(경유하여 도달 가능한 정점)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        floydWarShall(sc);

        for (int i = 1; i <= n ; i++) {
            int cnt = 0;
            for(int j = 1; j <= n ; j++) {
                if (dist[i][j] ==  Integer.MAX_VALUE && dist[j][i] == Integer.MAX_VALUE) { // i - j 서로 어떤 방법으로도 연결 불가
                    cnt ++;
                }
            }
            System.out.println(cnt);
        }

    }
}
