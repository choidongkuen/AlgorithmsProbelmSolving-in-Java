package Simulation01_시뮬레이션01;

import java.util.Arrays;
import java.util.Scanner;

import java.util.*;

public class Test{
    public static int[][] arr = new int[3][3];
    public static int n;
    public static int[] seq = new int[3];
    public static int ans;

    public static boolean simulate(int i, int j){
        int[] counts = new int[10];

        for(int k = 0; k < 3; k ++)
            counts[seq[k]] ++;

        if(counts[i] + counts[j] == 3 && counts[i] >= 1 && counts[j] >= 1)
            return true;
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++){
            char[] numbers = sc.next().toCharArray(); // 문자 배열로 변환
            for(int j = 0; j < 3; j++)
                arr[i][j] = numbers[j] - '0';
        } // 2차원 정수 배열로 변환

        ans = 0;

        for(int i = 1; i < 10; i++){
            for(int j = i + 1; j < 10; j++){
                boolean isWin = false;

                for(int row = 0; row < 3; row ++) // 모든 행
                    for(int col = 0; col < 3; col ++)
                        seq[col] = arr[row][col];

                    if(simulate(i,j))
                        isWin = true;

                for(int col = 0; col < 3; col ++) // 모든 열
                    for(int row = 0; row < 3; row ++)
                        seq[row] = arr[row][col];

                    if(simulate(i,j))
                        isWin = true;

                for(int d = 0; d < 3; d ++) // 오른쪽 대각선
                    seq[d] = arr[d][d];

                if(simulate(i,j))
                    isWin = true;


                for(int d = 0; d < 3; d ++) // 왼쪽 대각선
                    seq[d] = arr[d][2 - d];

                if(simulate(i,j))
                    isWin = true;

                if(isWin){
                    ans++;
                    System.out.printf("%d,%d\n",i,j);
                }
            }
        }
        System.out.println(ans);
    }
}