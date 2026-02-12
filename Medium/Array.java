package Medium;
import java.util.*;
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

    //Array Leader
    public ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> a=new ArrayList<>();
        int h=0;
        for(int i=arr.length-1;i>=0;i--){
            if(h<=arr[i]){
                a.add(0,arr[i]);
                h=arr[i];
            }
        }
        return a;
    }

    //Longest Consecutive Sequence
    public int longestConsecutive(int[] nums) { //O(n)(as we are at least checking it to go it into or not so going like O(n^2)) h ye but if doing it with O(n log n)(sorting) takes less time as well as memory
        if(nums.length==0) return 0;
        Set <Integer> k=new HashSet<>();
        for(int i=nums.length-1;i>=0;i--){
            k.add(nums[i]);
        }
        int mx=1;
        for(int i:k){
            int cnt=1;
            if(!k.contains(i-1)){
                while(k.contains(i+1)){
                    i++;cnt++;
                }
                mx=Math.max(mx,cnt);
            }
        }
        return mx;
    }

    //Set Matrix Zero
    public void setZeroes(int[][] matrix) {
        boolean fr=false;
        boolean fc=false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    if(i==0) fr=true;
                    if(j==0) fc=true;
                    else if (i!=0){
                        matrix[0][j]=0;
                        matrix[i][0]=0;
                    }
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++) matrix[i][j]=0;
            }
        }
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                for(int j=1;j<matrix.length;j++) matrix[j][i]=0;
            }
        }
        if(fr){
            for (int i=0;i<matrix[0].length;i++) matrix[0][i]=0;
        }
        if(fc){
            for (int i=0;i<matrix.length;i++) matrix[i][0]=0;
        }
    }

    //Rotate image by 90 degree
    public void rotate1(int[][] matrix) {
        int n=matrix.length;
        int p=0;
        while(n-(2*p)>1){
            int [] a=new int[n-(2*p)];
            for(int i=0;i<n-(2*p);i++){
                a[i]=matrix[p][p+i];
            }
            for(int i=0;i<n-(2*p)-1;i++){
                matrix[p][p+i]=matrix[n-p-i-1][p];
            }
            for(int i=0;i<n-(2*p)-1;i++){
                matrix[n-p-i-1][p]=matrix[n-p-1][n-p-1-i];
            }
            for(int i=0;i<n-(2*p)-1;i++){
                matrix[n-p-1][n-p-1-i]=matrix[p+i][n-p-1];
            }
            for(int i=0;i<n-(2*p);i++){
                matrix[p+i][n-p-1]=a[i];
            }
            p++;
        }
    }

    //or
    public void rotate2(int[][] matrix) {
        int n=matrix.length;
        //Transpose matrix
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        //Reverse each row elements
        for(int i=0;i<n;i++){
            for(int j=1;j<=n/2;j++){
                int t=matrix[i][j-1];
                matrix[i][j-1]=matrix[i][n-j];
                matrix[i][n-j]=t;
            }
        }
    }

    //Spiral Matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> a=new ArrayList<>();
        int i=0,j=0;
        int l=1, d=1;
        boolean hor=true;
        while(true){
            if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]==101){
                if(hor){
                    l*=-1;
                    j+=l;
                    i+=d;
                }
                else{
                    d*=-1;
                    j+=l;
                    i+=d;
                }
                if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length || matrix[i][j]==101) break;
                hor=!hor;
            } 
            a.add(matrix[i][j]);   
            matrix[i][j]=101;
            if(hor) j+=l;
            else i+=d;
        }
        return a;
    }

    //Subarray Sum Equals K
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer>a=new HashMap<>();
        a.put(0,1);
        int sum=0;
        int res=0;
        for(int i:nums){
            sum+=i;
            if(a.containsKey(sum-k)){
                res+=a.get(sum-k);
            }
            a.put(sum,a.getOrDefault(sum,0)+1);
        }
        return res;
    }
}