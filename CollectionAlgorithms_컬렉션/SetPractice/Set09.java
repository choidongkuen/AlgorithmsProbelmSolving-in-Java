// TreeSet
// 들어온 순서 유지, 중복 제거
// s.ceiling(E) : 해당 E 보다 같거나 큰 최초의 숫자
// s.floor(E) : 해당 E 보다 같거나 작은 최초의 숫자
// s.higher(E) : 해당 E 보다 큰 최초의 숫자
// s.lower(E) : 해당 E 보다 작은 최초의 숫자
// s.first() : treeSet의 가장 첫번째 숫자 == 가장 작은 숫자
// s.last() : treeSet의 가장 마지막 숫자 == 가장 큰 숫자

package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set09 {


    public static final int MAX_N = 100000;

    public static int n;
    public static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String command = sc.next();

            if (command.equals("add")) {
                Integer x = sc.nextInt();
                treeSet.add(x);
            } else if (command.equals("remove")) {
                Integer x = sc.nextInt();
                treeSet.remove(x);
            } else if (command.equals("find")) {
                Integer x = sc.nextInt();
                System.out.println(treeSet.contains(x));
            } else if (command.equals("lower_bound")) {
                Integer x = sc.nextInt();
                // x보다 같거나 큰 최초의 숫자
                if (treeSet.ceiling(x) == null) {
                    System.out.println("None");
                } else {
                    System.out.println(treeSet.ceiling(x));
                }
            } else if (command.equals("upper_bound")) {
                Integer x = sc.nextInt();
                // x보다 큰 최초의 숫자

                if (treeSet.higher(x) == null) {
                    System.out.println("None");
                } else {
                    System.out.println(treeSet.higher(x));
                }
            } else if (command.equals("largest")) {
                if (treeSet.isEmpty()) {
                    System.out.println("None");
                } else {
                    System.out.println(treeSet.last());
                }
            } else {
                if (treeSet.isEmpty()) {
                    System.out.println("None");
                } else {
                    System.out.println(treeSet.first());
                }
            }
        }
    }
}
