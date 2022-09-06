// 날짜 : 2022/09/07
// 문제 : 흥미로운 숫자 2
// 문제 설명 :
// 두 개의 숫자 X, Y가 주어지면 X이상 Y이하에 있는 ‘흥미로운 숫자’의 개수를 세려고합니다.
// 여기서 말하는 ‘흥미로운 숫자’란 모든 자릿수에 있는 숫자들이 같지만, 정확히 한 자리만 다른 숫자를 의미합니다. 예를 들어 33335와 1118은 정확히 한 자리만 다르므로 ‘흥미로운 숫자’지만, 333333는 전부 같은 숫자로만 이루어져 있고 11188은 정확히 한 자리만 다른 것은 아니므로 ‘흥미로운 숫자’가 아닙니다.
// ‘흥미로운 숫자’의 개수를 세는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 X와 Y가 공백을 사이에 두고 주어집니다.
// 100 ≤ X ≤ Y ≤ 1,000,000

// 입력 예시 :
// 110 133

// 출력 예시 :
// 13

package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES05 {
    public static boolean checkInterestingNum(int[] arr){
        int[] count = new int[10];
        for(int i = 0; i < arr.length; i++){
            count[arr[i]]++;
        }

        int cntOne = 0, cntAnother = 0;
        for(int i = 0; i < 10; i++){
            if(count[i] == 1)
                cntOne++; // 1인 숫자가 1개 있어야 하며,
            if(count[i] > 1)
                cntAnother++; // 2 이상인 숫자가 1개 있어야 한다.
        }

        if(cntOne == 1 && cntAnother == 1)
            return true;
        return false;
    }
    public static boolean isInteresting(int num){

        char[] arr = String.valueOf(num).toCharArray();
        int leng = arr.length;
        int[] numArr = new int[leng];

        for(int i = 0; i < leng; i++)
            numArr[i] = arr[i] - '0'; // 주어진 문자 배열을 정수형 배열로 변환

        return checkInterestingNum(numArr);
    }

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int ans = 0; // 흥미로운 숫자의 개수
        for(int i = x; i <= y; i++){
            if(isInteresting(i))
                ans++;
        }

        System.out.println(ans);
    }
}