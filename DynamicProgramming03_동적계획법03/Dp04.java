package DynamicProgramming03_동적계획법03;

import java.util.Scanner;

public class Dp04 {

    public static final int MAX_N = 100;

    public static int n;
    public static int[] red = new int[MAX_N + 1];
    public static int[] blue = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();


        for (int i = 1; i <= n ; i++) {

            red[i] = sc.nextInt();
            blue[i] = sc.nextInt();
        }

        
    }

}
