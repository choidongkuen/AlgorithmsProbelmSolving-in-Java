// 날짜 : 2022/11/08
// 문제 : 특별한 문자
// 문제 설명 :
// 소문자 알파벳으로만 이루어져 있는 문자열이 하나 주어졌을 때, 해당 문자열에 단 한번만 나오는 문자를 찾는 프로그램을 작성해보세요.
// 그러한 문자가 없다면  None 출력

// 입력 형식 :
// 첫 번째 줄에는 문자열이 하나 주어집니다. 문자열은 전부 소문자 알파벳으로만 이루어져 있습니다.
// 1 ≤ 주어지는 문자열의 길이 ≤ 100,000

// 입력 예시 01 :
// banana
// 출력 예시 01 :
// b
package CollectionAlgorithms_컬렉션.MapPractice;

import java.util.*;

public class Map07 {

    public static HashMap<Character,Integer> hashMap = new HashMap<>();
    public static Character result;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] charArr = str.toCharArray();


        for (int i = 0; i < charArr.length ; i++) {
            hashMap.put(charArr[i], hashMap.getOrDefault(charArr[i], 0) + 1);
        }

        Set<Character> keySet = hashMap.keySet();

        Iterator<Character> itr = keySet.iterator();

        while(itr.hasNext()){
            Character c = itr.next();
            if(hashMap.get(c) == 1){
                result = c;
            }
        }

        System.out.println(result == null ? "None" : result);



    }
}