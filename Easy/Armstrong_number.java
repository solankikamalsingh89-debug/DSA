public class Armstrong_number { // If number equals sum of power to its digits of length of number
    public static boolean armstrongNumber(int n) {
        int pow=String.valueOf(n).length();
        int sum=0;
        int t=n;
        for(int i=0;i<pow;i++){
            sum+=Math.pow(n%10,pow);
            n/=10;
        }
        return sum==t;
    }
}