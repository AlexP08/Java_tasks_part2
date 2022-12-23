package org.example;

public class Tree { // дерево (проверка как работает в Main)

    Node root; //корневой узел
    public Tree(Node node){
        this.root = node;
    }
    public void add(int value) {
        root = add(root, value);
    }
    private Node add(Node current, int value) {       //метод для добавления элементов в дерево
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = add(current.left, value);
        } else if (value > current.value) {
            current.right = add(current.right, value);
        } else {
            return current;
        }

        return current;
    }
    public boolean containsNode(int value) {
        return search(root, value);
    }
    private boolean search(Node current, int value) {
        if (current == null) {
            System.out.println(false);
            return false;
        }
        if (value == current.value) {
            System.out.println(true);
            return true;
        }
        return value < current.value
                ? search(current.left, value)
                : search(current.right, value);
    }
}
