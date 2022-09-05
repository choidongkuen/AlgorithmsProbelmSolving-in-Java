// 날찌 : 2022/ 09 / 04
// 문제 : 개발자의 능력
// 문제 설명 : 개발자 6명의 알고리즘 능력을 수치화해 각각 정수로 주어지면 6명을 3명씩 2팀으로 배정해줍니다.
// 팀원들의 능력 총합간의 차이를 최소화 할 수 있게 균형있게 구성해줄 때의 차를 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 총 6명의 능력이 공백을 사이에 두고 주어집니다.
//1 ≤ 능력 수치 ≤ 1,000,000

// 입력 예시 :
// 1 2 3 4 5 6

// 출력 예시 :
// 1

package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES18 {
    public static final int NUM = 6;
    public static int[] developers = new int[NUM]; // 6명의 개발자의 능력을 원소로 갖는 배열

    public static int func(int i, int j, int k){
        int sum = developers[i] + developers[j] + developers[k];
        int another = 0;

        for(int s = 0; s < NUM; s++){
            if(s == i || s == j || s == k)
                continue;
            another += developers[s];
        }
        return Math.abs(another - sum);
    }
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < NUM; i++){
            developers[i] = sc.nextInt();
        } // 배열 원소 입력

        int ans = Integer.MAX_VALUE; // 두 그룹의 능력 총합의 차이의 최소값
        for(int i = 0; i < NUM; i++){
            for(int j = i + 1; j < NUM; j++){
                for(int k = j + 1; k < NUM; k++){
                    ans = Math.min(ans, func(i,j,k));
                }
            }
        }

        System.out.println(ans);
    }
}