package CollectionAlgorithms_컬렉션.Map;

import java.util.Arrays;
import java.util.Scanner;

public class Map03 {
    public static final int MAX = 10000;
    public static int n,m;
    public static int[] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        int p2 = -1;
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n ; i++) {

            while(p2 + 1 < n && sum < m){
                sum += arr[p2 + 1];
                p2++;
            }

            if(sum == m){
                ans++;
            }

            sum -= arr[i];
        }

        System.out.println(ans);
    }
}
