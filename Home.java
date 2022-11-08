import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Home{

    public static void main(String[] args) {

        int[] arr = {1,2,3,4};

        // case 01 : primitive 배열을 reference 배열로 변환
        Integer[] integerArr = Arrays.stream(arr).boxed().toArray(Integer[] :: new);

        // case 02 : primitive 배열을 리스트로 변경
        List<Integer> list1 = Arrays.stream(arr).boxed().collect(Collectors.toList());

        // case 03 : reference 배열을 리스트로 변경
        List<Integer> list2 = Arrays.stream(integerArr).collect(Collectors.toList());
        // or
        List<Integer> list3 = new ArrayList<>(Arrays.asList(integerArr));

        // case 04 : 리스트를 int[] 배열로 변경
        int[] toArr1 = list1.stream().mapToInt(Integer::valueOf).toArray();

        // case 05 : 리스트르르 Integer[] 배열로 변경
        Integer[] toArr2 = list2.stream().toArray(Integer[] :: new);


    }


}