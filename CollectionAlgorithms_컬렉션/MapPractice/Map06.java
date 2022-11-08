// 날짜 : 2022/11/08
// 문제 :  순서를 바꾸었을 때 같은 단어 그룹화 하기

// 문제 설명 :
// n개의 단어가 입력으로 주어질 때, 한 단어에 속한 문자들의 순서를 바꾸어 만들 수 있는 단어들은 같은 그룹에 속한다고 정의된다고 합니다.
// 이 때 동일한 그룹에 속한 단어가 가장 많은 그룹의 단어 개수를 출력하는 코드를 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 단어의 개수 n이 주어집니다.
// 두 번째 줄부터 n+1번째의 줄에는 각각의 단어가 입력으로 주어집니다.
// 단 알파벳만이 입력으로 주어지며, 대소문자를 구분합니다.
// 1 ≤ n ≤ 1,000
// 1 ≤ 단어의 최대길이(m) ≤ 1,000

// 입력 예시 01 :
// 4
// aba
// aab
// naa
// baa

// 출력 예시 01 :
// 3

package CollectionAlgorithms_컬렉션.MapPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Map06 {

    public static final int MAX_N = 1000;

    public static int n;
    public static HashMap<String,Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        while(n -- > 0){

            // 문자열 입력 받고
            String str = sc.next();
            // 문자 배열로 변환 후,
            char[] charArr = str.toCharArray();
            // 문자 배열 정렬
            Arrays.sort(charArr);
            // 다시 문자열로 변환
            str  = new String(charArr);

//            System.out.println(str);

            hashMap.put(str,hashMap.getOrDefault(str,0) + 1);
        }

        List<Integer> valueCnt = hashMap.values().stream().collect(Collectors.toList());
        int maxCnt = Collections.max(valueCnt);
        System.out.println(maxCnt);

    }
}
