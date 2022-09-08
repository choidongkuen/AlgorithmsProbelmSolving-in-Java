// 날짜 : 2022/09/08
// 문제 : 팀으로 하는 틱택토 2
// 문제 설명 :
// 원래의 틱택토가 아닌 새로 개발한 틱택토 게임을 하려고합니다. 원래룰인 1 대 1 이 아닌 2명이 한 팀을 이루어 참여할 수 있도록 하였습니다.
// 게임 결과가 주어지면 팀으로 이길 수 있는 가짓수를 구하여 출력하는 프로그램을 작성해보세요. 단, 팀으로 이겼다는 뜻은 한 줄에 팀을 이루고 있는 2개의 숫자가 적어도 하나씩은 등장해야함을 뜻합니다.
// 예를 들어 숫자 1 1 1은 하나의 숫자로만 이루어져 있기 때문에 팀으로 이긴 것이 아닌, 개인이 이긴 것으로 생각합니다.

// 입력 형식 :
// 3개의 줄에 걸쳐 한 줄에 하나씩 3개의 숫자가 공백없이 주어집니다.
// 주어지는 숫자는 전부 1이상 9이하임을 가정해도 좋습니다.

// 입력 예시1 :
// 124
// 332
// 561

// 출력 예시1 :
// 2

// 입력 예시2 :
// 189
// 167
// 167

// 출력 예시2 :
// 2

package ExhaustiveSearch02_완전탐색02;

import java.util.*;

public class ES09{
    public static int[][] arr = new int[3][3];
    public static int n;
    public static int[] seq = new int[3];
    public static int ans;

    public static boolean simulate(int i, int j){
        int[] counts = new int[10]; // i,j의 횟수 기록용 1차원 배열

        for(int k = 0; k < 3; k ++)
            counts[seq[k]] ++; // 개수 증가

        if(counts[i] + counts[j] == 3 && counts[i] >= 1 && counts[j] >= 1)
            return true; // 조건 만족함으로, true 반환
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            char[] numbers = sc.next().toCharArray(); // 문자 배열로 변환
            for(int j = 0; j < 3; j++)
                arr[i][j] = numbers[j] - '0';
        } // 2차원 정수 배열로 변환

        ans = 0; // 가짓수

        for(int i = 1; i < 10; i++){
            for(int j = i + 1; j < 10; j++){
                boolean isWin = false;

                for(int row = 0; row < 3; row ++){ // 모든 행 검사
                    for(int col = 0; col < 3; col ++)
                        seq[col] = arr[row][col];

                    if(simulate(i,j))
                        isWin = true;
                }

                for(int col = 0; col < 3; col ++){ // 모든 열 검사
                    for(int row = 0; row < 3; row ++)
                        seq[row] = arr[row][col];

                    if(simulate(i,j))
                        isWin = true;
                }

                for(int d = 0; d < 3; d ++) // 오른쪽 대각선
                    seq[d] = arr[d][d];

                if(simulate(i,j))
                    isWin = true;


                for(int d = 0; d < 3; d ++) // 왼쪽 대각선
                    seq[d] = arr[d][2 - d];

                if(simulate(i,j))
                    isWin = true;

                if(isWin){
                    ans++;
                    //System.out.printf("%d,%d\n",i,j);
                }
            }
        }
        System.out.println(ans); // 출력
    }
}