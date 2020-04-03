package algorithm;

import java.text.DecimalFormat;
import java.util.Random;

public class BubbleSort {


    public static void main(String[] args) {

        int arr[]={3,2,7,5,9,2};

        BubbleSort(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    static void BubbleSort(int arr[]){


        for(int i=0;i<arr.length;i++){
            boolean flag = false;
            for(int j=0;j<arr.length-i-1;j++){

                int temp;
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;

                }


            }
            if(!flag)break;
        }


    }


}
