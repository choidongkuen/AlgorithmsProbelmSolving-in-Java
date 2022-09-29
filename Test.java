import java.util.ArrayList;
import java.util.Scanner;

/*

public class Test {
    public static final int MAX_N = 20; // n의 최대값
    public static final int BOMB_TYPE = 3; // 3가지의 폭탄

    public static int n; // 격자의 크기
    public static int[][] bombType = new int[MAX_N][MAX_N];
    public static boolean[][] bombed = new boolean[MAX_N][MAX_N]; // 특정 타입으로 폭탄들을 설정했을 때 터지는 영역을 기록하기 위한 2차원 배열
    public static int size; // 가장 많이 초토화시킬 수 있는 영역의 크기

    public static ArrayList<Bomb> bombPos = new ArrayList<>(); // 폭탄의 위치정보를 갖는 인스턴스를 저장할 인스턴스 배열
    public static BackTracking_백트랙킹.BT04.Bomb[][] bombShapes = {{},
            {new BackTracking_백트랙킹.BT04.Bomb(-2, 0), new BackTracking_백트랙킹.BT04.Bomb(-1, 0), new BackTracking_백트랙킹.BT04.Bomb(0, 0), new BackTracking_백트랙킹.BT04.Bomb(1, 0), new BackTracking_백트랙킹.BT04.Bomb(2, 0)},
            {new BackTracking_백트랙킹.BT04.Bomb(-1, 0), new BackTracking_백트랙킹.BT04.Bomb(1, 0), new BackTracking_백트랙킹.BT04.Bomb(0, 0), new BackTracking_백트랙킹.BT04.Bomb(0, -1), new BackTracking_백트랙킹.BT04.Bomb(0, 1)},
            {new BackTracking_백트랙킹.BT04.Bomb(-1, -1), new BackTracking_백트랙킹.BT04.Bomb(1, -1), new BackTracking_백트랙킹.BT04.Bomb(0, 0), new BackTracking_백트랙킹.BT04.Bomb(-1, 1), new BackTracking_백트랙킹.BT04.Bomb(1, 1)}
    }; // 3가지 유형에 따른 터지는 영역을 인스턴스화 해놓은 2차원 배열


    static class Bomb {
        int x;
        int y;

        public Bomb(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } // 폭탄 위치에 대한 클래스

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    } // 범위 체크하는 메소드

    public static void bomb(int x, int y, int bType) { // x,y 위치에 기록된 폭탄 타입을 근거로 터지는 영역을 기록

        for (int i = 0; i < 5; i++) {
            int nextX = x + bombShapes[bType][i].x;
            int nextY = y + bombShapes[bType][i].y;

            if (checkRange(nextX, nextY)) // 영역을 벗어나지 않는다면
                bombed[nextX][nextY] = true; // 터지는 것을 기로
        }

    }

    public static int calc() { // x 개의 폭탄의 타입이 결정된 후, 터지는 영역을 기록하기 위한 메소드

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bombed[i][j] = false;
            }
        } // 폭탄이 터진 위치를 표시하는 배열을
        // 초기화하기

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombType[i][j] > 0) // 해당 i,j 칸은 특정 타입으로 폭탄이 터져야 함
                    bomb(i, j, bombType[i][j]);
            }
        } // i,j 가 터져야 할 위치이면
        // 초토화 되는 영역을 표시한다.

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bombed[i][j])
                    cnt++;
            }
        }
        return cnt;
    }

    public static void backTracking(int cnt) { // cnt =  터져야 하는 폭탄을 처리한 갯수
        if (cnt == bombPos.size()) { // 처리해야할 폭탄의 타입을 모두 설정했으면
            size = Math.max(size, calc()); // 터지는 영역 계산 후, size 업데이트
            return;
        }

        for (int i = 1; i <= BOMB_TYPE; i++) {
            int x = bombPos.get(cnt).x;
            int y = bombPos.get(cnt).y; // cnt 번째에 있는 폭탄의 좌표(x,y)

            bombType[x][y] = i; // x,y 위치에 놓여야 할 폭탄을 i 타입으로 설정
            backTracking(cnt + 1); // 다음 폭탄 처리를 위해 backTracking 메소드 재귀 호출
            bombType[x][y] = 0; // 다시 해당 영역을 0으로 만들기
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int bombPlace = sc.nextInt();

                if (bombPlace == 1)
                    bombPos.add(new BackTracking_백트랙킹.BT04.Bomb(i, j)); // 폭탄이 있는 위치를 갖는 폭탄 인스턴스 생성 및
                // 폭탄 배열에 저장
            }
        } // 폭탄 배열에 대한 정보 입력

        backTracking(0);
        System.out.println(size); // 답 출력
    }
}
*/

