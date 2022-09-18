// 날짜 : 2022/09/18
// 문제 : k번 최댓값으로 이동하기(DFS ver)
// 문제 설명 :
// n*n 크기의 격자에 1이상 100이하의 숫자가 각 칸에 하나씩 주어져 있습니다. 이때 특정 위치에서 시작하여 아래 조건을 만족하는 숫자의 위치를 찾아 상하좌우로만 이동합니다.
// 이렇게 이동하는 것을 k번 반복한 이후의 위치를 구하는 프로그램을 작성해보세요. 만약 아직 k번을 반복하지 못했지만, 더 이상 새로 이동할 위치가 없다면 움직이는 것을 종료합니다.
// 한번 이동하기 위한 조건은 다음과 같습니다.
// 시작 위치에 적혀있는 숫자를 x라고 했을 때, 시작 위치에서 출발하여 인접한 칸들 중 적혀있는 숫자가 x보다 작은 곳으로는 전부 이동이 '가능'합니다.
// 다음 그림을 예로 들어보겠습니다. 시작 위치가 4행 3열인 숫자 10이라고 했을 때, 10보다 큰 11을 제외한 인접한 모든 숫자들로 이동이 가능합니다.


// 해당 위치에서 이동가능한 모든 격자의 칸 중, 다음 조건을 만족한 위치로 이동한다.
// - 위 조건을 만족하며 도달할 수 있는 칸들에 적혀있는 숫자 중 '최댓값'으로 이동합니다.
// - 최댓값이 여러개인 경우, 행이 작은순 and 열이 작은 순으로 결정

// 입력 형식 :
// 첫 번째 줄에는 격자의 크기를 나타내는 n과 반복할 횟수를 나타내는 k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 행에 해당하는 n개의 숫자가 순서대로 공백을 사이에 두고 주어집니다.
// 마지막 줄에는 초기 시작 위치 (r, c)가 공백을 사이에 두고 주어집니다. (r, c)는 r행 c열에서 시작함을 의미합니다. (1 ≤ r ≤ n, 1 ≤ c ≤ n)
// 1 ≤ n, k ≤ 100

// 입력 예시 1 :
// 4 2
// 1 3 2 11
// 4 9 6 9
// 2 6 9 8
// 1 9 10 7
// 4 3

// 출력 예시 1 :
// 2 3

// 입력 얘시 2 :
// 4 4
// 1 3 2 11
// 4 9 6 9
// 2 6 9 8
// 1 9 10 7
// 4 3

// 출력 예시 2 :
// 1 2


package GraphSearch_그래프탐색;

import java.util.*;

public class GS12 {
    public static final int MAX = 100; // 격자의 최대 크기
    public static int[][] arr = new int[MAX][MAX]; // 주어지는 정보를 원소로 갖는 격자
    public static boolean[][] visited; // 방문기록을 위한 2차원 배열
    public static int n,k;
    public static int curX,curY; // 각 k 마다의 위치
    public static int curVal;

    public static final int DIR_NUM = 4; // 4방향
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,1,-1};

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static boolean canGo(int x, int y){

        if(!checkRange(x,y) || arr[x][y] >= curVal || visited[x][y])
            return false;

        return true;

    } // 격자를 벗어난 경우, curVal보다 크거나 같은 경우, 이미 방문한 경우 = > false

    public static void DFS(int x, int y){

        for(int d = 0; d < DIR_NUM; d++){
            int nextX = x + dx[d];
            int nextY = y + dy[d]; // 다음 위치

            if(canGo(nextX,nextY)){
                visited[nextX][nextY] = true;
                DFS(nextX,nextY);
            }
        }
    }

    public static void findLoc(){ // 특정 위치에서 도달 가능한 격자 중, 이동할 지점을 찾아주는 메소드
        int maxVal = 0;
        int x = curX;
        int y = curY;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(visited[i][j] && maxVal < arr[i][j]){ // 방문 한 적이 있으며(시작위치의 값보다 작은 값) , 최대값보다 크다면
                    maxVal = arr[i][j];
                    x = i; y = j; // 값, 위치 업데이트
                }
            }
        }
        curX = x; curY = y;
        curVal = maxVal;
    }
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt(); // 격자 정보 입


        curX = sc.nextInt() - 1;
        curY = sc.nextInt() - 1; // 시작 위치 입력
        curVal = arr[curX][curY]; // 시작 위치의 값

        for(int i = 0; i < k; i++){ // k번 이동
            visited = new boolean[MAX][MAX];
            DFS(curX,curY); // DFS 메소드 호출(curX,curY 로 부터 도달가능한 지점 모두 방문)
            findLoc();
        }

        System.out.println((curX + 1) +" "+ (curY + 1)); // 결과 출력
    }
}