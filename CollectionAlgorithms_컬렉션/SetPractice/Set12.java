// 날짜 : 2022/11/09
// 문제 : 친한 점

// 문제 설명 :
// 2차 평면 위에 서로 다른 n개의 점이 주어집니다. 이후 m개의 질의가 주어지는데, 각 질의마다는 한 개의 점이 주어집니다.
// 각 질의에 대해 주어진 점 마다 가장 친근한 점을 찾아 출력하는 프로그램을 작성해보세요.
// (x, y)에 대해 (x', y')가 친근한 점이기 위해서는 x < x' 혹은 (x=x', y ≤ y')을 만족해야 합니다.
// 이 중 가장 친근한 점은 x좌표 값이 가장 작은 점이며, x좌표가 작은 점이 여러 개인 경우 y좌표 값이 가장 작은 점이 가장 친근한 점이 됩니다.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터는 n개의 줄에 걸쳐 점의 위치 (x, y)가 한 줄에 하나씩 공백을 사이에 두고 주어집니다.
// 이후 m개의 줄에 걸쳐 질의에 해당하는 점의 위치가 한 줄에 하나씩 공백을 사이에 두고 주어집니다.
// 1 ≤ n, m ≤ 10 ^ 5
// 1 ≤ 주어진 점들의 x, y 값 ≤ 10 ^ 9

// 입력 에시 01 :
// 3 2
// 6 2
// 1 5
// 2 9
// 5 7
// 6 3
// 출력 예시 01 :
//  6 2
// -1 -1

// 아이디어 :
// 일단 정렬 부터 하자
// treeSet 에서 커스텀 객체 정렬은 어떤 느낌? => 해당 객체를 treeSet에 넣는다고 생각 # 원래 커스텀 객체 정렬이랑 비슷

package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set12 {
    static class Point implements Comparable<Point>{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // this 기준 o 참조 변수와 비교

        @Override
        public int compareTo(Point o) {
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static final int MAX = (int)1e5;
    public static int n,m;

    public static TreeSet<Point> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n ; i++) {

            int x = sc.nextInt(); // x'
            int y = sc.nextInt(); // y'

            treeSet.add(new Point(x,y));
        }

        for (int i = 0; i < m; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            if(treeSet.ceiling(new Point(x,y)) == null){
                System.out.println("-1 -1");
            }else{
                System.out.println(treeSet.ceiling(new Point(x,y)).x + " " + treeSet.ceiling(new Point(x,y)).y);
            }
        }
    }
}
