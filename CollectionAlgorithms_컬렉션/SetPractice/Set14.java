// 날짜 : 2022/11/09
// 문제 :  가까운 숫자
// 문제 설명 :
// 처음 수직선 상에 x = 0 위치에만 점이 하나 놓여있습니다.
// 이후 n개의 숫자 주어졌을 때, 순서대로 하나씩 해당 숫자에 해당하는 x좌표 위치에 점을 하나 추가하며 추가한 직후 가장 가까운 두 점 사이의 거리를 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다. 이때 주어지는 숫자들은 전부 다름을 가정해도 좋습니다.
// 1 ≤ n ≤ 100,000
// 1 ≤ 주어지는 숫자들 ≤ 10^9

// 입력 예시 01 :
// 3
// 3 9 2

// 출력 예시 01 :
// 3
// 3
// 1

package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set14 {

    public static final int MAX = 100000;
    public static int n;
    public static TreeSet<Integer> treeSet = new TreeSet<Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        treeSet.add(0);

        int ans = Integer.MAX_VALUE;
        while(n -- > 0){
            Integer x = sc.nextInt();
            treeSet.add(x);

            // 추가한 값이 마지막인 경우
            if(treeSet.last() == x){
                ans = Math.min(ans,treeSet.last() - treeSet.lower(treeSet.last()));
            // 추가한 값이 처음인 경우
            }else if(treeSet.first() == x) {
                ans = Math.min(ans,treeSet.higher(x) - x);
            // 추가한 값이 중간인 경우
            } else{
                ans = Math.min(ans,x - treeSet.lower(x));
                ans = Math.min(ans,treeSet.higher(x) - x);
            }
            System.out.println(ans);
        }
    }
}
