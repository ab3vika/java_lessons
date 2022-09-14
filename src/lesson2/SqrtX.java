class SqrtX {    
    public int mySqrt(int x) {
        int i = 0;
        while (i * i <= x) {
            if (i * i == x) return i;
            i++;
        }
        return i - 1;
    }
}
