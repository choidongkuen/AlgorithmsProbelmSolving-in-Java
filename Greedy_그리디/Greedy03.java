// 날짜 : 2022/11/03
// 문제 : 0/1 knapsack

// 문제 설명 :
// 도둑이 보석방을 털러 갔습니다. 보석방에는 n개의 보석이 있고, 도둑 가방의 크기는 m이기 때문에 이보다 더 많은 양의 무게에 해당하는 보석들을 담아 나올 수는 없습니다.
// 또한, 보석은 종류별로 단 하나씩만 있으며 각 보석을 원하는 만큼 쪼개어 담는 것이 가능합니다.
// 예를 들어 도둑방에 보석이 다음과 같이 5개가 있는 경우를 살펴봅시다. 이때 도둑 가방의 크기는 8이라 가정합니다.
// 이 예시에서는 1번 보석과 3번 보석을 담고, 2번 보석의 2/3 만큼 담으면 무게는 정확히 8이 되며 이때 가치는 10.333이 됩니다. 이 예시에서 이보다 더 크게 가치를 만들 수는 없습니다.
// 도둑 가방 크기의 정보와 보석의 정보가 주어졌을 때, 얻을 수 있는 최대 가치를 구하는 프로그램을 작성해보세요

// 입력 형식 :
// 첫째 줄에는 N과 M이 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터는 N개의 줄에 걸쳐 보석의 정보 (w, v) 가 공백을 사이에 두고 주어집니다. w는 해당 보석의 무게를 의미하며, v는 해당 보석의 가치를 의미합니다. (1 ≤ w ≤ 1,000, 1 ≤ v ≤ 1,000)
// 1 ≤ N ≤ 100,000
// 1 ≤ M ≤ 1,000,000,000

// 입력 예시 01 :
// 3 7
// 5 8
// 3 6
// 4 4

// 출력 예시 02 :
// 12.400

// 아이디어 :
// 가격/무게 값이 가장 큰 것 부터 내림차순 정렬


package Greedy_그리디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Greedy03 {

    static class Jewelry implements Comparable<Jewelry>{

        int w,v;

        public Jewelry(int w, int v) {
            this.w = w;
            this.v = v;
        }

        @Override
        public int compareTo(Jewelry o) {
            if((double)this.v / (double)this.w > (double)o.v / (double)o.w) {
                return -1;
            }
            else if((double)this.v / (double)this.w  == (double)o.v / (double)o.w) {
                return 0;
            }
            else{
                return 1;
            }
        }
    }

    public static final int MAX_N = 100000;
    public static final int MAX_M = 1000000000;
    public static ArrayList<Jewelry> jewelry = new ArrayList<>();

    public static int n,m;
    public static double ans;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 보석 개수
        m = sc.nextInt(); // 가방 크기


        for (int i = 0 ; i < n ; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            jewelry.add(new Jewelry(w,v));
        }

        Collections.sort(jewelry);

        for (int i = 0; i < jewelry.size(); i++) {
            Jewelry j = jewelry.get(i);
            int w = j.w;
            int v = j.v;


            if(m >= w){ // 남은 가방의 크기가 해당 보석의 크기보다 큰 경우
                m -= w;
                ans += v;
            }else{ // 작은 경우 쪼갠 값으로 적용
                ans += (double)m/w * v;
                break;
            }
        }

        System.out.printf("%.3f",ans);
    }
}
