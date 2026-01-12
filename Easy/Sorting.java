public class Sorting {
    //Selection Sort
    void selectionSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            int m_i=arr[i];
            int m=i;
            for(int j=i+1;j<arr.length;j++){
                if(m_i>arr[j]){
                    m_i=arr[j];
                    m=j;
                }
            }
            if(i!=m){
                int t=arr[m];
                arr[m]=arr[i];
                arr[i]=t;
            }
        }
    }

    //Bubble Sort(+Optimiseb by if no swap-->sorted,break  --> can also do with selection sort)
    public void bubbleSort(int[] arr) {
        int n=arr.length;
        for(int i=n-1;i>0;i--){   //Similarly can do it by recursion
            boolean swap=false;
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    int t=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=t;
                    swap=true;
                }
            }
            if(!swap) break;
        }
    }

    //Insertion Sort
    public void insertionSort(int arr[]) {  //Similarly can do it by recursion
        int n=arr.length;
        for(int i=1;i<n;i++){
            int j=i-1;
            int k=arr[i];
            while(j>=0 && k<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=k;
        }
    }
}
