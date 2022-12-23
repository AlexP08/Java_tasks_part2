package org.example;
import java.util.Arrays;

public class Main {

    public static double[] get_random_array(int size) {
        double[] array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = Math.random();
        }
        return array;
    }

    public static void main(String[] args){
        System.out.println("Проверка первого задания");
        System.out.println(Recursion1.recursion_simple(30));


        System.out.println("Проверка второго задания");
        double[] test = get_random_array(100000000);
        Arrays.sort(test);
        long startTime = System.nanoTime();
        System.out.println(BinarySearch.bruteForce(test,1050));
        double res1 = ((double)(System.nanoTime()-startTime)/1_000_000_000);
        System.out.println("Временя на перебор: "+res1);
        startTime = System.nanoTime();
        System.out.println(BinarySearch.binarySearchRecursively(test,1050,0,test.length));
        double res2 = ((double)(System.nanoTime()-startTime)/1_000_000_000);
        System.out.println("Временя на двоичный поиск: "+res2);
        System.out.println("Перебор медленее на "+(res1-res2));


        System.out.println("Проверка четвертого задания");
        Tree tree = new Tree(new Node(3));
        tree.add(10);
        tree.add(14);
        tree.add(21);
        tree.add(8);
        tree.add(11);
        tree.add(33);

        tree.containsNode(14);
        tree.containsNode(8);
        tree.containsNode(44);
        tree.containsNode(2);


    }


}