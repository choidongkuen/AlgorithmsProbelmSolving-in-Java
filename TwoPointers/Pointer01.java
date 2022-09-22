// 투포인터 :
// 배열에서 두 개의 포인터를 사용하여 원하는 결과를 얻는 방법
// 두 개의 포인터 배치 방법
// 1. 같은 방향에서 시작 : 첫 번째 원소에 둘 다 배치
// 2. 서로 다른 방향에서 시작 : 첫 번째 원소와 마지막 원소에 배치

package TwoPointers;

import java.util.Arrays;

public class Pointer01 {

    public static int[] forLoop(int[] arr , int target) { // O(N^2) - for loop
        int[] result = {-1, -1};

        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i]; // i부터 합 시작
            boolean partSum = false; // 구간합이 존재하는지 여부
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    partSum = true;
                    break;
                }
            }
            if(partSum)
                break;
        }
        return result; // 결과 return
    }

    public static int[] twoPointers(int[] arr,int target){ // O(N)
        // 부분합 보다 작으면 p1 이동
        // 크게 되는 순간부턴 p2 이동

        int p1 = 0; // 첫번째 포인터
        int p2 = 0; // 두번째 포인터
        int sum = 0;
        int[] result = {-1,-1};

        while(true){
            if(sum > target){ // 구간합이 target보다 크면 p2 이동
                sum -= arr[p2++];
            }else if(p2 == arr.length){
                break; // 더이상 이동 불가
            }else{ // 구간합이 target보다 작으면 p1 이동
                sum += arr[p1++];
            }

            if(sum == target){
                result[0] = p2;
                result[1] = p1 - 1;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {

        int[] arr = {1,2,5,3,7,2,4,3,2};
        System.out.println(Arrays.toString(forLoop(arr,9)));
        System.out.println(Arrays.toString(forLoop(arr,14)));
        System.out.println(Arrays.toString(twoPointers(arr,9)));


    }
}
