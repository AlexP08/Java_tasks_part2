package org.example;

import java.util.Scanner;

public class EditTask extends Actions{ // Класс для редактирования заданий

    @Override
    public void showActionsInformation() {
        System.out.println("");
        System.out.println("Чтобы редактировать задание, через точку с запятой, без пробелов до и после даты, введите то что перечисленно ниже и нажмите Enter: ");
        System.out.println("id задания; Название задания; дату создания (в формате дд-мм-гггг); дату выполнения (в формате дд-мм-гггг); детали задания");
        System.out.println("Введите знак черта(-) если вам не нужно редактировать пункт, id вводить обязательно, так по нему будет произволится поиск ");
        System.out.println("");
        System.out.println("Введите 0 чтобы вернутся назад");
    }


    @Override
    public String readUserInput() {
        while (true) {
            System.out.println("");
            System.out.println("Введите информацию для редактирования");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals(0)) {
                String[] parts = userInput.split(";");
                if (parts.length == 5) {
                    boolean dateValidationRequired1 = true;
                    boolean dateValidationRequired2 = true;
                    if (parts[2].equals("-")) {
                        dateValidationRequired1 = false;
                    }

                    boolean isDateValid1 = true;
                    if (dateValidationRequired1) {
                        isDateValid1 = DateSorting.isDateValid("dd-mm-yyyy", parts[2]);
                    }

                    if (parts[3].equals("-")) {
                        dateValidationRequired2 = false;
                    }

                    boolean isDateValid2 = true;
                    if (dateValidationRequired2) {
                        isDateValid2 = DateSorting.isDateValid("dd-mm-yyyy", parts[3]);
                    }


                    if (isDateValid1) {
                        if (ToDoList.tasks.get(parts[0]) != null) {
                            return userInput;
                        } else {
                            System.out.println("ID не существует, попробуйте еще раз: ");
                        }
                    } else {
                        System.out.println("Введите коректную информацию или введите 0 для возврата в основное меню");
                    }

                    if (isDateValid2) {
                        if (ToDoList.tasks.get(parts[0]) != null) {
                            return userInput;
                        } else {
                            System.out.println("ID не существует, попробуйте еще раз: ");
                        }
                    } else {
                        System.out.println("Введите коректную информацию или введите 0 для возврата в основное меню");
                    }
                } else {
                    return userInput;
                }
            }
        }
    }


    public void executeAction(String command) {

        String[] parts = command.split(";");

        boolean isTaskEdited = false;
        if (!parts[1].equals("-")) {
            ToDoList.tasks.get(parts[0]).setTitle(parts[1]);
            isTaskEdited = true;
        }

        if (!parts[2].equals("-")) {
            ToDoList.tasks.get(parts[0]).setDueDate(DateSorting.parseDate("dd-mm-yyyy", parts[2]));
            isTaskEdited = true;
        }

        if (!parts[3].equals("-")) {
            ToDoList.tasks.get(parts[0]).setDueDate(DateSorting.parseDate("dd-mm-yyyy", parts[3]));;
            isTaskEdited = true;
        }
        if (!parts[4].equals("-")) {
            ToDoList.tasks.get(parts[0]).setDetails(parts[4]);
            isTaskEdited = true;
        }
        if (isTaskEdited) {
            System.out.println("Задание обновлено!!");
        } else {
            System.out.println("Изменений не было...");
        }
    }

}
