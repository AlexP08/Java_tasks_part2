package org.example;

public class Recursion1 {   //первое задание вызывается из Main
    public static String recursion_simple(int num){
        if (num == 1){
            return "1";
        }
        else{
            return recursion_simple(num-1)+" "+num;
        }
    }
}
