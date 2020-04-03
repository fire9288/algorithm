package algorithm;

public class HeapSort {

    public static void main(String[] args) {

        int arr[]= {4,6,8,5,9};


        heapsort(arr);
    }

    static void heapsort(int arr[]){

        int temp;
        System.out.println("Heap Sort :");

        for(int i=arr.length/2-1;i>=0;i--){

            adjustheap(arr,i,arr.length);

        }

        System.out.println("------调整为最大堆之后的结构------");

        for (int i : arr) {
            System.out.print(i+" ");
        }

        System.out.println();
        System.out.println("------经过完整的堆排序之后的结构-----");

        for(int j=arr.length-1;j>0;j--){

            temp=arr[0];
            arr[0]=arr[j];
            arr[j]=temp;
            adjustheap(arr,0,j);
        }
        System.out.println();
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
    /**
     *
     * @param arr   待排序数组
     * @param i     排序开始指向的节点
     * @param length   要排序数组的长度
     */
    static void adjustheap(int arr[],int i,int length){

        int temp = arr[i];

        for(int k =i*2+1;k<length;k=k*2+1){
            if(k+1<length&&arr[k]<arr[k+1]){
                k++;
            }

            if(arr[k]>temp){
                arr[i]=arr[k];
                i=k;
            }else break;
        }

        arr[i]=temp;

    }
}
