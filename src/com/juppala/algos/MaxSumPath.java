/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juppala.algos;

import java.util.ArrayList;

/**
 *
 * @author juppala
 */
/*
Examples:

Input:  ar1[] = {2, 3, 7, 10, 12}, ar2[] = {1, 5, 7, 8}
Output: 35
35 is sum of 1 + 5 + 7 + 10 + 12.
We start from first element of arr2 which is 1, then we
move to 5, then 7.  From 7, we switch to ar1 (7 is common)
and traverse 10 and 12.

Input:  ar1[] = {10, 12}, ar2 = {5, 7, 9}
Output: 22
22 is sum of 10 and 12.
Since there is no common element, we need to take all 
elements from the array with more sum.

Input:  ar1[] = {2, 3, 7, 10, 12, 15, 30, 34}
        ar2[] = {1, 5, 7, 8, 10, 15, 16, 19}
Output: 122
122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34
*/
public class MaxSumPath {
    public static void main(String args[]) {
        int ar1[] = {2, 3, 7, 10, 12, 15, 30, 34};
        int ar2[] = {1, 5, 7, 8, 10, 15, 16, 19};
        ArrayList<Integer> list = new ArrayList<Integer>();
        int m = ar1.length, n = ar2.length;
        int i = 0, j = 0;
        int sum1 = 0, sum2 = 0, result = 0;
        while(i < m && j < n) {
            if(ar1[i] < ar2[j]) {
                list.add(ar1[i]);
                sum1 += ar1[i++];
            } else if(ar1[i] > ar2[j]) {
                list.add(ar2[j]);
                sum2 += ar2[j++];
            } else {
                result += Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                while (i < m &&  j < n && ar1[i] == ar2[j])
                {
                    result = result + ar1[i++];
                    j++;
                }
            }
        }
        
        while (i < m)
        sum1  +=  ar1[i++];
        while (j < n)
        sum2 +=  ar2[j++];
        result +=  Math.max(sum1, sum2);
        System.out.println(result);
    }
}
/*
1
*/