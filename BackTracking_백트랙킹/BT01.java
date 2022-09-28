// 날짜 : 2022/09/28
// 문제 : k개 중에 1개를 n번 뽑기
// 문제 설명 :

// 1이상 K이하의 숫자를 하나 고르는 행위를 N번 반복하여 나올 수 있는 모든 서로 다른 순서쌍을 구해주는 프로그램을 작성해보세요.
// 예를 들어 K이 3,N이 2인 경우 다음과 같이 9개의 조합이 가능합니다.
// 1 1
// 1 2
// 1 3
// 2 1
// 2 2
// 2 3
// 3 1
// 3 2
// 3 3

// 입력 형식 :
// 첫째 줄에 K와 N이 공백을 사이에 두고 주어집니다.
// 1≤K≤4
// 1≤N≤8

// 입력 예시01 :
// 2 2

// 출력 예시01 :
// 1 1
// 1 2
// 2 1
// 2 2

// 입력 얘시02 :
// 3 2

// 출력 예시02 :
// 1 1
// 1 2
// 1 3
// 2 1
// 2 2
// 2 3
// 3 1
// 3 2
// 3 3

package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;
public class BT01 {
    public static int n,k;
    public static ArrayList<Integer> result = new ArrayList<>(); // 결과를 담을 배열리스트

    public static void printArr(){
        for(Integer element: result)
            System.out.print(element+" ");
        System.out.println();
    } // 배열리스트 원소 출력해주는 메소드
    public static void choose(int loc){ // 해당 location 자리에 1 ~ k의 숫자 배치
        if(loc == n + 1){
            printArr();
            return;
        }

        for (int i = 1; i <= k ; i++) {
            result.add(i);
            choose(loc + 1);
            result.remove(result.size() - 1);
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();

        choose(1); // 재귀 메소드 시작
    }
}