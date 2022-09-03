// 날짜 : 2022/09/04
// 문제 : G or H
// 문제 설명 :
// N명의 사람들이 일직선상에서 본인들에게 주어진 번호에 해당하는 위치에 서서 G와 H중 받은 알파벳의 팻말을 들고있습니다.
// 사진의 크기는 K이며, G가 찍히면 각각 1점씩 얻고 H가 찍히면 각각 2점씩 얻게 될 때, 사진을 찍어 얻을 수 있는 최대 점수를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 정수 N과 K가 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터는 N개의 줄에 걸쳐 한 줄에 하나씩 각 사람의 위치와 알파벳 정보가 공백을 사이에 두고 주어집니다.
// 위치가 겹쳐져 주어지는 경우는 없으며, 알파벳은 ‘G', 'H’ 중 하나로만 주어진다고 가정해도 좋습니다.
// 1 ≤ N ≤ 100
// 1 ≤ K ≤ 10,000
// 1 ≤ 위치 ≤ 10,000

// 입력 예시 :
// 6 6
// 4 G
// 10 H
// 7 G
// 16 H
// 1 G
// 3 H

// 출력 예시 :
// 5

package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES15{
    public static final int MAX_LOC = 10000; // 최대 위치
    public static final int MAX_N = 100; // 사람의 수(N) 최대값
    public static int ans = 0; // 사진 찍어 얻을 수 있는 최대 점수

    public static int[] arr = new int[MAX_LOC + 2]; // 0 ~ 10000
    // public static int[] people = new int[MAX_N + 1]; // 0 ~ 100

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 사람들의 수
        int k = sc.nextInt(); // 사진의 크기

        for(int i = 0; i < n; i++){
            int location = sc.nextInt(); // 서있는 위치
            char sign = sc.next().charAt(0); // 들고있는 표지판

            if(sign == 'H')
                arr[location] = 2;
            else // G
                arr[location] = 1;
        }

        for(int i = 1; i <= MAX_LOC - k; i++){
            int size = 0;

            for(int j = i; j <= i + k; j++){
                size += arr[j];
            }

            ans = Math.max(ans , size);
        }

        System.out.println(ans);
    }
}