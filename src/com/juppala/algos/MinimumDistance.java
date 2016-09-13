/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juppala.algos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author juppala
 */
public class MinimumDistance {
    public static void main(String args[]) {
        int array[] = {7, 1, 2,1, 3, 1, 5, 6, 7,7,1,1};
        Map<Integer, Integer> map = new HashMap<>();
        int len = array.length;
        int distance = len;
        for(int i=0; i < len; i++) {
            if(map.containsKey(array[i])) {
                int key = map.get(array[i]);
                map.put(array[i], i);
                if(i - key < distance) {
                    distance = i - key;
                }
            } else {
                map.put(array[i], i);
            }
        }
        System.out.println(distance);
    }
}
