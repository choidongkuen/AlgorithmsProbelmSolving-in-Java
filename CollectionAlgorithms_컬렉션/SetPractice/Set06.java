// 날짜 : 2022/11/08
// 문제 : 자리 바꾸기
// 문제 설명 :
// 코드 트리 중급 자료구조 HashSet << 부분 자리바꾸기 2 >> 참고


package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.*;

public class Set06 {

    static class Command{
        int x, y;

        public Command(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final int MAX_N = (int)1e5;
    public static final int MAX_M = (int)1e5;
    public static int cnt = 3;

    public static int n,k;
    public static ArrayList<Set<Integer>> setList = new ArrayList<>();
    public static ArrayList<Command> commandList = new ArrayList<>();


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            arr[i] = i;
        }



        for (int i = 0; i < n ; i++) {
            setList.add(new HashSet<Integer>());
            setList.get(i).add(i + 1);
        }

        for (int i = 0; i < k ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt() ;
            commandList.add(new Command(x,y));
        }

        while(cnt -- > 0){
            for (int i = 0; i < k ; i++) {
                int x = commandList.get(i).x;
                int y = commandList.get(i).y;

                setList.get(arr[x] - 1).add(y);
                setList.get(arr[y] - 1).add(x);

                int temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;


            }
        }

        for(Set<Integer> subSet : setList)
            System.out.println(subSet.size());
    }
}
