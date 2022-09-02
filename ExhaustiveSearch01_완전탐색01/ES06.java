// 날짜 : 2022/09/03
// 문제 : 이상한 진수 2
// 문제 설명 :
// 0 이상의 정수 N을 2진법으로 나타낸 뒤, 그 숫자들 중 정확히 한 숫자만을 바꾼 숫자 a가 주어졌을 때,
// 가능한 숫자 N 중 최댓값을 찾는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 a가 주어집니다. a는 전부 숫자 0과 1로 이루어져 있으며, 맨 앞은 0이 아님을 가정해도 좋습니다.
// 1 ≤ a의 자릿 수 ≤ 10

// 입력 예시 :
// 1010

// 출력 예시 :
// 14


package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES06 {
    public static int calculator(int[] arr){ // 주어진 2진수를 10 진수로 변환하는 메서드
        int result = 0;

        for(int i = 0; i < arr.length; i++){
            result += arr[i] * Math.pow(2,arr.length - 1 - i);
        } // 10 진수 변환
        return result; // 결과 return
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String st = sc.next(); // 문자열 입력
        int ans = 0; // 답

        int[] arr = new int[st.length()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = st.charAt(i) - '0';
        } // 문자열을 정수형 배열로 변환

        for(int i = 0; i < arr.length; i++){

            arr[i] = Math.abs(arr[i] - 1); // 하나씩 값 변경
            int result = calculator(arr); // 메서드 호출

            ans = Math.max(ans , result); // ans 업데이트
            arr[i] = Math.abs(arr[i] - 1); // 다시 복구
        }

        System.out.println(ans); // 결과 출력
    }
}