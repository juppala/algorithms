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
Determine if any 3 intergers in an array sum to 0
ex: array[] = {4, 2, -1, 1, -5, 6, -4}, [-1-5+6] = 0
*/
public class SumOf3Intergers0 {
    public static void main(String[] args) {
        int array[] = {4, 12, -111, 1, -51, -4, 2};
        int len = array.length;
        int bigO = 0;
        for(int i = 0, j = len - 1; i < len - 1; i++) {
            for(int k = len - 1; k >= i; k--) {
                int sum = array[i] + array[j] + array[k];
                bigO++;
                if(sum == 0) {
                    System.out.println("Sucess: sum of three elements are 0");
                    System.out.println(i+" :a[i]: "+array[i]);
                    System.out.println(j+" :a[j]: "+array[j]);
                    System.out.println(k+" :a[k]: "+array[k]);
                    break;
                }
            }
        }
        System.out.println(bigO);
    }
}
