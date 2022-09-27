import java.util.Arrays;

public class Test{
    public static void main(String[] args) {
        int[] arr = {100,200,300};
        int[] cnt = {0,0,1,0};
        System.out.println(Arrays.stream(arr).max().getAsInt());
        System.out.println(Arrays.stream(cnt).max().getAsInt());

    }
}