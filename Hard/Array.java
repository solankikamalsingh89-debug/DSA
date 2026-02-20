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
    //or
    public List<List<Integer>> threeSum1(int[] nums) { //Learned how complexity was improved to O(n^2) by double pointers moving according to condition and one is iterating for third element
        List<List<Integer>> s=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                    s.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }
                else if(sum>0){
                    r--;
                }
                else{
                    l++;

                }
            }
        }
        return s;
    }

    //4 sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> lst=new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int left=j+1;
                int right=n-1;
                while(left<right){
                    long sum=(long)nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum<target){
                        left++;
                    }else if(sum>target){
                        right--;
                    }else{
                        lst.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1]){
                            left++;
                        }
                        while(right>left && nums[right]==nums[right+1]){
                            right--;
                        }
                    }
                }
            }
        }
        return lst;
    }

    //Max length of the subarray with sum 0
    public int maxLength(int arr[]) { //Prefix array then traverse it with storing every new sum with idx to search if it appears again means sum between them 0
        HashMap<Integer,Integer> a=new HashMap<>();
        int ans=0;
        a.put(0,0);
        if(arr[0]==0){
            ans=1;
        }
        else a.put(arr[0],1);
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
            if(a.containsKey(arr[i])){
                ans=Math.max(ans,i+1-a.get(arr[i]));
            }
            else a.put(arr[i],i+1);
        }
        return ans;
    }

    //Count subarrays with given xor K
    public long subarrayXor(int arr[], int k) {
        HashMap<Integer,Integer> a=new HashMap<>();
        a.put(0,1);
        int pf=0;
        int ans=0;
        for(int i=0;i<arr.length;i++){
            pf^=arr[i];
            ans+=a.getOrDefault(pf^k,0);
            a.put(pf,a.getOrDefault(pf,0)+1);
        }
        return ans;
    }

    //Merge Overlapping Subintervals
    public int[][] merge(int[][] intervals) {
        List <List<Integer>> a=new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a1 -> a1[0]));
        int l=intervals[0][0];
        int h=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=h){
                h=Math.max(intervals[i][1],h);
            }
            else{
                a.add(Arrays.asList(l,h));
                l=intervals[i][0];
                h=intervals[i][1];
            }
        }
        a.add(Arrays.asList(l,h));
        int [][]b=new int[a.size()][2];
        for(int i=0;i<a.size();i++){
            b[i][0]=a.get(i).get(0);
            b[i][1]=a.get(i).get(1);
        }
        return b;
    }

    //Merge two sorted arrays without extra space
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]) nums1[k--]=nums1[i--];
            else nums1[k--]=nums2[j--];
        }
        //while(i>=0) nums1[k--]=nums1[i--]; iske toh isme honge hi so no need
        while(j>=0) nums1[k--]=nums2[j--];
    }

    //Find Missing and Repeated Values
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n=grid.length;
        n*=n;
        long s1=(n*(n+1))/2;
        long s2=(n*(n+1)*(2*n+1))/6;
        for(int i[]:grid){
            for(int j:i){
                s1-=j;
                s2-=j*j;
            }
        }
        s2/=s1;
        return new int[] {(int)((s2-s1)/2),(int)((s2+s1)/2)};
    }
    //OR
    
}
