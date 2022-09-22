// 날짜 : 2022/09/22
// 문제 : 문자열 규칙
// 문제 설명 :
// a,b,c,d 로 구성된 알파벳 문자열에 대해서
// 다음과 같은 규칙으로 문자열을 정리한 후, 남은 문자열을 반환하는 프로그램을 작성하세요.
// 양쪽의 문자를 비교한 후 같으면 삭제하는데 연속해서 같은 문자가 등장하면 함께 삭제한다.
// 최종적으로 남은 문자열을 반환하세요.

// 입출력 예시
// 입력 : "ab"
// 출력 : "ab"

// 입력 : "aaabbaa"
// 출력 : ""

// 입력 : "aabcddba"
// 출력 : "cdd"

package TwoPointers;

public class Pointer02 {

    public static String solution(String str){

        if(str == null || str.length() == 0)
            return null;

        int p1 = 0; // 시작점
        int p2 = str.length() - 1; // 끝점

        while(p1 < p2 && str.charAt(p1) == str.charAt(p2)){

            char standard = str.charAt(p1); // 기준이 되는 문자열

            while(p1 <= p2 && str.charAt(p1) == standard)
                p1 ++; // p1 이동

            while(p1 <= p2 && str.charAt(p2) == standard)
                p2 --; // p2 이동
        }

        return str.substring(p1,p2 + 1);
    }
    public static void main(String[] args) {

        // Test code
        System.out.println(solution("ab")); // ab
        System.out.println(solution("aaabbaa")); //
        System.out.println(solution("aabcddba")); // cdd
    }
}
