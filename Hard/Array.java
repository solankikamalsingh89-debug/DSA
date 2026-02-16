package Hard;
import java.util.*;
public class Array {
    //Majority Element II 9(Can be done by hashing but it is new so done)
    public List<Integer> majorityElement(int[] nums) {
        //Max 2 can be such elements--go with the expected elements
        int cnt1=0,cnt2=0,el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(el1==nums[i]) cnt1++;
            else if(el2==nums[i]) cnt2++;
            else{
                if(cnt1==0){
                    el1=nums[i];
                    cnt1=1;
                }
                else if(cnt2==0){
                    el2=nums[i];
                    cnt2=1;
                }
                else{
                    cnt1--;
                    cnt2--;
                }
            }
        }
        if(el1==el2) return new ArrayList<>(Arrays.asList(el1));
        cnt1=cnt2=0;
        int r=nums.length/3;
        for(int i=0;i<nums.length && (cnt1<=r || cnt2<=r);i++){
            if(nums[i]==el1) cnt1++;
            else if(nums[i]==el2) cnt2++;
        }
        List<Integer> a=new ArrayList<>();
        if(cnt1>r) a.add(el1);
        if(cnt2>r) a.add(el2);

        return a; 
    }

    //3 Sum
    public List<List<Integer>> threeSum(int[] nums) { //Get time complexity limit exceed
        Set<List<Integer>> ans=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            Set<Integer> a=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int t3=-(nums[i]+nums[j]);
                if(a.contains(t3)){
                    List<Integer> t=Arrays.asList(nums[i],nums[j],t3);
                    Collections.sort(t);
                    ans.add(t);
                }
                a.add(nums[j]);
            }
        }
        List<List<Integer>> s=new ArrayList<>();
        for (List<Integer> a1:ans){
            s.add(a1);
        }
        return s;
    }
}
