package lesson2;

public class FizzBuzz {
    public static String fizzBuzz(int n) {
        String s = "No fizz-buzz";
        if (n % 3 == 0 && n % 5 == 0) {
            s = "fizz-buzz";
        } else if (n % 3 == 0) {
            s = "fizz";
        } else if (n % 5 == 0) {
            s = "buzz";
        }
        return s;
    }
}
