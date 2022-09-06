// 날짜 : 2022/09/07
// 문제 : 선분 3개 지우기
// 문제 설명 :
// 1차원 직선 상에 n개의 선분이 주어집니다. 이 중 서로 다른 선분 3개를 제거하여
// 남은 n - 3개의 선분끼리 모두 겹쳐지지 않도록 하는 서로 다른 가짓수를 구하는 출력하는 프로그램을 작성해보세요.
// 단, 두 선분끼리 경계에서 닿는 경우 역시 겹치는 것으로 생각합니다.

// 입력 형식 :
// 첫 번째 줄에 n이 주어집니다.
// 두 번째 줄부터는 n개의 줄에 걸쳐 선분의 정보 (a, b)가 공백을 사이에 두고 주어집니다.
// 4 ≤ n ≤ 10
// 0 ≤ a < b ≤ 100

// 입력 예시 :
// 5
// 1 3
// 2 4
// 3 5
// 6 8
// 7 9

// 출력 예시 :
// 6

package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES02 {
    public static final int MAX_N = 10; // 선분의 최대 갯수
    public static final int MAX_SCOPE = 100; // 영역의 최대값

    public static int[][] arr = new int[MAX_N][2]; // start - end 기록할 2차원 배열

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 주어지는 선분의 갯수

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        } // 선분 정보 입력

        int ans = 0; // 모두 겹치지 않게 하는 서로 다른 가짓수
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){ // 세 선분을 제외

                    int[] count = new int[MAX_SCOPE + 1]; // 0 - 100
                    boolean isOverlap = false;

                    for(int s = 0; s < n; s++){
                        if(s == i || s == j || s == k)
                            continue;

                        int start = arr[s][0];
                        int end = arr[s][1];

                        for(int l = start; l <= end; l++)
                            count[l] ++;
                    } // 세 선분을 제외시켰을때, 각 구간에서 겹치는 횟수

                    for(int s = 0; s <= MAX_SCOPE; s++){
                        if(count[s] > 1){
                            isOverlap = true;
                            break;
                        }
                    }
                    if(!isOverlap)
                        ans++;
                }
            }
        }

        System.out.println(ans);
    }
}