// 날짜 : 2022/09/01
// 문제 : 일렬로 서있는 소
// 문제 설명 : N마리의 소가 x = 1부터 x = N까지 순서대로 서 있습니다. 각 소의 키는 Ai 이며,
// 예를 들어 첫 번째 위치에 놓여있는 소의 키는 A1 입니다. 3마리의 서로 다른 소의 위치를 (i, j, k)라고 했을 때,
// i < j < k를 만족하며 동시에 Ai ≤ Aj ≤Ak 를 만족하는 서로 다른 쌍의 수를 구하는 프로그램을 작성해보세요.

// 입력 예시 :
// 5
// 3 1 7 10 4

// 출력 예시 :
// 2

package ExhaustiveSearch01_완전탐색01;


import java.util.*;

public class ES03 {
    public static final int MAX = 100; // 최대 소의 마리 수
    public static int[] arr = new int[MAX]; // 소의 키 정보를 담을 배열 선언
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 소의 마리 수
        int ans = 0;

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        } // 배열 완성

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int l = j + 1; l < n; l++){
                    if((i < j && j < l) && (arr[i] <= arr[j] && arr[j] <= arr[l])){
                        ans ++; // 조건에 해당함으로 1 증가
                    }
                }
            }
        }
        System.out.println(ans); // 출력
    }
}