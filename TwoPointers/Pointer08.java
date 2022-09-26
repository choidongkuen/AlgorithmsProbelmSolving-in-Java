// 날짜 : 2022/09/26
// 문제 : CountingArray와 Two Pointer 1

// 문제 설명 : n개의 크기의 배열이 주어질때, 특정 구간을 잘 골라 구간 내 같은 숫자가
// 3개 이상 있지 않은 경우 중 가장 큰 구간의 크기를 구하는 프로그램을 작성해보세요.
// 숫자의 범위는 1 ~ 3

// 입출력 예시
// 7
// 2 1 2 2 1 3 1

// 아이디어 :
// 각 구간의 시작점을 i로 잡았다고 했을 때, 같은 숫자가 3개 이상이 되지 않도록 최대로 뻗어나갔을 때의 구간의 끝 점을
// j로 하여 투포인터를 구현하면 된다.

package TwoPointers;

import java.util.Scanner;

public class Pointer08 {
    public static int n;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 원소의 개수
        int[] arr = new int[n]; // 원소를 담을 1차원 배열
        int[] countArr = new int[4]; // 각 원소의 갯수를 담을 countarray

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        } // 원소 입력

        int j = -1;
        int ans = -1; // 가장 큰 구간의 길이
        for (int i = 0; i < n ; i++) {

            while(j + 1 < n && countArr[arr[j + 1]] < 2){
                countArr[arr[j + 1]] ++;
                j ++;
            }

            ans = Math.max(ans, j - i + 1);
            countArr[arr[i]] --;
        }

        System.out.println(ans);
    }
}
