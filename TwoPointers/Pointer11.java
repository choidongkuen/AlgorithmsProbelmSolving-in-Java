// 날짜 : 2022/09/27
// 문제 : 부분 수열 여부 판단하기

// 아이디어 :
// 각 수열의 포인터 p1,p2를 설정해놓는다.
// 수열 B를 기준으로 비교하여, 만약 p1에 놓인 수열 A의 원소와 p2에 놓인 수열 B의 원소가 동일하다면,
// p1 ++ & p2 ++;
// 만약 각 포인터에 놓인 원소가 다르다면, p1 증가(다음에 위치한 A의 원소 비교를 위함)
// 만약 p2가 B의 길이랑 동일해지면 True
// 만약 p2가 B의 길이에 도달하지도 못했는데, p1이 A의 길이에 도달하면 False

package TwoPointers;

public class Pointer11 {

    public static boolean isSubSequence(int[] A, int[] B) {

        if (A == null || B == null)
            return false;

        if (A.length == 0 || B.length == 0)
            return false;

        int p1 = 0; // 수열 A의 포인터
        int p2 = 0; // 수열 B의 포인터

        while (true) {

            while (p1 < A.length && A[p1] != B[p2]) {
                p1++;
            } // 원소가 동일할때까지 p1 증가

            if (p1 == A.length) { // A 끝에 도달할 때
                if (p2 == B.length)
                    return true; // B 끝에 도달한 경우
                return false; // B 끝에 도달하지 못한 경우
            }
            if (p2 == B.length) {
                return true;
            } // A 끝에 도달하지 못했지만, B 끝에 도달한 경우

            p1++;
            p2++; // 두 포인트에 원소가 동일한 경우
        }
    }
    public static void main(String[] args) {
        int[] A = new int[]{5,1,5,3,1,4};
        int[] B = new int[]{5,1,4};
        System.out.println(isSubSequence(A,B)); // True

        A = new int[]{5,1,5,3,1,4};
        B = new int[]{3,5,1};
        System.out.println(isSubSequence(A,B)); // False
    }
}
