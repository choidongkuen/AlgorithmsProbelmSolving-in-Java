public class Test{

    public static void main(String[] args) {

        int i = 3;
        int j = 3;

        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {

                for (int m = k; m < i; m++) {
                    for (int n = l; n < j; n++) {
                        System.out.println("(" + k + " " + m + " " + l + " " + n + ")");
                    }
                }

            }
        }
    }

}