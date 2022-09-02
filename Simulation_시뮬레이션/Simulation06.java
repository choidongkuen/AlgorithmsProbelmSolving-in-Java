// 문제 설명 :
// N명의 개발자들이 있으며, T번에 걸쳐 t초에 x개발자가 y개발자와 악수를 나눈 정황이 주어집니다.
// 1명의 개발자가 처음에 이 전염병을 옮기기 시작한 것이 확실해 졌고, 개발자가 이 병에 감염된 후에는 정확히 K번의 악수 동안만 전염병을 옮기게 되고,
// 그 이후부터는 전염병에 걸려있지만 새로 옮기지는 않게 됩니다. 개발자들의 악수에 대한 정보와 처음 전염병에 걸려 있는 개발자의 번호 P가 주어졌을 때,
// 모든 악수를 진행한 이후에 최종적으로 누가 전염병에 걸리게 되었는지를 알아내는 프로그램을 작성해보세요. 단, 전염된 사람끼리 만나도 전염시킨 것으로 간주해야 함에 유의합니다.
// 예를 들어 전염된 x 개발자와 전염된 y 개발자끼리 악수를 해도 전염병을 옮기게 되는 횟수에 포함시켜야 합니다.

// 입력 형식 :

// 첫 번째 줄에 정수 N, K, P, T가 각각 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터는 T개의 줄에 걸쳐 각 줄마다 t, x, y에 대한 정보가 공백을 사이에 두고 주어집니다. 이는 t초에 x 개발자와 y 개발자가 악수를 나눴음을 의미하고,
// x, y 값은 항상 다르게 주어짐을 가정해도 좋습니다. 또한, 입력으로 주어지는 t값은 모두 다름을 가정해도 좋습니다.
// 2 ≤ N ≤ 100
// 1 ≤ K ≤ 250
// 1 ≤ P ≤ N
// 1 ≤ T ≤ 250
// 1 ≤ t ≤ 250

// 입력 예시 :
// 4 2 2 3
// 7 1 2
// 5 2 3
// 6 2 4

// 출력 예시 :
// 0111
package Simulation_시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;
class Shake implements Comparable<Shake>{
    int time;
    int person1;
    int person2;

    public Shake(int time,int person1,int person2){
        this.time = time;
        this.person1 = person1;
        this.person2 = person2;
    }

    @Override
    public int compareTo(Shake s){ // 시간 순으로 정렬
        return this.time - s.time; // 오름차순 정렬
    }
}

public class Simulation06 {
    public static final int MAX_N = 100; // 최대 개발자 수
    public static final int MAX_T = 250; // 최대 주어지는 정보 횟수
    public static int[] infected = new int[MAX_N + 1]; // 감염 여부 기록용 배열 0 : 음성 , 1 : 양성
    public static int[] shakeNums = new int[MAX_N + 1]; // 개발자들의 악수 횟수 기록용 배열

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 주어지는 개발자 수
        int k = sc.nextInt(); // 전염시킬 수 있는 악수 횟수
        int p = sc.nextInt(); // 처음 전염된 개발자 번호
        int t = sc.nextInt(); // t개의 정보

        infected[p] = 1; // 원시 감염자 양성 기록
        Shake[] shake = new Shake[MAX_T]; // t개의 악수 정보를 담을 클래스 배열 선언(인덱스가 0부터)

        for(int i = 0; i < t; i++){

            int time = sc.nextInt(); // 악수 시간
            int person1 = sc.nextInt();
            int person2 = sc.nextInt(); // 악수한 두 개발자의 번호

            shake[i] = new Shake(time,person1,person2); // 객체 생성

        } // 클래스 배열 완성

        Arrays.sort(shake,0,t); // 클래스 배열 시간 순 오름차순 정렬

        for(int i = 0; i < t; i++){

            int person1 = shake[i].person1;
            int person2 = shake[i].person2;

            if(infected[person1] == 1){
                shakeNums[person1]++;
            }
            if(infected[person2] == 1){
                shakeNums[person2]++;
            }
            // 악수 횟수 증가

            if(infected[person1] == 1 && shakeNums[person1] <= k){
                infected[person2] = 1; // 양성 기록
            }
            else if(infected[person2] == 1 && shakeNums[person2] <= k){
                infected[person1] = 1; // 양성 기록

            }
        }

        for(int i = 1; i <= n; i++){
            System.out.print(infected[i]);
        }
    }
}