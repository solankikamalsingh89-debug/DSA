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
}
