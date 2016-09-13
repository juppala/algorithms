/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
For example, the following tree

                  10
               /      \
            -2        6
           /   \      /  \ 
         8     -4    7    5
should be changed to

                 20(4-2+12+6)
               /      \
         4(8-4)      12(7+5)
           /   \      /  \ 
        0      0    0    0
*/
package com.juppala.algos;

/**
 *
 * @author juppala
 */
public class SumTree {

    static Node root;
    int sumTree(Node node) {
        if(node == null) {
            return 0;
        }
        int value = node.data;
        int left_sum = sumTree(node.left);
        int right_sum = sumTree(node.right);
        node.data = left_sum + right_sum;
        return node.data + value;
    }
    
    void printTree(Node node) {
        if(node == null) {
            System.out.print("0");
        } else {
            printTree(node.left);
            System.out.print(" " + node.data + " ");
            printTree(node.right);
        }
    }
    
    public static void main(String args[]) {
        SumTree tree = new SumTree();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(6);
        
        tree.sumTree(root);
        tree.printTree(root);
    }
}
