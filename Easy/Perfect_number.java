public class Perfect_number { //If sum of divisors(except itself) equals number itself
    public boolean checkPerfectNumber(int num) {
        if (num==1) return false;
        int sum=1;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                int m=num/i;
                sum+=i;
                if(m!=i) sum+=m;
            }
        }
        return sum==num;
    }
}
