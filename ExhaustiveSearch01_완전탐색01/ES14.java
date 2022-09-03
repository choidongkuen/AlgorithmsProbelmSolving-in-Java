// 날짜 : 2022 / 09/ 04
// 문제 : carry 피하기 2
// 문제 설명 :
// n개의 숫자가 주어지고, 그 중 정확히 서로 다른 3개의 숫자를 골랐을 때 carry가 전혀 발생하지 않으면서 나올 수 있는 숫자 합의 최댓값을 계산하는 프로그램을 작성해보세요.
// 여기서 carry란, 수와 수를 더했을 때, 10의 자리를 넘기는 것을 말합니다.
// 예를 들어 3과 6을 더하면 9가 되고 자리수가 넘어가지않아 carry가 발생하지 않지만, 5와 7은 더하면 12가 되므로 carry가 발생합니다.
// 또, 81과 72를 더하면 일의 자리를 더할때는 carry가 발생하지 않더라도 십의 자리를 더할 때는 carry가 발생하게 되므로 불가능한 조합입니다.
// 즉, 각 자리수를 모두 각각 더해봤을 때 10 이상이 되는 경우가 전혀 없어야 한다는 뜻입니다.

// 입력 형식 :
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄부터는 n개의 줄에 걸쳐 숫자가 주어집니다. 입력으로 주어지는 숫자는 모두 다름을 가정해도 좋습니다.
// 3 ≤ n ≤ 20
// 1 ≤ 숫자의 범위 ≤ 10,000

// 입력 예시 :
// 6
// 522
// 6
// 84
// 7311
// 19
// 9999

// 출력 예시 :
// 7839


package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES14 {
    public static final int MAX_N = 20; // 원소의 개수(n) 의 최대값
    public static int[] arr = new int[MAX_N]; // n개의 숫자를 담을 1차원 배열 생성

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 주어지는 원소의 개수
        int ans = -1; // 최대값(모두 캐리 발생한다면 갱신되지 않을 것임)

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        } // 1차원 배열 값 채우기

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){

                    int x = arr[i], y= arr[j], z = arr[k];
                    boolean carryExist = false; // 세 순서쌍의 덧셈에서 carry 발생여부
                    int sum = 0; // 세 숫자쌍의 구간의 총합

                    for(int s = 0; s < 5; s++){ // 최대 10000
                        int partSum = x % 10 + y % 10 + z % 10; // 구간 합

                        if(partSum >= 10){ // carry 발생
                            carryExist = true;
                            break;
                        }
                        sum += partSum * Math.pow(10,s);
                        x = x / 10;
                        y = y / 10;
                        z = z / 10;

                    }
                    if(!carryExist){ // 세 숫자쌍의 합에서 carry가 발생하지 않는다면
                        ans = Math.max(ans,sum);
                    }
                }
            }
        }
        System.out.println(ans); // 최대값 출력
    }
}
