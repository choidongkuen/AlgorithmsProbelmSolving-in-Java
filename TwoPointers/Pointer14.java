// 날짜 : 2022/09/28
// 문제 : 1이 k개 이상 존재하는 부분 수열
// 문제 설명 :
// 1과 2로 이루어진 크기가 n인 수열에서, '1이 k개 이상 존재'하는 가장 짧은 연속된 부분 수열의 길이를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 n과 k가 주어집니다.
// 두 번째 줄에 n개의 1 또는 2가 공백을 두고 출력됩니다.
// 1 <= k < n < 10 ^ 6

// 입력 얘시 01 :
// 8 2
// 1 2 2 2 1 2 1 2

// 출력 예시 01 :
// 3

package TwoPointers;

import java.util.Scanner;

public class Pointer14 {

    public static int n,k;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n]; // 원소를 입력할 배열
        int[] countingArr = new int[3]; // 1 or 2

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = Integer.MAX_VALUE;
        boolean exist = false; // 1이 k개 이상 존재하는 부분 수열이 존재하는지 판단하는 부울 변수

        int p1 = 0;
        int p2 = 0;

        while(p2 < n){

            while(p2 < n && countingArr[1] < k){

                countingArr[arr[p2]] ++;
                p2 ++;
            }
            // p1이 n 이상이거나, countingArr[1]이 k 이상인 경우
            if(countingArr[1] >= k){
                ans = Math.min(ans, p2 - p1);
                exist = true;
            }

            countingArr[arr[p1]]--;
            p1 ++;
        }

        if(!exist)
            System.out.println(-1);
        else
            System.out.println(ans);
    }
}
