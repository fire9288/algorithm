package algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    static  int c = 0;
    public static void main(String[] args) {




    }

















    static int tallest(int[] arr){
        int sum=0;
        int max;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        max = sum/2;//最大不会超过一半
        for(int j=0;j<arr.length;j++){
            if(arr[j]==max)return max;

        }
        max=arr[0];
        for(int k=0;k<arr.length;k++){
            if(arr[k]>max)max=arr[k];
        }
        while(max>0){

        }





        return 0;
     }
     static int get(int customers[],int grumpy[],int x){

            if(customers.length==0)return 0;
            int temp[]=new int [8];
            int change =0;
            int zeroresult=0;
            int result =0;
            for(int i=0;i<customers.length-2;i++){
                if(grumpy[i]==0)zeroresult+=customers[i];
                for(int j=i;j<i+3;j++){
                    if(grumpy[j]==1){
                        change+=customers[j];
                    }
                }
                temp[i]=change;
            }
            if(grumpy[customers.length-1]==0)zeroresult+=customers[customers.length-1];
         if(grumpy[customers.length-2]==0)zeroresult+=customers[customers.length-2];

            int max = temp[0];
            int index=0;
            for(int k=0;k<temp.length;k++){
                if(temp[k]>max){
                    max=temp[k];
                    index=k;

                }
            }

            for(int m=index;m<index+3;m++){
                if(grumpy[m]==1){
                    result+=customers[m];
                }

            }


            return (result+zeroresult);



     }
}

