// 날짜 : 2022/11/09
// 문제 : 차이가 가장 작은 수
// 문제 설명 :
// n개의 정수로 이루어진 수열에서 두 수를 골랐을 때, 그 차이가 m 이상이면서 제일 작은 경우의 그 차이를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 정수 n과 m이 주어집니다.
// 두 번째 줄부터 n개의 줄에 걸쳐 n개의 정수가 차례대로 한 줄에 하나씩 주어집니다.
// 2 ≤ n ≤ 100,000
// 1 ≤ m ≤ 10 ^ 9
// −10^9 ≤ 정수의 크기 ≤ 10^9

// 입력 예시 01 :
// 3 3
// 1
// 5
// 3

// 4

// 아이디어 :
// 정렬 된 상태에서 마지막 원소부터 차근차근 계산?
// treeSet.floor() & treeSet.ceiling() 을 잘 활용하자
// 결국 특정 x 값 기준으로 m 이상이면서 제일 작은 경우의 값과의 차이는
// treeSet.ceiling(x + m) & treeSet.floor(x - m) 의 값을 갱신

package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set17 {
    public static int n,m;
    public static TreeSet<Integer> treeSet = new TreeSet();
    public static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 수열의 원소 개수
        n = sc.nextInt();
        // 조건의 숫자( m 이상 )
        m = sc.nextInt();

        // n개의 수열을 treeSet에 삽입
        // 효율적인 탐색을 위해 O(logN)
        for (int i = 0; i < n ; i++) {
            treeSet.add(sc.nextInt());
        }

        for(Integer x : treeSet){
            // x 보다 m 이상 큰 값이 존재 한다면
            if(treeSet.ceiling(x + m) != null){
                ans = Math.min(ans, treeSet.ceiling(x + m) - x);
            }
            // x 보다 m 이상 작은 값이 존재 한다면
            if(treeSet.floor(x - m) != null){
                ans = Math.min(ans, x - treeSet.floor(x - m));
            }
        }

        if(ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(ans);
        }
    }
}
