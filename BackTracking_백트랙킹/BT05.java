// 날짜 : 2022/09/29
// 문제 : 겹치지 않게 선분 고르기
// 문제 설명 :
// 수직선상에 n개의 선분이 주어졌을 때, '겹치지 않게 가장 많은 수의 선분'을 고르는 프로그램을 작성해보세요.
// 단, 끝점을 공유하는 것 역시 겹친 것으로 생각합니다.

// 입력 형식 :
// 첫 번째 줄에는 선분의 개수를 나타내는 n이 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 선분의 정보 (x1, x2)가 공백을 사이에 두고 주어집니다. 이 때 x1, x2는 해당 선분의 수직선상에서의 양끝점 좌표를 나타냅니다. (1 ≤ x1 < x2 ≤ 1,000)
// 1 ≤ n ≤ 15

// 입력 예시 01 :
// 3
// 1 2
// 3 4
// 5 6

// 출력 예시 01 :
// 3

// 입력 예시 02 :
// 3
// 1 2
// 1 4
// 3 4

// 출력 예시 02 :
// 2

// 아이디어 :
// 모든 가능한 조합을 고려하여 겹치지 않을 때 갯수 업데이트
// 백트랙킹

package BackTracking_백트랙킹;

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
import java.util.Scanner;

public class BT05 {
    public static final int MAX_N = 15; // n의 최대값

    public static ArrayList<Line> lines = new ArrayList<>(); // Line 인스턴스를 원소로 하는 배열리스트
    public static ArrayList<Line> selectedLines = new ArrayList<>(); // 특정 순간에 선택된 선분을 원소로 하는 배열리스트

    public static int ans; // 겹치지 않는 선분의 최대 갯수
    public static int n; // 주어지는 선분의 개수

    static class Line{

        int start;
        int end;

        public Line(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static boolean overlap(int i, int j){

        int start1 = selectedLines.get(i).start;
        int end1 = selectedLines.get(i).end;

        int start2 = selectedLines.get(j).start;
        int end2 = selectedLines.get(j).end;

        /*
        return (start1 >= start2 && start1 <= end2) || (start2 >= start1 || start2 <= end1)
                || (start1 <= start2 && end2 <= end1) || (start2 <= start1 && end1 <= end2);
         */

        return (start1 <= start2 && start2 <= end1) || (start1 <= end2 && end2 <= end1) ||
                (start2 <= start1 && start1 <= end2) || (start2 <= end1 && end1 <= end2);
    }
    public static boolean isPossible(){ // selectedLines에 있는 원소가 서로 겹치지 않는지 판단하는 메소드

        for (int i = 0; i < (int)selectedLines.size() ; i++) {
            for (int j = i + 1; j < (int)selectedLines.size(); j++) {
                if(overlap(i,j))
                    return false;
            }
        }
        return true;
    }
    public static void backtracking(int cnt){

        if(cnt == n){
            if(isPossible()){
                ans = Math.max(ans,(int)selectedLines.size());
            }
            return;
        }

        selectedLines.add(lines.get(cnt)); // cnt번째 있는 선분을 add
        backtracking(cnt + 1); // 재귀적 호출
        selectedLines.remove(selectedLines.size() - 1); // cnt번째 있는 선분 remove
        backtracking(cnt + 1); // 이부분이 중요!(cnt번째 선분이 제거된채로 재귀적호출)
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            lines.add(new Line(start,end));
        }
//        Collections.sort(lines);

        backtracking(0);
        System.out.println(ans);
    }
}
