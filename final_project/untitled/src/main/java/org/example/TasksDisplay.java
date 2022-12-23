package org.example;

public class TasksDisplay extends Actions { //Класс для вывода всех заданий на экран

    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Здесь все задания которые есть: ");
    }

    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("Запрашиваемая операция не поддерживается.");
    }

    @Override
    public void executeAction(String command) {
        ToDoList.tasks.forEach((key, task) -> {
            System.out.println("ID: " + task.getId() + ", Название: " + task.getTitle() + ", Дата создания: "
                    + DateSorting.convertDateToString(task.getCreateDate(), "dd-MM-yyyy") + ", Дата исполнения: "
                    + DateSorting.convertDateToString(task.getDueDate(),"dd-MM-yyyy") + ", Детали: " + task.getDetails());
        });

    }


}
