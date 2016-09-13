/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juppala.algos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author juppala
 */
public class NonDivisionSubSet {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();

        int divisibleNo = sc.nextInt();
                List<Integer> list = new ArrayList<>();
        List<Integer> subSetList = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            int value = sc.nextInt();
            list.add(value);
        }
        for(int i = 0; i < len; i++) {
            int value = list.get(i);
            int count = 0;
            for(int j = 0; j < len; j++) {
                int number = list.get(j);
                if(i != j && (number + value) % divisibleNo == 0) {
                    count++;
                    break;
                }
            }
            if(count == 0) {
                subSetList.add(value);
            }
        }
        System.out.println(subSetList);
    }
}