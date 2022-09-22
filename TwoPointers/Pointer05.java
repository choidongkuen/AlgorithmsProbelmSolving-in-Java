// 날짜 : 2022/09/22
// 문제 : 3개의 합이 0이 되는 모든 숫자를 출력하시오.
// 문제 설명 :
// 주어진 nums 배열에서 3개의 합이 0이 되는 모든 숫자들을 출력하세요.
// 중복된 숫자 set은 제외하고 출력하세요.

// 입출력 예시
// nums : {-1,0,1,2,-1,-4}
// 출력 : [[-1,-1,2] , [-1,0,1]]

// nums : {1,-7,6,3,5,2}
// 출력 : [[-7,1,6] , [-7,2,5]]

// 아이디어 :
// 두 개의 투 포인터를 잡고 하나는 for 문으로 앞에서부터 i 인덱스 원소로 잡는다.
// i + 1 ~ arr.length 까지 돌면서 0이되는 부분 찾아준다.

package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Pointer05 {

    public static ArrayList<ArrayList<Integer>> solution(int[] nums){

        Arrays.sort(nums); // 오름차순 정렬
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){
            if(i == 0 || i > 0 && nums[i] != nums[i - 1]){

                int p1 = i + 1;
                int p2 = nums.length - 1;

                int sum = 0 - nums[i]; // arr[p1] + arr[p2] == -nums[i]

                while(p1 < p2){
                    if(nums[p1] + nums[p2] == sum){
                        result.add(new ArrayList<>(Arrays.asList(nums[i],nums[p1],nums[p2])));

                        while(p1 < p2 && nums[p1] == nums[p1 + 1]){
                            p1++;
                        }
                        while(p1 < p2 && nums[p2] == nums[p2 - 1]){
                            p2--;
                        }
                        p1++;
                        p2--;
                    }else if(nums[p1] + nums[p2] < sum){
                        p1++;
                    }else{
                        p2--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution(nums));

        nums = new int[]{1,-7,6,4,5,2};
        System.out.println(solution(nums));

    }
}
