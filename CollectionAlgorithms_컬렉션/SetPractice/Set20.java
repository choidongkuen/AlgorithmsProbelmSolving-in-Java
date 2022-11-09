package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set20 {

    public static final int MAX = 100000;
    public static int n,m;
    public static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // n개의 원소 treeSet에 삽입
        // O(NlogN)
        for (int i = 0; i < n; i++) {
            treeSet.add(sc.nextInt());
        }

        // x가 주어지고 x 보다 같거나 작은 숫자 중 최대 값 출력
        // O(MlogN)
        for (int i = 0; i < m; i++) {
            Integer x = sc.nextInt();

            if (treeSet.floor(x) == null) {
                System.out.println(-1);
            } else {
                System.out.println(treeSet.floor(x));
                treeSet.remove(treeSet.floor(x));
            }
        }
    }
}

// 결국 treeSet 은 특정 숫자가 주어질 때 해당 숫자보다 크거나 같거나 작은 숫자들을 쉽게 구할 수 있음
