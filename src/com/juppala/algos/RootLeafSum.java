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
/*
Given a binary tree, check whether  a given sum ‘x’ is present along any path from the 
root to any of the leaves. 
                                                                           1
                                                                    /            \
                                                                 4                 3
                                                            /        \           /      \
                                                          9          5       6           7
                     if x = 14 , answer is true  because 1+4+9 = 14
                     if x =  12, answer is false

                10
            /        \
           8          2
        /    \      /   
      3      5    2

*/
public class RootLeafSum {
    static Node root;
    static boolean hasPathSum(Node node, int sum) {
        if(node == null) {
            return sum == 0;
        }
        //boolean hasPath = false;
        int data = node.data;
        int pathSum = sum - data;
        Node left = node.left;
        Node right = node.right;
        boolean hasLeft = hasPathSum(left, pathSum);
        boolean hasRight = hasPathSum(right, pathSum);
        
        return hasLeft || hasRight;
    }
    public static void main(String arGs[]) {
        int sum = 22;
        RootLeafSum tree = new RootLeafSum();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
        boolean hasSum = hasPathSum(root, sum);
        System.out.println(hasSum);
    }
}
