package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class DateSorting extends Actions{ // Класс для работы с датами, он вообще-то может не наследоваться от Action, но уже не буду менять

    @Override
    public void showActionsInformation() {
        throw new UnsupportedOperationException("Запрашиваемая операция не поддерживается.");
    }

    @Override
    public String readUserInput() {
        throw new UnsupportedOperationException("Запрашиваемая операция не поддерживается.");
    }

    @Override
    public void executeAction(String command) {
        List<Map.Entry<String, Task>> entries = new ArrayList<>(ToDoList.tasks.entrySet());


    }

    public static boolean isDateValid(String format, String value) {
        DateTimeFormatter formatting = DateTimeFormatter.ofPattern(format);
        try {
            LocalDate localDate = LocalDate.parse(value, formatting);

            String result = localDate.format(formatting);

            return result.equals(value);
        } catch (DateTimeParseException err) {

        }
        return false;
    }

    public static String convertDateToString(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String result = null;
        try {
            result = date.format(formatter);

        } catch (DateTimeParseException e) {

        }
        return result;
    }

    public static LocalDate parseDate(String format, String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(value, formatter);
        return localDate;
    }
}
