/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juppala.algos;

import java.util.Scanner;

/**
 *
 * @author juppala
 */
public class ReversedBinary {

    public static void main(String[] args) {
        int number;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter a positive integer");
        number = in.nextInt();

        if (number < 0) {
            System.out.println("Error: Not a positive integer");
        } else {

            System.out.print("Convert to binary is:");
            //System.out.print(binaryform(number));
            printBinaryform(number);
        }
    }

    private static int printBinaryform(int number) {
        int binary = 0;
        if(number == 0 || number == 1) {
            return number;
        }
        int reminder = number % 2;
        binary = printBinaryform(number / 2);
        binary = binary * 10 + reminder;
        System.out.println(binary);
        return binary;
    }
}
