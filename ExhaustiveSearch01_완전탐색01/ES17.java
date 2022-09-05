package ExhaustiveSearch01_완전탐색01;

import java.util.*;

public class ES17 {
    public static final int MAX = 100; // 최대 사람 수
    public static int[] arr = new int[MAX + 1]; // 1차원 배열 선언

    public static boolean func(int start, int end){
        int gCnt = 0, hCnt = 0; // 해당 구간(start - end)의 G,H 개수

        for(int i = start; i <= end; i++){
            if(arr[i] == 1)
                gCnt++;
            else if(arr[i] == 2)
                hCnt++;
        }

        if((gCnt != 0 && hCnt !=0) && (gCnt == hCnt))
            return true; // G,H 의 갯수가 동일한 경우

        else if(gCnt == 0 || hCnt != 0)
            return true; // H만 있는 경우

        else if(gCnt != 0 || hCnt == 0)
            return true;

        else
            return false; // 그 외 false

    }
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 주어지는 사람의 수

        for(int i = 0; i < n; i++){
            int loc = sc.nextInt();
            char al = sc.next().charAt(0);

            arr[loc] = (al == 'G')? 1:2; // G - > 1 // H -> 2
        } // 위치 : 인덱스 , 알파벳에 대한 번호 : 원소

        int ans = 0;

        for(int i = 0; i <= MAX; i++){
            for(int j = i; j <= MAX; j++){
                if(arr[i] == 0 || arr[j] == 0)
                    continue;

                if(func(i,j)){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        System.out.println(ans);
    }
}