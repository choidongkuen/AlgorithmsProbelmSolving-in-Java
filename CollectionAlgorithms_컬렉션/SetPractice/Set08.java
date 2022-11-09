// 날짜 : 2022/11/09
// 문제 : 대칭 차집합

// 문제 설명 :
// 대칭 차집합이란?
// 대칭 차집합이란, 두 집합 A와 B가 있을때 집합 A - B 와 집합 B - A 의 합집합을 대칭 차집합 이라고 한다.
// 자연수를 원소로 갖는 두 집합 A와 B에 대한 대칭 차집합의 원소의 개수를 구하는 프로그램을 작성하세요.

// 입력 형식 :
// 첫 번째 줄에는 집합 A의 원소의 개수와 집합 B의 원소의 개수가 공백을 두고 주어집니다.
// 두 번째 줄에는 집합 A의 모든 원소가 공백을 두고 주어집니다.
// 세 번째 줄에는 집합 B의 모든 원소가 공백을 두고 주어집니다.
// 1 ≤ 집합의 원소의 개수 ≤ 200,000
// 1 ≤ 원소의 크기 ≤ 100,000,000
// A, B 각각의 집합 안에서는 같은 원소가 여러번 주어지지 않습니다.

// 입력 예시 01 :
// 3 3
// 1 2 6
// 2 6 9

// 출력 예시 01 :
// 2

// Set.removeAll(Collection c) => 차집합 기능
// Set.retainAll(Collection c) => 교집합 기
// Collection의 깊은 복사


package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Set08 {

    public static int n,m;
    public static ArrayList<Set<Integer>> arrList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < 2 ; i++) {
            arrList.add(new HashSet<Integer>());
        }

        int[] cntArr = new int[]{n,m};

        for (int i = 0; i < 2 ; i++) {
            for (int j = 0; j < cntArr[i]; j++) {
                arrList.get(i).add(sc.nextInt());
            }
        }
        Set<Integer> A = new HashSet<Integer>();
        Set<Integer> B = new HashSet<Integer>();

        A.addAll(arrList.get(0));
        B.addAll(arrList.get(1));

        A.removeAll(arrList.get(1));
        B.removeAll(arrList.get(0));

        System.out.println(A.size() + B.size());
    }
}
