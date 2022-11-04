// 날짜 : 2022/11/04
// 문제 : 최대 숫자 만들기
// 문제 설명 :
// n개의 숫자가 주어졌을 때, 적당한 순서에 맞춰 나열하여 각 숫자들을 붙여 만들 수 있는 숫자 중 가능한 최댓값을 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 n이 주어집니다.
// 두 번째 줄부터 n+1 번째 줄 까지 n개의 숫자가 차례대로 주어집니다.
// 1 ≤ n ≤ 50,000
// 1 ≤ 주어지는 숫자들의 범위 ≤ 10
// 9

// 입력 예시 01 :
// 3
// 43
// 37
// 4

// 출력 예시 01 :
// 44337
package Greedy_그리디;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Greedy06 {

    public static final int MAX_N = 50000;

    public static int n;
    public static int[] arr ;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Integer[] intArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
//        System.out.println(Arrays.toString(intArr));

        Arrays.sort(intArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = Integer.toString(o1) + Integer.toString(o2);
                String s2 = Integer.toString(o2) + Integer.toString(o1);
                return s2.compareTo(s1);

                // String.compareTo(String s2)
                // 두 문자열의 아스키 코드 값의 차이
                // s2가 더 크다면 양수 작다면 음수
            }
        });

        for (int i = 0; i < intArr.length ; i++) {
            System.out.print(intArr[i]);
        }
    }
}
