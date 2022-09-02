// 날짜 : 2022/09/03
// 문제 : 마라톤 중간에 택시타기
// 문제 설명 : 개발자는 막상 마라톤 대회를 나가려니 귀찮아서
// n개의 체크 포인트중 시작 포인트와 끝 포인트를 제외한 특정 포인트를 하나 건너뛰고 도달한다고 할때 어떤 체크 포인트를 건너뛰어야 거리가
// 최소가 될까요? 이때 거리는 택시 거리(Manhattan Distance) 기준으로 계산합니다.

// 입력 형식 :

// 첫 번째 줄에 체크포인트 N이 주어집니다.
//이후 N개의 줄에 걸쳐 한 줄에 하나씩 각 번호에 해당하는 지점의 위치 (x, y)가 공백을 사이에 두고 주어집니다.
//3 ≤ N ≤ 100
//-1,000 ≤ x, y ≤ 1,000

// 입력 예시 :
// 4
// 0 0
// 8 3
// 11 -1
// 10 0

// 출력 예시 :
// 14
package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES07 {
    public static final int MAX_N = 100; // 체크 포인트의 최대값
    public static int[] x = new int[MAX_N];
    public static int[] y = new int[MAX_N]; // 각 x,y 좌표 기록
    public static int ans = Integer.MAX_VALUE; // 정수의 최대값

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 체크 포인트 개수

        for(int i = 0; i < n; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt(); // 각 좌표 입력
        }

        for(int i = 1; i < n - 1; i++){
            int sumDis = 0; // i번째 체크 포인트를 제거할때 멘하턴 거리
            int prev = 0;
            for(int j = 1; j < n; j++){
                if( i == j )
                    continue;
                sumDis = sumDis + Math.abs(x[prev] - x[j]) + Math.abs(y[prev] - y[j]);
                prev = j;
            }
            ans = Math.min(ans,sumDis);
        }
        System.out.println(ans);
    }
}