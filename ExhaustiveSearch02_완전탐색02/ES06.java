// 날짜 : 2022/09/07
// 문제 : 정보에 따른 숫자 2

// 문제 설명 :
// T개의 '정보'와, a부터 b까지 위치를 검토해야합니다. '정보'는 구분값 S와 N중 하나의 값과 그에 따른 위치값이 정수로 주어집니다.
// a이상 b이하의 위치값 중 주어진 '정보'에서 구분값 N보다 구분값 S의 위치와 더 가까이에 있는 위치값의 개수를 세는 프로그램을 작성해보세요.
// 만약, 구분값 S와 구분값 N 과의 거리가 같다면 이 역시 가짓수에 포함합니다.

// 입력 형식 :
// 첫 번째 줄에 T, a, b이 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터는 T개의 줄에 걸쳐 각 줄마다 적혀있는 구분값과 그의 위차값이 정수로 공백을 사이에 두고 주어집니다. 구분값은 S혹은 N로만 주어지며, 주어지는 숫자는 전부 다름을 가정해도 좋습니다.
// 1 ≤ T ≤ 100
// 1 ≤ A ≤ B ≤ 1,000

// 입력 예시 :
// 3 1 10
// S 10
// N 4
// S 1

// 출력 예시 :
// 6




package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES06 {
    public static final int MAX_T = 100; // 정보의 최대 갯수
    public static char[] ns = new char[MAX_T]; // N or S 기록용 배열
    public static int[] num = new int[MAX_T]; // 정보에 주어진 구분값의 위치
    public static int t,a,b;

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        for(int i = 0; i < t; i++){
            ns[i] = sc.next().charAt(0);
            num[i] = sc.nextInt();
        } // 각 정보에 기록

        int ans = 0; // 조건을 만족하는 위치의 갯수


        for(int i = a; i <= b; i++){

            int sDis = 1000;
            int nDis = 1000;

            for(int j = 0; j < t; j++){
                if(ns[j] == 'S')
                    sDis = Math.min(sDis,Math.abs(i - num[j]));
                else
                    nDis = Math.min(nDis,Math.abs(i - num[j]));
            }
            if(sDis <= nDis)
                ans++;
        }
        System.out.println(ans);
    }
}