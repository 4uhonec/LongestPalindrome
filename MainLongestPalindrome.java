package longest_palindrom;

public class MainLongestPalindrome {
    public static void main(String[] args) {
        String str = "abgftttrrhjkkkkjhruuuur";
        LongestPalindrome lp = new LongestPalindrome(str);
        System.out.println(lp.calculate());
    }
}
