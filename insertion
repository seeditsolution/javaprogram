package Sorting;

import java.util.Scanner;

public class Insertion_Sort {
    // User for Insertion Sort
    public static void insertion_Sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(is_Greater(arr, j, j + 1)){
                    swap(arr, j, j + 1);
                }else{
                    break;
                }
            }
        }
    }

    // Used to swap ith and jth elements of array
    public static void swap(int[] arr, int i, int j){
        System.out.println("Swapping "+arr[i]+" and "+arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Return true if ith element is smaller than jth element
    public static boolean is_Greater(int[] arr, int j, int i){
        System.out.println("Comparing "+arr[i]+" and "+arr[j]);
        if(arr[i] < arr[j]){
            return true;
        } else{
            return false;
        }
    }

    // Displaying the  resultant array
    public static void display(int[] arr){
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        insertion_Sort(arr);
        display(arr);

        sc.close();
    }

}
