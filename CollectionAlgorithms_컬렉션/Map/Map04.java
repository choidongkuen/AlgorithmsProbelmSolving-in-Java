// 날짜 : 2022/10/07
// 문제 : 자주 등장한 top k 숫자

// 문제 설명 :
// n개의 숫자가 주어졌을 때, 자주 등장한 순으로 k개의 숫자를 출력하는 프로그램을 작성해보세요.
// 등장 횟수가 동일한 경우라면 더 큰 숫자부터 출력

// 입력 형식 :
// 첫 번째 줄에는 원소의 개수 n과 k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 원소가 공백을 사이에 두고 주어집니다.
// 1 ≤ k ≤ n ≤ 100,000
// 1 ≤ 주어지는 원소 값 ≤ 10
// 9

// 입력 예시 01 :
// 5 2
// 1 1 3 2 3

// 출력 예시 01 :
// 3 1


package CollectionAlgorithms_컬렉션.Map;

import java.util.*;

public class Map04 {
    public static final int MAX = 100000;
    public static HashMap<Integer, Integer> hashMap;
    public static ArrayList<Node> nodes = new ArrayList<>();

    static class Node implements Comparable<Node>{
        int key;
        int value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        public int compareTo(Node n){
            if(this.value == n.value) // value가 동일한 경우 key 가준 정렬
                return n.key - this.key;
            else // 그 외는 value 기준 정렬
                return n.value - this.value;

            // 큰 값이 먼저 나와야 함으로 내림차순 정렬
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        hashMap = new HashMap<>();

        for (int i = 0; i < n ; i++) {
            int num = sc.nextInt();
            hashMap.put(num, hashMap.getOrDefault(num,0) + 1);
        } // hashMap 생성

        ArrayList<Integer> keyArr = new ArrayList<>(hashMap.keySet());
//        System.out.println(keyArr);

        for (int i = 0; i < keyArr.size() ; i++) {
            int key = keyArr.get(i);
            nodes.add(new Node(key, hashMap.get(key)));
        }
        Collections.sort(nodes); // 정렬 기준을 정했으면 정렬해야지..

        for (int i = 0; i < k ; i++) {
            System.out.print(nodes.get(i).key + " ");
        }
    }
}
