// 날짜 : 2022/09/03
// 문제 : 원 모양으로 되어있는 방
// 문제 설명 :
// 원 모양으로 되어있는 N개의 방이 있고, 방은 1부터 N까지 시계 반대방향으로 번호가 매겨져 있습니다.
// 각 방에는 이웃한 두 개의 방으로 통하는 문이있습니다. 사람들은 무조건 시계 반대방향으로만 이동해야 합니다.
// 각자 방에 몇 명이 사람이 들어가야하는지 주어지며, 모든 사람이 같은 방에서 시작한다고 합니다.
// 어떤 방에서 시작해야 각 방에 정해진 인원이 들어가는 데까지의 거리의 합을 최소화 할 수 있는지를 계산하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 정수 N이 주어집니다.
//두 번째 줄부터는 N 개의 줄에 걸쳐 한 줄에 하나씩 순서대로 각 방에 들어가야 하는 사람들의 인원이 주어집니다.
//3 ≤ N ≤ 1,003
//1 ≤ 각 방에 들어가야 하는 사람들의 인원 ≤ 100

// 입력 예시 :
// 5
// 4
// 7
// 8
// 6
// 4

// 출력 예시 :
// 48




package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES08 {
    public static final int MAX = Integer.MAX_VALUE; // 정수의 최대값
    public static final int MAX_N = 1003; // 방의 최대 수
    public static int[] arr = new int[MAX_N]; // 각 방에 들어갈 인원정보를 원소로 갖는 1차원 배열
    public static int n; // 방의 수


    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 방의 수 입력
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = MAX;

        for(int i = 0; i < n; i++){
            int sumDis = 0;
            // i 기준 왼쪽에 있는 인덱스와의 거리는 n보다 작은수, 오른쪽 인덱스와의 거리는 n보다 큰수
            for(int j = 0; j < n; j++){
                int dis = (j + n - i) % n; // 생각 잘하기
                sumDis += arr[j] * dis;
            }
            ans = Math.min(ans , sumDis);
        }
        System.out.println(ans);
    }
}