// 날짜 : 2022/11/10
// 문제 : 배열에서의 추출2

// 문제 설명 :
// 배열에 다음과 같은 연산을 할 수 있습니다.
// 배열에 정수 x (x ≠ 0) 를 넣습니다.
// 배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거합니다.
// ( 절댓값이 가장 작은 값이 여러개일 때는, 그 중 가장 작은 수를 출력하고, 그 값을 배열에서 제거합니다. )
// 비어있는 배열에서 시작하여 입력된 연산을 실행하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 연산의 개수 n이 주어집니다.
// 다음 n개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어집니다.
// x가 0이 아닌 정수라면 배열에 x라는 값을 넣습니다.
// x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거합니다.
// 1 ≤ n ≤ 100,000
// −2^31 < 입력되는 수 < 2^31

// 입력 예시 01 :
// 12
// -1
// 1
// 0
// 0
// 0
// -1
// -1
// 1
// 0
// 0
// 0
// 0

// 출력 예시 01 :
// -1
// 1
// 0
// -1
// -1
// 1
// 0

// 아이디어 :
// 처음 시도 : TreeSet을 쓰려고 했으나, TreeSet은 중복 허용 x
// 따라서 우선순위 큐를 사용
package CollectionAlgorithms_컬렉션.PriorityQueue;

import java.util.*;

public class Pq03 {
    static class Point implements Comparable<Point>{
        int value;

        public Point(int value){
            this.value = value;
        }

        public int compareTo(Point p){
            // 두 객체의 절대값이 같은 경우, 실제 값 고려
            if(Math.abs(this.value) == Math.abs(p.value)){
                return this.value - p.value;
            }

            return Math.abs(this.value) - Math.abs(p.value);
        }
    }

    // 주어지는 연산의 횟수
    public static int n;
    public static PriorityQueue<Point> pq = new PriorityQueue<>();

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        while(n -- > 0){

            int command = sc.nextInt();

            if(command == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else {
                    Point p = pq.poll();
                    System.out.println(p.value);
                }
            }else{
                pq.add(new Point(command));
            }

        }
    }
}