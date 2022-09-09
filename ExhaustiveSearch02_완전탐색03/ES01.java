// 날짜 : 2022/09/09
// 문제 : 독서실 거리 두기 5
// 문제 설명 :
// 신종 전염병이 퍼짐으로써 리브로스 독서실은 이용자들의 좌석 간의 거리를 두려고 합니다.
// 새로 한 명을 더 받으려고 하는데, 현재 있는 사람들은 원래 있던 자리에 그대로 두고 최대한 거리를 두면서 자리배치를 해주려고 합니다.
// 여기서 거리라 함은, 두 사람이 몇 칸 떨어져 있는지를 의미합니다. 리브로스 독서실에 있는 모든 좌석의 개수가 N개이고,
// 현재 좌석의 공석 여부가 주어지면, 한 명의 인원을 배치한 후 최대한의 거리두기를 실행한 간격을 출력하는 프로그램을 작성해보세요.
// 최대한의 거리두기를 한다는 것은, 한 명을 더 집어넣었을 때 가장 가까운 두 사람 간의 거리를 최대로 하고 싶다는 뜻입니다.

// 입력 형식 :
// 첫 번째 줄에 좌석의 개수 N을 출력합니다.
// 두 번째 줄에 길이가 N이며 ‘0'과 ‘1’로만 이루어진 문자열이 하나 주어집니다. N개의 좌석 중 ‘0’인 곳은 비어있음을,
// '1’인 곳은 이미 차 있음을 뜻합니다. 처음 최소 한 개 이상의 '1'이 주어짐을 가정해도 좋습니다.
// 2 ≤ N ≤ 20

// 입력 예시 :
// 13
// 1000100100010

// 출력 예시 :
// 2

package ExhaustiveSearch02_완전탐색03;

import java.util.*;

public class ES01{
    public static int n;
    public static int[] seats;

    public static int getMaxSeats(){ // 두 사람간의 최소 거리를 구하는 메서드
        int minDis = n; // 최대 n

        for(int i = 0; i < n; i ++)
            for(int j = i + 1; j < n; j ++)
                if(seats[i] == 1 && seats[j] == 1)
                    minDis = Math.min(minDis,j - i);

        return minDis;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        seats = new int[n];

        char[] charArr = sc.next().toCharArray(); // 문자 배열

        int ans = 0; // 두 사람 간의 거리의 최대값

        for(int i = 0; i < n; i++)
            seats[i] = charArr[i] - '0'; // 정수 배열로 변환

        for(int i = 0; i < n; i++){

            if(seats[i] == 0){
                seats[i] = 1; // 채운다고 가정

                ans = Math.max(ans,getMaxSeats()); // i를 1로 변경했을 때, 사람간의 최소 거리를 구하는 메서드

                seats[i] = 0; // 다시 복구
            }
        }
        System.out.println(ans); // 출력
    }
}