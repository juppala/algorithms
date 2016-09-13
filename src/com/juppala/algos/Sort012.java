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
public class Sort012 {
    // Sort the input array, the array is assumed to
    // have values in {0, 1, 2}
    static void sort012(int a[], int arr_size)
    {
        int len = a.length;
        int zeroIndex = 0, oneIndex = 0, twoIndex = len - 1, temp = 0;
        while(oneIndex <= twoIndex) {
            switch(a[oneIndex]) {
                case 0:
                    temp = a[oneIndex];
                    a[oneIndex] = a[zeroIndex];
                    a[zeroIndex] = temp;
                    zeroIndex++;
                    oneIndex++;
                    break;
                case 1:
                    oneIndex++;
                    break;
                case 2:
                    temp = a[twoIndex];
                    a[twoIndex] = a[oneIndex];
                    a[oneIndex] = temp;
                    twoIndex--;
                    break;
            }
            printArray(a, len);
        }
    }
	/* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }
 
    /*Driver function to check for above functions*/
    public static void main (String[] args)
    {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        printArray(arr, arr_size);
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        printArray(arr, arr_size);
    }
}