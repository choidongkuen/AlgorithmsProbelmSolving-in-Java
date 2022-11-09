// 날짜 : 2022/11/09
// 문제 : 점 빼기

// 문제 설명 :
// 2차 평면 위에 서로 다른 n개의 점이 주어집니다. 이후 m개의 질의가 주어지는데, 각 질의마다는 한 개의 숫자 k가 주어집니다.
// 각 질의에 대해 주어진 숫자 k보다 x값이 같거나 큰 점 중 x값이 가장 작은 점을 찾아 지우려고 합니다.
// 만약 x값이 가장 작은 점이 여러 개라면, 그 중 y값이 가장 작은 점을 지우면 됩니다. 각 질의에 대해 해당하는 점을 순서대로 출력하고 지우는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터는 n개의 줄에 걸쳐 점의 위치 (x, y)가 한 줄에 하나씩 공백을 사이에 두고 주어집니다.
// 이후 m개의 줄에 걸쳐 질의에 해당하는 숫자 k가 한 줄에 하나씩 주어집니다.
// 1 ≤ n, m ≤ 10 ^ 5
// 1 ≤ 주어진 점들의 x, y 값 ≤ 10 ^ 9
// 1 ≤ k ≤ 10 ^ 9

// 입력 예시 01 :
// 3 3
// 6 2
// 2 9
// 2 5
// 1
// 1
// 7

// 출력 예시 01 :
// 2 5
// 2 9
// -1 -1

package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set18 {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            // x 좌표값이 동일한 경우 y기준으로 오름차순 정렬
            if (this.x == o.x) {
                return this.y - o.y;
            }
            // x 좌표값이 다르다면 x기준으로 오름차순 정렬
            return this.x - o.x;
        }
    }

    public static int n, m;
    public static TreeSet<Point> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();

            treeSet.add(new Point(x, y));
            // O(NlogN) : n개의 데이터 삽입
        }

        while( m -- > 0){
            // O(MlogN) : m개의 데이터 삭제 및 탐색

            Integer x = sc.nextInt();
            if(treeSet.higher(new Point(x,0)) == null){
                System.out.println("-1 -1");
            }else{
                Point p = treeSet.higher(new Point(x,0));
                System.out.println(p.x + " " + p.y);
                treeSet.remove(p);
            }
        }
    }
}
