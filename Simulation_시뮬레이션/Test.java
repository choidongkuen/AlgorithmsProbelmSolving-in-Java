package Simulation_시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int s = 123456;
        char[] arr = String.valueOf(s).toCharArray();

        int[] numArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            numArr[i] = arr[i] - '0';
        }

        System.out.println(Arrays.toString(numArr));

    }
}
