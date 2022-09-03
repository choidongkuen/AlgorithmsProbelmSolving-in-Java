// 날짜 : 2022/09/04
// 문제 : 씨 오 더블유2
// 문제 설명 :
// 숫자 N과 문자열이 주어지면 그 문자열에서 ‘C', ‘O’, 그리고 ‘W’ 가 순서대로 몇번 나오는지 세고싶어합니다. 세는 방법이 특이합니다.
// 만약에 CWOW이 주어지고 각 문자의 위치를 1234 라고 표현할 때, 134의 순으로 한번 가능하고, 만약 CCOOWW가 주어지고 각 문자의 위치를 123456 이라고 표현할 때,
// 가능한 조합은 135, 136, 145, 146, 235, 236, 245, 246 순으로 총 8번 가능합니다. 문자열이 주어지면 총 'COW’가 순서대로 가능한 가짓수를 출력하는 프로그램을 작성해보세요

// 입력 형식 :
// 첫 번째 줄에 문자열의 길이가 주어집니다.
// 두 번째 줄에 문자열이 주어집니다.
// 1 ≤ 문자열의 길이 ≤ 100

// 입력 예시 :
// 6
// COOWWW

// 출력 예시 :
// 6
package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES13 {
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 문자열 길이 입력
        int ans = 0;

        char[] arr = sc.next().toCharArray(); // 문자 배열 생성
        for(int i = 0; i < n; i++){
            if(arr[i] == 'C'){
                for(int j = i + 1; j < n; j++){
                    if(arr[j] == 'O'){
                        for(int k = j + 1; k < n; k++){
                            if(arr[k] == 'W'){
                                ans ++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
