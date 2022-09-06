// 날짜 : 2022/09/07
// 문제 : 상해버린 치즈

// 문제 설명 :
// N명의 사람이 M개의 치즈를 먹었는데 정확히 하나의 치즈가 상했다는것을 뒤늦게 알았습니다. 특정 사람이 어떤 치즈를 언제 먹었는지에 대한 기록이 총 D번 주어지고,
// 특정 사람이 언제 확실히 아팠는지에 대한 기록이 S번 주어지게 됩니다.
// 완벽하게 기록된 것이 아니기 때문에, 아프다고 기록되어 있는 사람 외의 다른 사람도 아플 수 있습니다. 상한 치즈를 먹은 사람에게 약을 복용시켜야 할 때, 약이 최대 몇 개나 필요할지를 구하는 프로그램을 작성해보세요.
// 단, 상한 치즈를 먹게 되면 1초가 지나야 아프기 시작하며, 상한 치즈를 먹지 않는 한 배가 아플 일은 없다고 가정해도 좋습니다.


// 입력 형식 :
// 첫 번째 줄에 사람의 수 N, 치즈의 수 M, 치즈를 먹은 기록의 수 D, 그리고 아픈 기록의 수 S가 각각 공백을 사이에 두고 주어집니다.
//1 ≤ N ≤ 50
//1 ≤ M ≤ 50
//1 ≤ D ≤ 1,000
//1 ≤ S ≤ N

//두 번째 줄부터 D개의 줄에 걸쳐 한 줄에 하나씩 몇 번째 사람(p)이 몇 번째 치즈(m)를 언제 먹었는지(t초)에 대한 정보 (p, m, t)가 공백을 사이에 두고 주어집니다.
//1 ≤ p ≤ N
//1 ≤ m ≤ M
//1 ≤ t ≤ 100

//그 다음에는 S개의 줄에 걸쳐 한 줄에 하나씩 몇 번째 사람(p)이 언제 확실히 아팠는지(t초)에 대한 기록 (p, t)가 공백을 사이에 두고 주어집니다. 동일한 사람이 아프다는 정보가 여러 번 주어지지 않는다고 가정해도 좋습니다. 또한, 모순된 입력 역시 주어지지 않는다고 가정해도 좋습니다.
//1 ≤ p ≤ N
//1 ≤ t ≤ 100

// 입력 예시 :
// 3 4 7 2
// 1 1 1
// 1 4 1
// 1 3 4
// 1 2 2
// 3 1 3
// 2 1 5
// 2 2 7
// 1 3
// 2 8

// 출력 예시 :
// 3

package ExhaustiveSearch01_완전탐색01;

import java.util.*;

class info1{ // d번의 기록(누가 어떤치즈를 언제 먹었는지)
    int p,m,t;
    public info1(int p, int m, int t){
        this.p = p;
        this.m = m;
        this.t = t;
    }
}

class info2{ // s번의 기록(누가 언제 아팠는지)
    int p,t;
    public info2(int p, int t){
        this.p = p;
        this.t = t;
    }
}

public class ES29 {
    public static final int MAX_N = 50; // 최대 인원
    public static final int MAX_M = 50; // 최대 치즈 수
    public static final int MAX_D = 1000; // 어떤 사람이 어떤 치즈를 언제 먹었는지에 대한 정보의 최대 수
    public static int n,m,d,s;

    public static info1[] dRecord = new info1[MAX_D]; // D번의 기록에 대한 인스턴스 배열
    public static info2[] sRecord = new info2[MAX_N]; // S번에 기록에 대한 인스턴스 배열


    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); d = sc.nextInt(); s = sc.nextInt();


        for(int i = 0; i < d; i++){
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();

            dRecord[i] = new info1(p,m,t);
        }

        for(int i = 0; i < s; i++){
            int p = sc.nextInt();
            int t = sc.nextInt();

            sRecord[i] = new info2(p,t);
        }
        // 인스턴스 배열 완성
        // 특정 치즈 기준으로 생각하자
        // 치즈가 상할 조건 : 1. 아픈사람 중에 반드시 그 치즈를 먹은 사람이 있어야 함.
        //                2. 특정 치즈를 먹은 사람의 먹은 시점이 아픈 시점보다 작아야함.
        // time배열을 만들어서 각 사람들에 대해 먹은 경우, 원소로 시간을 기록
        // 먹지 않았다면, 원소는 0

        int ans = 0; // 필요한 약의 최대 개수

        for(int i = 1; i<=m; i++){ // i번째 치즈
            int[] times = new int[MAX_N + 1]; // 1 - 50번

            for(int j = 0; j < d; j++){
                if(dRecord[j].m != i) // i 치즈를 먹지 않은 사람에 대한 정보인 경우
                    continue;

                // i치즈를 먹은 사람에 대한 정보인 경우
                if(times[dRecord[j].p] == 0)
                    times[dRecord[j].p] = dRecord[j].t;
                else if(times[dRecord[j].p] > dRecord[j].t)
                    times[dRecord[j].p] = dRecord[j].t;
            }

            boolean isPossible = true; // 해당 i번째 치즈가 상할 가능성

            for(int j = 0; j < s; j++){

                if(times[sRecord[j].p] == 0){
                    isPossible = false; // 아픈 사람중 해당 치즈르 먹지 않은 사람이 있는 경우
                    break;
                }
                if(times[sRecord[j].p] >= sRecord[j].t){
                    isPossible = false;
                    break;
                }
            }
            int cnt = 0;
            if(isPossible){ // i번째 치즈는 상했을 확률이 있음
                for(int j = 1; j <= n; j++){
                    if(times[j] != 0) // d기록 중 i번째 치즈를 먹은 사람이라면
                        cnt++;
                }
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }
}
