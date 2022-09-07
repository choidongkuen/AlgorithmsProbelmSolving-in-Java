// 날짜 : 2022/09/08
// 문제 : 빙산의 일각2
// 문제 설명 :
// 해수면의 높이에 따라 물에 잠기는 빙산들이 있습니다. 빙산의 개수 N이 주어지고 N개의 빙산들의 높이 H(i)가 순서대로 주어집니다.
// 빙산들이 물에 잠기지 않은 채로 붙어있는 경우를 한 덩어리로 볼 때,
// 해수면의 높이를 적절하게 설정 했을 때 가능한 빙산 덩어리의 최대 개수를 구하는 프로그램을 아래 예를 참고하여 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 빙산들의 개수 N이 주어지고
// 두 번째 줄부터 N개의 줄에 걸쳐 빙산의 높이 H(i)가 순서대로 한 줄에 하나씩 주어집니다.
// 1 ≤ N ≤ 100
// 1 ≤ H(i) ≤ 1,000

// 입력 예시 :
// 8
// 3
// 5
// 2
// 3
// 1
// 4
// 2
// 3

// 출력 예시 :
// 4

package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES08 {
    public static final int MAX_N = 100; // 최대 빙산 갯수
    public static final int MAX_H = 1000; // 최대 높이
    public static int[] ices = new int[MAX_N]; // 빙산의 높이를 원소로 갖는 1차원 배열
    public static int n; // 주어지는 빙산의 갯수

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n 입력

        int height = 0;
        for(int i = 0; i < n; i++){
            ices[i] = sc.nextInt();
            height = Math.max(height,ices[i]);
        } // 고려해야 할 높이는 빙산의 최대 높이까지(MAX_H 까지 하는 건 낭비)

        int ans = 0; // 수면위로 들어나는 빙산 덩어리의 최대 갯수

        for(int h = 1; h <= height; h++){
            int cnt = 0;

            if(ices[0] > h) // 첫번째 빙산은 예외적으로 처리
                cnt++;

            for(int i = 1; i < n; i++){
                if(ices[i] > h && ices[i - 1] <= h)
                    cnt++; // 이 방식으로 덩어리에 대한 중복 처리를 피할 수 있음.
            }
            ans = Math.max(ans, cnt); // 최대값 갱신
        }
        System.out.println(ans); // 출력
    }
}