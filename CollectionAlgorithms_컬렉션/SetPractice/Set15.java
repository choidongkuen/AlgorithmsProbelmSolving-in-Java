// 날짜 : 2022/11/09
// 문제 : Top k 숫자 고르기
// 문제 설명 :
// n개의 숫자가 주어졌을 때, 중복을 제외하고 내림차순으로 정렬했을 때 앞에 있는 k개의 숫자를 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 원소의 개수 n과 k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 원소가 공백을 사이에 두고 주어집니다.
// 1 ≤ k ≤ n ≤ 100,000
// 1 ≤ 주어지는 원소 값 ≤ 10^9

// 입력 예시 01 :
// 5 2
// 1 1 3 2 3

// 출력 예시 01 :
// 3 2

package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Set15 {
    public static final int MAX = 100000;

    public static int n,k;
    // 일반적인 TreeSet 은 오름차순 정렬이다.
    public static TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        while(n --> 0){
            treeSet.add(sc.nextInt());
        }

        while(k -- > 0){
            System.out.print(treeSet.first() + " ");
            treeSet.remove(treeSet.first());
        }
    }
}
