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
public class StringDisJoint {
    public static void main(String args[]) {
        String a = "ABCDEFGH";
        String b = "IJKLMNOPQRSHA";
        int a_arry[] =new int[26];
        boolean isDisJoint = false;
        for(char c: a.toLowerCase().toCharArray()) {
            a_arry[c - 'a'] = 1;
        }
        for(char c: b.toLowerCase().toCharArray()) {
            if(a_arry[c - 'a'] == 1) {
                isDisJoint = true;
            }
        }
        if(isDisJoint) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
