package org.example;

public abstract class Actions { //Абстрактный класс от которого наследуют все действия
    public static final int ADD_TASK = 1;
    public static final int REMOVE_TASK = 2;
    public static final int EDIT_TASK = 3;
    public static final int DISPLAY_ALL_TASKS = 4;
    public static final int COMPLETED_TASKS = 5;

    public static final int TASKS_AT_WORKS = 6;

    public static final int BY_CREATE_DATE = 7;

    public static final int BY_DUE_DATE = 8;

    public static final int DETAIL = 9;

    public static final int EXIT = 10;

    public abstract void showActionsInformation();

    public abstract String readUserInput();

    public abstract void executeAction(String command);

}
