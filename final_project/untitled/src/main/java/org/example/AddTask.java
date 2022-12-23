package org.example;

import java.util.Scanner;


public class AddTask extends Actions { // Создание задания

    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Чтобы добавить задание, через точку с запятой, без пробелов до и после при вводе даты, введите то что перечисленно ниже и нажмите Enter:");
        System.out.println("ID задания; Название задания; дату создания (в формате дд-мм-гггг); дату выполнения (в формате дд-мм-гггг); детали задания");
        System.out.println("");
        System.out.println("Введите 0 чтобы вернутся назад");
    }


    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("");
            System.out.print("Введите информацию о задании: ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals("0")) {
                String[] parts = userInput.split(";");
                if (parts.length == 5) {
                    if (DateSorting.isDateValid("dd-MM-yyyy", parts[2]) && DateSorting.isDateValid("dd-MM-yyyy", parts[3])){
                        return userInput;
                    } else {
                        System.out.println("Вы не правильно ввели дату, попробуйте еще раз (формат дд-мм-гггг): ");
                    }
                } else {
                    System.out.println("Что-то пошло не так, вводите как написано выше: ");
                }
            } else {
                return userInput;
            }
        }
    }

    @Override
    public void executeAction(String command) {
        String[] parts = command.split(";");
        Task task = Task.buildTask(parts[0], parts[1], DateSorting.parseDate("dd-MM-yyyy",parts[2]), DateSorting.parseDate("dd-MM-yyyy", parts[3]),
                parts[4]);

        ToDoList.tasks.put(task.getId(), task);
        System.out.println("Задание успешно дабавлено!");

    }




}
