package org.example;

public class Root { // Задание поиск корня уровнения (запускается прямо здесь)

    public static double equation(double x){
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double  rootOf(double start, double end){
        if(end - start <= 0.001){
            return start;
        }

        double x = start + (end - start) / 2;

        if(equation(start) * equation(x) > 0){
            return rootOf(x, end);
        } else {
            return rootOf(start, x);
        }
    }

    public static void main(String[] args) {
        System.out.println(rootOf(0, 10));
    }

}
