// 날짜 : 2022 / 09 / 04
// 문제 : 아름다운 수열 2
// 문제 설명 :
// 이루어진 수열 A와 M개의 숫자로 이루어진 수열 B가 주어집니다. 수열 B의 각 원소들의 순서를 바꿔 나오는 수열을 아름다운 수열이라고 합니다.
// 수열 A에서 길이가 M인 연속 부분 수열들 중 아름다운 수열의 수를 세는 프로그램을 작성해보세요.
// 예를 들어 수열 B를 “4 6 7“이라 했을 때 "4 6 7", "4 7 6", "6 4 7", "6 7 4", "7 4 6", "7 6 4"는 모두 아름다운 수열이 됩니다.

// 입력 형식 :
// 첫 번째 줄에는 N, M이 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 수열 A에 해당하는 N개의 숫자가 공백을 사이에 두고 주어집니다.
// 세 번째 줄에는 수열 B에 해당하는 M개의 숫자가 공백을 사이에 두고 주어집니다.
// 1 ≤ N ≤ 100
// 1 ≤ M ≤ 100
// 1 ≤ 입력으로 주어지는 숫자 ≤ 100

// 입력 예시 :
// 8 3
// 2 4 6 7 5 7 6 4
// 4 6 7

// 출력 예시 :
// 2


package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES16 {
    public static final int MAX = 100;
    public static int[] arrA = new int[MAX];
    public static int[] arrB = new int[MAX]; // A,B 수열
    public static int[] temp = new int[MAX]; // A 수열로부터 구간을 잡은 특정 서브 배열이 아름다운 수열에 해당하는지
    // 확인하기 위한 용도 - > 매 구간마다 새로 정의
    public static int ans = 0; // 아름다운 수열의 개수

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0; i < n; i++){
            arrA[i] = sc.nextInt();
        } // 수열 A 채우기

        for(int i = 0; i < m; i++){
            arrB[i] = sc.nextInt();
        } // 수열 B 채우기

        Arrays.sort(arrB,0,m); // 0 - m 오름차순 정렬

        for(int i = 0; i <= n - m; i ++){
            for(int j = 0; j < m; j++){
                temp[j] = arrA[i + j];
            }

            Arrays.sort(temp,0,m); // temp배열 오름차순 정렬
            boolean isBeautiful = true;

            for(int j = 0; j < m; j++){
                if(temp[j] != arrB[j]){
                    isBeautiful = false; // 아름다운 수열 x
                    break;
                }
            }

            if(isBeautiful) // 특정 구간이 아름다운 수열이라면
                ans++; // 경우의수 + 1
        }
        System.out.println(ans);
    }
}
