// 날짜 : 2022/11/08
// 문제 : 서로 다른 숫자

// 문제 설명 :
// n개의 숫자가 주어졌을 때, 서로 다른 숫자의 수를 출력하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 원소의 개수 n이 주어집니다.
// 두 번째 줄에는 n개의 숫자가 주어집니다.
// 1 ≤ n ≤ 100,000
// −10^9≤ 주어지는 숫자 ≤ 10^9

// 입력 예시 01 :
// 5
// 1 5 2 2 1
// 출력 예시 01 :
// 3

// 아이디어 :
// HashSet으로 원소를 담으면
// 중복이 제거되어 자연스래 서로 다른 원소의 갯수 == HashSet의 사이즈
package CollectionAlgorithms_컬렉션.SetPractice;
import java.util.HashSet;
import java.util.Scanner;

public class Set04 {
    public static final int MAX = 100000;
    public static int n;

    public static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        while(n -- > 0){
            hashSet.add(sc.nextInt());
        }

        System.out.println(hashSet.size());
    }
}
