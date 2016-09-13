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
public class FibonacciSeries {
    public static void main(String args[]) {
        int sum = 1;
        int previous = 0;
        for(int i = 0; i < 10; i++) {
                System.out.println(sum);
                int temp = sum;
                sum += previous;
                previous = temp;
        }
        
        System.out.println(fib(40));
    }

    static int[] memo;
    private static int fib(int n) {
        if(memo == null) {
            memo = new int[n+1];
        }
        if(memo[n] != 0) return memo[n];
        int sum = 0;
        if(n <= 2) return 1;
        else {
            sum = fib(n-1) + fib(n-2);
        }
        memo[n] = sum;
        return sum;
    }
}
