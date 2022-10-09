package CollectionAlgorithms_컬렉션.MapPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Map05 {
    static HashMap<Character,Integer> map = new HashMap<>();

    static class Node{
        int key;
        int value;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(); // 문자열 입력

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        ArrayList<Node> node = new ArrayList<>();
        ArrayList<Character> keySet = new ArrayList<>(map.keySet());

        for (int i = 0; i < keySet.size(); i++) {
            char key = keySet.get(i);
            node.add(new Node(key, map.get(key)));
        }
        boolean isExist = false;

        for (Node element : node) {
            if (element.value == 1) {
                System.out.print((char) element.key + " ");
                isExist = true;
                System.exit(0);
            }
        }
        if(!isExist){
            System.out.println("None");
            System.exit(0);
        }
    }
}
