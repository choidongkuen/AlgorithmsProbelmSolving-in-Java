import java.util.*;

public class Test {
    public static final int MAX_N = 10; // n의 최대값
    public static final int MAX_M = 100; // m의 최대값
    public static int[][] arr = new int[MAX_M][2]; // m개의 주어지는 정보를 담을 2차원 배열
    public static int n,m;

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();


        for(int i = 0; i < m; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int ans = 0;

        for(int i = 0; i < m; i++){
            int cnt = 0;
            for(int j = i + 1; j < m; j++){
                int x = arr[j][0];
                int y = arr[j][1];

                if(arr[i][0] == x && arr[i][1] == y){
                    cnt++;
                }
                else if(arr[i][0] == y && arr[i][1] == x){
                    cnt++;
                }
            }
            ans = Math.max(ans,cnt);
        }
        System.out.println(ans);
    }
}