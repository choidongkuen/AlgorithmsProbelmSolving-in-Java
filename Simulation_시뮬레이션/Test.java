package Simulation_시뮬레이션;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6}};
        for(int[] subArr : arr){
            for(int ele : subArr){
                System.out.print(ele+" ");
            }
            System.out.println();
        }
    }
}
