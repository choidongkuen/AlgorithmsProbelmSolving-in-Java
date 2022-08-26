// 문제 : 선두를 지켜라
// 날짜 : 2022/08/22
// 문제 설명 : A와 B가 동일한 시작점에서 같은 방향으로 출발합니다.
// 도중에 방향을 바꾸는 경우는 없고, A, B는 각각 N번, M번에 걸쳐주어지는 특정 속도로 특정 시간만큼 이동한다고 합니다.
// 선두가 몇번이 바뀌는지 찾아 출력하는 프로그램을 작성해보세요.

// 입력 형식
// 첫 번째 줄에 N과 M이 주어집니다.
// 두 번째 줄부터는 N개의 줄에 걸쳐 각 줄마다 A가 어떤 속도로 몇 시간 동안 이동했는지를 나타내는 (v, t) 값이 공백을 사이에 두고 주어집니다.
// 그 다음 줄부터는 M개의 줄에 걸쳐 각 줄마다 B가 어떤 속도로 몇 시간 동안 이동했는지를 나타내는 (v, t) 값이 공백을 사이에 두고 주어집니다.
// A가 총 이동한 시간과 B가 총 이동한 시간은 항상 동일하게 주어짐을 가정해도 좋습니다.
// 1 ≤ N, M ≤ 1,000
// 1 ≤ v, t ≤ 1,000

// ===============================================================
// 입력 예시
// 4 3
// 1 2
// 4 1
// 1 1
// 2 10
// 2 3
// 1 2
// 3 9
// ===============================================================
// 출력 예시
// 2

package Simulation_시뮬레이션;
import java.util.*;

public class Simulation05 {
    public static final int MAX = 1000;
    public static ArrayList<Integer> listA = new ArrayList<>();
    public static ArrayList<Integer> listB = new ArrayList<>();
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        listA.add(0);listB.add(0);

        int aInd = 1;
        for(int i = 0; i < n; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();

            for(int j = 0; j < t; j++){
                listA.add(listA.get(aInd-1) + v);
                aInd++;
            }
        }
        int bInd = 1;
        for(int i = 0; i < m; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();

            for(int j = 0; j < t; j++){
                listB.add(listB.get(bInd-1) + v);
                bInd++;
            }
        }

        int changeCnt = 0; // 선두가 바뀌는 횟수
        int win = (listA.get(1) > listB.get(1))? 0 : 1; // 0 : A가 선두 , 1 : B가 선두


        for(int i = 0; i < listA.size(); i++){
            if(listA.get(i) > listB.get(i)){
                if(win == 1){
                    changeCnt ++;
                    win = 0;
                }
            }
            else if(listB.get(i) > listA.get(i)){
                if(win == 0){
                    changeCnt ++;
                    win = 1;
                }
            }
        }
        System.out.println(changeCnt);
    }
}

