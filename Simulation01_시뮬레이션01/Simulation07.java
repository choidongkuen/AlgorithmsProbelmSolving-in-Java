// 날짜 : 2022 /09 /03
// 문제 : 거울에 레이저 쏘기
// 문제 설명 : N * N 크기의 격자 안에 각 칸마다 거울이 하나씩 들어 있습니다. 각 거울은 \나 /의 형태를 띄고있고,
// 격자 밖 4N개의 위치 중 특정 위치에서 레이저를 쏘았을 때, 거울에 튕기는 횟수를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 N이 주어집니다.
// 두 번째 줄부터 N개의 줄에 걸쳐 맵의 정보가 주어집니다. 각 줄에는 각 행에 해당하는 정보가 공백없이 주어집니다. 이는 /나 \ 문자로만 이루어져 있습니다.
// 그 다음 줄에는 레이저를 쏘는 위치 K가 주어집니다. K는 다음과 같이 위에서 아래 방향으로 1행 1열 칸으로 들어오는 곳을 1번으로 하여
// 시계 방향으로 돌며 가능한 시작 위치에 순서대로 번호를 붙여 4N 번을 마지막으로 했을 때의 번호들 중 하나의 값으로 주어집니다.

// 입력 예제 :
// 3
// /\\
// \\\
// /\/
// 2

// 출력 예제 :
// 3

package Simulation01_시뮬레이션01;

import java.util.*;

public class Simulation07 {
    public static final int MAX_N = 1000; // 최대 격자 크기
    public static char[][] arr = new char[MAX_N][MAX_N];
    public static int n,dirNum; // 격자 크기, 방향 번호
    public static int row,col; // 특정 순간에 행,열
    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,-1,0,1}; // 남 서 북 동
    public static int ans = 0; // 튕긴 횟수

    public static void initialize(int startNum){
        if(startNum <= n){
            dirNum = 0;
            row = 0;
            col = startNum - 1;
        }else if(startNum <= 2 * n){
            dirNum = 1;
            row = startNum - n - 1;
            col = n - 1;
        }else if(startNum <= 3 * n){
            dirNum = 2;
            row = n - 1;
            col = 3 * n - startNum;
            //col = n - (startNum - 2 * n);
        }else{
            dirNum = 3;
            row = 4 * n - startNum;
            col = 0;
        }
    }
    public static boolean checkRange(int row, int col){ // 영역 체크하는 메서드
        return row >= 0 && row < n && col >= 0 && col < n;
    }
    public static void simulation(){

        while(checkRange(row,col)){
            ans ++;

            if(arr[row][col] == '/'){
                /*
               if(dirNum == 0 || dirNum == 2){
                   dirNum += 1;
               }else{
                   dirNum -= 1;
               }*/
                dirNum = dirNum ^ 1; // 0 <-> 1, 2 <-> 3
            }else{
                dirNum = 3 - dirNum; // 3 <-> 0, 1 <-> 2
            } // 방향 바꾸기

            row = row + dx[dirNum];
            col = col + dy[dirNum];
        }
    }
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 행,열 개수 입력

        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j);
            } // 2차원 배열 완성
        }

        int startNum = sc.nextInt(); // 시작 위치 입력
        initialize(startNum); // dirNum,시작 위치에 대한 초기화

        simulation(); // 시뮬레이션 메서드

        System.out.println(ans);

    }
}