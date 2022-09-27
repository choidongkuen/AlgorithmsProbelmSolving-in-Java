import java.util.Arrays;

public class Test{
    public static final int limit = 10;
    public static int solution01(int[] arr){
        int ans = -1;
        int n = arr.length;

        for (int i = 0; i < n ; i++) {
            int sum = 0;
            for (int j = i; j < n ; j++) {
                sum += arr[j];
                if(sum > limit){
                    ans = Math.max(ans, j - i);
                    break;
                }
            }
        }
        return ans;

    }

    public static int solution02(int[] arr){

        int p1 = 0;
        int p2 = 0;
        int ans = -1;
        int sum = 0;

        while(p2 < arr.length){
            while(p2 < arr.length && arr[p2] + sum < limit){ // 갈 수 있을 때까지
                sum += arr[p2];
                p2 ++;
            }

            ans = Math.max(ans, p2 - p1);
            sum -= arr[p1 ++];
        }
        return ans;

    }
    public static void main(String[] args) {
        int[] arr = {6,3,2,4,9,1};
        System.out.println(solution01(arr));
        System.out.println(solution02(arr));

    }
}