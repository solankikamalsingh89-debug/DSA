public class Binary_Search {
    //Search X in sorted array
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // avoids overflow
            if (nums[mid] == target) {
                return mid;
            } 
            else if (nums[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //Lower Bound
    public int lowerBound(int[] arr, int target) {
        int h=arr.length-1,l=0;
        while(h>l){
            if(arr[l+(h-l)/2]>=target) h=l-1+(h-l)/2;
            else if(arr[l+(h-l)/2]<target) l=l+1+(h-l)/2;
        }
        if(arr[l]>=target) return l; //As 'h' can go lesser than 'l', but l always increase
        return h+1;
    }
}
