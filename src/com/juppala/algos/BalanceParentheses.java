/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juppala.algos;

import java.util.Stack;

/**
 *
 * @author juppala
 */
public class BalanceParentheses {
    
    public static void main(String args[]) {
        String expression = "[{}]";
        Stack stack = new Stack();
        int len = expression.length();
        boolean isBanacled = true;
        for(int i = 0; i < len; i++) {
            char c =expression.charAt(i);
            if(c == '{' || c == '[') {
                stack.push(c);
            } else if(c == '}' || c == ']') {
                char top = (char) stack.lastElement();
                switch (c) {
                    case '}':
                        isBanacled = (top != '{' ? false : true);
                        break;
                    case ']':
                        isBanacled = (top != '[' ? false : true);
                        break;
                }
                if(!isBanacled) {
                    break;
                }
                stack.pop();
            }
        }
        System.out.println("is balanced or not: "+ isBanacled);
    }
}
