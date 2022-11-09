// 날짜 : 2022/11/09
// 문제 : 문제 추천 시스템 1

// 문제 설명 :
// 문제를 추천해주는 프로그램을 만드려합니다. 만드려는 명령어는 총 3가지입니다.
// rc x : x가 1인 경우 문제 리스트에서 난이도가 가장 높은 문제의 번호를 출력 합니다. 만약 난이도가 가장 높은 문제가 여러 개라면 문제 번호가 큰 것으로 출력합니다.
// x가 -1인 경우 문제 리스트에서** 난이도가 가장 낮은 문제의 번호를 출력**합니다. 만약 난이도가 가장 낮은 문제가 여러 개라면 문제 번호가 작은 것으로 출력합니다.
// 명령어 rc는 문제 리스트에 문제가 하나 이상 있을 때만 주어집니다. x는 반드시 1 또는 -1으로만 주어집니다.
// ad P L : 문제 리스트에 난이도가 L인 문제 번호 P를 추가합니다.
// 이전에 문제 리스트에 있던 문제 번호가 다른 난이도로 다시 들어 올 수 있습니다.
// sv P L : 추천 문제 리스트에서 난이도가 L인 문제 번호 P를 제거합니다.
// 명령어 sv는 추천 문제 리스트에 난이도가 L이고 문제 번호가 P인 문제가 있을 때만 주어집니다.
// 위 명령어들을 수행하는 문제 추천 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 추천 문제 리스트에 있는 문제의 개수 n이 주어집니다.
// 두 번째 줄부터 n+1 줄까지 문제 번호 P와 난이도 L가 공백을 두고 주어집니다.
// n+2 번째 줄은 입력될 명령문의 개수 m이 주어집니다.
// n+m+3 번째 줄부터 m개의 위에서 설명한 명령문이 입력됩니다.
// 1 ≤ n, P ≤ 100,000
// 1 ≤ L ≤ 100, L은 자연수
// 1 ≤ m ≤ 10,000

// 입력 예시 01 :
// 4
// 1000 1
// 1001 2
// 19998 78
// 2042 55
// 4
// ad 1402 59
// sv 19998 78
// rc 1
// rc -1

// 출력 예시 01 :
// 1402
// 1000
package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set19 {

    static class Problem implements Comparable<Problem>{
        // 난이도가 가장 낮은 문제 기준으로 오름차순 정렬
        // 만약 난이도가 동일하다면 문제 번호가 낮은 기준으로 오름차순 정렬
        int number;
        int level;

        public Problem(int number, int level) {
            this.number = number;
            this.level = level;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.level == o.level){
                return this.number - o.number;
            }
            return this.level - o.level;
        }
    }

    public static int n,m;
    public static TreeSet<Problem> treeSet = new TreeSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // n : 문제 개수
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            Integer number = sc.nextInt();
            Integer level = sc.nextInt();
            treeSet.add(new Problem(number,level));
        }

        m = sc.nextInt();

        for(int i = 0; i < m; i ++ ){

            String command = sc.next();
            if(command.equals("rc")){
                Integer x = sc.nextInt();

                if(x == 1){
                    // 난이도가 가장 높은 문제
                    Problem p = treeSet.last();
                    System.out.println(p.number);
                }else{
                    // 난이도가 가장 낮은 문제
                    Problem p = treeSet.first();
                    System.out.println(p.number);
                }
            }else if(command.equals("ad")){
                Integer number = sc.nextInt();
                Integer level = sc.nextInt();
                treeSet.add(new Problem(number,level));
            }else{
                Integer number = sc.nextInt();
                Integer level = sc.nextInt();
                treeSet.remove(new Problem(number,level));
            }
        }
    }
}
