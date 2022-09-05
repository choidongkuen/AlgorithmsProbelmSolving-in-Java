package Simulation_시뮬레이션;

import java.util.Scanner;

public class Test{
    public static final int WILL_EXPLODE = 0;
    public static final int BLANK = -1;
    public static final int MAX_NUM = 100;

    public static int n, m, k, endOfNumbers_1d, endOfTemp_1d;
    public static int[][] numbers_2d = new int[MAX_NUM][MAX_NUM];
    public static int[] numbers_1d = new int[MAX_NUM];
    public static int[][] temp_2d = new int[MAX_NUM][MAX_NUM];
    public static int[] temp_1d = new int[MAX_NUM];

    // 주어진 시작점에 대하여
    // 부분 수열의 끝 위치를 반환합니다.
    public static int getEndIdxOfExplosion(int startIdx, int currNum) {
        int endIdx = startIdx + 1;
        while(endIdx < endOfNumbers_1d) {
            if(numbers_1d[endIdx] == currNum)
                endIdx++;
            else{
                break;
            }
        }

        return endIdx - 1;
    }

    // 터져야 할 폭탄들에 대해 터졌다는 의미로 0을 채워줍니다.
    public static void fillZero(int startIdx, int endIdx) {
        for(int i = startIdx; i <= endIdx; i++) {
            numbers_1d[i] = WILL_EXPLODE;
        }
    }

    // Arr에서 폭탄이 터진 이후의 결과를 Temp에 임시로 저장합니다.
    public static void moveToTemp() {
        endOfTemp_1d = 0;
        for(int i = 0; i < endOfNumbers_1d; i++) {
            if(numbers_1d[i] != WILL_EXPLODE) {
                temp_1d[endOfTemp_1d++] = numbers_1d[i];
            }
        }
    }

    // Temp배열을 그대로 Copy하여 Arr에 저장합니다.
    public static void copyFromTemp() {
        endOfNumbers_1d = endOfTemp_1d;
        for(int i = 0; i < endOfNumbers_1d; i++) {
            numbers_1d[i] = temp_1d[i];
        }
    }

    public static void explode() {

        boolean didExplode;
        do {
            didExplode = false;
            for(int currIdx = 0; currIdx < endOfNumbers_1d; currIdx++) {
                // 각 위치마다 그 뒤로 폭탄이 m개 이상 있는지 확인합니다.

                // 이미 터지기로 예정되어있는 폭탄은 패스합니다.
                if(numbers_1d[currIdx] == WILL_EXPLODE) {
                    continue;
                }
                // currIdx로부터 연속하여 같은 숫자를 갖는 폭탄 중
                // 가장 마지막 위치를 찾아 반환합니다.
                int endIdx = getEndIdxOfExplosion(currIdx, numbers_1d[currIdx]);

                if(endIdx - currIdx + 1 >=  m) {
                    // 연속한 숫자의 개수가 m개 이상인 경우 폭탄이 터졌음을 기록해줍니다.
                    fillZero(currIdx, endIdx);
                    didExplode = true;
                }
            }

            // Arr에서 폭탄이 터진 이후의 결과를 Temp에 임시로 저장합니다.
            moveToTemp();
            // Temp배열을 그대로 Copy하여 Arr에 저장합니다.
            copyFromTemp();
        }
        while(didExplode); // 더 이상 폭탄이 터질 수 없을 때까지 반복합니다.

    }

    //////////////////////////////////////////////////////////////////////////////////
    //이 줄을 기준으로 위에 있는 함수들에 대한 설명은 1차원 폭발 게임을 참조해주세요//
    //////////////////////////////////////////////////////////////////////////////////

    // 격자의 특정 열을 일차원 배열에 복사해줍니다.
    public static void copyColumn(int col){
        endOfNumbers_1d = 0;
        for(int i = 0; i < n; i++)
            if(numbers_2d[i][col] != BLANK)
                numbers_1d[endOfNumbers_1d++] = numbers_2d[i][col];

        return;
    }

    // 폭탄이 터진 결과를 격자의 해당 열에 복사해줍니다.
    public static void copyResult(int col){
        int resultIdx = endOfNumbers_1d - 1;
        for(int i = n - 1; i >= 0; i--) {
            if(resultIdx >= 0)
                numbers_2d[i][col] = numbers_1d[resultIdx--];
            else
                numbers_2d[i][col] = BLANK;
        }
    }

    // 폭탄이 터지는 과정을 시뮬레이션 합니다.
    public static void simulate() {
        for(int col = 0; col < n; col++) {
            copyColumn(col);
            explode();
            copyResult(col);
        }
    }

    // 시계 방향으로 90도 회전해줍니다.
    public static void rotate() {
        // 임시 격자를 빈 칸으로 초기화해줍니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                temp_2d[i][j] = BLANK;

        // 기존 격자를 시계 방향으로 90도 회전했을 때의 결과를
        // 임시 격자에 저장해줍니다.
        int currIdx;
        for(int i = n - 1; i >= 0; i--) {
            currIdx = n - 1;
            for(int j = n - 1; j >= 0; j--) {
                if(numbers_2d[i][j] != BLANK)
                    temp_2d[currIdx--][n - i - 1] = numbers_2d[i][j];
            }
        }

        // 임시 격자에 저장된 값들을 기존 격자에 복사합니다.
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                numbers_2d[i][j] = temp_2d[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                numbers_2d[i][j] = sc.nextInt();

        // 주어진 입력에 따라 폭탄이 터지는 것을 시뮬레이션 합니다.
        simulate();
        for(int i = 0; i < k; i++) {
            rotate();
            simulate();
        }

        // 격자를 순회하며 남아 있는 폭탄의 개수를 세줍니다.
        int answer = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(numbers_2d[i][j] != BLANK)
                    answer++;

        System.out.print(answer);
    }
}