package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BT03 {
    public static final int MAX = 10; // n의 최대 값
    public static final int NUM = 4; // 1 ~ 4
    public static int n, cnt; // 주어지는 n(자리), 아름다운 수의 갯수
    public static ArrayList<Integer> result = new ArrayList<>(); // 조합을 기록할 배열 리스트


    public static boolean isHappy() { // 행복 수열 판단하는 메소드

        for (int i = 0; i < result.size(); i += result.get(i)) { // 간격 설정 !!

            if (i + result.get(i) > result.size())
                return false;
            // 사이즈 처리

            for (int j = i; j < i + result.get(i); j++){
                if (result.get(j) != result.get(i))
                    return false;
            }
        }
        return true;
    }
    public static void choose(int loc){

        if(loc == n + 1){
            if(isHappy())
                cnt ++;
            return;
        } // n을 초과한 경우

        for (int i = 1; i <= NUM ; i++) {
            result.add(i);
            choose(loc + 1); // 다음 위치
            result.remove(result.size() - 1); // 마지막 원소 삭제
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        choose(1);

        System.out.println(cnt); // 가능한 조합에서의 아름다운수의 갯수
    }
}
