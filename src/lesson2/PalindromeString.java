class PalindromeString {
    public boolean isPalindrome(int x) {
        String y = String.valueOf(x);
        for (int i = 0; i < y.length() / 2; i++)
        {
            if (y.charAt(i) != y.charAt(y.length() - 1 - i))
            {
                return false;
            }
        }
        return true;
    }
}
