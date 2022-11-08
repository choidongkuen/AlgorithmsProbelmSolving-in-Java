// 날짜 : 2022/ 11/ 08
// 문제 : TreeMap 명령어 수행하기

// 문제 설명 :
// n개의 명령이 주어졌을 때, 각 명령을 수행하는 프로그램을 작성해보세요. 명령의 종류는 크게 4가지 입니다
// add k v : (k, v) 쌍을 treemap에 추가합니다. key가 k, value가 v라는 뜻입니다. 이때 만약 동일한 k가 이미 존재한다면, v로 덮어씁니다.
// remove k : key가 k인 쌍을 찾아 treemap에서 제거합니다. 잘못된 입력은 주어지지 않습니다.
// find k : key가 k인 쌍이 treemap에 있는지를 판단합니다. 있다면 해당하는 value를 출력하고, 없다면 None을 출력합니다.
// print_list : treemap에 있는 쌍들을 key 기준으로 오름차순 정렬하여 각 value 값들만 공백을 사이에 두고 순서대로 출력합니다. 만약 treemap이 비어있다면 None을 출력합니다.

// 입력 형식 :
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 명령이 한 줄에 하나씩 주어집니다. 각 명령에 주어지는 key와 value는 전부 숫자입니다. 명령들은 순서대로 수행되어야 합니다. 단, print_list 명령은 최대 10번만 주어진다고 가정해도 좋습니다
// 1 ≤ n ≤ 100,000
// 1 ≤ 주어지는 숫자 ≤ 10
// 9

// TreeMap
// HashMap 의 삽입,삭제,탐색 : O(1)
// TreeMap 의 삽입,삭제,탐색 : O(logN) ( 순서 보장 )
// 일반적인 이진 탐색 트리의 메소드 : O(N) but , 균형 잡힌 이진 탐색 트리 : O(logN)
// TreeMap 은 균형 잡힌 이진 탐색 트리를 기반으로 생성된 자료구조(key 기준 오름차순 정렬)

package CollectionAlgorithms_컬렉션.MapPractice;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Map08 {
    public static TreeMap<Integer,Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n -- > 0){

            String command = sc.next();
            if(command.equals("add")){
                int key = sc.nextInt();
                int value = sc.nextInt();
                treeMap.put(key,value);
            }else if(command.equals("remove")){
                int key = sc.nextInt();
                treeMap.remove(key);

            }else if(command.equals("find")){

                int key = sc.nextInt();
                if(treeMap.containsKey(key)){
                    System.out.println(treeMap.get(key));
                }else{
                    System.out.println("None");
                }
            }else{
                if(treeMap.isEmpty()){
                    System.out.println("None");
                }else {

                    Iterator<Map.Entry<Integer, Integer>> treeMapItr =
                            treeMap.entrySet().iterator();

                    while (treeMapItr.hasNext()) {
                        Integer value = treeMapItr.next().getValue();
                        System.out.print(value + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
