// 날짜 : 2022/11/08
// 문제 : 단어장
// 문제 설명 :
// n개의 단어(문자열)가 주어졌을 때,
// 각 단어가 몇 번씩 나왔는지를 앞선 단어가 먼저 나오도록 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 단어가 한 줄에 하나씩 주어집니다.
// 모든 단어는 소문자 알파벳으로만 이루어져 있다고 가정해도 좋습니다.
// 1 ≤ n ≤ 100,000
// 1 ≤ 주어지는 단어의 길이 ≤ 5

// 입력 예시 01 :
// 10
// cat
// apple
// banana
// dog
// apple
// cat
// cat
// cat
// apple
// dog

// 출력 예시 01 :
// apple 3
// banana 1
// cat 4
// dog 2

package CollectionAlgorithms_컬렉션.MapPractice;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Map11 {

    // 단어의 개수
    public static int n;
    public static TreeMap<String,Integer> treeMap = new TreeMap<String, Integer>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {

            String str = sc.next();
            treeMap.put(str,treeMap.getOrDefault(str,0) + 1);
        }
        Iterator<Map.Entry<String,Integer>> itr = treeMap.entrySet().iterator();

        while(itr.hasNext()){
            Map.Entry<String,Integer> entry
                    = itr.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
