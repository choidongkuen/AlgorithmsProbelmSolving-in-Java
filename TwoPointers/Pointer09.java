// Pointer08을 내가 떠올린 다른 투포인터 방식으로 구현해보기
// 개념은 동일하나, 투 포인터를 조금 다른식으로 표현

package TwoPointers;

import java.util.Arrays;
import java.util.Scanner;

public class Pointer09 {
    public static int n; // 주어지는 원소의 갯수

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        int[] countingArr = new int[4]; // 1 ~ 4

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int p1 = 0;
        int p2 = 0;
        int ans = -1;

        // 반복할때마다, 해당 p2 더해보고, countingArr의 최대값이 3이 되면 구간 길이 업데이트
        // countingArr[arr[p1]] -- + p1++
        while (p2 < arr.length) {
            while (p2 < arr.length && Arrays.stream(countingArr).max().getAsInt() != 3) {
                countingArr[arr[p2]]++; // 해당 arr[p2] 더하고
                p2++; // p2 증가
            }

            ans = Math.max(ans, p2 - p1 - 1);
            countingArr[arr[p1]]--;
            p1++;
        }

        System.out.println(ans);
    }
}
