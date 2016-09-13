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
public class SquareRootAlgo {
    public static void main(String[] args) {
        System.out.println(squareRoot(12));
    }

    private static double squareRoot(double input) {
        double sqrt = 1.00f, tempSqrt = input;
        
        while(sqrt != tempSqrt) {
            sqrt = (tempSqrt + sqrt) / 2;
            tempSqrt = input / sqrt;
            System.out.println(sqrt);
            System.out.println(input / sqrt);
            System.out.println("-------------------------");
        }
        return sqrt;
    }
}
