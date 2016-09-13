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
public class Algos {
    private int array[];
    
    private void quickSort(int a[]) {
        array = a;
        quickSort2(array, 0, array.length - 1);
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    private void quickSort2(int a[], int start, int end){
        if(start < end) {
            int pIndex = partiation(a, start, end);
            quickSort2(a, start, pIndex - 1);
            quickSort2(a, pIndex+1, end);
        }
    }
    int partiation(int a[], int start, int end) {
        int temp = a[end];
        int pIndex = start;
        for(int i = start; i < end; i++) {
            if(a[i] <= temp) {
                int t = a[i];
                a[i] = a[pIndex];
                a[pIndex] = t;
                pIndex++;
            }
        }
        int t = a[pIndex];
        a[pIndex] = a[end];
        a[end] = t;
        return pIndex;
    }
    
    void quickSort(int a[], int min_len, int max_len){
        if(a == null || a.length == 0) {
            return;
        }
        int base_min_len = min_len;
        int base_max_len = max_len;
        int mid_value = a[(max_len + min_len)/2];
        while(min_len <= max_len) {
            while(a[min_len] < mid_value) {
                min_len++;
            }
            while(a[max_len] > mid_value) {
                max_len--;
            }
            if(min_len <= max_len) {
                int temp = a[min_len];
                a[min_len] = a[max_len];
                a[max_len] = temp;
                min_len++;
                max_len--;
            }
            if(base_min_len < max_len) {
                quickSort(a, base_min_len, max_len);
            }
            if(base_max_len > min_len) {
                quickSort(a, min_len, base_max_len);
            }
        }
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Algos algos = new Algos();
        System.out.println("Hello World!!");
        int a[] = {1, 2, 3,7,4,9, 19, 12};
        algos.quickSort(a);
    }

}

class Node {

    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class LinkList {

    int data;
    LinkList next;

    public LinkList(int value) {
        data = value;
        next = null;
    }
    

}
