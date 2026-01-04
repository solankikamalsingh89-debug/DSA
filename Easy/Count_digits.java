class Count_digits {
    public int countDigits(int n) {
        // code here
        return (int)(Math.log(n)/Math.log(10))+1;
    }
}
