// 날짜 : 2022/10/07
// 문제 : 겹치지 않게 선분 고르기 2
// 문제 설명 :
// 수직선상에 n개의 선분이 주어졌을 때, "겹치지 않게 가장 많은 수의 선분"을 고르는 프로그램을 작성해보세요. 단, 끝점을 공유하는 것 역시 겹친 것으로 생각합니다.

// 입력 형식 :
// 첫 번째 줄에는 선분의 개수를 나타내는 n이 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 선분의 정보 (x1, x2)가 공백을 사이에 두고 주어집니다. 이 때 x1, x2는 해당 선분의 수직선상에서의 양끝점 좌표를 나타냅니다. (1 ≤ x1 < x2 ≤ 1,000)
// 1 ≤ n ≤ 1,000


// 입력 예시 01 :
// 3
// 1 2
// 3 4
// 5 6

// 출력 예시 01 :
// 3

package DynamicProgramming01_동적계획법01;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class DP17 {
    public static final int MAX_N = 1000;
    public static List<Node> info;
    public static int[] dp = new int[MAX_N + 1];
    public static int n;

    static class Node{
        int s;
        int e;

        public Node(int s, int e){
            this.s =  s;
            this.e = e;
        }
    }
    public static int solution(){
        return 1;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        for (int i = 0; i < n ; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            info.add(new Node(s,e));
        }

        System.out.println(solution());
    }
}
