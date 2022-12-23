package org.example;

import java.util.*;

public class ToDoList { //Список заданий, вообше его надо куда-то сохранять наверно. Но в задании этого не было так что оставлю так

    public static Map<String, Task> tasks = new LinkedHashMap<>();
    public static boolean applicationRunning = true;

    public void start() {
        showApplicationTitle();
        while (ToDoList.applicationRunning) {
            showAvailableActions();
            int actionNumber = readAction();
            executeAction(actionNumber);

        }
    }

    public void executeAction(int actionNumber) {
        Actions action;
        switch (actionNumber) {
            case Actions.ADD_TASK:
                action = new AddTask();
                action.showActionsInformation();
                String command = action.readUserInput();
                if (!command.equals("0"))
                    action.executeAction(command);
                break;


            case Actions.REMOVE_TASK:
                if (tasks.size() > 0) {
                    action = new RemoveTask();
                    action.showActionsInformation();
                    String id = action.readUserInput();
                    if (!id.equals("0"))
                        action.executeAction(id);
                } else {
                    System.out.println("У тебя нет заданий которые можно удалить! ");
                }
                break;

            case Actions.EDIT_TASK:
                if (tasks.size() > 0) {
                    action = new EditTask();
                    action.showActionsInformation();
                    String editCommand = action.readUserInput();
                    if (!editCommand.equals(0))
                        action.executeAction(editCommand);
                } else {
                    System.out.println("У тебя нет заданий которые можно редактировать! Может добавиш? ");
                }
                break;

            case Actions.DISPLAY_ALL_TASKS:
                if (tasks.size() > 0) {
                    action = new TasksDisplay();
                    action.showActionsInformation();
                    action.executeAction(null);
                } else {
                    System.out.println("Нечего выводить, добавь сначала что-то! ");
                }
                break;

            case Actions.COMPLETED_TASKS:
                action = new ComplitedTask();
                action.showActionsInformation();
                action.executeAction(null);
                break;

            case Actions.TASKS_AT_WORKS:
                action = new AtWork();
                action.showActionsInformation();
                action.executeAction(null);
                break;


            case Actions.BY_CREATE_DATE:
                action = new ByCreationDate();
                action.showActionsInformation();
                String dateCreation = action.readUserInput();
                if (!dateCreation.equals("0"))
                    action.executeAction(dateCreation);
                break;


            case Actions.BY_DUE_DATE:
                action = new ByDueDate();
                action.showActionsInformation();
                String dueDate = action.readUserInput();
                if (!dueDate.equals("0"))
                    action.executeAction(dueDate);
                break;

            case Actions.DETAIL:
                if (tasks.size() > 0) {
                    action = new ViewDetail();
                    action.showActionsInformation();
                    String id = action.readUserInput();
                    if (!id.equals("0"))
                        action.executeAction(id);
                } else {
                    System.out.println("У тебя нет заданий которые можно посмотреть! ");
                }
                break;

            case Actions.EXIT:
                applicationRunning = false;
                break;


        }
    }

    public void showApplicationTitle() {
        System.out.println("Программа планировщик");
        System.out.println("-----------------------");
    }

    public void showAvailableActions() {
        System.out.println("");
        System.out.println("1. Добавить задание");
        System.out.println("2. Удалить задание");
        System.out.println("3. Редактировать задание ");
        System.out.println("4. Список всех заданий");
        System.out.println("5. Список выполненных заданий");
        System.out.println("6. Список невыполненных задний");
        System.out.println("7. Список по дате создания");
        System.out.println("8. Список по дате выполнения");
        System.out.println("9. Детальная информация");
        System.out.println("10. Выход");
        System.out.println("");
    }

    public int readAction() {
        List<Integer> availableActions = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        while (true) {
            try {
                System.out.print("Введите номер действия которое хотите выполнить: ");
                Scanner scan = new Scanner(System.in);
                int action = scan.nextInt();
                if (availableActions.contains(action)) {
                    return action;
                } else {
                    System.out.println("Ввведите число, который есть в списке: ");
                }
            } catch (Exception e) {
                System.out.println("Это должно быть число");

            }
        }
    }

}
