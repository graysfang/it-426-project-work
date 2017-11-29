package ui;
/*
 * Nicholas Perez
 * 11/27/2017
 * ToDoView.java
 *
 * This is a Java FX application for creating, viewing and updating to-do items.
 */

import controller.ToDoController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.ToDo;
import model.ToDoModel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * This is a Java FX application for creating, viewing and updating to-do items.
 *
 * @author Nicholas Perez
 * @version 1.0
 **/
public class ToDoView implements Observer
{
    private static ToDoController controller = new ToDoController();
    private static ArrayList<ToDo> data = controller.getList();


    /**
     * Default Constructor
     */
    public ToDoView()
    {
    }

    /**
     * Home scene - Landing page with nav to Tasks scene
     * @param stage the current stage
     * @return the completed scene
     */
    public static Scene home(Stage stage)
    {

        GridPane gridPane = gridPaneTemplate();

        Text welcome = new Text("Welcome!");
        welcome.getStyleClass().add("header-text");

        //add some logic to check on the current number of tasks here
        Text msg = new Text("You have "+ data.size()+" unfinished tasks.");

        Button viewButton = new Button("    View    ");

        Image tasksImage = new Image("tasks.png", 100, 100, false, false);
        ImageView imageView = new ImageView();
        imageView.setImage(tasksImage);

        viewButton.setOnAction(event -> {
            stage.setScene(viewTasks(stage));
        });

        VBox vBox = new VBox();
        vBox.getStyleClass().add("home-alignment");
        vBox.getChildren().addAll(welcome, msg, viewButton, imageView);
        vBox.setSpacing(15);
        gridPane.add(vBox, 0,1,4,2);

        return new Scene(gridPane, 300,325);
    }

    //lists current tasks with nav to add new tasks
    private static Scene viewTasks(Stage stage)
    {
        GridPane gridPane = gridPaneTemplate();

        HBox hBox = new HBox();
        hBox.setSpacing(155);

        VBox vBox = new VBox();
        vBox.getStyleClass().add("home-alignment");

        Text heading = new Text("Tasks");
        heading.getStyleClass().add("header-text");

        Button addTask = new Button("   +   ");

        addTask.setOnAction(event -> {
            stage.setScene(addTask(stage));
        });

        VBox taskListVBox = new VBox();
        Label message = new Label("");


        //if there are no tasks show this
        if (data.size() != 0)
        {
            for (ToDo item: data)
            {

                CheckBox checkBox = new CheckBox(item.getMessage());

                checkBox.selectedProperty().addListener((observable, oldValue, newValue) ->
                {
                    if (newValue == true)
                    {
                        controller.completeTask(checkBox.getText());
                    }
                    stage.setScene(viewTasks(stage));
                });

                taskListVBox.getChildren().add(checkBox);

            }
        }
        else
        {
            message = new Label("There are no tasks currently. Add a task by clicking the + button above.");
            message.setWrapText(true);

        }

        hBox.getChildren().addAll(heading, addTask);
        vBox.getChildren().addAll(hBox, message, taskListVBox);
        gridPane.add(vBox, 0, 1, 4, 1);

        return new Scene(gridPane, 300,325);
    }

    //scene for adding a new task and nav to add the task
    private static Scene addTask(Stage stage)
    {
        GridPane gridPane = gridPaneTemplate();

        VBox vBox = new VBox();
        vBox.setSpacing(15);

        Text heading = new Text("Add New Task");
        heading.getStyleClass().add("header-text");

        TextField newTask = new TextField();
        newTask.setPromptText("Enter a new task.");

        Button addTaskButton = new Button("   Add   ");

        addTaskButton.setOnAction(event -> {
            controller.addTask(newTask.getText());

            stage.setScene(viewTasks(stage));
        });

        vBox.getChildren().addAll(heading, newTask, addTaskButton);
        gridPane.add(vBox,0,1,4,1);

        return new Scene(gridPane, 300,325);
    }

    //gridpane template method
    private static GridPane gridPaneTemplate()
    {
        GridPane gridPane = new GridPane();

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        final int COLUMN_WIDTH = 80;

        gridPane.getColumnConstraints().addAll(
                new ColumnConstraints(COLUMN_WIDTH),
                new ColumnConstraints(COLUMN_WIDTH),
                new ColumnConstraints(COLUMN_WIDTH)
        );

        gridPane.getStylesheets().add("styles.css");

        return gridPane;
    }

    /**
     * Update method for the observable model class
     * @param observable the model
     * @param args object containing task data
     */
    @Override
    public void update(Observable observable, Object args)
    {
        if(observable instanceof ToDoModel)
        {
            Object[] part = (Object[])args;
            data = (ArrayList<ToDo>) part[0];
        }
    }
}
