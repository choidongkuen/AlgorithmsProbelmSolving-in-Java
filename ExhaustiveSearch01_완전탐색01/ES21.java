// 날짜 : 2022/ 09/ 04
// 문제 : 가장많이 겹치는 선분의 개수 구하기
// 문제 설명 :
// n개의 선분이 정보가 주어질때, 하나의 선분을 제거하여 얻을 수 있는 최대 겹치는 횟수는?
// 예시 : n = 5, arr = {{1,3},{2,4},{5,8},{7,8}}
// 예시 답안 : 2
package ExhaustiveSearch01_완전탐색01;

import java.util.Scanner;

public class ES21 {
    public static final int MAX_N = 100; // 선분의 최대 수
    public static final int MAX_LOC = 10; // 구간의 최대값
    public static int[][] arr = new int[MAX_N][2]; // 선분 정보(start - end)를 담을 2차원 배열

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 선분의 수

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt(); // start
            arr[i][1] = sc.nextInt(); // end
        } // 선분 정보를 담은 배열 완성

        int ans = 100;
        for(int i = 0; i < n; i++){ // i번째 선분 제외
            int[] count = new int[MAX_LOC + 1];

            for(int j = 0; j < n; j++){
                if(i == j) continue;

                int start = arr[j][0];
                int end = arr[j][1];

                for(int s = start; s <= end; s++){
                    count[s]++;
                }
                int cnt = 0;
                for(int s = 0; s <= MAX_LOC; s++){
                    cnt = Math.max(cnt, count[s]);
                }
                ans = Math.max(ans, cnt);
            }
        }
        System.out.println(ans);
    }
}
