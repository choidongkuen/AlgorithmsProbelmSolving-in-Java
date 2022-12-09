// 날짜 : 2022/11/04
// 문제 : 높은 숫자의 카드가 이기는 게임
// 문제 설명 :
// A와 B가 카드게임을 하고 있습니다. 1부터 2N까지 번호가 쓰인 카드가 한 장씩 총 2N장 있으며, A와 B가 카드를 N개씩 나눠 가집니다.
// A와 B는 한 번에 카드 한 장씩을 내고, 더 큰 숫자의 카드를 가진 사람이 점수를 1점 얻습니다.
// 카드는 한 턴에 한 번 까지만 낼 수 있고, A와 B는 모든 카드를 다 낼 때 까지 이를 N번 반복합니다. << B가 카드를 내는 순서가 주어졌을 때, >> A가 얻을 수 있는 점수의 최댓값을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 N이 주어집니다.
// 두 번째 줄부터 N개의 줄에 걸쳐 한 줄에 하나씩 B가 내는 카드들이 순서대로 주어집니다.
// 1 ≤ N ≤ 50,000

// 입력 예시 01 :
// 3
// 1
// 6
// 4

// 출력 예시 01 :
// 2

// A의 작은 숫자부터 남아있는 카드의 숫자를 보면서
// B의 카드의 숫자보다 큰 경우 바로 매칭
// 즉 A,B 둘다 오름차순 정렬을 해서
// 작은 숫자부터 고려해간다.


package Greedy_그리디;

import java.util.*;

public class Greedy09 {

    public static final int MAX_N = 50000;
    // TreeSet 의 삽입,삭제,탐색 => O(logN)
    public static TreeSet<Integer> A = new TreeSet<>();
    public static TreeSet<Integer> B = new TreeSet<>();


    public static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i ++){
            B.add(sc.nextInt());
        }

        for(int i = 1; i <= 2*n; i ++){
            if(B.contains(i))
                continue;
            A.add(i);
        }

        int bIdx = 0;
        int cnt = 0;

        for(int i = 0; i < n; i ++){

            if(A.first() > B.first()){
                cnt ++;
                B.remove(B.first());
            }
            A.remove(A.first());
        }

        System.out.print(cnt);
    }
}

// 각자 작은 값의 원소부터 보면서
// 만약 A 배열리스트의 원소가 B의 배열리스트의 원소보다 크다면
// cnt ++ ;
// bIdx++;
