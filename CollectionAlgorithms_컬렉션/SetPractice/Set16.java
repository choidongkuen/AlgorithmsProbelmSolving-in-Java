// 날짜 : 2022/11/09
// 문제 : 자리 차지하기

// 문제 설명 :
// 처음 m개의 비어있는 의자가 주어집니다. 이 의자들은 순서대로 1번부터 m번까지 번호가 붙여져 있습니다. 이후 사람들이 앉고자 하는 의자에 대한 정보 ai 값이 n개 주어집니다.
// << ai는 1이상 m이하로, i번째 사람은 1번이상 ai번 이하의 의자에만 앉고 싶다는 것 >> 을 의미합니다.
// 1번 사람부터 순서대로 해당 규칙에 맞춰 앉기 시작하며, 최초로 앉지 못하는 사람이 생기면 종료한다고 했을 때 사람들이 앉을 자리를 적절하게 배정하여 앉게 되는 사람 수를 최대로 만드는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다.
// 1 ≤ n, m ≤ 100,000
// 1 ≤ 주어지는 숫자들 ≤ m

// 입력 예시 01:
// 3 4
// 4 1 1

// 출력 예시 01 :
// 2

// 아이디어 :
// 모든 사람은 1 ~ ai 이하의 자리에 앉아야 한다 => 어떤 사람이던 1번은 앉을 수 있다.
// 주어진 선호하는 좌석의 큰 값부터 고려 만약 해당 좌석에 아무 원소도 없다면 treeSet에 추가하고 ans ++(이런 방식은 최대한 인원이 앉을 수 있는 것을 보장)
// 1번 좌석까지 고려 했는데도 불구하고, 못앉았다면 종료

package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Scanner;
import java.util.TreeSet;

public class Set16 {

    public static int n,m;
    public static TreeSet<Integer> treeSet = new TreeSet<>();
    public static int ans = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // n명의 사람의 정보
        n = sc.nextInt();
        // 자리의 갯수
        m = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            // i번째 사람이 최대 앉을 수 있는 좌석의 번호(of m)
            int seat = sc.nextInt();
            boolean canNext = false;

            // 뒤에 사람을 위해 앉을 수 있는 좌석 중 가능한 최대 좌석에 앉힌다.
            // s = m ~ 1
            for (int s = seat; s >= 1 ; s --) {
                // 아무도 해당 좌석에 앉지 않았다면
                if(!treeSet.contains(s)){
                    // 해당 좌석에 앉히고,
                    treeSet.add(s);
                    // 다음 사람으로 넘어 갈 수 있음
                    canNext = true;
                    ans ++;
                    break;
                }
            }

            // 결국 i번째 사람은 좌석에 앉히지 못함.
            if(!canNext)
                break;
        }
        System.out.println(ans);
    }
}