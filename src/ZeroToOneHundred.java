/**
 * @author Chris Campo
 */
public class ZeroToOneHundred {

    public static void main(final String[] args) {
        //iterative();
        recursive();
    }

    static void iterative() {
        for(int i = 0; i <= 100; i++) {
            System.out.println(100 - i);
        }
    }

    static void recursive(final int i) {
        if (i < 0) {
            return;
        }
        System.out.println(i);
        recursive(i - 1);
    }

    static void recursive() {
        recursive(100);
    }
}
