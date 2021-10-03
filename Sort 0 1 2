public class Solution {

    public static void sort012(int[] arr){
        int nZ=0,nT=arr.length-1;
        int tempforTwo=0;
        int tempforZero=0;
        int i=0;
    	while(i<=nT){
              if(arr[i]==0){
                 tempforZero=arr[nZ];
                 arr[nZ]=arr[i];
                 arr[i]=tempforZero;
                 i++;
                 nZ++;
              }
            else  if(arr[i]==2){
                tempforTwo=arr[nT];
                arr[nT]=arr[i];
                arr[i]=tempforTwo;
                nT--;
             }
            else 
                i++;
        }
    }
}
