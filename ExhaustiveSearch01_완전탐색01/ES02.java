// 날짜 : 2022/09/01
// 문제 : 괄호 쌍 만들어주기
// 문제 설명 : 문자 '(', ')'로만 이루어진 문자열 A가 주어지면 그 문자열들 사이에서 여는 괄호와 닫는 괄호로 쌍을 이룰 수 있는 서로 다른 가지수를 구하는 프로그램을 작성해보세요.
// 단, 여는 괄호가 먼저 나와야 합니다.
// 즉, 다음과 같은 모양을 띄는 쌍의 수를 세야 합니다.
// ...(.....)....

// 입력 형식 :
// 첫 번째 줄에 문자 '(', ')'로만 이루어진 문자열 A가 주어집니다.
// 1 ≤ 문자열 A의 길이 ≤ 100

// 입력 예시 :
// )(()())

// 출력 예시 :
// 8


package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // 문자열 입력
        int n = str.length(); // 문자열 길이
        int ans = 0; // 쌍의 갯수

        for(int i = 0; i < n ; i++){
            if(str.charAt(i) == '('){ // 여는 괄호가 나오면
                for(int j = i + 1; j < n ; j++){
                    if(str.charAt(j) == ')') // 닫는 괄호가 나오면
                        ans ++; // 갯수 1 추가
                }
            }
        }
        System.out.println(ans); // 출력
    }
}

