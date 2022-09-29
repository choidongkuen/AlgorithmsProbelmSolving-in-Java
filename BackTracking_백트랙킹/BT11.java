// 문제 : 1의 갯수가 m 개인 n자리의 모든 2진수를 오름차순으로 출력하시오.

package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BT11 {

    public static ArrayList<Integer> binary = new ArrayList<>();
    public static int n,m;

    public static void print(){
        System.out.println(binary);
    }

    public static void backtracking(int currNum, int cnt){
        if(currNum == n + 1){
            if(cnt == m) {
                print();
            }
            return;
        }

        for (int i = 0; i < 2 ; i++) {
            binary.add(i);
            if(i == 1){
                backtracking(currNum + 1, cnt + 1);
            }else{
                backtracking(currNum + 1, cnt);
            }
            binary.remove(binary.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 자릿수
        m = sc.nextInt(); // 요구되는 1의 갯수

        backtracking(1,0);
    }
}
