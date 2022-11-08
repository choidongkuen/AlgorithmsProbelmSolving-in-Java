// 날짜 : 2022/11/08

// 문제 : 비율 구하기
// 문제 설명 :
// 여러가지의 문자열이 주어졌을때 그 문자열이 전체 문자열 중 어느정도의 비율을 차지하는지에 대해 구하는 프로그램을 작성해보세요.

// 입력 형식 :

// 첫 번째 줄에는 문자열의 개수 n이 주어집니다.
// 두 번째 줄부터 n + 1 번째의 줄에는 각각의 문자열이 입력으로 주어집니다.
// 1 ≤ n ≤ 10000
// 1 ≤ 문자열의 길이 ≤ 30

// 입력 예시 01 :
// 5
// red
// blue
// green
// yellow
// red

// 출력 예시 01 :
// blue 20.0000
// green 20.0000
// red 40.0000
// yellow 20.0000

// 아이디어 :
// 문자열을 key, 출현 갯수를 value 로 설정
// 주어지는 문자열을 사전순으로 출력해야 함으로 treeMap 사용하자

package CollectionAlgorithms_컬렉션.MapPractice;

import java.util.*;
import java.util.stream.Collectors;

public class Map09 {

    public static int n;
    public static TreeMap<String,Integer> treeMap = new TreeMap<>();
    public static ArrayList<String> strList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        // n개의 원소 입력 받기
        for (int i = 0; i < n ; i++) {
            strList.add(sc.next());
        }

        for(int i = 0; i < strList.size(); i ++ ){
            String key = strList.get(i);

            if(treeMap.containsKey(key)){
                treeMap.put(key,treeMap.get(key) + 1);
            }else{
                treeMap.put(key,1);
            }
        }
        System.out.println(n);
//        List<Integer> valueList = treeMap.values().stream().collect(Collectors.toList());
//        System.out.println(valueList);

        Iterator<Map.Entry<String, Integer>> itr = treeMap.entrySet().iterator();
        while (itr.hasNext()) {

            Map.Entry<String,Integer> entry = itr.next();

            String k = entry.getKey();
            int cnt = entry.getValue();

            double ratio = (double)cnt / n * 100;
            System.out.printf("%s %.4f\n",k,ratio);
        }
    }
}
