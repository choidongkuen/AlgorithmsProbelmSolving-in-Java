// 날짜 : 2022/09/08
// 문제 : 등차 수열
// 문제 설명 :
// n개의 원소가 주어질 때, k를 적절히 잡아 1 <= i < j <= n 에 대해 (ai ,k , aj) 가 등차 수열을 이루는 횟수가
// 최대가 되도록 하는 프로그램을 작성해보세요. 등차수열의 의미 => ( aj - k == k - ai )

// 입력 형식 :
// 첫 번째 줄에 n이 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다. 단, 입력으로 주어지는 숫자는 모두 다르다는 것을 가정해도 좋습니다.
// 1 ≤ n ≤ 100
// 1 ≤ 주어지는 숫자 ≤ 100

// 입력 예시 :
// 4
// 7 6 4 3

// 출력 예시 :
// 2

package ExhaustiveSearch02_완전탐색02;
import java.util.*;

import java.util.*;

public class ES07 {
    public static final int MAX_N = 100; // n의 최대 값
    public static int[] arr = new int[MAX_N]; // 주어지는 n개의 원소를 담을 1차원 배열
    public static int n; // 주어지는 n

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n 입력


        int maxNum = 0;
        for(int i = 0; i < n ; i++){
            arr[i] = sc.nextInt(); // n개의 원소 입력
            maxNum = Math.max(maxNum, arr[i]);
        }

        int ans = 0;
        for(int i = 0; i <= maxNum; i++){
            int cnt = 0;

            for(int j = 0; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    if(Math.abs(i - arr[j]) == Math.abs(arr[k] - i))
                        cnt++;
                }
            }
            ans = Math.max(ans,cnt); // 최대 갯수 업데이트
        }
        System.out.println(ans); // 출력
    }
}