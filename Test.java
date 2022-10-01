import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Test{
    public static int n, m;
    public static ArrayList<Integer> combination = new ArrayList<>();

    // 방문한 원소들을 출력해줍니다.
    /*
    public static void printCombination() {
        for(int i = 0; i < combination.size(); i++)
            System.out.print(combination.get(i) + " ");
        System.out.println();
    }*/

    // 지금까지 뽑은 갯수와 뽑을지 말지를 결정할 숫자를 인자로 받습니다.
    public static void findCombination(int currNum, int cnt) {
        // n개의 숫자를 모두 탐색했으면 더 이상 탐색하지 않습니다.
        if(currNum == n+1) {
            // 탐색하는 과정에서 m개의 숫자를 뽑은 경우 답을 출력해줍니다.
            if(cnt == m)
//                printCombination();
            return;
        }

        // currNum에 해당하는 숫자를 사용했을 때의 경우를 탐색합니다.
        combination.add(currNum);
        findCombination(currNum + 1, cnt + 1);
        combination.remove(combination.size() - 1);

        // currNum에 해당하는 숫자를 사용하지 않았을 때의 경우를 탐색합니다.
        findCombination(currNum + 1, cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        findCombination(1, 0);
    }
}
