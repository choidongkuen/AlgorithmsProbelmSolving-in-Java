// 날짜 : 2022/11/08
// 문제 : 정수 찾기
// 문제 설명 :
// 수열 a와 수열 b가 주어졌을 때, 수열 b의 각 원소가 수열 a에 포함되는지 알아보는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 수열 a의 원소의 개수 n이 주어집니다.
// 두 번째 줄에 수열 a의 각 원소가 공백을 두고 주어집니다.
// 세 번째 줄에 수열 b의 원소의 개수 m이 주어집니다.
// 네 번째 줄에 수열 b의 각 원소가 공백을 두고 주어집니다.
// 수열 a 내의 각 숫자들은 전부 다르게 주어짐을 가정해도 좋습니다.
// 1 ≤ n ≤ 100,000
// 1 ≤ m ≤ 100,000
// −2^31 ≤ 원소의 크기 ≤ 2^31 - 1

// 입력 예시 01 :
// 4
// 1 2 3 4
// 3
// 3 4 5

// 입력 예시 02 :
// 1
// 1
// 0

// 아이디어 :
// HashSet의 원소를 탐색하는 것 => O(1)

package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Set05 {

    public static final int MAX = 100000;

    public static int n,m;
    public static int[] a = new int[MAX];
    public static int[] b = new int[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        for (int i = 0; i < n ; i++) {
            a[i] = sc.nextInt();
        }
        m = sc.nextInt();

        for (int i = 0; i < m ; i++) {
            b[i] = sc.nextInt();
        }

        Set<Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());

        for (int i = 0; i < m ; i++) {
            if(setA.contains(b[i]))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
