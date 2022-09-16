// 날짜 : 2022/09/16
// 문제 : 뱀을 피해 이동하자.
// 문제 설명 : n X n 격자가 주어질 떄, 뱀이 있으면 0, 없으면 1로 주어진다.
// 이때 (0,0) 에서 시작하여, 아래 혹은 오른쪽 방향으로 이동하여 갈 수 있는 모든 정점을 DFS 탐색으로 방문하려고 할 때, 방문 순서를 출력하시오.

// 정리
// DFS 탐색을 사용하되, 따로 인접 행렬이나, 인접 리스트를 구현할 필요가 없다.
// dx,dy 테크닉을 이용하여, 아래쪽 & 오른쪽 방향에 대해 갈 수 있는지 파악 후, 갈 수 있을 때까지 이동하면 된다.
// 이동할 수 있는 조건 : 1. 뱀이 존재하지 않을 때(info) 2. 격자의 범위를 벗어나지 않을 때(checkRange) 3. 방문 한적이 없을 때(visited)

package GraphSearch_그래프탐색;
import java.util.Scanner;

public class GS03 {
    public static final int MAX_N = 100; // 최대 격자 크기
    public static int[][] info = new int[MAX_N][MAX_N]; // 뱀의 정보가 담긴 2차원 배열
    public static int[] dx = {1,0};
    public static int[] dy = {0,1}; // 아래 & 오른쪽
    public static int n; // 주어지는 격자 크기
    public static int order = 1; // 방문 순서

    public static int[][] answer = new int[MAX_N][MAX_N]; // 방문 순서를 기록할 2차원 배열
    public static boolean[][] visited = new boolean[MAX_N][MAX_N]; // 방문 기록을 위한 2차원 배열

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){
        if(!checkRange(x,y))
            return false;

        if(info[x][y] == 0 || visited[x][y]){
            return false;
        } // 뱀이 있거나, 방문한 적이 있다면

        return true;
    }

    public static void DFS(int x, int y){
        for(int i = 0; i < 2; i++){
            int newX = x + dx[i];
            int newY = y + dy[i]; // 다음 위치

            if(canGo(newX,newY)){
                answer[newX][newY] = order++;
                visited[newX][newY] = true;
                DFS(newX,newY); // 재귀적 호출
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("격자 크기 입력 : ");
        n = sc.nextInt(); // 격자 크기 입력

        System.out.println("뱀 정보 입력 : ");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                info[i][j] = sc.nextInt(); // 뱀 존재하면 0 아니면 1
            }
        // info 배열 완성

        answer[0][0] = order ++;
        visited[0][0] = true;
        DFS(0,0);

        System.out.println("==== 방문 순서 ====");
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0; j < n; j++){
                System.out.print(answer[i][j] + " ");// 방문 순서 출력
            }
            System.out.println();
        }
    }
}
