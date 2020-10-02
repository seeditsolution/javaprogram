package com.sanket.Array;
/*
    Problem Link - https://leetcode.com/problems/sort-colors/
    Status - Accepted
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int size = nums.length;
        int low = 0, high = size - 1;
        int i = low;
        while (i <= high) {
            if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
            }
            else if (nums[i] == 0) {
                swap(nums, i, low);
                low++;
                i++;
            }
            else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}