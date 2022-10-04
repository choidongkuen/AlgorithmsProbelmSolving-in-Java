package ShortestPathWithWeight_최단경로_가중치;

import java.util.Scanner;

public class SPW06 {

    public static final int MAX_N = 100;

    public static int n,m;
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];

    public static void floydWarShall(Scanner sc){

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

        for(int k = 1; k <= n; k ++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        floydWarShall(sc);
        int ans = (int)1e9;

        for (int i = 1; i <= n ; i++) {
            for (int j = i; j <= n ; j++) {
                if(i == j)
                    continue;
                ans = Math.min(ans,dist[i][j] + dist[j][i]);
            }
        }
        System.out.println(ans);
    }
}
