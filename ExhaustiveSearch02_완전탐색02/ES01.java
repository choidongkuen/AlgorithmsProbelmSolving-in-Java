// 날짜 : 2022/09/07
// 문제 : 이상한 폭탄2
// 문제 설명 :
// 이상한 폭탄이 N개 있습니다. 이 이상한 폭탄은 각자에게 부여된 번호가 있고, 같은 번호가 부여된 폭탄끼리 거리가 K안에 있다면 폭발하게 됩니다.
// 폭탄의 개수 N, 특정 거리인 K, 그리고 폭탄을 나열한 순서가 주어지면,
// 폭발 할 폭탄중에 부여된 번호가 가장 큰 번호를 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 N 과 K가 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터 각 줄마다 폭탄의 순서가 주어집니다.
// 0 ≤ 폭탄의 번호 ≤ 1,000
// 1 ≤ N ≤ 100
// 1 ≤ K ≤ N

// 입력 예시 :
// 6 3
// 7
// 3
// 4
// 2
// 3
// 4

// 출력 예시 :
// 4

package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES01 {
    public static final int MAX_N = 100; // 폭탄의 최대 개수
    public static int[] bombs = new int[MAX_N]; // 폭탄 번호를 원소로 갖는 1차원 배열 선언

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 폭탄 개수
        int k = sc.nextInt(); // 터지는 거리

        int ans = -1; // 터질 폭탄의 최대 번호

        for(int i = 0; i < n; i++){
            bombs[i] = sc.nextInt();
        } // 폭탄 정보 입력

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(bombs[i] == bombs[j] && j - i <= k)
                    ans = Math.max(ans,bombs[i]);
            }
        }
        System.out.println(ans);
    }
}