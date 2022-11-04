// 날짜 : 2022/11/03
// 문제 : 숫자 합치기

// 문제 설명 :
// n개의 숫자가 주어졌을 때, 2개의 숫자를 골라 하나의 숫자로 합치는 과정을 단 하나의 숫자가 남을 때까지 반복하려고 합니다.
// 이때 2개의 숫자가 a, b였다면, 이 두 숫자를 합치는 데 드는 비용은 a + b 입니다. n개의 숫자를 잘 합쳐 하나의 숫자가 되기까지의 가능한 최소 비용을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 100,000
// 1 ≤ 주어지는 숫자 ≤ 10,000

// 입력 예시 01 :
// 4
// 1 2 3 2

// 출력 예시 01 :
// 16

// 아이디어 :
// 첫번째 아이디어 : 오름차순으로 정렬하여 주어진 순서대로 합치면 될까? -> No
// 우선순위 큐에 원소가 하나 남을 때까지 작은 두값의 합을 비용에 더해주고, 다시 큐에 넣어준다. << 하프만 코드 >>
// 매 순간 최소값만 고려 -> 그리디

package Greedy_그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy04 {

    public static final int MAX_N = 100000;
    public static int n;
    public static int ans;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            int n = sc.nextInt();
            pq.add(n);
        }

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            int cost = x + y;
            ans += cost;
            pq.add(cost);
        }

        System.out.println(ans);
    }
}
