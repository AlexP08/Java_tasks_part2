package org.example;

import java.time.LocalDate;

public class ComplitedTask extends Actions{ // Выводим все выполненные задания

    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Здесь все выполненные задания: ");
    }

    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("Запрашиваемая операция не поддерживается.");
    }

    @Override
    public void executeAction(String command) {
        ToDoList.tasks.forEach((key, task) -> {
            if (task.getDueDate().isBefore(LocalDate.now()))
            System.out.println("ID: " + task.getId() + ", Название: " + task.getTitle() + ", Дата создания: "
                    + DateSorting.convertDateToString(task.getCreateDate(), "dd-MM-yyyy") + ", Дата исполнения: "
                    + DateSorting.convertDateToString(task.getDueDate(),"dd-MM-yyyy") + ", Детали: " + task.getDetails());
        });

    }
}
