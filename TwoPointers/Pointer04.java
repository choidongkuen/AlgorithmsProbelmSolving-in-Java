// 날짜 : 2022/09/22
// 문제 : 문자열 s를 거꾸로 출력하시오.
// 단, 각 단어의 알파벳 순서는 그대로 출력합니다.
// 문장에서 공백이 여러개일 시, 단어와 단어 사이 하나의 공백을 제외한 나머지 공백은 제거하세요.

// 입출력 예시
// 문자열 : "the sky is blue"
// 출력 : "blue is sky the"

// 문자열 : "  hello     java    "
// 출력 : "java hello"


package TwoPointers;

class Solution04{

    public String solution(String str){
        if(str == null)
            return null;
        if(str.length() < 2)
            return str;

        // 공백을 먼저 제거하자.

        str = removeSpaces(str); // 공백 제거
        char[] cArr = str.toCharArray();
        reverseString(cArr,0,str.length() - 1); // callbyValue
        reverseWords(cArr,str.length());

        String result = new String(cArr);
        return result;
    }

    public String removeSpaces(String str){ // 문자열에 공백을 제거하는 메소드
        int p1 = 0; // 실제 저장되는 데이터 값을 위한 포인터
        int p2 = 0; // 공백을 제거하기 위한 서브 포인터

        char[] charArr = str.toCharArray();
        int length = charArr.length;

        while(p2 < length){

            while(p2 < length && charArr[p2] == ' '){
                p2++;
            } // 공백일때
            while(p2 < length && charArr[p2] != ' '){
                charArr[p1++] = charArr[p2++];
            } // 공백이 아닌 상황
            while(p2 < length && charArr[p2] == ' '){
                p2++;
            } // 다시 공백일때

            // 한 단어에 대해 공백 제거
            if(p2 < length){
                charArr[p1++] = ' ';
            } // 다른 단어가 더 존재(단어와 단어 사이에 공백 추가)
        }
        return new String(charArr).substring(0,p1);
    }
    public void reverseString(char[] cArr, int i, int j){ // 문자열 뒤깁기 메소드
        while(i < j){
            char tmp = cArr[i];
            cArr[i ++] = cArr[j];
            cArr[j --] = tmp;
        }
    }
    public void reverseWords(char[] cArr, int length){

        int p1 = 0;
        int p2 = 0;

        while(p1 < length){

            while(p1 < p2 || p1 < length && cArr[p1] == ' ')
                p1++;
            while(p2 < p1 || p2 < length && cArr[p2] != ' ')
                p2++;

            reverseString(cArr,p1,p2 - 1);
        }

    }


}

public class Pointer04 {

    public static void main(String[] args) {

        System.out.println(new Solution04().solution("the sky is blue"));
        System.out.println(new Solution04().solution("   hello     java    "));
    }
}
