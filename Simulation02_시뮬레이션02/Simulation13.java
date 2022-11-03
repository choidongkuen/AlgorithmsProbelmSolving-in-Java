// 날짜 : 2022/11/03
// 문제 : 1차원 바람
// 문제 설명 :
// 0이상 9이하의 숫자로만 이루어진 N*M 행렬 모양의 건물에 총 Q번의 바람이 붑니다.
// 바람은 특정 행의 모든 원소들을 왼쪽 혹은 오른쪽으로 전부 한 칸씩 밀어 shift 하는 효과를 가져옵니다.
// 이 바람에 영향을 받아 특정 행의 숫자들이 한 칸씩 밀리게 되면, 위 아래로도 영향을 미치기 시작합니다.
// 밀리기 시작한 행을 기준으로 위 아래 방향으로 순차적으로 전파가 되며 도중에 전파 방향이 바뀌는 경우는 없습니다
// 전파가 이어질 조건은 현재 행과 나아가려는 행을 비교했을 때, 단 하나라도 같은 열에 같은 숫자가 적혀있는 경우라면 전파를 이어나갑니다.
// 같은 숫자가 하나도 존재하지 않거나 끝에 다다랐다면 전파를 종료합니다. 전파가 진행되는 경우 나아가려는 행의 숫자들을 한 칸씩 밀게되며, 현재 행이 밀렸던 방향과 반대 방향으로 작용합니다.

// 입력 형식 :
// 첫째 줄에는 행렬의 크기를 나타내는 N과 M 그리고 총 바람이 불어온 횟수를 의미하는 Q가 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터 N개의 줄에 걸쳐 한 줄에 M개 씩 건물의 상태를 나타내는 0이상 9이하의 숫자가 공백을 사이에 두고 주어집니다.
// 그 다음 줄 부터는 Q개의 줄에 걸쳐 불어오는 바람에 대한 정보 (r, d)가 공백을 사이에 두고 주어집니다. r은 바람에 영향을 받는 행 번호를 의미하며 d는 바람이 불어오는 방향을 의미합니다. d는 ‘L' 또는 ‘R’의 값을 가지며, ‘L’은 바람이 왼쪽에서 불어온다는 것을 'R’은 바람이 오른쪽에서 불어온다는 것을 의미합니다.
// 1 ≤ r ≤ N
// 1 ≤ N ≤ 100
// 1 ≤ M ≤ 10
// 0 ≤ Q ≤ 100

// 입력 예시 01 :
// 6 5 1
// 1 5 6 7 3
// 5 3 2 5 4
// 6 4 5 2 5
// 2 6 1 0 5
// 5 1 2 1 6
// 4 2 5 2 8
// 3 L

// 출력 예시 01 :
// 1 5 6 7 3
// 3 2 5 4 5
// 5 6 4 5 2
// 6 1 0 5 2
// 6 5 1 2 1
// 2 5 2 8 4


package Simulation02_시뮬레이션02;

import java.util.ArrayList;
import java.util.Scanner;

public class Simulation13 {

    static class Info{
        int start;
        char dir;
        // 각 q 번의 시작위치와 방향
        // 방향 : L or R(0 : 1)

        public Info(int start, char dir) {
            this.start = start;
            this.dir = dir;
        }
    }

    public static final int MAX = 100;

    public static int n,m,q;
    public static int[][] arr = new int[MAX][MAX];
    public static ArrayList<Info> info = new ArrayList<>();

    public static boolean hasSameNumber(int firstRow, int secondRow){ // 두 행 중에 같은 원소가 있는지 확인하는 메소드


        for (int i = 0; i < m ; i++) {
            if(arr[firstRow][i] == arr[secondRow][i]){
                return true; // 하나라도 동일 원소가 있다면 true
            }
        }
        return false;
    }

    public static int flipDir(int dir) { // 방향을 뒤집어주는 메소드
        dir = (dir == 0 ? 1 : 0);
        return dir;
    }

    public static void shift(int row, int dir) { // 특정 방향으로 이동시키는 메소드
        // dir == 0(왼쪽으로 이동하는 경우)
        if (dir == 1) {
            int tmp = arr[row][0];

            for (int i = 0; i < m - 1; i ++) {
                arr[row][i] = arr[row][i + 1];
            }

            arr[row][m - 1] = tmp;
            // dir == 1(오른쪽으로 이동하는 경우)
        } else if (dir == 0) {
            int tmp = arr[row][m - 1];

            for (int i = m - 1; i >= 1; i --) {
                arr[row][i] = arr[row][i - 1];
            }
            arr[row][0] = tmp;
        }
    }


    public static void simulate(int startRow, int startDir){

        // step 1 : 처음 위치의 행에서 처음 방향으로 이동시키기!
        shift(startRow,startDir);
        
        // 처음 방향 반전
        startDir = flipDir(startDir);

        // step 2: 위 방향으로 전파 시도
        for (int row = startRow ,dir = startDir; row >= 1 ; row-- ) {

            if(hasSameNumber(row, row - 1)){
                shift(row - 1 ,dir); // 바로 위에 행 처리 후,
                dir = flipDir(dir); // 방향 변경
            }else{
                break; // 더이상 고려 x
            }
        }
        
        // step 3: 아래 방향으로 전파 시도
        for (int row = startRow, dir = startDir; row <= n - 2 ; row++) {

            if(hasSameNumber(row, row + 1)){
                shift(row + 1, dir); // 바로 밑에 행 처리 후,
                dir = flipDir(dir); // 빙향 변경
            }else{
                break;
            }
        }
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
        } // 원소 입력

        for (int i = 0; i < q ; i++) {

            int start = sc.nextInt() - 1;
            char dir = sc.next().charAt(0);

            info.add(new Info(start,dir));
        } // q개의 정보를 저장

        for (int i = 0; i < q ; i++) {
            int start = info.get(i).start;
            int dir = info.get(i).dir == 'R'? 1 : 0;
            System.out.println(dir);

            simulate(start,dir);
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        } // 출력 단계
    }
}
