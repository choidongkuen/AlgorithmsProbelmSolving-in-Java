// 해싱 :
// 특정 값을 해시 함수에 대입하여 해시값을 인덱스로 하여 값을 대입
// 삽입,삭제,탐색 : O(1) # 해시함수만 돌리면 된다.
// but 한계 존제 : 배열 같은 값은 처리 불가!
// 해싱을 사용하는 경우 : 들어오는 순서에 상관 없이 삽입,삭제,탐색이 빈번히 일어날
// Standard Library(STL) : 표준 라이브러리

// HashSet : 데이터를 해시 기반으로 관리
// - 메소드 -

// HashSet(Collection c)
// add(obj)
// addAll(Collection c)
// clear()
// clone() # 얕은 복사(주소값 복사)
// contains(Object obj)
// containsAll(Collection c)
// isEmpty()
// remove(Obj)
// removeAll(Collection c) -> 컬렉션에 저장된 모든 객체와 동일한 것들을 삭제<차집합>
// retainAll(Collection c) -> 컬렉션에 저장된 모든 객체와 동일한 것만 남기고 삭제<교집합>
// toArray() -> 배열로 변환


package CollectionAlgorithms_컬렉션.SetPractice;

import java.util.HashSet;
import java.util.Scanner;

public class Set01 {
    public static final int MAX_N = 100000;
    public static int n;
    public static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {

            String command = sc.next();

            if(command.equals("add")){
                Integer num = sc.nextInt();
                hashSet.add(num);
            }else if(command.equals("remove")){
                Integer num = sc.nextInt();
                hashSet.remove(num);
            }else{ // find
                Integer num = sc.nextInt();
                System.out.println(hashSet.contains(num));
            }

        }
    }
}
