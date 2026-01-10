import java.util.HashMap;
public class Hashing {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> k=new HashMap<>();
        int ans=0;
        int max_fq=0;
        for(int i=0;i<nums.length;i++){
            int fq=0;
            if(k.containsKey(nums[i])){
                fq=k.get(nums[i]);
                k.put(nums[i],fq+1);
            }
            else k.put(nums[i],1);
            if(fq+1>max_fq) max_fq=ans=fq+1;
            else if(fq+1==max_fq) ans+=max_fq;
        }
        return ans;
    }
}
