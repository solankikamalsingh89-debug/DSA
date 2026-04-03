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
    //OR(XOR Method- Bitwise use to check numbers noth coming in continous range and also xor property of different bits giving 1 to get where digits bits changes)
    public int[] findMissingAndRepeatedValues1(int[][] grid) { //XOR method
        //Compute the number of digits
        int n=grid.length;
        //Compute Xor of missing and repeated number to get position the first bit(from right) as 1 meaning one have 1 and other have 0 at that bit position
        int xr=0;
        int x=1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                xr^=(x^grid[i][j]);
                x++;
            }
        }
        int t=xr&(~(xr-1)); //In integer for ex- 100 representing first bit different at 3rd pos
        //Now find seperately two numbers from bit position(xor of all having bit as 0 and 1 seperately)
        int zero=0,one=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((t & grid[i][j])==0) zero^=grid[i][j];
                else one^=grid[i][j];
            }
        }
        for(int i=1;i<=n*n;i++){
            if((t&i)==0) zero^=i;
            else one^=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==zero){
                    return new int[] {zero,one};
                }
            }
        }
        return new int[] {one,zero};
    }

    //Count Inversion(By merge sort: while setting element from other earlier than prev element add it)
    static int divide(int arr[], int l, int r){
        if(l>=r) return 0;
        int m=l+(r-l)/2;
        return divide(arr,l,m)+divide(arr,m+1,r)+merge(arr,l,m,r);
    }
    static int merge(int arr[], int l, int m, int r){
        int ans=0;
        int y=m-l+1;
        int a1[]=new int[m-l+1];
        int a2[]=new int[r-m];
        for(int i=0;i<m-l+1;i++){
            a1[i]=arr[l+i];
        }
        for(int i=r-m;i>0;i--){
            a2[r-m-i]=arr[r-i+1];
        }
        int i=0,j=0;
        while(i<y && j<r-m){
            if(a1[i]>a2[j]){
                arr[l++]=a2[j++];
                ans+=y-i;
            }
            else{
                arr[l++]=a1[i++];
            }
        }
        while(i<y){
            arr[l++]=a1[i++];
        }
        while(j<r-m){
            arr[l++]=a2[j++];
        }
        return ans;
    }
    static int inversionCount(int arr[]) {
        return divide(arr,0,arr.length-1);
    }

    //Reverse Pairs(By merge sort with checking condition for smaller crossing bigger ones)
    private int merge1(int nums[], int s, int m, int e){
        int ans=0;
        int a[]=new int[m-s+1];
        int b[]=new int[e-m];
        for(int i=s;i<=m;i++){
            a[i-s]=nums[i];
        }
        for(int i=m+1;i<=e;i++){
            b[i-m-1]=nums[i];
        }
        int j=m+1;
        for(int i=s;i<=m;i++){
            while(j<=e && nums[i]>(long)2*nums[j]){
                j++;
            }
            ans+=j-m-1;
        }
        j=0;
        int i=0,y=m-s+1;
        while(i<y && j<e-m){
            if(a[i]>b[j]){
                nums[s++]=b[j++];
            }
            else{
                nums[s++]=a[i++];
            }
        }
        while(i<y){
            nums[s++]=a[i++];
        }
        while(j<e-m){
            nums[s++]=b[j++];
        }
        return ans;
    }
    private int divide1(int nums[], int s, int e){
        if(s==e) return 0;
        return divide1(nums,s,(s+e)/2)+divide1(nums,(s+e+2)/2,e)+merge1(nums, s, (s+e)/2, e);
    }
    public int reversePairs(int[] nums) {
        return divide1(nums,0,nums.length-1);
    }

    //Maximum Product Subarray
    public int maxProduct(int[] nums) {
        boolean single_neg=true;
        int max=nums[0], neg=0, pehle=1, baad=1, cur=nums[0];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]>0){
                single_neg=false;
                if(i>0) cur*=nums[i];
                if(neg==0){
                    pehle*=nums[i];
                }
                else if(neg%2==1){
                    baad*=nums[i];
                }
            }
            else if(nums[i]<0){
                if(neg==0){
                    pehle*=nums[i];
                }
                if(neg%2==0){
                    baad=nums[i];
                }
                neg++;
                if(i>0) cur*=nums[i];
            }
            else{
                if(neg%2==0){
                    max=Math.max(cur,max);
                    neg=0; baad=1;
                    single_neg=true;
                    while(i+1<nums.length && nums[i+1]==0) i++;
                    if(i+1<nums.length){
                        pehle=cur=nums[i+1];
                        if(nums[i+1]<0){
                            neg++;
                            baad=nums[i+1];
                            max=Math.max(max,nums[i+1]);
                        }
                        else if(nums[i+1]>0) single_neg=false;
                        i++;
                    }
                }
                else{
                    if(neg>1) single_neg=false;
                    if(!single_neg) cur/=Math.max(pehle,baad);
                    max=Math.max(max,cur);
                    neg=0; baad=1;
                    single_neg=true;
                    while(i+1<nums.length && nums[i+1]==0) i++;
                    if(i+1<nums.length){
                        pehle=cur=nums[i+1];
                        if(nums[i+1]<0){
                            neg++;
                            baad=nums[i+1];
                            max=Math.max(max,nums[i+1]);
                        }
                        else if(nums[i+1]>0) single_neg=false;
                        i++;
                    }
                }
            }
        }
        if(neg%2==0){
            max=Math.max(cur,max);
        }
        else{
            if(neg>1) single_neg=false;
            if(!single_neg) cur/=Math.max(pehle,baad);
            max=Math.max(max,cur);
        }
        return max;
    }
}
