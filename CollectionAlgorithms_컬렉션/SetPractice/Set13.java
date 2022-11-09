// 날짜 : 2022/11/09
// 문제 : 최대 숫자 구하기

// 문제 설명 :
// 1부터 m까지의 숫자들이 적혀있는 공이 정확히 하나씩 놓여 있습니다. 이후 n개의 숫자들이 주어졌을 때, 순서대로 하나씩 해당 숫자가 적혀있는 공을 제거한 이후 남아 있는 공들 중 최대 공의 번호를 출력하는 프로그램을 작성해보세요.
// 더 이상 남아 있지 않은 공의 번호가 주어지는 경우는 없다고 생각해도 좋습니다.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다. 모든 숫자는 다르게 주어짐을 가정해도 좋습니다.
// 1 ≤ n < m ≤ 100,000
// 1 ≤ 주어지는 숫자들 ≤ m

// 입력 예시 01 :
// 3 4
// 3 4 1

// 출력 예시 01 :
// 4
// 2
// 2
package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set13 {

    public static final int MAX = 100000;
    public static int n,m;
    public static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= m ; i++) {
            treeSet.add(i);
        }

        for (int i = 0; i < n ; i++) {

            Integer x = sc.nextInt();
            treeSet.remove(x);
            System.out.println(treeSet.last());
        }
    }
}
