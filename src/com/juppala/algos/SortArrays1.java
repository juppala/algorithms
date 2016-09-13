/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juppala.algos;

/**
 *
 * @author juppala
 */
/*
 We have an array of objects A and an array of indexes B. Reorder objects in array A with given indexes in array B. Do not change array A's length. 

 example:

 var A = [C, D, E, F, G];
 var B = [3, 0, 4, 1, 2];
 //
 sort(A, B);
 // A is now [D, F, G, C, E];
 */
public class SortArrays1 {

    public static void main(String[] args) {
        char[] a = {'C', 'D', 'E', 'F', 'G'};
        int[] b = {3, 0, 4, 1, 2};
        sort(a, b);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void sort(char[] A, int[] B) {
        for (int i = 0; i < B.length; ++i) {
            int tmp = i;
            while (B[tmp] != tmp) {
                swap(A, B[tmp], tmp);
                swapIndex(B, B[tmp], tmp);
                tmp = B[tmp];
            }
        }
    }

    private static void swap(char[] A, int i, int j) {
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private static void swapIndex(int[] B, int i, int j) {
        int tmp = B[i];
        B[i] = B[j];
        B[j] = tmp;
    }
}
