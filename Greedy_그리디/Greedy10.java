package Greedy_그리디;

import java.util.Scanner;
import java.util.TreeSet;

public class Greedy10 {
    static class Bomb implements Comparable<Bomb> {
        int score, time;

        public Bomb(int score, int time) {
            this.score = score;
            this.time = time;
        }

        public int compareTo(Bomb b) {
            if (this.time != b.time) {
                return this.time - b.time;
            } else {
                return b.score - this.score;
            }
        }
    }
    public static final int MAX_N = 10000;

    public static int n;
    public static TreeSet<Bomb> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        while(n --> 0){
            Integer score = sc.nextInt();
            Integer time = sc.nextInt();
            treeSet.add(new Bomb(score,time));
        }

        int prevTime = -1;
        int ans = 0;
        for(Bomb b : treeSet){
            if(b.time >= prevTime + 1){
                ans += b.score;
                prevTime = b.time;
            }
        }
        System.out.println(ans);
    }
}