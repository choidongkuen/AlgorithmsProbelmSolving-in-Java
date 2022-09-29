package BackTracking_백트랙킹;

import java.util.ArrayList;
import java.util.Scanner;

public class BT14 {
    public static final int MAX_N = 8;

    public static ArrayList<Integer> result = new ArrayList<>();
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int n;

    public static void print(){
        for(Integer x : result){
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void backtracking(int currNum){
        if(currNum == n + 1){
            print();
            return;
        }

        for(int i = n; i >= 1; i --){
            if(visited[i])
                continue;

            result.add(i);
            visited[i] = true;
            backtracking(currNum + 1);
            visited[i] = false;
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        backtracking(1);
    }
}
