// 날짜 : 2022/ 09 / 04
// 문제 : 자물쇠 열기
// 문제 설명 :
// 1부터 N까지 숫자를 이용해 총 3자리를 만들어야 하는 자물쇠가 하나 주어집니다. 이 자물쇠는 특이해서 한 자리라도 주어지는 조합과 거리가 2 이내라면 열리게 됩니다.
// 예를 들어, N = 6이고 주어진 조합이 (1, 2, 3) 이라면, 이 자물쇠는 (5, 4, 6)일 때 두 번째 자리의 숫자 차이가 2 이내가 되므로 열리게 됩니다.
// 자물쇠 번호가 (1, 5, 6)인 경우에는 첫 번째 자리의 숫자 차이가 2 이내가 되므로 열리게 됩니다.
// 만약 자물쇠 번호가 (6, 6, 6) 이라면 숫자 차이가 2 이내인 위치가 없으므로 열리지 않습니다.
// N과 조합이 주어졌을때 자물쇠가 열리게 되는 서로 다른 조합의 수를 구하는 프로그램을 작성해보세요. 단, (1, 2, 3)과 (3, 2, 1)은 다른 가짓수로 셉니다.

// 입력 형식 :
// 첫 번째 줄에는 N이 주어집니다.
// 두 번째 줄에는 조합에 해당하는 정보 a, b, c가 공백을 사이에 두고 주어집니다.
// 1 ≤ N ≤ 100
// 1 ≤ a, b, c ≤ N

// 입력 예시 :
// 6
// 1 2 3

// 출력 예시 :
// 210



package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES19 {
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 숫자의 갯수

        int first = sc.nextInt();
        int second = sc.nextInt();
        int third = sc.nextInt();

        int ans = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(!(Math.abs(i - first) > 2 && Math.abs(j - second) > 2 && Math.abs(k - third) > 2))
                        ans ++;
                }
            }
        }
        System.out.println(ans);
    }
}
