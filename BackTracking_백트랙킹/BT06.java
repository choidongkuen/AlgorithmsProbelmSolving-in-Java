// 날짜 : 2022/09/29
// 문제 : 0이 반복되어 나타나지않는 n자리에 2진수를 오름차순으로 출력하기

// 문제 설명 :
// n이 주어질때, 0이 반복되지 않는 n자리에 이진수를 오름차순으로 출력하세요.

package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BT06 {
    public static int n;
    public static ArrayList<Integer> binary = new ArrayList<>();

    public static void printBinary(){
        System.out.println(binary);
    }

    public static void backtracking(int currLoc){

        if(currLoc == n + 1){
            printBinary(); // 출력하기
            return;
        }

        for (int i = 0; i < 2 ; i++) {

            if(i == 0){ // 0 인경우 조건과 함께 처리
                if(currLoc == 1 || binary.get(binary.size() - 1) != 0){
                    binary.add(i); // 0
                    backtracking(currLoc + 1);
                    binary.remove(binary.size() - 1);
                }
            }
            else { // 1인 경우 조건 없이 처리

                binary.add(i); // 1
                backtracking(currLoc + 1);
                binary.remove(binary.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        backtracking(1);
    }
}
