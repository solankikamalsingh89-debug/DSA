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

    
}
