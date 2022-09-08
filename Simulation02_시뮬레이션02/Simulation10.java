// 날짜 : 2022/09/09
// 문제 : 숫자의 순차적 이동
// 문제 설명 :
// 1이상 n * n이하의 숫자들이 정확히 한번씩만 등장하는 n * n 크기의 격자판 정보가 주어집니다.
// 이때 m번의 턴에 걸쳐 숫자들을 이동하려고 합니다. 한 번의 턴에는 숫자 1이 적힌 위치에서부터 숫자 n * n이 적힌 위치까지 순서대로 하나씩 보면서 특정 조건에 맞춰 다들 한번씩 움직입니다.
// 이 조건이란, 각 위치에서 여덟방향으로 인접한 칸들 중 가장 큰 숫자와 가운데 칸의 숫자를 교환하는 것입니다.

// 입력 형식 :
// 첫 번째 줄에는 격자의 크기를 나타내는 n과 턴의 수를 나타내는 m 값이 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 행에 해당하는 n개의 숫자가 공백을 사이에 두고 주어집니다.
// 1이상 n * n이하의 숫자가 정확히 한 번씩만 나온다고 가정해도 좋습니다.
// 2 ≤ n ≤ 20
// 1 ≤ m ≤ 100

// 입력 예시1 :
// 4 1
// 15 13 1 11
// 4 8 3 5
// 2 12 16 7
// 14 6 9 10

// 출력 예시1 :
// 4 1 13 11
// 8 12 5 7
// 6 15 3 9
// 2 14 16 10

// 입력 예시2 :
// 4 2
// 15 13 1 11
// 4 8 3 5
// 2 12 16 7
// 14 6 9 10

// 출력 예시2 :
// 13 4 1 9
// 12 15 7 11
// 14 2 5 16
// 6 8 3 10

package Simulation02_시뮬레이션02;
import java.util.*;

class Point2{
    int x,y;
    Point2(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Simulation10 {

    public static final int MAX_N = 20; // n의 최대값
    public static final int moveNum = 8; // 8방향
    public static int[][] arr = new int[MAX_N][MAX_N]; // n*n개의 원소들을 담을 2차원 배열
    public static int n,m; // 격자의 크기, 턴의 수
    public static int[] dx = {0,-1,-1,-1,0,1,1,1};
    public static int[] dy = {1,1,0,-1,-1,-1,0,1};

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    public static Point findPos(int target){
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(arr[i][j] == target)
                    return new Point(i,j);

        return new Point(0,0);
    }

    public static void moveAll(int target){

        Point p = findPos(target); // target의 위치 찾는 매서드 호출
        int maxVal = -1;

        int x = p.x;
        int y = p.y;

        for(int i = 0; i < moveNum; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(checkRange(nextX,nextY) && arr[nextX][nextY] > maxVal){ // 격자를 벗어나지 않으며, 기존의 값보다 더 클 때
                p = new Point(nextX,nextY); // 위치 업데이트
                maxVal = arr[p.x][p.y]; // 최대값 업데이트
            }
        }
        int temp = arr[x][y];
        arr[x][y] = maxVal;
        arr[p.x][p.y] = temp; // 값 교환
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt(); // 2차원 배열 원소 입력

        for(int i = 0; i < m; i++){ // m턴 반복
            for(int j = 1; j <= n*n; j++){ // j를 이동할 차례
                moveAll(j); // 메서드 호출
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        } // 출력
    }
}