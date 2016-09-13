/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juppala.algos;

import java.util.*;
import java.lang.*;

/**
 *
 * @author juppala
 */

/*

 A program to check if a binary tree is BST or not
 A binary search tree (BST) is a node based binary tree data structure which has the following properties.
 • The left subtree of a node contains only nodes with keys less than the node’s key.
 • The right subtree of a node contains only nodes with keys greater than the node’s key.
 • Both the left and right subtrees must also be binary search trees.

 From the above properties it naturally follows that:
 • Each node (item in the tree) has a distinct key.


 10
 /        \
 4          12
 /   \       /    \ 
 3      5   11     22
 /
 17
 /
 16
 BST

 */
public class BinarySearchTree {

    Node root;

    Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (node.data < data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    int size(Node node) {
        if (node == null) {
            return 0;
        }
        int left_size = size(node.left);
        int right_size = size(node.right);
        return left_size + 1 + right_size;
    }

    int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int left_depth = 1 + maxDepth(node.left);
        int right_depth = 1 + maxDepth(node.right);
        return (left_depth > right_depth ? left_depth : right_depth);
    }

    int minValue(Node node, int min) {
        if (node == null) {
            return min;
        }
        int data = node.data;
        int left_min = minValue(node.left, Math.min(data, min));
        int right_min = minValue(node.right, Math.min(data, min));

        return Math.min(left_min, right_min);
    }

    /**
     * Prints the node values in the "inorder" order. Uses a recursive helper to
     * do the traversal.
     */
    private void printTree(Node node) {
        if (node == null) {
            return;
        }
        // left, node itself, right 
        printTree(node.left);
        System.out.print(node.data + "  ");
        printTree(node.right);
    }

    /**
     * Prints the node values in the "postorder" order. Uses a recursive helper
     * to do the traversal.
     */
    public void printPostorder(Node node) {
        if (node == null) {
            return;
        }

        // first recur on both subtrees 
        printPostorder(node.left);
        printPostorder(node.right);

        // then deal with the node 
        System.out.print(node.data + "  ");
    }

    /**
     * Given a tree and a sum, returns true if there is a path from the root
     * down to a leaf, such that adding up all the values along the path equals
     * the given sum. Strategy: subtract the node value from the sum when
     * recurring down, and check to see if the sum is 0 when you run out of
     * tree.
     */
    boolean hasPathSum(Node node, int sum) {
        // return true if we run out of tree and sum==0 
        if (node == null) {
            return (sum == 0);
        } else {
            // otherwise check both subtrees 
            int subSum = sum - node.data;
            return (hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum));
        }
    }

    boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data < min || node.data > max) {
            return false;
        }

        boolean isLeftBST = isBST(node.left, min, node.data - 1);
        boolean isRightBST = isBST(node.right, node.data + 1, max);
        return isLeftBST && isRightBST;
    }

    void levelOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        while (queue.size() > 0) {

            Node current = (Node) queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    /*public static void breadthFirstSearch(Queue queue) {

     if (queue.isEmpty()) {
     return;
     }

     Node node = (Node) queue.poll();

     System.out.println(node + " ");

     if (node.right != null) {
     queue.offer(node.right);
     }

     if (node.left != null) {
     queue.offer(node.left);
     }

     breadthFirstSearch(queue);
     }

     public static void depthFirstSearch(Stack stack) {

     if (stack.isEmpty()) {
     return;
     }

     Node node = (Node) stack.pop();

     System.out.println(node + " ");

     if (node.right != null) {
     stack.push(node.right);
     }

     if (node.left != null) {
     stack.push(node.left);
     }

     depthFirstSearch(stack);
     }*/
    public static void main(String args[]) {
        BinarySearchTree node = new BinarySearchTree();
        node.root = new Node(10);
        node.root.left = new Node(4);
        node.root.right = new Node(12);
        node.root.left.left = new Node(3);
        node.root.left.right = new Node(5);
        node.root.right.left = new Node(11);
        node.root.right.right = new Node(22);
        node.root.right.right.left = new Node(17);
        node.root.right.right.left.left = new Node(16);
        System.out.println("is Binary Search Tree: " + node.isBST(node.root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        System.out.println("SIZE: " + node.size(node.root));

        System.out.println("MaxDepth: " + node.maxDepth(node.root));

        System.out.println("MinValue: " + node.minValue(node.root, Integer.MAX_VALUE));

        System.out.println("InOrder Traverse:");
        node.printTree(node.root);

        System.out.println("PostOder Traverse:");
        node.printPostorder(node.root);

        System.out.println("hasPathSum:");
        System.out.println(node.hasPathSum(node.root, 17));

        System.out.println("Level Order Traverse");
        node.levelOrderTraverse(node.root);
    }
}
