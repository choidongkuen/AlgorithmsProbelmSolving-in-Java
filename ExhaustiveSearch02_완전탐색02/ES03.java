// 날짜 : 2022/09/07
// 문제 : 숫자들의 합 중 최대
// 문제 설명 : 두 개의 숫자 X, Y가 주어지면 X이상 Y이하에 있는 수 중 각 자리 숫자의 합이 최대가 되도록 하는 프로그램을 작성해보세요.

// 입력 형식 : 첫 번째 줄에 X와 Y가 공백을 사이에 두고 주어집니다.
//1 ≤ X ≤ Y ≤ 10,000

// 입력 예시 :
// 19 21

// 출력 예시 :
// 10

package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES03 {
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();


        int ans = 0;
        for(int i = x; i <= y; i++){
            int first = i % 10;
            int second = (i / 10) % 10;
            int third = (i / 100) % 10;
            int fourth = (i / 1000) % 10;
            int fifith = (i / 10000) % 10;

            ans = Math.max(ans , first + second + third + fourth + fifith);
        }

        System.out.println(ans);
    }
}