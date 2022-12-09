// 날짜 : 2022/11/04
// 문제 : 회의실 고르기

// 문제 설명 :
// 하나의 회의실이 있고, n개의 회의 요청이 들어왔습니다.
// 각 회의의 시작 시간과 끝 시간이 주어져 있으며, 한 회의가 시작되면 도중에 그만둘 수 없고, 한 회의가 끝나는 직후에 동시에 다른 회의가 시작될 수 있습니다. 적절하게 회의 요청을 수락하여 최대로 많은 회의가 진행되도록 하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 회의 요청이 들어온 횟수 n이 주어집니다.
// 두 번째 줄부터는 n개의 줄에 걸쳐 회의의 정보 (s, e)가 한 줄에 하나씩 공백을 사이에 두고 주어집니다. 이는 해당 회의가 시간 s에서 시작하여 시간 e에 끝남을 의미합니다. 여기서 시간은 편의상 하나의 정수값으로 주어집니다.
// 1 ≤ n ≤ 100,000
// 0 ≤ s < e ≤ 100,000

// 입력 예시 01:
// 7
// 0 1
// 1 9
// 8 23
// 2 3
// 3 4
// 7 8
// 4 6

// 출력 예시 01:
// 6

// 아이디어 :
// try 01) 회의시간이 가장 빠른 회의 부터 고르기
// -> 최적의 해 x
// try 02) 회의시간의 시작시간이 빠른 회의 부터 고르기
// -> 최적의 해 x
// try 03) 회의시간의 끝나는 시간이 빠른 회의 부터 고르기
// -> 항상 끝나는 시간이 빠른 것 부터 고르면 남은 시간이 항상 최대가 된다.


// 동적계획법으로도 구할 수 있다.
package Greedy_그리디;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy05 {

    static class Meeting{
        int s,e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static final int MAX_N = 100000;

    public static int n;
    public static int ans;
    public static PriorityQueue<Meeting> pq = new PriorityQueue<>(new Comparator<Meeting>() {
        @Override
        public int compare(Meeting o1, Meeting o2) {

            // 끝나는 시간이 같은 경우
            // 시작 시간이 큰 거 부터
            // ex (2,3) , (3,3)
            if(o1.e == o2.e){
                return o1.s - o2.e;

            // 끝나는 시간이 다른 경우
            }else{
                return o1.e - o2.e;
            }
        }
    });


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n ; i++) {

            int start = scanner.nextInt();
            int end = scanner.nextInt();

            pq.add(new Meeting(start,end));
        }

        int preEnd = -1;

        while(!pq.isEmpty()){

            Meeting m = pq.poll();
            int s = m.s;
            int e = m.e;

            if(s >= preEnd){

                preEnd = e;
                ans ++;
            }
        }
        System.out.println(ans);
    }

}
