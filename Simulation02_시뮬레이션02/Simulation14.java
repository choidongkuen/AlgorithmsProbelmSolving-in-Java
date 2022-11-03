// 날짜 : 2022/11/03
// 문제 : 2차원 바람
// 문제 설명 :
// 0이상 9이하의 숫자로만 이루어진 N*M 행렬 모양의 건물에 총 Q번의 바람이 붑니다.
// 이 바람은 굉장히 특이해서 특정 직사각형 영역의 경계에 있는 숫자들을 시계 방향으로 한 칸씩 shift 하고 해당 직사각형 내 영역에 있는 값들을 각각 자신의 위치를 기준으로 자신과 인접한 원소들과의 평균 값으로 바꿉니다. (평균 계산시에는 항상 버림하여 정수값이 나오도록 합니다.)
// 예를 들어 바람이 다음과 같은 영역에 영향을 미치게 되는 경우를 생각해봅시다.
// 먼저 직사각형의 경계에 있는 숫자들이 시계 방향으로 한 칸씩 회전을 하게 됩니다.
// 그 다음 직사각형 영역 내에 있는 각각의 숫자들의 값이 자신과 인접한 곳에 적혀있는 숫자들과의 평균 값으로 바뀌게 됩니다. 이 과정은 순차적으로 일어나는 것이 아니라 동시에 일어납니다.
// 예를 들어 (2, 2) 위치에 있던 원소는 인접한 4개의 값들과의 평균값을 버림한 값인 3으로 바뀌어야 합니다.
// (4, 6) 위치에 있던 원소는 인접한 숫자가 2개밖에 없으므로, 그 숫자들과의 평균값을 버림한 값인 6으로 바뀌게 됩니다.

// 입력 형식 :
// 첫째 줄에는 행렬의 크기를 나타내는 N과 M 그리고 총 바람이 불어온 횟수를 의미하는 Q가 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터 N개의 줄에 걸쳐 한 줄에 M개 씩 건물의 상태를 나타내는 0이상 9이하의 숫자가 공백을 사이에 두고 주어집니다.
// 그 다음 줄 부터는 Q개의 줄에 걸쳐 불어오는 바람에 대한 정보 (r1, c1, r2, c2)가 공백을 사이에 두고 주어집니다. (r1, c1)은 바람에 영향을 받는 직사각형의 좌측 상단의 위치이며 (r2, c2)는 바람에 영향을 받는 직사각형의 우측 하단의 위치입니다. 즉, 해당 바람에 의해 r1행 c1열부터 r2행 c2열까지의 직사각형이 영향을 받게 됨을 의미합니다. (1 ≤ r1 < r2 ≤ N, 1 ≤ c1 < c2 ≤ M)
// 2 ≤ N ≤ 100
//
// 2 ≤ M ≤ 100
//
// 0 ≤ Q ≤ 100

// 입력 예시 01 :
// 4 6 1
// 4 5 2 5 6 6
// 2 6 1 0 5 5
// 5 1 2 1 6 6
// 4 2 5 2 8 8
// 2 2 4 6

// 출력 예시 01 :
// 4 5 2 5 6 6
// 2 3 2 2 3 4
// 5 3 2 3 4 5
// 4 3 4 4 7 6



package Simulation02_시뮬레이션02;

import java.util.Scanner;

public class Simulation14 {

    public static final int MAX = 100;
    public static final int DIR = 4;

    public static int n,m,q;
    public static int[][] arr = new int[MAX][MAX];
    public static int[][] tempArr = new int[MAX][MAX];

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static boolean checkRange(int x, int y){ // 범위 체크하는 메소드
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void printResult(){

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int getAver(int row, int col){

        int sum = arr[row][col];
        int cnt = 1;

        for (int d = 0; d < DIR ; d++) {

            int nextX = row + dx[d];
            int nextY = col + dy[d];
            // 상하 좌우 칸 확인

            if(checkRange(nextX,nextY)){
                // 인접한 칸이 범위에 포함된다면,
                cnt ++;
                sum += arr[nextX][nextY];
            }
        }

        return sum / cnt;
    }
    public static void calAllAver(int x1, int y1, int x2, int y2) {
        // 동시에 평균값으로 업데이트가 발생해야 한다.
        // 변경된 값이 다른 값의 평균을 구하는데 영향을 끼쳐서는 안됨
        // 임시 배열을 만들어서 해당 행과 열의 평균값을 저장

        for (int row = x1; row <= x2; row++) {
            for (int col = y1; col <= y2; col++) {
                tempArr[row][col] = getAver(row, col);
            }
        }

        for (int row = x1; row <= x2; row++) {
            for (int col = y1; col <= y2; col++) {
                arr[row][col] = tempArr[row][col];
            }
        }
    }

    public static void shift(int x1, int y1, int x2, int y2){

        int tmp = arr[x1][y1]; // 1 - 1


        // 1 - 2
        for (int row = x1; row < x2; row++) {
            arr[row][y1] = arr[row + 1][y1];
        }

        // 1 - 3
        for (int col = y1; col < y2  ; col++) {
            arr[x2][col] = arr[x2][col + 1];
        }

        // 1 - 4
        for (int row = x2; row > x1 ; row --) {
            arr[row][y2] = arr[row - 1][y2];
        }

        // 1 - 5
        for (int col = y2; col > y1 ; col --) {
            arr[x1][col] = arr[x1][col - 1];
        }
        arr[x1][y1 + 1] = tmp;


//        for (int i = 0; i < n ; i++) {
//            for (int j = 0; j < m ; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

    }


    public static void simulate(int x1, int y1, int x2, int y2){

        //  step 01 : 해당 영역에 존재하는 원소들을 시계방향으로 한 칸 씩 회전
             // 1 - 1 : 좌측 상단 원소를 tmp 변수에 대입(저장)
             // 1 - 2 : 왼쪽 열 위로 이동
             // 1 - 3 : 아래 행 왼쪽으로 이동
             // 1 - 4 : 오른쪽 열 아래로 이동
             // 1 - 5 : 위쪽 행 오른쪽으로 이동
             // 1 - 6 : tmp 값을 좌측 상단 마로 오른쪽 칸에 대입

        shift(x1,y1,x2,y2);


        // step 02 : 모든 원소 이동 후, 각 원소의 상하좌우 값의 평균값으로 해당 원소 변경
        calAllAver(x1,y1,x2,y2);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }


        while(q -- > 0){
            int startRow = sc.nextInt() - 1;
            int startCol = sc.nextInt() - 1;

            int endRow = sc.nextInt() - 1;
            int endCol = sc.nextInt() - 1;

            simulate(startRow, startCol, endRow, endCol);
        }

        printResult();
    }
}
