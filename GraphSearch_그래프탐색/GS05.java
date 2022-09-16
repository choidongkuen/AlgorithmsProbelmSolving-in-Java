// 날짜 : 2022/09/16
// 문제 : 마을 구분하기
// 문제 설명 :
// n * n크기의 이차원 영역에 사람 혹은 벽이 놓여져있습니다. 이 때 상하좌우의 인접한 영역에 있는 사람들은 같은 마을에 있는 것으로 간주한다고 합니다.
// 이 때 총 마을의 개수와 같은 마을에 있는 사람의 수를 오름차순으로 정렬하여 출력하는 코드를 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n이 주어지고,
// 두 번째 줄부터 (n+1)번째 줄까지는 각 행에 사람이 있는 경우 1, 벽이 있는 경우 0으로 입력이 공백을 사이에 두고 주어집니다.
// 5 ≤ n ≤ 25

// 입력 예시 :
// 5
// 1 0 1 1 1
// 1 0 0 0 0
// 0 0 0 1 1
// 1 1 0 1 1
// 1 1 0 1 1

// 출력 예시 :
// 4
// 2
// 3
// 4
// 6

package GraphSearch_그래프탐색;
import java.util.*;

public class GS05 {
    public static final int MAX_N = 25; // 최대 격자 크기
    public static final int DIR_NUM = 4; // 4방향
    public static int[][] info = new int[MAX_N][MAX_N]; // 마을에 정보를 담은 2차원 배열
    public static boolean[][] visited = new boolean[MAX_N][MAX_N]; // 방문 기록을 담은 2차원 배열
    public static ArrayList<Integer> people = new ArrayList<>(); // 각 마을마다의 사람 수를 담을 배열리스트
    public static int[] dx = {0,-1,0,1};
    public static int[] dy = {1,0,-1,0}; // 동 - 북 - 서 - 남
    public static int n; // 주어지는 격자 크기
//    public static int vilegeNum = 0; // 마을의 갯수

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){
        if(!checkRange(x,y))
            return false; // 범위 벗어난 경우

        if(info[x][y] == 0 || visited[x][y])
            return false; // 벽이 있거나, 방문한 적이 있는 경우

        return true;
    }

    public static int DFS(int x, int y){

        int cnt = 1;
        for(int dir = 0 ; dir < DIR_NUM; dir ++){
            int newX = x + dx[dir];
            int newY = y + dy[dir]; // 다음 위치

            if(canGo(newX, newY)){
                visited[newX][newY] = true;
                cnt += DFS(newX,newY); // 재귀적 호출(생각 좀)
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 격자 크기 입력

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                info[i][j] = sc.nextInt();
        // 마을에 정보 배열 입력

        for(int i = 0 ; i < n; i++)
            for(int j = 0; j < n; j++)
                if(info[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true; // 방문 기록
//                    vilegeNum++; // 마을 갯수 증가

                    int cnt = DFS(i,j);
                    people.add(cnt); // 해당 마을내 사람 수 저장
                }

        Collections.sort(people); // 오름차순 정렬
//        System.out.println(vilegeNum); // 마을 갯수 출력

        System.out.println(people.size());
        for(int i = 0; i < people.size(); i++)
            System.out.println(people.get(i)); // 각 마을 주민 수 출력
    }
}