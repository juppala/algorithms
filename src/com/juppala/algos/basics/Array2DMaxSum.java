/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juppala.algos.basics;

import java.util.Scanner;

/**
 *
 * @author juppala
 */
/*
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
-------------
Explanation

1 1 1   1 1 0   1 0 0   0 0 0
  1         0         0       0
1 1 1   1 1 0   1 0 0   0 0 0

0 1 0   1 0 0   0 0 0   0 0 0
  1         1         0        0
0 0 2   0 2 4   2 4 4   4 4 0

1 1 1   1 1 0   1 0 0   0 0 0
  0         2        4        4
0 0 0   0 0 2   0 2 0   2 0 0

0 0 2   0 2 4   2 4 4   4 4 0
  0         0        2         0
0 0 1   0 1 2   1 2 4   2 4 0
--------------------------------
2 4 4
  2
1 2 4
-------------
19

*/
public class Array2DMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        int max_sum = 0;
        int len = arr.length;
        int startIndexX = len - 3;
        int startIndexY = len - 3;
        while(startIndexX >= 0) {
            while(startIndexY >= 0) {
                int temp = 0;
                for(int i = startIndexX; i < 3 + startIndexX; i++) {
                    for(int j = startIndexY; j < 3 + startIndexY; j++) {
                        if( i == startIndexX + 1 && (j == startIndexY || j == startIndexY + 2)) {
                            //do nothing;
                        } else {
                            temp += arr[i][j];
                        }
                    }
                }
                //System.out.println(temp);
                if(temp > max_sum) {
                    max_sum = temp;
                }
                startIndexY--;
            }
            startIndexY = len - 3;
            startIndexX--;
        }
        System.out.print(max_sum);
    }
}
