// 문제 : 두 수의 합
// 문제 설명 : n개의 정수가 입력으로 주어지고, 이 중 서로 다른 위치에 있는 두개의 수를 뽑아 더했을 때
// k가 되는 가짓수를 구하는 프로그램을 작성하세요.

// 입력 형식 :
// -10 ^ 9 <= 정수 <= 10 ^ 9
// 1 <= n < 100000
// -2 ^ 31 <= k <= 2^31 - 1


// 아이디어 :
// 1. hashMap
// 배열에 대한 for문을 돌면서 diff가 있는지 확인
// 나중에 diff가 arr[i]로 나올 수 있음으로, arr[i]의 횟수 기록


package CollectionAlgorithms_컬렉션.Map;

import java.util.HashMap;
import java.util.Scanner;

public class Map01 {
    public static final int MAX = 100000;
    public static int n,k;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            int diff = k - arr[i];

            if(hashMap.containsKey(diff))
                ans += hashMap.get(diff); // diff 원소가 있다는 것은 이전에 diff 원소가 배열에 있었으며, 해당 값을 hashMap에 저장한 상태

            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0) + 1); // 현재 나온 숫자 기록
        }

        System.out.println(ans);

    }
}
