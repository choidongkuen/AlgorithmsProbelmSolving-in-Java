// treeSet을 이용하면 n개의 수가 입력 될 때 마다 최대값을 빠르게 구할 수 있다.
// 시간 복잡도 : O(NlogN)

// 날짜 : 2022/11/09

// 문제 : 정수 명령어
// 문제 설명 :
// 정수만 저장하는 큐가 있습니다. 이 큐에는 다음과 같은 3가지의 연산을 할 수 있습니다.
// I n : 정수 n을 큐에 삽입하는 연산을 의미합니다.
// D 1 : 큐에서 최댓값을 삭제하는 연산을 의미합니다.
// D -1 : 큐에서 최솟값을 삭제하는 연산을 의미합니다.
// 삽입되는 값에 중복되는 숫자는 주어지지 않습니다.
// 만약 큐가 비어있는데 적용할 연산이 ‘D’라면 이 연산은 무시합니다.
// 큐에 적용될 일련의 연산이 주어질 때 이를 처리한 후 최종적으로 큐에 저장된 데이터 중 최댓값과 최솟값을 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 입력의 테스트 데이터의 수를 나타내는 정수 T가 주어집니다.
// 각 테스트 데이터의 첫째 줄에는 큐에 적용할 연산의 개수를 나타내는 정수 k가 주어집니다.
// 이어지는 k 줄 각각엔 연산을 나타내는 문자(‘D’ 또는 ‘I’)와 정수 n이 주어집니다.
// 1 ≤ T ≤ 3
// 1 ≤ k ≤ 100,000
// −10^9 ≤ n ≤ 10^9

// 입력 에시 01 :
// 3
// 5
// I 16
// I -56
// D 1
// D 1
// D 1
// 6
// I -48
// I 65
// D 1
// I -68
// I 48
// D -1
// 4
// I -48
// D 1
// D 1
// D 1

// 출력 예시 01 :
// EMPTY
// 48 -48
// EMPTY


package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set10 {

    public static int k,t;
    public static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 테스트 수 입력 받음
        t = sc.nextInt();

        while(t --> 0){
            // 각 테스트의 연산의 수
            k = sc.nextInt();
            treeSet.clear();

            for (int i = 0; i < t ; i++) {

                String command = sc.next();
                Integer x = sc.nextInt();
                if(command.equals("I")){
                    treeSet.add(x);
                }else if(command.equals("D")){
                    if(treeSet.isEmpty()){
                        continue;
                    }
                    if(x == 1){
                        // 최대값 삭제
                        treeSet.remove(treeSet.last());
                    }else{
                        // 최소값 삭제
                        treeSet.remove(treeSet.first());
                    }
                }
                System.out.println(treeSet.isEmpty() ? "EMPTY" : treeSet.last() + " " + treeSet.first());

            }
        }

    }
}
