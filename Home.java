import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Home {

    // Consumer,Supplier 인터페이스를 알아보자.
    // Consumer 인터페이스 : 매개 값을 받아 소비만 하고 리턴 값을 가지지 않음
    // Supplier 인터페이스 : 매개 값 없이, 리턴 값을 가짐

    public static void main(String[] args) {

        // Consumer 인터페이스 : 매개변수 1개
        Consumer<String> consumer = (t) -> {
            System.out.println(t +" 이다.");
        };

        // accept : 매개 변수를 전달해주는 메소드
        consumer.accept("king");

        // BiConsumer 인터페이스 : 매개변수 2개
        BiConsumer<String,Integer> biConsumer = (a,b) -> {
            System.out.println("이름은 " + a + " 나이는 " + b);
        };

        biConsumer.accept("king",26);


        /////////////////////////////////////////

        Supplier<String> supplier = () -> {
            String result = "King";
            return result;
        };

        System.out.println(supplier.get());


    }
}
