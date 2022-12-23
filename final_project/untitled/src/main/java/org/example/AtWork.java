package org.example;

import java.time.LocalDate;

public class AtWork extends Actions{ //Вывод всех невыполненых заданий

    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Здесь все НЕвыполненные задания: ");
    }

    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("Запрашиваемая операция не поддерживается.");
    }

    @Override
    public void executeAction(String command) {
        ToDoList.tasks.forEach((key, task) -> {
            if (task.getDueDate().isAfter(LocalDate.now()) | task.getDueDate().equals(LocalDate.now()))
                System.out.println("ID: " + task.getId() + ", Название: " + task.getTitle() + ", Дата создания: "
                        + DateSorting.convertDateToString(task.getCreateDate(), "dd-MM-yyyy") + ", Дата исполнения: "
                        + DateSorting.convertDateToString(task.getDueDate(),"dd-MM-yyyy") + ", Детали: " + task.getDetails());
        });

    }


}
