// 날짜 : 2022/09/08
// 문제 : 수를 여러번 사용하여 특정 수 만들기
// 문제 설명 :
// 크기가 다른 정수 A, B, C가 주어집니다.
// A와 B를 여러 번 사용할 수 있고 사용한 숫자들의 합이 C보다 작거나 같으면서 최대가 되도록 하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 정수 A, B, C가 주어집니다.
// 1 ≤ A < B < C ≤ 1,000

// 입력 예시 :
// 17 25 77

// 출력 예시 :
// 76

package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES12 {
    public static final int MAX = 1000; // 정수의 최대값
    public static int a,b,c; // 주어지는 세 수
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt(); // 세 수 입력

        /*
        int ans = 0; // c보다 작거나 같으면서 최대가 되는 값
        for(int i = 0; i <= MAX; i++){
            for(int j = 0; j <= MAX; j++){
                int sum = (a * i) + (b * j);

                if(sum <= c)
                    ans = Math.max(ans, sum);
            }
        }*/

        int ans = 0;

        for(int i = 0; i * a <= c; i++){ // 잘 생각해보기
            int cnt = a * i;

            int numB = (c - cnt) / b; // b * numB
            cnt += numB * b; // a * i + b * j

            ans = Math.max(ans , cnt); // 최대값 업데이트
        }
        System.out.println(ans);
    }
}