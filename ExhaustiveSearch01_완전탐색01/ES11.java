// 날짜 : 2022 / 09 / 04
// 문제 : 괄호 쌍 만들어주기
// 문제 설명 :
// 문자 '(', ')'로만 이루어진 문자열 A가 주어지면 그 문자열들 사이에서 연속한 여는 괄호 두 개와 연속한 닫는 괄호 두 개로 쌍을 이룰 수 있는 서로 다른 가지수를 구하는 프로그램을 작성해보세요.
// 단, 여는 괄호가 먼저 나와야 합니다.
// 즉, 다음과 같은 모양을 띄는 쌍의 수를 세야 합니다.
// ...((.....))....

// 입력 형식 :
// 첫 번째 줄에 문자 '(', ')'로만 이루어진 문자열 A가 주어집니다.
// 1 ≤ 문자열 A의 길이 ≤ 100

// 입력 예시 :
// )((()())())

// 출력 예시 :
// 4


package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // 문자열 입력
        int ans = 0; // 조건에 만족하는 괄호 쌍 개수
        int n = str.length(); // 문자열의 길이

        for(int i = 0; i < n - 1; i++){
            if(str.charAt(i) == '(' && str.charAt(i + 1) == '(' ){
                for(int j = i + 2; j < n - 1; j++){
                    if(str.charAt(j) == ')' && str.charAt(j + 1) == ')'){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
