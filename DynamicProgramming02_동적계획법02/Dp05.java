package DynamicProgramming02_동적계획법02;

// 날짜 : 2022/11/02
// 문제 : 알바로 부자 되기
// 문제 설명 :
// 총 N개의 알바 정보가 주어졌을 때, 적절하게 알바를 선택하여 일하는 기간이 겹치지 않게 하면서 얻을 수 있는 돈이 최대가 되도록 하는 프로그램을 작성해보세요.
// 동시에 2개 이상의 알바를 하는 것은 불가능 하며, 각각의 알바는 일해야 하는 기간을 모두 채워야 돈을 얻을 수 있습니다.
// 단, 한 알바를 끝낸 날과 다른 알바를 시작하는 날이 일치하는 경우에도 일하는 기간이 겹치는 것으로 간주합니다.

// 입력 형식 :
// 첫째 줄에는 N이 주어집니다.
// 두 번째 줄 부터는 N개의 줄에 걸쳐 알바 정보 (s,e,p)이 공백을 사이에 두고 주어집니다. s는 알바가 시작되는 날짜, e는 알바가 끝나는 날짜를 의미하며, p는 해당 알바를 하여 얻을 수 있는 금액을 의미합니다.
// (1≤s≤e≤10^9,≤p≤1,000)
// 알바가 시작되는 날짜가 증가하는 순으로 데이터가 주어진다고 가정해도 좋습니다.
// 1≤N≤1,000


// 입력 예시 01 :
// 2
// 1 5 10
// 5 10 6

// 출력 예시 01 :
// 10

import java.util.*;

public class Dp05 {

    static class Work{
        int s,e,cost;

        // dp[i] = 이전 dp[j] 중 최대값(i.start > j.end 인 경우)

        public Work(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }

    public static final int MAX_N = 1000;

    public static ArrayList<Work> works = new ArrayList<>();
    public static int[] dp = new int[MAX_N + 1];

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            works.add(new Work(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }

        Collections.sort(works, new Comparator<Work>() {
            @Override
            public int compare(Work o1, Work o2) {
                return o1.s - o2.s;
            }
        }); // 시작 시간 기준으로 오름차순 정렬

        for (int i = 1; i <= n ; i++) {

            dp[i] = works.get(i - 1).cost;

            for (int j = 1; j < i ; j++) {

                if(works.get(i - 1).s > works.get(j - 1).e){
                    dp[i] = Math.max(dp[i], dp[j] + works.get(i - 1).cost);
                }
            }

        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
