// 날짜 : 2022/09/28
// 문제 : 연속하는 정수 n개의 합
// 문제 설명 :
// 크기가 n인 수열이 주어졌을 때, 이 중 연속하는 몇 개의 원소들의 합이 m이 되는 경우의 수를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 주어집니다.
// 두 번째 줄에는 n개의 정수가 공백을 두고 차례대로 주어집니다.
// 1 ≤ n ≤ 10,000
// 1 ≤ m ≤ 300,000,000
// 1 ≤ 원소의 크기 ≤ 30,000


// 입력 예시01 :
// 5 7
// 1 3 2 4 1

// 출력 예시01 :
// 1

// 입력 예시02 :
// 4 2
// 1 1 1 1

// 출력 예시02 :
// 3

// 아이디어 :
// 투포인터를 쓰되, 딱 m이 되어야 한다는 점에 주의(앞에 문제는 범위였음)

package TwoPointers;

public class Pointer12 {
    public static int solution(int[] arr, int m){

        if(arr == null || arr.length == 0)
            return 0;

        if(m < 1)
            return 0;

        int p1 = 0;
        int p2 = 0;
        int sum = 0;

        int ans = 0;
        while(p2 < arr.length) {
            while(p2 < arr.length && arr[p2] + sum < m){
                sum += arr[p2];
                p2 ++;
            } // sum과 해당 p2에 원소를 더했을 때, m보다 작을 때까지 p2 증가
              // p2가 마지막에 멈출 곳은 해당 p2를 더했을 때, 같거나 커지는 포인트가 될 것이다.

            if(p2 < arr.length && sum + arr[p2] == m){
                ans++;
            } // 동일한 경우, p1만 조작해주면 됨

            sum -= arr[p1];
            p1 ++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,1};
        System.out.println(solution(arr,7)); // 1



        arr = new int[]{1,1,1,1};
        System.out.println(solution(arr,2)); // 3


        arr = new int[]{1,2,3,4,2,5,3,1,1,2};
        System.out.println(solution(arr,5)); // 3
    }
}
