// 날짜 : 2022/09/07
// 문제 : 행복 수열의 개수
// 문제 설명 :
// 1이상 100이하의 숫자로만 이루어져 있는 n * n 크기의 격자 정보가 주어집니다.
// 이때 행복한 수열이라는 것은 다음과 같이 정의됩니다.
// 행복한 수열 = 연속하여 m개 이상의 동일한 원소가 나오는 순간이 존재하는 수열
// n * n 크기의 격자 정보가 주어졌을 때 각 행마다 봤을 때 나오는 n개의 수열과, 각 열마다 봤을 때 나올 수 있는 n개의 수열을 포함하여
// 총 2n개의 수열 중 행복한 수열의 개수를 세서 출력하는 프로그램을 작성해보세요.
// 예를 들어, 다음과 같은 경우라면, 첫 번째 행을 골랐을 경우와 첫 번째 열을 골랐을 경우에만 행복한 수열이 되므로, 총 행복한 수열의 수는 2개가 됩니다.

// 입력 형식 :
// 첫 번째 줄에는 격자의 크기를 나타내는 n과 연속해야 하는 숫자의 수를 나타내는 m이 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터는 n개의 줄에 걸쳐 격자에 대한 정보가 주어집니다. 각 줄에는 각각의 행에 대한 정보가 주어지며,
// 이 정보는 1이상 100이하의 숫자가 각각 공백을 사이에 두고 주어집니다.
// 1 ≤ m ≤ n ≤ 100

// 입력 예시 :
// 3 2
// 1 2 2
// 1 3 4
// 1 2 3

// 출력 예시 :
// 2
package Simulation02_시뮬레이션02;

import java.util.*;

/*
public class Main {
    public static final int MAX_N = 100; // n의 최대값
    public static int[][] arr = new int[MAX_N][MAX_N]; // 주어지는 숫자를 원소로 갖는 2차원 배열
    public static int n,m; // 주어지는 n,m

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        if(m == 1){
            System.out.println(n * 2);
            System.exit(0);
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        } // 2차원 배열 원소 입력

        int ans = 0; // 행복한 수열의 개수

        for(int i = 0; i < n; i++){
            int cnt = 1;

            for(int j = 1; j < n; j++){
                if(arr[i][j] != arr[i][j - 1])
                    cnt = 1;
                else
                    cnt ++;

                if(cnt >= m){
                    ans++;
                    break;
                }
            }

            cnt = 1;

            for(int j = 1; j < n; j++){
                if(arr[j][i] != arr[j - 1][i])
                    cnt = 1;
                else
                    cnt ++;

                if(cnt >= m){
                    ans ++;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
*/
public class Simulation03{
    public static final int MAX_N = 100; // n의 최대값
    public static int n,m; // 주어지는 n,m
    public static int[][] arr = new int[MAX_N][MAX_N]; // 격자 정보를 담을 2차원 배열

    public static int[] seq = new int[MAX_N]; // 중간 상태를 담을 1차원 임시 배열

    public static boolean isHappy(){
        int consecutive = 1,maxConsecutive = 1;

        for(int i = 1; i < n; i++){
            if(seq[i] == seq[i - 1])
                consecutive ++;
            else
                consecutive = 1;

            maxConsecutive = Math.max(maxConsecutive,consecutive);
        }

        if(maxConsecutive >= m)
            return true;
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        } // 2차원 배열 정보 입력


        int numOfHappy = 0; // 행복 수열 갯수

        for(int i = 0; i < n; i++){ // 각 행
            for(int j = 0; j < n; j++){ // 각 열
                seq[j] = arr[i][j];
            } // 임시 배열의 각 행의 정보를 담음
            if(isHappy())
                numOfHappy ++;
        }

        for(int i = 0; i < n; i++){ // 각 열
            for(int j = 0; j < n; j++){ // 각 행
                seq[j] = arr[j][i];
            } // 임시 배열의 각 행의 정보를 담음
            if(isHappy())
                numOfHappy ++;
        }

        System.out.println(numOfHappy); // 출력
    }
}