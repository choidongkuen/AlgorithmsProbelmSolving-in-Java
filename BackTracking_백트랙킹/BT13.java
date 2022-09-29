// 날짜 : 2022/09/29
// 문제 : 순열 만들기
// 문제 설명 :
// n이 주어질때, 1 ~ n의 수를 이용하여 중복없이 모든 수들이 나오는 순열을 출력하는 코드를 작성하시오.

package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BT13 {

    public static int n; // 주어지는 값
    public static ArrayList<Integer> result = new ArrayList<>(); // 조합을 원소로하는 배열리스트
    public static boolean[] visited;

    public static void print(){
        for(Integer x : result){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void backtracking(int currNum){

        if(currNum == n + 1){
            print();
            return;
        }

        for (int i = 1; i <= n ; i++) {
            if(visited[i])
                continue;

            result.add(i);
            visited[i] = true;
            backtracking(currNum + 1);
            result.remove(result.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n + 1];

        backtracking(1);
    }
}
