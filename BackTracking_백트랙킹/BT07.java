// 날짜 : 2022/09/29
// 문제 : 특정 조건에 맞게 k개 중에 1개를 n번 뽑기

// 문제 설명 :
// 1이상 K이하의 숫자를 하나 고르는 행위를 N번 반복하여 나올 수 있는 모든 서로 다른 순서쌍을 구해주는 프로그램을 작성해보세요.
// 단, '연속하여 같은 숫자가 3번 이상 나오는 경우'는 제외합니다.
// 예를 들어 K이 2, N이 3인 경우 다음과 같이 6개의 조합이 가능합니다.
// 1 1 2
// 1 2 1
// 1 2 2
// 2 1 1
// 2 1 2
// 2 2 1

// - > (1,1,1),(2,2,2) 불가

package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BT07 {
    public static final int MAX_N = 8;
    public static final int MAX_K = 4;

    public static ArrayList<Integer> result = new ArrayList<>(); // 원소를 기록할 배열리스트
    public static int n,k;

    public static void printArr(){ // 배열리스트 상태 출력하는 메소드
        for (int i = 0; i < n ; i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }

    public static boolean isPossible(int num){ // 해당 num기준 연속해서 3번째 나오는 상황인지 판단하는 메소드
        if(result.get(result.size() - 1) == num && result.get(result.size() - 2) == num)
            return false;

        return true;
    }
    public static void backtracking(int currNum){

        if(currNum == n + 1){
            printArr();
            return;
        }

        for (int i = 1; i <= k; i++) {

            if(result.size() >= 2) { // 현재 배열리스트의 길이가 2 이하일때만 비교가치가 있
                if (!isPossible(i)) { // 해당 i를 넣기 전 i 숫자가 연속해서 2번째 나왔는지 확인
                    continue;
                }
            }
            result.add(i); // 추가
            backtracking(currNum + 1); // 다음 위치
            result.remove(result.size() - 1);
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        k = sc.nextInt(); // 반복 횟수
        n = sc.nextInt(); // 숫자의 범위

        backtracking(1);
    }
}