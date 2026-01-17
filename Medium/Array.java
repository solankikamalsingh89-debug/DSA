package Medium;
public class Array {
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
}
