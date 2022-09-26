// [6,3,2,4,9,1] 와 같이 배열이 주어질때,
// 특정 구간을 잘 골라 구간 내 숫자의 합이 10을 넘지 않으면서 가장 큰 구간의 크기를 구하세요.

package TwoPointers;

public class Pointer06 {
    public static int limit = 10; // 기준이 되는 숫자
    public static int n = 6; // 원소의 갯수

    public static int bruteForce(int[] arr){ // BruteForce 방법

        if(arr == null || arr.length == 0)
            return -1;

        int ans = 0; // 조건을 만족하는 구간의 최대값

        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n; j++) {

                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                if (sum <= limit)
                    ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
    public static int twoPointer(int[] arr){

        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int ans = -1;

        while(p1 < arr.length && p2 < arr.length){

            if(sum > limit){
                sum -= arr[p1];
                p1 ++;
            }else{
                ans = Math.max(ans, p2 - p1);
                sum += arr[p2++];

            }
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] arr = {6,3,2,4,9,1};
        System.out.println("BruteForce : " + bruteForce(arr));
        System.out.println("Two-Pointer : " + twoPointer(arr));

    }
}
