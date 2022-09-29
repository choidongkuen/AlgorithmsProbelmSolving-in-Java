// 날짜 : 2022/09/28
// 문제 : 강력한 폭발
// 문제 설명 :
// 0, 1로 구성된 n * n 크기의 격자판이 주어집니다. 1은 해당 위치에 폭탄이 놓이게 됨을 의미합니다. 1이 써있는 위치에 각각 다음 3가지 중 하나의 폭탄을 선택하여 초토화시킬 지역의 수를 최대화 하려고 합니다.
// 각 폭탄은 폭탄위치를 포함하여 밑에 제시된 방법으로 영역을 초토화시키게 된다.

// 0,1,0
// 0,1,0
// 0,b,0
// 0,1,0
// 0,1,0
// 1번 폭탄

// 0,1,0
// 1,b,1
// 0,1,0
// 2번 폭탄

// 1,0,1
// 0,b,0
// 1,0,1
// 3번 폭탄

// b : 폭탄이 놓여야 할 위치

// 아이디어 :
// 폭탄이 놓여야 할 위치를 입력받을 때, 인스턴스화 하여 저장한다.
// 또한 특정 위치에 있는 폭탄들을 3가지의 폭탄 중 하나로 설정했을때, 터질 수 있는 영역을 표시하는 2차원 배열을 만든다.
// 각 x개의 폭탄이 갖을 수 있는 '모든 폭탄의 타입'을 고려하여, x개의 타입이 모두 정해질때마다 터질 수 있는 영역을 계산하여 업데이트
// 재귀적 메소드 호출이 필요하며 이를 위해 백트랙킹 기법으로 문제에 접근


package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;


public class BT04{

    public static final int MAX_N = 20; // n의 최대값
    public static final int BOMB_TYPE = 3; // 3가지의 폭탄 유형

    public static boolean[][] bombed = new boolean[MAX_N][MAX_N]; // 터지는 폭탄의 영역을 기록할 2차원 배열
    public static int[][][] bombShapes = {{{}},{{-2,0},{-1,0},{0,0},{1,0},{2,0}},
                                                {{-1,0},{1,0},{0,1},{0,0},{0,-1}},
                                                {{-1,-1},{1,1},{0,0},{1,-1},{-1,1}}}; // 각 타입일때 좌표 이동을 위한 3차원 배열

     /*
    public static Bomb[][] bombShapes = {
            {},
            {new Bomb(-2, 0), new Bomb(-1, 0), new Bomb(0, 0), new Bomb(1, 0), new Bomb(2, 0)},
            {new Bomb(-1, 0), new Bomb(1, 0), new Bomb(0, 0), new Bomb(0, -1), new Bomb(0, 1)},
            {new Bomb(-1, -1), new Bomb(-1, 1), new Bomb(0, 0), new Bomb(1, -1), new Bomb(1, 1)}
    };*/

    public static ArrayList<Bomb> bombPos = new ArrayList<>(); // 주어지는 폭탄 정보를 이용해 폭탄 객체를 저장할 배열리스트
    public static int[][] bombType = new int[MAX_N][MAX_N]; // 주어지는 x개의 폭탄의 타입을 저장할 2차원 배열

    public static int n; // 주어지는 격자 크기
    public static int size; // 가장 많이 초토화시킬 수 있는 영역의 크기

    static class Bomb{

        int x;
        int y;
        public Bomb(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkRange(int x, int y){
        return x >= 0 && x < n && y >= 0 && y < n;
    }
    public static void bomb(int x, int y, int type){

        for (int i = 0; i < 5; i++) {
            int nx = x + bombShapes[type][i][0];
            int ny = y + bombShapes[type][i][1];

            if(checkRange(nx,ny))
                bombed[nx][ny] = true;

        }
    }

    public static void initialize(){ // 이전에 기록된 폭탄의 기록을 초기화 하는 메소드
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                bombed[i][j] = false;
            }
        }
    }

    public static int calcArea(){

        initialize(); // 초기화

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                if(bombType[i][j] > 0){ // 해당 영역은 bombType[i][j] 유형으로 터져야 한다.
                    bomb(i,j,bombType[i][j]);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if(bombed[i][j])
                    cnt++;
            }
        }

        return cnt; // 색칠된 영역의 갯수 리턴
    }

    public static void backtracking(int cnt){ // cnt번째 폭탄의 타입 처리

        if(cnt == bombPos.size()) { // 모든 x 개의 폭탄의 타입을 정한 상태
            size = Math.max(size, calcArea());
            return;
        }

        int x = bombPos.get(cnt).x;
        int y = bombPos.get(cnt).y;

        for (int i = 1; i <= BOMB_TYPE ; i++) {
            bombType[x][y] = i; // x행 y열에 위치한 폭탄의 타입을 i로 설정
            backtracking(cnt + 1); // 다음 폭탄의 유형을 결정하기 위해 재귀적 호출
            bombType[x][y] = 0; // 해당 위치 다시 0으로 초기화
        }

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                int loc = sc.nextInt();
                if(loc == 1){
                    bombPos.add(new Bomb(i,j)); // i,j 위치한 폭탄을 인스턴스화 하여 배열리스트에 저장
                }
            }
        }
        // bombPos 배열리스트에 사이즈가 곧 폭탄의 갯수

        backtracking(0); // 0번째 폭탄부터 시작
        System.out.println(size);
    }
}