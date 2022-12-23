package org.example;

public class BinarySearch {
    public static int bruteForce(double[] array, double key) { // простой перебор
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key)
                return i;
        }
        return -1;
    }

    public  static int binarySearchRecursively // бинарный поиск  с использованием рекурсии, запуск и сравнение времени в Main
            (double[] sortedArray, double key, int low, int high) {
        int middle = (low + high) / 2;
        if (high <= low) {
            return -1;
        }

        if (key == sortedArray[middle]) {
            return middle;
        }
        else if (key < sortedArray[middle]) {
            return binarySearchRecursively(
                    sortedArray, key, low, middle - 1);
        }
        else {
            return binarySearchRecursively(
                    sortedArray, key, middle+1, high);
        }
    }
}
