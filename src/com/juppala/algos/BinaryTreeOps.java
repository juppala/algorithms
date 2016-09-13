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
public class BinaryTreeOps {
    Node root;
    Node insert(Node node, int data) {
        if(node == null) {
            return new Node(data);
        }
        if(node.data < data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }
    public static void main(String args[]) {
        BinaryTreeOps node = new BinaryTreeOps();
        node.root = new Node(10);
        node.root.left = new Node(2);
        node.root.right = new Node(4);
        node.root = node.insert(node.root, 5);
    }
}
