// 날짜 : 2022 / 09 / 04
// 문제 : 구간 정하기
// 문제 설명 : n개의 원소가 주어질때, 구간을 잡아 합을 구할때, 합이 최대가 되도록해보세요.
// 예시 : n = 6, arr = {4, -5, 8, -1, -6, 9}
// 예시 답 : 10


package ExhaustiveSearch01_완전탐색01;

import java.util.Scanner;

public class ES10 {
    public static final int MAX_N = 100; // 원소의 최대 갯수
    public static int[] arr = new int[MAX_N]; // 주어지는 숫자를 원소로 하는 1차원 배열 선언
    public static int ans = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 주어지는 원소의 갯수

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        } // 배열 생성

        for(int i = 0; i < n; i++){ // 시작 점
            for (int j = i; j < n; j++) {
                int sumVal = 0;

                for(int k = i; k <= j; k++){
                    sumVal += arr[k];
                }
                ans = Math.max(ans, sumVal);
            }
        }

        System.out.println(ans);
    }
}
