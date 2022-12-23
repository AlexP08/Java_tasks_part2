package org.example;

import java.time.LocalDate;
import java.util.Scanner;

public class ByDueDate extends Actions{//Вывод всех заданий выполненную в дату введенную пользователем

    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Введите дату завершения (в формате дд-мм-гггг) без пробелов до и после при вводе даты и нажмите Enter:");
        System.out.println("Введите 0 чтобы вернутся назад");
    }

    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("");
            System.out.print("Введите дату завершения: ");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (DateSorting.isDateValid("dd-MM-yyyy", userInput)){
                return userInput;
            } else {
                System.out.println("Вы не правильно ввели дату, попробуйте еще раз (формат дд-мм-гггг): ");
            }
        }
    }

    @Override
    public void executeAction(String command) {
        LocalDate searchDate = DateSorting.parseDate("dd-MM-yyyy", command);
        System.out.println("Задания завершенные в этот день: ");
        ToDoList.tasks.forEach((key, task) -> {
            if (task.getDueDate().equals(searchDate))
                System.out.println("ID: " + task.getId() + ", Название: " + task.getTitle() + ", Дата создания: "
                        + DateSorting.convertDateToString(task.getCreateDate(), "dd-MM-yyyy") + ", Дата исполнения: "
                        + DateSorting.convertDateToString(task.getDueDate(),"dd-MM-yyyy") + ", Детали: " + task.getDetails());
        });

    }
}
