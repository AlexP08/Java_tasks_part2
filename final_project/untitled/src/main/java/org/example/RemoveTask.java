package org.example;

import java.util.Scanner;

public class RemoveTask extends Actions { //Класс для удаления заданий

    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Чтобы удалить задачу введите ее ID и нажмите Enter");
        System.out.println("");
        System.out.println("Введите 0 чтобы вернутся назад");
    }

    @Override
    public String readUserInput() {

        while (true) {
            System.out.println("");
            System.out.print("Введите ID: ");
            Scanner in = new Scanner(System.in);
            try {
                String userInput = in.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if (userInputAsNum != 0) {
                    Task task = ToDoList.tasks.get(userInput);
                    if (task != null) {
                        return userInput;
                    } else {
                        System.out.println("такой ID не найден, попробуйте ввести другой ID: ");
                    }
                } else {
                    return userInput;
                }

            } catch (Exception err) {
                System.out.println("Введите корректный ID или 0 для возврата");
            }

        }

    }

    @Override
    public void executeAction(String command) {
        ToDoList.tasks.remove(command);

        System.out.println("Задание с ID: " + command + ", удалено!");

    }



}
