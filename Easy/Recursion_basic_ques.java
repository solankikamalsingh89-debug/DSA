public class Recursion_basic_ques {
    //Print GFG n times
    void printGfg(int N) {
        if(N>1) printGfg(N-1);
        System.out.print("GFG ");
    }

    //Print 1 to n
    public void printNos(int n) {
        if(n==0) return;
        printNos(n-1);
        System.out.print(String.valueOf(n)+" ");
    }

    //Print n to 1
    void printNos2(int N) {
        if(N==0) return;
        System.out.print(String.valueOf(N)+" ");
        printNos2(N-1);
    }

    //Sum of first n natural numbers
    public static int findSum(int n) {
        if(n<=1) return n;
        return n+findSum(n-1);
    }

    //Factorial of n
    int factorial(int n) {
        if(n==0) return 1;
        return n*factorial(n-1);
    }

    //Reverse an Array
    public void helper(int arr[],int i, int j){
        if(i>=j) return;
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
        helper(arr,i+1,j-1);
    }
    public void reverseArray(int arr[]) {
        helper(arr,0,arr.length-1);
    }

    //Valid-Pallindrome
    public boolean isPalindrome(String b) {
        //Recursion approach is leading TLE-- As creating substring take O(length of substring) Time Complexity
        //However instead of taking substring we can directly give starting and ending index that will have same TC as looping method given below
        //return h((b.replaceAll("[^a-zA-Z0-9]", "")).toLowerCase());

        String s=(b.replaceAll("[^a-zA-Z0-9]", "")).toLowerCase();
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(j)!=s.charAt(i)) return false;
            i++;j--;
        }
        return true;
    }

    //This function is for recursion method
    public boolean h(String s){
        int l=s.length();
        if(l<=1) return true;
        // char a=s.charAt(0);
        // char z=s.charAt(l-1);
        //if(!(a==z || a-'a'==z-'A' || a-'A'==z-'a')) return false; //or pehle hi lowercase krke -->lead to wrong answer e.g. 0P
        if(s.charAt(0)!=s.charAt(l-1)) return false;
        return isPalindrome(s.substring(1,l-1));
    }

    //Fibonacci Series nth no.
    public int fib(int n) { //O(2^n) O(n)
        if(n<=1) return n;
        return fib(n-1)+fib(n-2);
    }
}
