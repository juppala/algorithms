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
public class SumOfContinuousArray {
    static void solutionOne() {
         int array[] = {4, 5, 10, 2, 6};
        int sequenceSum = 8, len = array.length;
        boolean isValidSumExists = false;
        int k = 0;
        for(int i = 0; i < len && !isValidSumExists; i++, k++) {
            int sum = 0, j = -1;
            while(sum < sequenceSum && i + j < len) {
                k++;
                if(i + j < 0) {
                    j++;
                    continue;
                }
                    sum += array[i + (j++)];
                if(sum == sequenceSum) {
                    isValidSumExists = true;
                }
            }
        }
        System.out.println(isValidSumExists);
        System.out.println(k);
    }
    
    static void solutionTwo() {
         int array[] = {4, 5, 10, 2, 6};
        int sequenceSum = 10, len = array.length;
        boolean isValidSumExists = false;
        int start = 0, current = 0, sum = 0;
        int bigOn = 0;
        while(sum < sequenceSum && current < len) {
            bigOn++;
              sum +=array[current++];
              while(sum > sequenceSum) {
                  bigOn++;
                  sum -= array[start++];
              }
              if(sum == sequenceSum) {
                  isValidSumExists = true;
                  break;
              }
        }
        System.out.println(isValidSumExists);
        System.out.println(bigOn);
    }
    
    public static void main(String[] args) {
       solutionOne();
       solutionTwo();
    }
}
