// 날짜 : 2022/11/08
// 문제 : 두 배열의 구성이 정확히 동일한지 판단하기
// 문제 설명 :
// 두 배열이 있을 때, 두 배열을 이루는 원소가 정확히 동일한지 판단해보자.

package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Set02 {

    public static final int MAX_N = 100;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();


        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        // 첫번째 배열 원소 입력
        for (int i = 0; i < n1 ; i++) {
            arr1[i] = sc.nextInt();
        }

        // 두번째 배열 원소 입력
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());

        // set -> 배열로 변환
        // toArray의 인자로 변환될 배열 객체를 넘겨줄 때, 0으로 지정시 자동 크기 지정
        Integer[] newArr1 = set1.toArray(new Integer[0]);
        Integer[] newArr2 = set2.toArray(new Integer[0]);



        boolean isSame = true;

        for (int i = 0; i < newArr1.length; i++) {
            if(newArr1[i] != newArr2[i])
                isSame = false;
        }
        System.out.println(isSame);
    }
}
