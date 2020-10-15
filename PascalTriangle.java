package com.sanket.Array;

import java.util.ArrayList;
import java.util.List;

/*
    Problem Link - https://leetcode.com/problems/pascals-triangle/
    Status - Accepted
 */
public class PascalTriangle {

    public static void main(String[] args) {
        int num = 3;
        generate(num);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        if (numRows < 1) { return lists; }
        List<Integer> first = new ArrayList<>();
        first.add(1);
        lists.add(first);
        int i = 1;
        while (i < numRows) {
            List<Integer> integers = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    integers.add(1);
                }
                else {
                    List<Integer> prev = lists.get(i - 1);
                    int total = prev.get(j - 1) + prev.get(j);
                    integers.add(total);
                }
            }
            lists.add(integers);
            i++;
        }
        return lists;
    }
}