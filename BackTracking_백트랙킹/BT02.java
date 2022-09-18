// 날짜 : 2022/09/18
// 문제 : k개 중 하나를 N번 선택하기
// 문제 설명 :

// n이 주어질 때, n자리 이진수의 모든 경우의 수를 출력하세요.
// 단 오름차순 순서로 출력해주세요.


package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BT02 {
    public static int n;
    public static ArrayList<Integer> list = new ArrayList<>();

    public static void print(){
        for(int i = 0; i < list.size(); i++)
            System.out.print(list.get(i));
        System.out.println();
    }

    public static void func(int currNum){
        if(currNum == n + 1) {
            print();
            return;
        }
        for(int i = 0; i < 2; i ++){
            list.add(i);
            func(currNum + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        func(1);
    }
}
