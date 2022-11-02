package DynamicProgramming02_동적계획법02;

// 날짜 : 2022/11/2
// 문제 : 최대 증가 부분 수열
// 문제 설명 :
// N개의 숫자가 주어졌을 때, 가장 긴 증가 부분 수열의 길이를 구하는 프로그램을 작성해보세요
// 부분 수열이란 수열의 원소들 중 임의로 몇 개를 골라 순서대로 나열한 수열을 의미하고, 이때 순서대로 나열했을 때 원소들이 계속 증가한다면 이 수열을 증가 부분 수열이라고 합니다.
// 예를 들어, N=6, 주어진 수열이 1,6,4,3,9,3 이라 했을 때
// 1,3,6은 순서대로 나열해 만들 수 없으므로 부분 수열이라 할 수 없습니다.
// 1,6,3은 부분 수열 이지만 계속 증가하는 수열이 아니므로 증가 부분 수열은 아닙니다.
// 1,3,3은 부분 수열 이지만 역시 마찬자기로 계속 증가하는 수열이 아니므로 증가 부분 수열은 아닙니다.
// 1,4,9는 계속 증가하는 부분 수열이므로 증가 부분 수열 입니다.

// 입력 형식 :
// 첫째 줄에는 N이 주어집니다.
// 두 번째 줄에는 N개의 숫자가 공백을 사이에 두고 주어집니다.
// 1≤N≤1,000
// 1≤ 수열의 원소 (M)≤10,000

// 입력 에시 01 :
// 4
// 1 3 2 4

// 출력 예시 01 :
// 3


import java.util.Arrays;
import java.util.Scanner;

public class Dp03 {
        public static final int MAX = 1000;

        public static int n;
        public static int[] arr = new int[MAX + 1];
        public static int[] dp = new int[MAX + 1];
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();

            for (int i = 1; i <= n ; i++) {
                arr[i] = sc.nextInt();
            }

            dp[1] = 1;
            // 시작 위치의 최대 증가 부분 수열의 길이 = 1

            for (int i = 2; i <= n ; i++) {

                int MAX = Integer.MIN_VALUE;
                for (int j = 1; j < i ; j++) {

                    if(arr[j] < arr[i]){
                        dp[i] = Math.max(dp[i], dp[j]);
                    }
                }
                dp[i] += 1;
            }

            System.out.println(Arrays.stream(dp).max().getAsInt());

        }
    }
