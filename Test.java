/*

class SolutionTest{

    public boolean canBuy(boolean[] arr) {
        for (boolean element : arr) {
            if (!element)
                return false;
        }
        return true;
    }

    public void initialize(boolean[] arr){
        for(int i = 0; i < arr.length; i++)
            arr[i] = false;
    }

    public int solution(String[] ingredients, String[] items){

        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i < items.length; i++){

            boolean[] canBuy = new boolean[ingredients.length];
            initialize(canBuy);

            int leng = 1;
            int p1 = i;
            int p2 = i + 1;

            while(p2 < items.length){

                if(canBuy(canBuy)){
                    leng = p2 - p1;
                    break;
                }
                if()


            }
        }


        return 1;

    }
}




public class Test{
    public static void main(String[] args) {

        String[] items = {"물","인삼","커피","생딝","소주","사탕","생닭","쌀"};
        String[] ingredients = {"생닭","인삼","소주","대추"};

        System.out.println(new SolutionTest().solution(ingredients,items));

    }
}
*/
