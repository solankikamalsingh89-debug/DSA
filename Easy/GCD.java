class GCD {
    public int findGCD(int[] nums) {
        int min=1000;
        int max=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) max=nums[i];
            if(nums[i]<min) min=nums[i];
        }
        while(min>0){
            int t=max;
            max=min;
            min=t%min;
            if(min==0) return max;
        }
        return 1;

        //Doing GCD by Function
        //return gcd(min,max);
    }
    public int gcd(int a , int b){
        while(a>0 && b>0){
            if(a>b) a%=b;
            else b%=a;
        }
        return Math.max(a,b);
    }
}
