package DynamicProgramming02_동적계획법02;

// 날짜 : 2022/11/2
// 문제 : 겹치지 않게 선분 고르기
// 문제 설명 :
// 수직선상에 n개의 선분이 주어졌을 때, 겹치지 않게 가장 많은 수의 선분을 고르는 프로그램을 작성해보세요.
// 단, 끝점을 공유하는 것 역시 겹친 것으로 생각합니다.

// 입력 형식 :
// 첫 번째 줄에는 선분의 개수를 나타내는 n이 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 선분의 정보 (x1, x2)가 공백을 사이에 두고 주어집니다. 이 때 x1, x2는 해당 선분의 수직선상에서의 양끝점 좌표를 나타냅니다. (1 ≤ x1 < x2 ≤ 1,000)
// 1 ≤ n ≤ 1,000

// 입력 예시 01:
// 3
// 1 2
// 3 4
// 5 6
// 출력 예시 01 :

// 3

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Collections;
// import java.util.Scanner;

// public class Main{

//     public static final int MAX = 1000;
//     public static int n;
//     public static ArrayList<Point> points = new ArrayList<>();

//     static class Point implements Comparable<Point>{
//         int x, y;

//         public Point(int x, int y) {
//             this.x = x;
//             this.y = y;
//         }

//         @Override
//         public int compareTo(Point o) {

//             if(this.y == o.y){
//                 return this.x - o.x;
//             }
//             return this.y - o.y;
//         } // 끝 지점 기준 오름차순 정렬
//     }

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);
//         n = sc.nextInt();

//         for (int i = 0; i < n ; i++) {
//             points.add(new Point(sc.nextInt(),sc.nextInt()));
//         }

//         Collections.sort(points); // 정렬

//         int cnt = 0;
//         int preEndTime = -1;



//         for (int i = 0; i < points.size() ; i++) {
//             if(preEndTime < points.get(i).x){
//                 preEndTime = points.get(i).y; // 끝나는 시간 갱신
//                 cnt ++;
//             }
//         }
//         System.out.println(cnt);
//     }
// }
import java.util.*;

public class Dp02{

    // 동적 계획법으로 풀기

    public static final int MAX = 1000;

    //    public static int[] arr = new int[MAX + 1];
    public static int[] dp = new int[MAX + 1];
    public static ArrayList<Point> arrList = new ArrayList<>();

    public static int n;

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();
            arrList.add(new Point(x,y));
        }

        Collections.sort(arrList, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x;
            }
        });

        for (int i = 0; i < arrList.size() ; i++) {

            int x1 = arrList.get(i).x;
            int y1 = arrList.get(i).y;
            dp[i] = 1; // 모든 점은 최소 겹치지 않는 수로 1의 값을 가짐

            // 현재 지점과 겹치지 않는 지점 중 겹치지 않는 수의 값으로 최대값을 가지는 이전 지점 값 + 1
            for (int j = 0; j < i ; j++) {

                int x2 = arrList.get(j).x;
                int y2 = arrList.get(j).y;

                if(y2 < x1)
                    dp[i] = Math.max(dp[i],dp[j] + 1);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }

}