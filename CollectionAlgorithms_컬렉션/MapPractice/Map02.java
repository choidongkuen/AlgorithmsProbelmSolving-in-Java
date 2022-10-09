// 날짜 : 2022/09/28
// 문제 : 세 수의 합
// 문제 설명 :
// n개의 정수가 입력으로 주어지고, 이 중 서로 다른 세 개의 위치를 골라 각 위치에 있는 세 수를 더했을 때 k가 되는 서로 다른 조합의 개수를 출력하는 코드를 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 원소의 개수 n과 세 수의 합이 될 k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 정수가 공백을 사이에 두고 주어집니다. 숫자가 중복되어 주어질 수 있습니다.
// −5 × 10^8 ≤ 원소 값, k ≤ 5×10^8
// 1 ≤ n ≤ 1,000


package CollectionAlgorithms_컬렉션.MapPractice;

import java.util.HashMap;
import java.util.Scanner;

public class Map02 {
    public static final int MAX = 1000;

    public static int n, k;
    public static int[] arr = new int[MAX];
    public static HashMap<Integer, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
        } // 원소입력 + 원소 : 원소의 갯수 형태로 Mapping

        for (int i = 0; i < n; i++) {

            if (!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], -1);
            }

            else // Map에 존재한다면
                hashMap.put(arr[i], hashMap.get(arr[i]) - 1);

            for (int j = 0; j < i; j++) {
                if (hashMap.containsKey(k - arr[i] - arr[j]))
                    ans += hashMap.get(k - arr[i] - arr[j]);
            }
        }
        System.out.println(ans);
    }
}

