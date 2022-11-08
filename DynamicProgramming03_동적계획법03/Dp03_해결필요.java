// 날짜 : 2022/11/06
// 문제 : 적절하게 숫자를 변경하기
// 문제 설명 :
// 1이상 4이하의 숫자로만 이루어진 길이가 N인 수열이 하나 주어졌을 때, 순서대로 읽었을 때 인접한 두 숫자가 다른 횟수가 M번 이하인 수열을 잘 만들어 두 수열 간의 유사도가 가장 높아지게 하려고 합니다.
// 두 수열 간 유사도는 같은 위치에 같은 원소가 나온 횟수로 결정됩니다.
// 예를 들어, N=5,M=1 이고 입력으로 주어진 수열이 1,2,1,3,3 이라면 숫자를 1에서 3으로 한 번 변경한 1,1,1,3,3 이라는 수열을 만들어 유사도 4를 만들어 낼 수 있습니다.

// 입력 형식 :
// 첫째 줄에는 N과 M이 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 N개의 1이상 4 이하의 숫자가 공백을 사이에 두고 주어집니다.
// 1≤N≤500
// 0≤M≤100

// 입력 예시 01 :
// 5 1
// 1 2 1 3 3

// 출력 예시 01 :
// 4

package DynamicProgramming03_동적계획법03;

import java.util.Scanner;

public class Dp03_해결필요 {

    public static final int MAX_N = 500;
    public static final int MAX_M = 100;
    public static final int NUM = 4;

    public static int n,m;
    public static int[] arr = new int[MAX_N + 1];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();


        for (int i = 1; i <= n ; i++) {
            arr[i] = sc.nextInt();
        }



    }
}
