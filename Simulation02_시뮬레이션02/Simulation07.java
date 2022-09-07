// 날짜 : 2022/09/08
// 문제 : 컨베이어 벨트

// 문제 설명 :
// 시계 방향으로 한 칸씩 회전하는 컨베이어 벨트가 있습니다.
// 컨베이어 벨트 위아래로 n개씩 총 2 * n 개의 숫자가 두 줄로 적혀 있고, 1초에 한 칸씩 움직입니다.
// 위의 그림에서 1초가 흐른 뒤에는 다음과 같이 그림이 바뀌게 됩니다.
// t초의 시간이 흐른 뒤 컨베이어 벨트에 놓여있는 숫자들의 상태를 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n과 t가 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 위 변에 있는 초기 n개의 숫자들이 공백을 사이에 두고 주어집니다.
// 세 번째 줄에는 아래 변에 있는 초기 n개의 숫자들이 공백을 사이에 두고 주어집니다.
// 숫자는 각 변마다 숫자가 올바르게 보이는 방향에서 바라봤을 때 왼쪽에서 오른쪽 순으로 주어집니다.
// 1 ≤ n ≤ 200
// 1 ≤ t ≤ 1,000
// 1 ≤ 주어지는 숫자 ≤ 9

// 입력 예시 :
// 3 1
// 1 2 3
// 6 5 1

// 출력 예시 :
// 1 1 2
// 3 6 5

package Simulation02_시뮬레이션02;

import java.util.*;

public class Simulation07 {
    public static final int MAX_N = 200; // n의 최대값
    public static int[] arr1 = new int[MAX_N]; // 컨베이어 벨트 1
    public static int[] arr2 = new int[MAX_N]; // 컨베이어 벨트 2
    public static int n,t;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 주어지는 n값
        t = sc.nextInt(); // 주어지는 시간

        for(int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr2[i] = sc.nextInt();
        // 각 컨베이어 벨트 원소 채우기

        for(int i = 0; i < t; i++){ // t초 동안 진행
            int temp1 = arr1[n-1];
            int temp2 = arr2[n-1];

            for(int j = n - 1; j >= 1; j--){
                arr1[j] = arr1[j - 1];
            }
            arr1[0] = temp2;

            for(int j = n - 1; j >= 1; j--){
                arr2[j] = arr2[j - 1];
            }
            arr2[0] = temp1;
        }

        for(int i = 0; i < n; i++)
            System.out.print(arr1[i]+" ");
        System.out.println();

        for(int i = 0; i < n; i++)
            System.out.print(arr2[i]+" ");
        System.out.println();

        // 출력
    }
}