// 문제 : n개 중에 m개 뽑기
// 문제 설명 :
// 1이상 N이하의 숫자 중 M개의 숫자를 골라 만들 수 있는 모든 조합을 구해주는 프로그램을 작성해보세요.
// 예를 들어 N이 4, M이 3인 경우 다음과 같이 4개의 조합이 가능합니다.

// 1 2 3
// 1 2 4
// 1 3 4
// 2 3 4

// 입력 형식 :
// 첫째 줄에 N과 M이 공백을 사이에 두고 주어집니다.
// 1≤M≤N≤10

// 입력 예시01 :
// 3 2
// 출력 얘시01 :
// 3 2
// 1 2
// 1 3
// 2 3

// 출력 얘시02 :
// 4 3
// 출력 예시02 :
// 1 2 3
// 1 2 4
// 1 3 4
// 2 3 4
package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BT12 {

    public static final int MAX = 10;
    public static ArrayList<Integer> result = new ArrayList<>();
    public static int n,m;

    public static void print(){
        for(Integer x : result){
            System.out.print(x +" ");
        }
        System.out.println();
    }

    public static void backtracking(int currNum, int prev){

        if(currNum == m + 1){
            print();
            return;
        }

        for (int i = 1; i <= n ; i++) {
            if(i <= prev){
                continue;
            }

            result.add(i);
            backtracking(currNum + 1, i);
            result.remove(result.size() - 1);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        backtracking(1,0);
    }
}
