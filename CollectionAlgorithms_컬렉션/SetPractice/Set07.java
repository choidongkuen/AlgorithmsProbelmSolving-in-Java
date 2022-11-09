// 날짜 : 2022/11/09
// 문제 : C-TAG
// 문제 설명 :
// 각 종이에 A, T, G, C가 적절히 조합된 M개의 알파벳이 한 줄 적혀있는 종이가 2N장 있습니다. 이 중 N장은 A그룹에, 나머지 N장은 B그룹에 속합니다.
// 종이에 적힌 알파벳들 중 몇 번째 자리의 알파벳들이 종이의 그룹을 결정하는지 살펴보려고 합니다.
// 예를 들어 N=3, M=8일 때, 종이에 적힌 알파벳이 다음과 같고 M개의 자리 중 2개의 자리에 있는 알파벳들로 그룹 A, B를 구분할 수 있는지를 살펴본다고 합시다.

// ex)
// 알파벳 자리:
//     1 2 3 4 5 6 7 ... M
// A 1: A A T C C C A ... T
// A 2: G A T T G C A ... A
// A 3: G G T C G C A ... A
// B 1: A C T C C C A ... G
// B 2: A G T T G C A ... T
// B 3: A G T T C C A ... T

// 이 경우 예로 2, 4째 알파벳이 A, B 그룹을 결정한다고 말할 수 있습니다.
// 그 이유는 2, 4번째 알파벳이 순서대로 AC, AT, GC인 경우에는 그룹 A이며 CC 혹은 GT인 경우에는 그룹 B라 말하면 모순이 없기 때문입니다.
// 이를 2개의 자리가 아닌 3개의 자리로 그룹 A, B를 확실히 구분할 수 있는 방법의 수를 구해보려 합니다.
// 가능한 서로 다른 조합의 수를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 N, M이 공백을 사이에 두고 차례대로 주어집니다.
// 두 번째 줄부터 N개의 줄에 걸쳐 각 줄에 그룹 A에 속한 종이에 쓰여진 M개의 알파벳들이 공백없이 주어집니다.
// N+2번째 줄부터 N개의 줄에 걸쳐 각 줄에 그룹 B에 속한 종이에 쓰여진 M개의 알파벳들이 공백없이 주어집니다.
// 1 ≤ N ≤ 500
// 3 ≤ M ≤ 50
// 모든 알파벳은 대문자로 주어지며, ‘A', ‘T’, ‘G’, 'C’로만 이루어져 있습니다.

// 입력 예시 01 :
// 3 8
// AATCCCAT
// GATTGCAA
// GGTCGCAA
// ACTCCCAG
// ACTCGCAT
// ACTTCCAT

// 출력 예시 01 :
// 22

// 아이디어 :
// A 그룹에 n개의 문자열이 있고, B 그룹에 n개의 문자열이 있다.
// 그룹에 각 문자열은 m길이의 문자열이며, 문제의 핵심은 m개의 자리 중 3개를 잘 뽑아 해당 조합이 어느 것도 겹치면 안된다.
// 결국 m 자리 중 3개를 2n개 뽑았을 때 모두 달라야 한다.
package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Set07 {
    public static final int MAX_N = 500;
    public static final int MAX_M = 50;
    public static int n,m;
    public static int ans = 0;

    public static String[] A = new String[MAX_N];
    public static String[] B = new String[MAX_N];

    public static boolean isPossible(int x, int y, int z){

        Set<String> aSet = Arrays.stream(A).collect(Collectors.toSet());
        // Set 을 사용하는 이유 :
        // 삽입,탐색,삭제 : O(1)

        for (int i = 0; i < n ; i++) {
            String addedA = A[i].substring(x,x + 1) + A[i].substring(y,y + 1)
                    + A[i].substring(z,z + 1);
            aSet.add(addedA);
        }

        for (int i = 0; i < n; i++) { // O(N)
            String addedB = B[i].substring(x, x + 1) + B[i].substring(y, y + 1)
                    + B[i].substring(z,z + 1);

            if(aSet.contains(addedB))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            A[i] = sc.next();
        }

        for (int i = 0; i < n ; i++) {
            B[i] = sc.next();
        }

        // 3 자리 선택
        // O(M^3)
        for (int i = 0; i < m ; i++) {
            for (int j = i + 1; j < m ; j++) {
                for (int k = j + 1; k < m ; k++) {
                    if(isPossible(i,j,k)){
                        ans ++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
