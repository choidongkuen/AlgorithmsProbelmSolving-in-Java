package BackTracking_백트랙킹;

import java.util.Scanner;

public class BT01 {
    public static final int MAX_N = 20; // n의 최대값
    public static int[] seats = new int[MAX_N]; // n개의 좌석정보를 원소로 갖는 1차원 배열
    public static int n; // 주어지는 n값

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        char[] charArr = sc.next().toCharArray(); // 문자 배열로
        for(int i = 0; i < n; i++)
            seats[i] = charArr[i] - '0'; // 문자 배열 정보를 정수 배열 정보로 이동

        int ans = 0; // 가장 가까운 두 사람 간의 거리의 최대값

        for(int i = 0; i < n; i++){
            if(seats[i] == 0){
                seats[i] = 1; // 해당 좌석에 자리를 배치하겠다고 가정
                int minDis = 20; // 가정했을 때, 가장 가까운 좌석의 간격

                for(int j = 0; j < n; j++){
                    if(seats[j] == 1){ // 해당 좌석에 자리가 있다면,
                        for(int k = j + 1; k < n; k++){
                            if(seats[k] == 1){ // 다음 자리가 있는 좌석까지의 거리를 구한다.
                                minDis = Math.min(minDis, k - j);
                            }
                        }
                    }
                }
                ans = Math.max(ans, minDis); // ans 업데이트
                seats[i] = 1; // 다시 복구
            }
        }

        System.out.println(ans); // 출력
    }
}