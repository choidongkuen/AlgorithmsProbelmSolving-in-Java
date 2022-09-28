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
    public static int n = 7;
    public static int[] countArr = new int[4]; // 각 원소의 갯수를 담을 countarray

    public static int solution(int[] arr){

        int p1 = 0;
        int p2 = 0;
        int ans = -1;

        while(p2 < n){

            while(p2 < n && countArr[arr[p2]] < 2){
                countArr[arr[p2]] ++; // 증가시켜주고,
                p2 ++; // 다음 위치로 이동
            }

            // p2에 존재하는 원소의 갯수가 2개 기록된 경우(해당 위치까지 포함하면 3개가 되는 경우)

            ans = Math.max(ans, p2 - p1);

            countArr[arr[p1]] --;
            p1 ++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,2,2,1,3,1};
        System.out.println(solution(arr)); // 5
    }
}

