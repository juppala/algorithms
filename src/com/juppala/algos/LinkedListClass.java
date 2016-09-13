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
class Link {
    int data;
   Link next;
   Link(int data) {
       this.data = data;
       next = null;
   }
}

public class LinkedListClass {
    static Link root;
    
    void insert(int data, int atIndex) {
        int index = 1;
        Link link = new Link(data);
        Link temp = root;
        if(temp == null || atIndex == 1) {
            link.next = temp;
            root = link;
            return;
        }
        while(temp != null) {
            if(index == atIndex - 1) {
                link.next = temp.next;
                temp.next = link;
                break;
            }
            temp = temp.next;
            index++;
        }
        if(temp == null)  {
            System.out.println("invalid index");
        }
    }
    
    void print() {
        Link temp = root;
        System.out.print("LinkedList : ");
        while(temp != null) {
            System.out.print(temp.data + "  ");
            temp = temp.next;
        }
    }
    
    void delete(int atIndex) {
        Link temp =root;
        int index = 1;
        if(root == null) {
            return;
        }
        while(temp != null) {
            if(atIndex == 1) {
                root = root.next;
                return;
            }
            if(index == atIndex - 1) {
                temp.next = temp.next == null ? null : temp.next.next;
            }
            temp = temp.next;
            index++;
        }
    }
    
    void sort() {
        Link temp = root;
        int count[] = {0, 0, 0};
        while(temp != null) {
                count[temp.data-1]++;
                temp = temp.next;
        }
        temp = root;
        int i = 0;
        while(temp != null) {
            if(count[i] == 0) {
                i++;
            }
            count[i]--;
            temp.data = i+1;
            temp = temp.next;
        }
    }
    int size() {
        Link temp = root;
        int size = 0;
        if(temp == null) {
            return size;
        }
        while(temp.next != null) {
            size++;
            temp = temp.next;
        }
        return size+1;
    }
    //10 3 4 9 5
    void sort2() {
        Link insertion = root, current = root.next;
        while(current != null) {
            insertion = root;
            while(insertion != null) {
                if(insertion.data > current.data) {
                    int c_data = current.data;
                    current.data = insertion.data;
                    insertion.data = c_data;
                } else {
                    insertion = insertion.next;
                }
            }
            current = current.next;
        }
    }
    
    Link reverse(Link link) {
        Link temp = link;
        Link previous = null;
         Link tempNext = null;
        while(temp != null) {
            if(temp.next == null) {
                temp.next = previous;
                link = temp;
                break;
            }
            tempNext = temp.next;
            temp.next = previous;
            previous = temp;
            temp = tempNext;
        }
        return link;
        
    }
    
   public static void main(String args[]) {
       LinkedListClass link = new LinkedListClass();
//       link.insert(10, 1);  // 10
//       link.insert(2, 1);   // 2 -> 10
//       link.insert(11, 3); // 2 -> 10 -> 11
//       link.insert(9, 4);  // 2 -> 10 -> 11 -> 9
//       link.insert(8, 4);  // 2 -> 10 -> 11 -> 8 -> 9
//       link.insert(13, 5); // 2 -> 10 -> 11 -> 8 -> 13 -> 9
       link.insert(3, 1);  // 3
       link.insert(2, 1);   // 2 -> 3
       link.insert(3, 3); // 2 -> 3 -> 3
       link.insert(1, 4);  // 2 -> 3 -> 3 -> 1
       link.insert(2, 4);  // 2 -> 3 -> 3 -> 2 -> 1
       link.insert(1, 5); // 2 -> 3 -> 3 -> 2 -> 1 -> 1
       link.insert(1, 5); // 2 -> 3 -> 3 -> 2 -> 1 -> 1 -> 1
       link.print();
       link.sort();
       link.print();
       link.delete(1);
       link.print();
       link.root = link.reverse(link.root);
       link.print();
       link.sort2();
       link.print();
   }
}
