import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    //Largest Element in Array
    public static int largest(int[] arr) {
        int m=arr[0];
        for(int i=0;i<arr.length;i++) if(m<arr[i]) m=arr[i];
        return m;
    }

    //Find Second Smallest and Second Largest Element in an array(Done only for smallest and 2nd smallest)
    public ArrayList<Integer> minAnd2ndMin(int[] arr) {
        int min=arr[0];
        int m=100000;
        for(int i=1;i<arr.length;i++){
            if(m>arr[i]){
                if(min>arr[i]){
                    m=min;
                    min=arr[i];
                }
                else if(min!=arr[i]) m=arr[i];
            }
        }
        if(m==100000) return new ArrayList<>(Arrays.asList(-1));
        else return new ArrayList<>(Arrays.asList(min,m));
    }

    //Check if Array Is Sorted and Rotated
    public boolean check(int[] nums) {
        boolean ek_galti=false;
        for(int i=1;i<nums.length;i++){
            if(!(nums[i]>=nums[i-1])){
                if(!ek_galti) ek_galti=true;
                else return false;
            }
        }
        if(ek_galti && nums[nums.length-1]>nums[0]) return false;
        return true;
    }

    //Remove Duplicates from Sorted Array
    public int removeDuplicates(int[] nums) {
        int k =1;
        int pr=nums[0];
        for(int i=1;i<nums.length;i++){
            if(pr!=nums[i]) nums[k++]=pr=nums[i];
        }
        return k;
    }

    //Rotate Array
    public void rotate(int[] nums, int k) {//Better SC & TC(if we reverse whole arr then reverse fist k and reverse remaining)
        int n=nums.length;
        k%=n;
        if(n<2*k){ //toh left m n-k times( To reduce memory consumption )
            k=n-k;
            int pr[]=new int[k];
            for(int i=0;i<k;i++) pr[i]=nums[i];
            for(int i=0;i<n-k;i++) nums[i]=nums[i+k];
            for(int i=n-k,j=0;i<n;i++,j++) nums[i]=pr[j];
        }
        else{
            int pr[]=new int[k];
            for(int i=n-k,j=0;i<n;i++) pr[j++]=nums[i];
            for(int i=n-1;i>=k;i--) nums[i]=nums[i-k];
            for(int i=0,j=0;i<k;i++,j++) nums[i]=pr[j];
        }
    }

    //Move Zeros to end
    public void moveZeroes(int[] nums) {
        int j=-1;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1) return;
        for(int i=j+1;i<n;i++){
            if(nums[i]!=0){
                nums[j]=nums[i];
                nums[i]=0;
                j++;
            }
        }
    }

    //Array Search
    public int search(int arr[], int x) {
        for(int i=0;i<arr.length;i++) if(arr[i]==x) return i;
        return -1;
    }

    //Union of 2 Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]) nums1[k--]=nums1[i--];
            else nums1[k--]=nums2[j--];
        }
        //while(i>=0) nums1[k--]=nums1[i--]; iske toh isme honge hi so no need
        while(j>=0) nums1[k--]=nums2[j--];
    }

    //Missing Number
    public int missingNumber(int[] nums) {
        // int s=(nums.length*(nums.length+1))/2;
        // for(int i=0;i<nums.length;i++) s-=nums[i];
        // return s;

        /* OR
        1 2 3 4 5 (We know XOR(^): a^a=0, a^0=a, and XOR is commutative)
        1 2   4 5
        */
        int xor1=0;
        for(int i=0;i<nums.length;i++){
            xor1^=nums[i]^(i+1);
        }
        return xor1;
    }

    //Max Consecutive Ones
    public int findMaxConsecutiveOnes(int[] nums) {
        int c1=0, m=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) c1++;
            else{
                if(c1>m) m=c1;
                c1=0;
            }
        }
        if(c1>m) m=c1; //not taking Math.max()-- as quite difference in TC
        return m;
    }

    //Single Number
    public int singleNumber(int[] nums) {
        int x=0;
        for(int i=0;i<nums.length;i++) x^=nums[i];
        return x;
    }

    
}
