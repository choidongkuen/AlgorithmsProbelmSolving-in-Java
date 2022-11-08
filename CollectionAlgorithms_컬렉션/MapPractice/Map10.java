// 날짜 : 2022/11/08
// 문제 : 처음 등장하는 위치
// 문제 설명 :
// n개의 숫자가 주어졌을 때, 각 숫자마다 처음으로 주어진 위치를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 원소의 개수 n이 주어집니다. 두 번째 줄에는 n개의 숫자가 주어집니다.
// 1 ≤ n ≤ 100,000
// −10^9 ≤ 주어지는 숫자 ≤ 10^9

// 입력 예시 01 :
// 5
// 1 5 2 2 1

// 출력 예시 01 :
// 1 1
// 2 3
// 5 2

package CollectionAlgorithms_컬렉션.MapPractice;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Map10 {
    public static final int MAX_N = 100000;
    public static TreeMap<Integer,Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n ; i++) {

            int num = sc.nextInt();
            // 이미 해당 숫자 key로 처리
            if(treeMap.containsKey(num)) {
                continue;
            }
            treeMap.put(num,(i + 1));
        }

        Iterator<Map.Entry<Integer,Integer>> itr = treeMap.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,Integer> entry = itr.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
