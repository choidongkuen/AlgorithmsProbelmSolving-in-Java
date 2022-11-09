// 날짜 : 2022/11/09
// 문제 : 중앙값 찾기

// 문제 설명 :
// 수열을 입력받고, 홀수 번째의 원소를 읽을 때 마다 지금까지 입력받은 값의 중앙값을 출력하는 프로그램을 작성해보세요.
// 중앙값이란?
// 중앙값이란 어떤 주어진 값들을 오름차순으로 정렬했을 때 가장 중앙에 위치하는 값을 의미합니다.

// 입력 형식 :
// 첫 번째 줄에 테스트 케이스의 개수 t가 주어집니다.
// 두 번째 줄 부터는 각 테스트 케이스가 주어집니다.
// 테스트 케이스의 첫 번째 줄에는 수열의 크기 m이 주어집니다.
// 테스트 케이스의 두 번째 줄 부터는 수열의 원소가 한 줄에 m개씩 주어집니다.
// 1 ≤ t ≤ 5
// 1 ≤ m ≤ 100,000, m은 홀수
// 0 ≤ 주어지는 정수 ≤ 100,000

// 입력 예시 01 :
// 2
// 5
// 1 2 3 4 5
// 7
// 7 6 5 4 3 2 1

// 출력 예시 01 :
// 1 2 3
// 7 6 5 4
package CollectionAlgorithms_컬렉션.PriorityQueue;

import java.util.*;

public class Pq01 {

    // 총 테스트 개수
    public static int t;
    public static Scanner sc;
    public static PriorityQueue<Integer> minPq; // 중앙값보다 큰 값들을 위한 최소 힙
    public static PriorityQueue<Integer> maxPq; // 중앙값보다 작은 값들을 위한 최대 힙
    public static int[] arr;

    public static void findMedian(int m){

        arr = new int[m]; // m개의 원소를 저장할 배열
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>();

        for (int i = 0; i < m ; i++) {
            arr[i] = sc.nextInt();
        }
        int median = arr[0]; // 일단 처음 값을 중앙값
        System.out.print(median + " " );

        for (int i = 1; i < m ; i++) {

            // 짝수번째 원소인 경우
            if(i % 2 != 0){
                if(arr[i] > median){
                    minPq.add(arr[i]);
                }else{
                    maxPq.add(-arr[i]);
                }

            // 홀수번째 원소인 경우
            }else{

                int val = 0;
                if (maxPq.size() > minPq.size()) {
                    val = -maxPq.poll();
                }else{
                    val = minPq.poll();
                }

                ArrayList<Integer> arrList = new ArrayList<>();

                arrList.add(val);
                arrList.add(median);
                arrList.add(arr[i]);

                Collections.sort(arrList);

                maxPq.add(-arrList.get(0));
                median = arrList.get(1);
                minPq.add(arrList.get(2));

                System.out.print(median + " ");
            }
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        t = sc.nextInt();
        while(t -- > 0){
            // 각 테스트 마다의 수열의 원소 개수
            int m = sc.nextInt();

            findMedian(m);
            System.out.println();
        }
    }
}
