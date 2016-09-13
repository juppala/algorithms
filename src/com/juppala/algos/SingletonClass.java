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
final class SingletonClass {
    private SingletonClass() {
        
    }
    private static SingletonClass instance;
    public static SingletonClass getInstance() {
        if(instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }
}

class SingletonInstantiate {
    public SingletonInstantiate() {
        SingletonClass instance = SingletonClass.getInstance();
    } 
}