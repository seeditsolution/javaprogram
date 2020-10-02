package com.sanket.Array;

import java.util.Scanner;

/*
    Problem Link - https://practice.geeksforgeeks.org/problems/find-missing-and-repeating/0
    Status - Accepted
 */
public class FindMissingAndRepeating {

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- != 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int duplicate = -1;
            for (int i = 0; i < n; i++) {
                int current = Math.abs(arr[i]) - 1;
                if (arr[current] < 0) {
                    duplicate = current + 1;
                }
                else {
                    arr[current] = - arr[current];
                }
            }

            int missing = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] > 0) {
                    missing = i + 1;
                    break;
                }
            }
            System.out.println(duplicate + " " + missing);
        }
    }
}