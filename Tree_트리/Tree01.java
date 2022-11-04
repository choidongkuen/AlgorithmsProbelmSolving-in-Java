package Tree_트리;


import javax.swing.text.Segment;

class SegmentTree{

    // 세그먼트 트리를 구현할 배열
    private long[] tree;

    public SegmentTree(int n) {

        // 트리의 높이 계산
        double treeHeight = Math.ceil(Math.log(n)/ Math.log(2)) + 1;

        // 트리의 노드 수 계산
        long treeNodeCount = Math.round(Math.pow(2, treeHeight));

        tree = new long[Math.toIntExact(treeNodeCount)];
    }
    // 부모노드의 값은 자식 노드의 두 값을 더한 값
    public long init(long[] arr, int node, int start, int end){

        if(start == end){
            return tree[node] = arr[start];
        }else{
            int mid = (start + end) / 2;
            return tree[node] = init(arr,node * 2, start,mid) + init(arr,node * 2 + 1,mid + 1, end);
        }
    }

    // 세그먼트 트리를 구현하고, 구간합 구하는 메소드
    // node : 노드 번호
    // start : 노드가 가지는 합의 시작 인덱스
    // end : 노드가 가지는 합의 끝 인덱스
    // left : 배열의 구간 합 중 시작 인덱스(구하려는)
    // right : 배열의 구간 합 중 끝 인덱스(구하려는)

    public long sum(int node, int start, int end, int left, int right){

        // 노드가 가지는 구간이 구하려는 합의 구간에 속하지 않는 경우
        if(end < left || start > right) {
            return 0;
        } // 노드가 가지는 구간이 구하려는 합의 구간에 속하는 경우
        else if(left <= start && end <= right){
            return tree[node];
        }else{

            // case 01 : 노드가 가지는 값의 구간이 구하려는 합의 구간에 일부만 속하는 경우
            // case 02 : 노드가 가지는 값의 구간이 구하려고 하는 합의 구간을 모두 포함 -> 자식을 봐야 함!

            int mid = (start + end) / 2;
            return sum(node * 2, start, mid, left, right)
                    + sum(node * 2 + 1, mid + 1, end,left,right);
        }
    }
}

public class Tree01 {

    public static void main(String[] args) {

        int[] arr = {5,8,7,3,2,5,1,8,9,8,7,8};
        SegmentTree st = new SegmentTree(11);
        //...
    }
}
