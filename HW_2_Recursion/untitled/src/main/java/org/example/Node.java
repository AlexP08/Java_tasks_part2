package org.example;

public class Node {  //класс с узлами дерева (проверка как работает в Main)
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
}

