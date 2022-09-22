// 날짜 : 2022/09/22
// 문제 : 두 배열의 공통 원소를 배열로 반환하기
// 문제 설명 :
// 두 배열의 공통 원소를 배열로 반환하는 프로그램을 작성하세요
// 결과 배열의 원소에는 중복 값이 없도록 하며, 순서는 상관 없다.


// 입출력 예시
// num1 = 1,2,2,1
// num2 = 2,2
// 출력 : 2

// num1 = 4,9,5
// num2 = 9,4,9,8,4
// 출력 : 4,9 (9 or 4)

package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution03 {

    public static int[] solution01(int[] num1, int[] num2) {

        HashSet<Integer> hashSet = new HashSet<>(); // 중복,순서 x
        Arrays.sort(num1);
        Arrays.sort(num2); // 두 배열 오름차순 정렬

        int p1 = 0; // num1 포인터
        int p2 = 0; // num2 포인터


        while (p1 < num1.length && p2 < num2.length) {

            if (num1[p1] < num2[p2])
                p1++;
            else if (num1[p1] > num2[p2])
                p2++;
            else {
                hashSet.add(num1[p1]);
                p1++;
                p2++;
            }
        }
        int idx = 0;
        int[] result = new int[hashSet.size()];
        for (Integer x : hashSet)
            result[idx++] = x;

        return result;
    }


}

public class Pointer03 {
    public static void main(String[] args) {

        System.out.println("===== first solution ===== ");

        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(Arrays.toString(new Solution03().solution01(num1,num2)));

        num1 = new int[]{4,9,5};
        num2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(new Solution03().solution01(num1,num2)));

        num1 = new int[]{1,7,4,9};
        num2 = new int[]{7,9};
        System.out.println(Arrays.toString(new Solution03().solution01(num1,num2)));
    }
}
