package org.example;
import java.time.LocalDate;

public class Task {   // Класс для создания задания
    private String id;
    private String title;
    private LocalDate createDate;
    private LocalDate dueDate;

    private String Details;



    public String getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }


    public LocalDate getDueDate() {
        return dueDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }


    public String getDetails() {
        return Details;
    }


    public void setId(String id) {
        this.id = id;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    public void setDetails(String Details) {
        this.Details = Details;
    }


    public static Task buildTask(String id, String title, LocalDate createDate, LocalDate dueDate, String Details) {
        Task task = new Task();

        task.setId(id);
        task.setTitle(title);
        task.setCreateDate(createDate);
        task.setDueDate(dueDate);
        task.setDetails(Details);

        return task;
    }



    @Override
    public String toString() {
        return id + ", " + title + ", " + DateSorting.convertDateToString(createDate, "dd-MM-yyyy")+ ", " + DateSorting.convertDateToString(dueDate, "dd-MM-yyyy") + ", " + Details + "," ;
    }

}
