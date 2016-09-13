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
public class MergeSort {
    public static void main(String args[]) {
        int arry1[] = {1, 5, 9, 10, 15, 44};
        int arry2[] = {2, 3, 8, 13, 22, 33, 30, 4};
        int len1 = arry1.length, len2 = arry2.length;
        //mergeSort(arry1, arry2);
        
        for(int i = len2 -1; i >= 0; i--) {
            int last = arry1[len1 - 1], j;
            for(j = len1 - 1; j >= 0 && arry1[j] > arry2[i]; j--) {
                arry1[j] = arry1[j-1];
            }
            
            if(j != len1 - 1) {
                arry1[j+1] = arry2[i];
                arry2[i] = last;
            }
        }
        System.out.print("arry1 :");
        for(int i = 0; i < len1; i++) {
            System.out.print(arry1[i] + ", ");
        }
        System.out.print("\narry2 :");
        for(int i = 0; i < len2; i++) {
            System.out.print(arry2[i] + ", ");
        }
        
    }
}
