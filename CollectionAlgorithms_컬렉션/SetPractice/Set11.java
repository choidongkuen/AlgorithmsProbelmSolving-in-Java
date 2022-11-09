// 날짜 : 2022/11/09
// 문제 : 숫자 빠르게 찾기 2
// 문제 설명 :
// 서로 다른 n개의 숫자가 주어집니다. 이후 m개의 숫자가 추가적으로 주어졌을 때, 각각의 숫자에 대해 처음 주어진 n개의 숫자 중 같거나 큰 최초의 숫자를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n, m이 공백을 두고 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다. 주어지는 모든 숫자는 서로 다름을 가정해도 좋습니다.
// 세 번째 줄 부터는 m개의 줄에 걸쳐 숫자가 한 줄에 하나씩 주어집니다.
// 1 ≤ n, m ≤ 100,000
// 1 ≤ 주어지는 값 ≤ 1,000,000,000

// 입력 예시 01 :
// 5 8
// 7 9 1 5 10
// 1
// 2
// 5
// 6
// 7
// 9
// 10
// 11

// 출력 예시 01 :
// 1
// 5
// 5
// 7
// 7
// 9
// 10
// -1

package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set11 {
    public static final int MAX = 100000;
    public static int n,m;
    public static TreeSet<Integer> treeSet = new TreeSet<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            treeSet.add(sc.nextInt());
        }

        for (int i = 0; i < m ; i++) {
            Integer x = sc.nextInt();
            if(treeSet.ceiling(x) == null){
                System.out.println(-1);
            }else {
                System.out.println(treeSet.ceiling(x));
            }

        }
    }
}
