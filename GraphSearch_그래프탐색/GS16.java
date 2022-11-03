// 날짜 : 2022/11/03
// 문제 : 빙하 녹이기
// 문제 설명 :

// N×M 크기의 격자안에 빙하의 정보가 주어집니다. << 격자의 가장 바깥 부분은 항상 빙하가 아니고 >>, 빙하를 제외한 나머지 위치에는 전부 물이 채워져 있습니다. 숫자 1은 빙하를, 숫자 0은 물을 나타냅니다.
// 빙하는 1초에 한 번씩 물에 닿아있는 부분들이 동시에 녹습니다. << 하지만 빙하로 둘러쌓여있는 물의 경우에는 붙어있는 빙하를 녹이지 못합니다. >>
// 여기서 닿아있다는 말은 상하좌우로 인접한 경우를 의미하며, 다음의 경우 역시 안쪽에 있는 0들은 빙하로 둘러쌓인 것이기 때문에 빙하가 녹는데 영향을 주지 못합니다.
// 빙하가 전부 녹는데 걸리는 시간과 마지막으로 녹은 빙하의 크기(1의 개수)를 구하는 프로그램을 작성해보세요.

// 아이디어 :
// 가장자리는 무조건 물(0) 임으로, 물인 영역을 모두 찾아 방문 처리 해준다(by BFS)
// 방문 처리 한 후, 방문 처리 되어 있는 영역과 인접해 있는 빙하 위치는 녹여준다.

// 입력 예시 01 :
// 3 3
// 0 0 0
// 0 1 0
// 0 0 0

// 출력 예시 01 :
// 1 1

// step 01 : 빙하로 둘러쌓여 있지 않은 물의 영역을 모두 방문 처리
// step 02 : 존재하는 빙하중 (바깥 부분)인접한 영역에 물이 존재하면 녹이기

package GraphSearch_그래프탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GS16 {

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int MAX = 200;
    public static final int DIR = 4;
    public static final int WATER = 0;
    public static final int GLACIER = 1;

    public static int n,m;
    public static int[][] arr = new int[MAX][MAX];

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static boolean[][] visited;
    public static Queue<Point> q = new LinkedList<>();

    public static int time = 0; // 모든 빙하를 녹이는 데 걸린 시간
    public static int lastArea; // 한번 빙하를 녹이고 남은 모든 빙항의 개수


    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean canGo(int x, int y){
        return checkRange(x,y) && arr[x][y] == WATER && !visited[x][y];
        // 범위를 벗어나지 않으며, 해당 영역이 물이 있는 영역이며 방문한적 없는 경우
    }

    public static void bfs(){
        // 빙하로 둘러쌓여있지 않은 물의 영역 모두 방문 처리

        visited = new boolean[MAX][MAX];

        q.add(new Point(0,0));

        while(!q.isEmpty()){

            Point curP = q.poll();

            int curX = curP.x;
            int curY = curP.y;

            for (int d = 0; d < DIR ; d++) {

                int nextX = curX + dx[d];
                int nextY = curY + dy[d];

                if(canGo(nextX,nextY)){
                    visited[nextX][nextY] = true;
                    q.add(new Point(nextX,nextY));
                }
            }
        }
    }

    public static boolean hasNeighborWater(int x, int y){
        // 상하좌우에 물이 있는지 판단하는 메소드

        for (int d = 0; d < DIR ; d++) {
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(checkRange(nextX,nextY) && visited[nextX][nextY])
                return true;
            // 방문한 적이 있다는 것은 빙하로 둘러쌓여있지 않은 물이라는 뜻

        }
        return false;
    }

    public static void melt(){
        // 방문 기록 후, 주변에 물이 존재하면 해당 빙하를 녹이기

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(arr[i][j] == GLACIER && hasNeighborWater(i,j)){
                    arr[i][j] = WATER;
                    lastArea ++; // 마지막 남은 영역 증가
                }
            }
        }

    }

    public static void controller(){
        // 해당 메소드가 호출된다는 것은 빙하가 하나라도 존재하는 경우
        lastArea = 0; // 마지막 영역 업데이트 가능
        time ++;

        bfs();
        // 방문 기록

        melt();

    }

    public static boolean glacierIsExist(){

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(arr[i][j] == GLACIER){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();


        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        controller();

        while(glacierIsExist()) {
            // 빙하가 하나라도 존재하는 경우
            controller();
        }

        System.out.println(time + " " + lastArea);
    }
}
