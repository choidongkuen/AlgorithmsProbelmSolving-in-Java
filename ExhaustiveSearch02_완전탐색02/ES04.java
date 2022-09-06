// 날짜 : 2022/09/07
// 문제 : 데이터센터의 온도 조정 2
// 문제 설명 :
// 데이터센터 안에 있는 장비들의 효율을 위해 온도를 맞춰주려고 합니다. 각 장비들마다 선호하는 온도의 범위들이 전부 다릅니다. 각 장비의 작업량은 다음과 같이 정의됩니다.
// 1. 만약 데이터센터의 온도범위가 장비 A가 선호하는 온도 Ta 보다 낮다면 C만큼의 작업량을 수행하고,
// 2. 만약 데이터센터의 온도범위가 장비 A가 선호하는 온도 Ta이상 Tb 이하에 있다면 G만큼의 작업량을 수행하고,
// 3. 만약 데이터센터의 온도범위가 장비 A가 선호하는 온도 Tb 보다 높다면 H만큼의 작업량을 수행합니다.

// 장비의 개수 N과 온도에 따른 장비들의 작업량 C, G, H가 주어지고 N개 장비들이 선호하는 온도의 범위가 주어지면
// 온도를 적절히 설정하여 데이터센터안의 최고 작업량을 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 차례로 N, C, G, H가 공백을 사이에 두고 주어집니다.
// 두 번째 줄부터 N줄에 걸쳐 한 줄 하나씩 온도 범위 Ta, Tb가 공백을 사이에 두고 주어집니다.
// 1 ≤ N ≤ 1,000
// 0 ≤ Ta ≤ Tb ≤ 1,000
// 0 ≤ C, H ≤ G ≤ 1,000

// 입력 예시 :
// 4 7 9 6
// 5 8
// 3 4
// 13 20
// 7 10

// 출력 예시 :
// 31

package ExhaustiveSearch02_완전탐색02;
import java.util.*;

public class ES04{
    public static final int MAX_N = 1000; // 장비의 최대 개수
    public static int[][] arr = new int[MAX_N][2]; // 장비의 정보를 담을 2차원 배열
    public static int n,c,g,h;

    public static int getWork(int temp, int sensor){
        int ta = arr[sensor][0];
        int tb = arr[sensor][1];

        if(temp < ta)
            return c;
        else if(temp >= ta && temp <= tb)
            return g;

        return h;

    }


    public static void main(String[] args) {
        // Your Program Goes Here

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        g = sc.nextInt();
        h = sc.nextInt();

        int maxTemp = 0;

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            maxTemp = Math.max(maxTemp,arr[i][1]);
        }

        int maxWork = 0;
        for(int i = 0; i <= maxTemp + 1; i++){ // 온도 0 ~ maxTemp
            int work = 0;
            for(int j = 0; j < n; j++){
                work += getWork(i,j);
            }

            maxWork = Math.max(work,maxWork);
        }
        System.out.println(maxWork);
    }
}