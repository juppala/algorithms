/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juppala.algos;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author juppala
 */
public class SumLinkList {
    
    /*
5 2 3
8 5 9

3 7 2
1 0 1  =   13 8 2

(((1*10) + 3) + 0)*10 + 7) + 1) *10 + 2
    */
    static int getSumList(LinkedList l1, LinkedList l2) {
        int total = 0;
        Iterator i1 = l1.iterator();
        Iterator i2 = l2.iterator();
        LinkedList<Integer> sumList = new LinkedList<Integer>();
        while(i1.hasNext() && i2.hasNext()) {
            int l1_data = (int) i1.next();
            int l2_data = (int) i2.next();
            int sum = l1_data + l2_data;
            int reminder = (sum % 10);
            sumList.add(sum);
            System.out.println(sum);
            total = ((total + (sum / 10)) * 10) + reminder;
        }
        return total;
    }
    
    public static void main(String args[]) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        LinkedList<Integer> sumList = new LinkedList<Integer>();
        
        list1.add(5);
        list1.add(2);
        list1.add(3);
        
        list2.add(8);
        list2.add(5);
        list2.add(9);
        
        int sum = getSumList(list1, list2);
        System.out.println(sum);
    }
}
