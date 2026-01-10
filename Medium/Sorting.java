package Medium;
public class Sorting {
    //Merge Sort
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
}
