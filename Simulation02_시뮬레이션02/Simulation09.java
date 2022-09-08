// 날짜 : 2022/09/08
// 문제 : 격자 안에서 여러 객체를 이동
// 문제 설명 : n X n 격자 각 칸에 숫자가 적혀있습니다.
// m개의 구슬이 서로 다른 위치에서 시작하여 인접한 4개의 칸 중, 현재 위치에 있는 숫자보다 더 큰 숫자로
// 동시에 이동하는 것을 t번 반복하려고 합니다. 단 상하좌우 순서대로 우선 순위를 매겨 가능한 곳 중 우선순위가
// 높은 곳으로 이동하며, 이동 할 수가 없는 경우 움직일 수 없습니다.
// 만약 이동 후 2개 이상의 구슬이 같은 칸에 존재하게 되면 충돌이 생겨 사라지게 된다.
// 최종적으로 남아있는 구슬의 수를 출력 하시오.

// 1 <= n <= 100

// 입력 예시 :
// n = 4, m = 3, t = 1
// arr = {{1, 2, 2, 3},{3,5,16,16},{3,8,11,2},{4,5,4,4}}
// start = [(2,1),(2,4),(3,3)]

// 출력 예시 :
// 1

package Simulation02_시뮬레이션02;
import java.util.Scanner;

class Point{ // 위치(점)에 대한 클래스
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Simulation09 {
    public static final int MAX_N = 100; // 격자의 최대 크기
    public static final int moveNum = 4; // 상 - 하 - 좌 - 우
    public static int[][] arr = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] count = new int[MAX_N + 1][MAX_N + 1];
    public static int[][] nextCount = new int[MAX_N + 1][MAX_N + 1];
    public static int n,m,t; // 주어지는 격자 크기, 구슬의 갯수, 이동 시간
    public static Scanner sc;

    public static boolean checkRange(int x, int y){ // 범위 체크하는 메서드
        return x >= 1 && x <= n && y >= 1 && y <= n;
    }
    public static Point getNextpos(int x, int y) { // 더 큰 값을 가지는 위치를 구하는 메서드
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1}; // 상하좌우
        Point p = new Point(x,y);

        int maxVal = arr[x][y];
        for (int i = 0; i < moveNum; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i]; // 다음 위치

            if (checkRange(nx, ny) && arr[nx][ny] > maxVal) { // 범위를 벗어나지 않으면서 값이 더 크다면
                p = new Point(nx, ny); // 새로운 Point 객체 생성
            }
        }
        return p; // Point 객체 리턴
    }
    public static void move(int x, int y){ // 구슬 이동하는 메서드
        Point nextPos = getNextpos(x,y);
        int nextX = nextPos.x;
        int nextY = nextPos.y; // x,y 에서 가장 최대값을 가진 위치로 이동

        nextCount[nextX][nextY] += 1;
    }
    public static void removeDuplication(){ // 충돌난 부분을 0으로 만들어주는 메서드
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++) {
                if (count[i][j] >= 2)
                    count[i][j] = 0; // 충돌났음으로, 제거
            }
    }
    public static void moveAll(){ // t초 동안 모든 구슬 이동시키는 메서드

        for(int i = 1; i <= n; i ++)
            for(int j = 1; j <= n; j ++)
                nextCount[i][j] = 0; // nextCount 배열 초기화

        for(int i = 1; i <= n; i ++)
            for(int j = 1; j <= n; j ++)
                if(count[i][j] == 1)
                    move(i,j); // 구슬이 존재하면 move 메서드 호출

        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                count[i][j] = nextCount[i][j]; // count배열로 결과 이동
    }
    public static void simulate(){ // 시뮬레이션 메서드
        moveAll(); // moveAll 메서드 호출
        removeDuplication(); // nextCout 배열에서 충돌난 구슬 제거
    }
    public static void initialize(){ // 초기화 메서드
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= n; j++)
                arr[i][j] = sc.nextInt(); // 각 배열의 원소 입력

        for(int i = 0; i < m; i++){
            int row = sc.nextInt();
            int col = sc.nextInt();
            // 구슬의 시작 위치 입력
            count[row][col] = 1;
        }
    }
    public static void main(String[] args){
        sc = new Scanner(System.in);
        n = sc.nextInt(); // 주어지는 격자 크기
        m = sc.nextInt(); // 구슬의 갯수
        t = sc.nextInt(); // 이동 시간

        initialize(); // 초기화 메서드 호출

        while(t -- > 0)
            simulate(); // t 번 동안 시뮬레이트 메서드 호출

        int marvelCnt = 0; // 구슬의 갯수
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(count[i][j] + " ");
                marvelCnt += count[i][j];
            }
            System.out.println();
        }

        System.out.print("최종 구슬 갯수: ");
        System.out.println(marvelCnt); // 최종 구슬 갯수 출력
    }
}
