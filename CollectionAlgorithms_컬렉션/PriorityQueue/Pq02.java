// 날짜 : 2022/11/09
// 문제 : k번째로 작은 쌍의 합

// 문제 설명 :
// n개의 숫자로 이루어진 수열과 m개의 숫자로 이루어진 수열이 주어졌을 때,
// 각 수열에서 정확히 원소를 하나씩만 뽑아 나올 수 있는 모든 쌍들을 모두 구하고,
// 그 값들을 오름차순이 되도록 나열했을 때의 k번째 쌍의 두 수의 합을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n, m, k가 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다. 주어지는 모든 숫자는 다르다고 가정해도 좋습니다.
// 세 번째 줄에는 m개의 숫자가 공백을 사이에 두고 주어집니다. 주어지는 모든 숫자는 다르다고 가정해도 좋습니다.
// 1 ≤ n, m ≤ 100,000
// 1 ≤ k ≤ min(n * m, 100,000)
// 1 ≤ 주어지는 숫자들 ≤ 10^9

// 입력 예시 01 :
// 5 4 4
// 6 1 2 3 7
// 1 8 7 5

// 출력 예시 01 :
// 6

// 아이디어 :
// 모든 조합을 naive 하게 고려하면 O(n^2) = > 100억 연산(시간 초과)
package CollectionAlgorithms_컬렉션.PriorityQueue;

import java.util.*;

public class Pq02 {

    static class Tuple implements Comparable<Tuple>{
        int sum;
        int idx1;
        int idx2;


        public Tuple(int s, int idx1, int idx2){
            this.sum = s;
            this.idx1 = idx1;
            this.idx2 = idx2;
        }

        public int compareTo(Tuple t){

            if(this.sum != t.sum){
                return this.sum - t.sum;
            }if(this.idx1 != t.idx1){
                return this.idx1 - t.idx1;
            }else{
                return this.idx2 - t.idx2;
            }

        }
    }

    public static int MAX_N = 100000;
    public static int MAX_M = 100000;

    public static PriorityQueue<Tuple> pq = new PriorityQueue<>();
    public static int[] A = new int[MAX_N];
    public static int[] B = new int[MAX_M];
    public static int n,m,k;

    public static void main(String[] args) {
        // Your Program Goes Here

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();


        for(int i = 0; i < n; i ++){
            A[i] = sc.nextInt();
        }


        for(int j = 0; j < m; j ++){
            B[j] = sc.nextInt();
        }

        // 두 수열 모두 오름차순 정렬
        Arrays.sort(A,0,n);
        Arrays.sort(B,0,m);


        // step 1 : 모든 수열 A의 원소에 대해 B 수열의 첫번째 원소와의 조합을 우선순위 큐에 넣어준다.
        // => 이는 첫번째 최소값을 갖는 조합을 보장한다.
        for(int i = 0; i < n; i ++){
            pq.add(new Tuple(A[i] + B[0],i,0));
        }


        // step 2 : 구성한 우선순위 큐를 가지고
        // k - 1 번 가장 최소값을 삭제한다.
        // 이때 삭제되는 Tuple 객체의 idx1 속성을 잘 고려하자
        // 만약 최소 Tuple의 조합이(i,j)였다면
        // 다음 조합은 (i,j + 1) 조합을 고려한다.

        for(int i = 0; i < k - 1; i ++){
            Tuple minTuple = pq.poll();
            int sum = minTuple.sum;
            int idx1 = minTuple.idx1;
            int idx2 = minTuple.idx2;

            if(idx2 + 1 < m){
                idx2 ++;
                pq.add(new Tuple(A[idx1] + B[idx2],idx1,idx2));
            }
        }

        // step 3 : k - 1번의 반복문 후
        // 가장 우선순위가 높은 객체의 sum 속성이 답이다.
        System.out.println(pq.peek().sum);


    }
}