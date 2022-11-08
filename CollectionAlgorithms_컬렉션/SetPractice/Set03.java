// 날짜 : 2022/11/08
// 문제 : 데이터 비교
// 문제 설명 :
// 정수로 이루어진 두 수열을 비교하여 같은 원소를 가지고 있는지 판단하는 프로그램을 작성해 보세요.

// 입력 형식 :
// 첫 번째 줄에는 수열 1의 원소의 개수 n이 주어집니다.
// 두 번째 줄에는 수열 1의 원소들이 공백을 두고 주어집니다.
// 세 번째 줄에는 수열 2의 원소의 개수 m이 주어집니다.
// 네 번째 줄에는 수열 2의 원소들이 공백을 두고 주어집니다.
// 1 ≤ n, m ≤ 100,000
// −10^9 ≤ 주어지는 숫자의 범위 ≤ 10^9

// 입력 예시 01 :
// 3
// 1 2 3
// 5
// 1 1 3 4 2

// 출력 예시 01 :
// 1 1 1 0 1

// 아이디어 :
// 모든 arr2의 원소를 arr1에 있는지 확인하는 것은 시간 초과 => O(N^2)
package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Set03 {
    public static final int MAX = 100000;

    public static int n,m;
    public static int[] arr1 = new int[MAX];
    public static int[] arr2 = new int[MAX];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n ; i++) {
            arr1[i] = sc.nextInt();
        }

        m = sc.nextInt();
        for (int i = 0; i < m ; i++) {
            arr2[i] = sc.nextInt();
        }

        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());

        for(int i = 0; i < m; i ++ ){
            if(set1.contains(arr2[i]))
                System.out.print(1 + " ");
            else
                System.out.print(0 + " ");
        }
    }
}
