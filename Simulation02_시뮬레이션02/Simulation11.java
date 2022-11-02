package Simulation02_시뮬레이션02;


import java.util.Scanner;

// 두개의 직사각형이 잡을 수 있는 모든 영역을 확인

public class Simulation11 {

    public static final int MAX = 5;
    public static final int OFFSET = 1000;
    public static int[][] arr = new int[MAX][MAX];
    public static int[][] visited;
    public static int n,m;
    public static int ans = Integer.MIN_VALUE;

    public static void initialize(){

        visited = new int[n][m];
    }

    public static int getSum(int x1, int x2, int y1, int y2, int i, int k, int j, int l){

        int sum = 0;

        for (int o = x1; o <= x2 ; o++) {
            for (int p = y1; p <= y2 ; p++) {
                sum += arr[o][p];
            }
        }

        for (int o = i; o <= k  ; o++) {
            for (int p = j; p <= l; p++) {
                sum += arr[o][p];
            }
        }

        return sum;
    }


    public static void record(int x1, int x2, int y1, int y2, int i, int k, int j, int l){
        // 정해진 두 직사각형의 범위에 따라 기록

        initialize(); //  초기화

        for (int o = x1; o <= x2 ; o++) {
            for (int p = y1; p <= y2 ; p++) {
                visited[o][p] ++;
            }
        } // 첫번째 직사각형 방문 처리

        for (int o = i; o <= k ; o++) {
            for (int p = j; p <= l ; p++) {
                visited[o][p] ++;
            }
        } // 두번째 직사각형 방문 처리

        for (int o = 0; o < n; o++) {
            for (int p = 0; p < m ; p++) {
                if(visited[o][p] >=  2){
                    return;
                } // 하나라도 겹치는 부분이 존재
            }
        }

        // 하나라도 겹치는 부분이 없다면
        // 해당 영역의 정수값의 합
        int val = getSum(x1,x2,y1,y2,i,k,j,l);
        ans = Math.max(ans, val);
    }

    public static void getVal(int x1, int x2, int y1, int y2){

        for (int i = 0; i < n ; i++) { // 첫번째 행
            for (int j = 0; j < m ; j++) { // 첫번째 열
                for (int k = i; k < n ; k++) { // 두번째 행
                    for (int l = j; l < m ; l++) { // 두번째 열
                        record(x1,x2,y1,y2,i,k,j,l);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();


        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 원소 입력받고
        for (int i = 0; i < n ; i++) { // 첫번째 행
            for (int j = 0; j < m ; j++) { // 첫번째 열
                for (int k = i; k < n ; k++) { // 두번째 행
                    for (int l = j; l < m ; l++) { // 두번째 열
                        getVal(i,k,j,l);

                        // 만약 k = i + 1, l = j + 1이라고 하면
                        // k 혹은 l 이 마지막 행 혹은 열일 때 고려 대상이 되지 못한다.(난 이걸 왜 몰랐을까..)

                    }
                }
            }
        }

        System.out.println(ans);

    }
}
