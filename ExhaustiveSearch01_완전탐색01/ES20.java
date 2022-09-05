// 날짜 : 2022/ 09 / 04
// 문제 : 개발자의 능력 2
// 문제 설명 :
// 개발자 6명의 알고리즘 능력을 수치화해 각각 정수로 주어지면 6명을 2명씩 3팀으로 배정해줍니다.
// 팀원들의 능력 총합이 가장 큰 팀과 가장 작은 팀의 차이를 최소화 할 수 있게 균형있게 구성해줄 때의 차를 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 총 6명의 능력이 공백을 사이에 두고 주어집니다.
// 1 ≤ 능력 수치 ≤ 1,000,000

// 입력 예시 :
// 7 3 10 8 2 6

// 출력 예시 :
// 2

// 이 문제는 완전탐색으로 풀 수 도 있지만, 생각을 잘해보면 쉽게 풀 수 있다.
// 균형잡히게(그룹의 능력치합의 최대와 능력치 합의 최소의 차가 최소가 되도록) 한다는 것은 정렬을 해서
// 각 턴에 맞는 가장 큰 능력과 가장 작은 능력을 갖는 개발자를 한 그룹으로 묶어주면 가장 균형잡히게 집단화된다.

package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES20 {
    public static final int NUM = 6;
    public static int[] arr = new int[NUM];

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < NUM ;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < NUM / 2; i++){
            max = Math.max(max,arr[i] + arr[NUM - i - 1]);
            min = Math.min(min,arr[i] + arr[NUM - i - 1]);
        }

        System.out.println(max - min);
    }
}