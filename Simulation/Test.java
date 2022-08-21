import java.util.*;
// ArrayList 버전

public class Test {
    public static ArrayList<Integer> aList = new ArrayList<>();
    public static ArrayList<Integer> bList = new ArrayList<>();

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        aList.add(0);bList.add(0);

        int aIdx = 1;
        for(int i = 0; i < n; i++){
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            while(t-- > 0){
                if(d == 'R')
                    aList.add(aList.get(aIdx - 1) + 1);
                else
                    aList.add(aList.get(aIdx - 1) - 1);

                aIdx++;
            }
        }

        int bIdx = 1;
        for(int i = 0; i < m; i++){
            int t = sc.nextInt();
            char d = sc.next().charAt(0);

            while(t-- > 0){
                if(d == 'R')
                    bList.add(bList.get(bIdx - 1) + 1);
                else
                    bList.add(bList.get(bIdx - 1) - 1);

                bIdx++;
            }
        }
        if(aIdx < bIdx){
            for(int i = 0; i < bIdx - aIdx; i++){
                aList.add(aList.get(aIdx-1));
            } // b가 a보다 긴 경우 차이가 나는 a리스트에 칸에 a의 마지막 원소 채우기
        }
        else if(aIdx > bIdx){
            for(int i = 0; i < aIdx - bIdx; i++){
                bList.add(bList.get(bIdx-1));
            } // a가 b보다 긴 경우 차이가 나는 b리스트에 칸에 b의 마지막 원소 채우기
        }
        System.out.println(aList.get(12) == bList.get(12));
        System.out.println(bList);
/*
        int ans = 0;
        int timeMax = 0;
        if(aIdx < bIdx)
            timeMax = bIdx;
        else
            timeMax = aIdx;

        for(int i = 1; i < timeMax; i++){
            if(aList.get(i) == bList.get(i) && aList.get(i-1) != bList.get(i-1)){
                ans++;
            }
        }
        System.out.println(ans);*/
    }
}
