// 날짜 : 2022/09/29
// 문제 : 가능한 수열 중 최솟값 구하기
// 문제 설명 :
//
// 길이가 n인 수열을 세 개의 숫자 4,5,6 으로만 구성하려고 합니다. 이 때 임의의 길이를 갖는 두 개의 인접한 연속 부분 수열이 동일한 경우,
// 이는 불가능한 수열로 간주합니다. <그림 1> 은 불가능한 수열의 예시들 입니다.
// 아래의 그림과 같이 빨간색으로 밑줄이 쳐진 부분 수열과 파란색으로 밑줄 쳐진 인접한 연속 부분 수열이 동일한 경우, 이는 불가능한 수열입니다.
// 이 때 길이가 n인 가능한 수열 중 앞에서부터 읽었을 때 '사전순으로 가장 앞선 수열'을 출력하는 코드를 작성해보세요.

// < 그림 1 >

// 4 5 5 4 - > 불가
// 6 6 4 5 4 5 5 - > 불가
// 6 4 5 6 4 5 6 6 - > 불가

// 입력 형식 :
// 첫 번째 줄에 n이 주어집니다.
// 1≤n≤80

// 입력 예시 01 :
// 2
// 출력 예시 01 :
// 45

// 입력 예시 02 :
// 3
// 출력 예시 02 :
// 454

// 입력 예시 03 :
// 7
// 출력 예시 03 :
// 4546454

package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BT09 {
    public static final int MAX_N = 80; // n의 최대값

    public static ArrayList<Integer> result = new ArrayList<>(); // n개의 4,5,6 순서쌍을 담을 배열리스트
    public static int n;

    public static void printResult(){

        for(Integer x: result){
            System.out.print(x);
        }
    }

    public static boolean isEqual(int start1, int end1, int start2, int end2){

        int len = end1 - start1 + 1;
        for (int i = 0; i < len ; i++) {
            if(result.get(start1 + i) != result.get(start2 + i))
                return false; // 동일한 인접부분수열이 아니다.
        }
        return true;
    }

    public static boolean isPossible(){

        // 결정된 result를 이용하여 모든 길이에 대해 인접연속부분수열중 동일한 것이 있는지 확인(모든 길이)
        for (int i = 0; i < result.size() ; i++) {

            int len = 1; // 초기 길이

            while(true){
                int start1 = i;
                int end1 = i + len - 1;
                int start2 = end1 + 1;
                int end2 = start2 + len - 1;

                if(end2 >= result.size())
                    break; // i를 start로 했을 때, 해당 길이는 불가

                if(isEqual(start1,end1,start2,end2)){
                    return false;
                }

                len ++; // 길이 증가
            }
        }
        return true; // 인접연속부분수열중 동일한 수열 존재 x
    }

    public static void backtracking(int currN){
        if(currN == n){
            if(isPossible()) {
                printResult();
                System.exit(0);
            }
            return;
        }

        for (int i = 4; i <= 6; i++) {
            result.add(i);
            backtracking(currN + 1);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        backtracking(0);
    }
}
