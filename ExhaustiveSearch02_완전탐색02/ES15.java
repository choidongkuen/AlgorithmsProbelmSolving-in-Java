// 날짜 : 2022/09/09
// 문제 : 가장 작은 x 찾기
// 문제 설명 :
// 처음에는 양의 정수 x로 시작하여 값에 2를 곱하는 것을 n번 반복하려 합니다. 2를 곱할 때마다 현재 숫자의 범위에 대한 단서 ai,bi가 주어진다.
// 이는 2배가 된 후의 값이 ai이상 bi 이하임을 의미한다. 이러한 조건을 만족하는 가능한 값 중 최소값을 구하여라.

// 입력 형식 :
// 첫 번째 줄에는 정수 n이 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 범위에 대한 정보 ai ,bi 값이 공백을 사이에 두고 주어진다.
// 1 <= n <= 10
// 1 <= ai <= bi <= 10000

// 입력 예시 :
// 4
// 1 10
// 10 16
// 20 25
// 40 50

// 출력 예시 :
// 3





package ExhaustiveSearch02_완전탐색02;
import java.util.*;

public class ES15 {
    public static final int MAX_N = 10; // n의 최대값
    public static int n;

    public static int[] a = new int[MAX_N];
    public static int[] b = new int[MAX_N];
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int ans = -1;

        for(int i = 1; i <= 10000; i++){
            boolean isPossible = true;
            int num = i;

            for(int j = 0; j < n; j++){
                num *= 2;
                if(num < a[j] || num > b[j]){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){
                ans = i;
                break;
            }
        }

        System.out.println(ans); // 출력
    }
}