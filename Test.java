import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Pair implements Comparable<Pair>{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int compareTo(Pair p){

        return this.x - p.x;
    }
}

public class Test{
    public static void main(String[] args) {

        ArrayList<Pair> arr = new ArrayList<>();

        arr.add(new Pair(20000,20));
        arr.add(new Pair(-100,2));
        arr.add(new Pair(-123123,2));

        Collections.sort(arr);

        for(Pair p : arr){
            System.out.println(p.x);
        }
    }
}