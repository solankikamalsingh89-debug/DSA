package Medium;
public class Sorting {
    //Merge Sort O(n logn)
    void mergeSort(int arr[], int l, int r) {
        if(l<r){
            int m=l+((r-l)/2);
            mergeSort(arr,l,m); //(l+r)/2 Not used to prevent integer limit overflow
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    void merge(int arr[], int l, int m, int r){
        int a[]=new int[r-l+1];
        int li=l,mi=m+1,i=0;
        while(li<=m && mi<=r){
            if(arr[li]<arr[mi]) a[i++]=arr[li++];
            else a[i++]=arr[mi++];
        }
        while(li<=m) a[i++]=arr[li++];
        while(mi<=r) a[i++]=arr[mi++];
        for(int j=r;j>=l;j--){
            arr[j]=a[--i];
        }
    }

    //Quick Sort O(n logn)
    public void quickSort(int[] arr, int low, int high) {
        if(low<high){
            int pidx=partition(arr,low,high);
            quickSort(arr,low,pidx-1);
            quickSort(arr,pidx+1,high);
        }
    }
    private int partition(int[] arr, int low, int high) {
        int j=low;
        int pivot=arr[high];
        for (int i=low;i<high;i++){
            if(arr[i]<pivot){
                swap(i,j,arr);
                j++;
            }
        }
        swap(high,j,arr);
        return j;
    }
    public void swap(int i,int m,int[] arr){
        int mi=arr[i];
        arr[i]=arr[m];
        arr[m]=mi;
    }
}
