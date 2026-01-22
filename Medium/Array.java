package Medium;
public class Array {
    //Sort array of 0,1,2
    public void sortColors(int[] nums) { // Dutch National Flag algorithm
        int low=0, mid=0, high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                nums[mid++]=nums[low];
                nums[low++]=0;
            }
            else if(nums[mid]==2){
                nums[mid]=nums[high]; //no increement of mid(as number swaped may be 0)
                nums[high--]=2;
            }
            else mid++;
        }
    }

    //Majority Element(>n/2)
    public int majorityElement(int[] nums) {//Optimal approach is better as we will refresh only if c==0 ho jyega, as mentioned >n/2 element will be there
        int e=0,c=0;
        for(int i=0;i<nums.length;i++){
            if(c==0){
                e=nums[i];
                c++;
            }
            else if(nums[i]==e) c++;
            else c--;
        }
        return e;
    }

    //Max subarray sum , Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int p_m=Integer.MIN_VALUE; //as subarray cann't be -ve so for single -ve element 
        int m=0;
        for(int i=0;i<nums.length;i++){
            if(m<0) m=0;
            m+=nums[i];
            p_m=Math.max(p_m,m);
        }
        return p_m;
    }

    //Stock Buy and Sell
    public int maxProfit(int[] prices) {
        int bp=prices[0];
        int p=0;
        for(int i=1;i<prices.length;i++){
            if(bp>prices[i]) bp=prices[i];
            else if(prices[i]-bp>p) p=prices[i]-bp;
        }
        return p;
    }

    //Rearrange array element by sign
    public int[] rearrangeBySign(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                ans[negIndex] = A[i];
                negIndex += 2;
            } else {
                ans[posIndex] = A[i];
                posIndex += 2;
            }
        }

        return ans;
    }


    //Next Permutation
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        if(i==-1){
            return;
        }
        int pr=nums[i+1];
        for(;i>=0;i--){
            if(pr>nums[i]){
                break;
            }
            pr=nums[i];
        }
        if(i==-1){
            for(int j=0;j<(nums.length)/2;j++){
                int t=nums[j];
                nums[j]=nums[nums.length-j-1];
                nums[nums.length-j-1]=t;
            }
        }
        else{
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]>nums[i]){
                    int t=nums[j];
                    nums[j]=nums[i];
                    nums[i]=t;
                    break;
                }
            }
            for(int j=1;j<=(nums.length-i-1)/2;j++){
                int t=nums[i+j];
                nums[i+j]=nums[nums.length-j];
                nums[nums.length-j]=t;
            }
        }
    }
}
