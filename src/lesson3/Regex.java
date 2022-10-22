package lesson3;

public class Regex {

    private static final String EMAIL = "^[A-Za-z0-9_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
    private static final String PHONE = "^((\\+7)|8)\\d{10}$";
    private static final String ISBN = "^97(8|9)-\\d{1,5}-\\d{1,7}-\\d{1,6}-(\\d|X)$";
    private static final String DATE = "^\\d{4}-\\w{3}-\\d{2}$";

    public static void main(String[] args) {
        System.out.println("ab3vika@gmail.com".matches(EMAIL));
        System.out.println("+79181239801".matches(PHONE));
        System.out.println("978-3-16-148410-0".matches(ISBN));
        System.out.println("2022-Oct-17".matches(DATE));
    }

}
