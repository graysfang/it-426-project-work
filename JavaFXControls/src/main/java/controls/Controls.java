package controls;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType;

import javafx.stage.Stage;



public class Controls extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setScene(createLists());
        stage.setTitle("Practice controls");
        stage.show();
    }

    //buttons
    public Scene creatButtons()
    {
        VBox vBox = new VBox();
        //create a button and style it

        Button button = new Button("Click Me!");
        button.setAlignment(Pos.CENTER);
        button.setPrefWidth(150);
        button.setPrefHeight(50);

        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                button.setText("Don't Touch me!");
            }
        });

        vBox.getChildren().add(button);
        vBox.setAlignment(Pos.CENTER);

        return new Scene(vBox, 300, 300);
    }

    //text, label, textfield, text area
    public Scene creatText()
    {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

//        Text header = TextBuilder.create().text("Enter Info")
//                .font(Font.font("Century Gothic", FontWeight.MEDIUM, 30))
//                .underline(true)
//                .build();

        Text header = new Text("Enter Info");
        header.setFont(Font.font("Century Gothic", FontWeight.MEDIUM, 30));
        header.setUnderline(true);

        vBox.getChildren().add(header);

        //form control
        HBox row1 = new HBox();
        row1.setSpacing(10);

        Label nameLabel = new Label("Name: ");
        nameLabel.setPrefWidth(90);
        nameLabel.setAlignment(Pos.CENTER);

        TextField nameField = new TextField();
        nameField.setPrefWidth(180);


        row1.getChildren().addAll(nameLabel, nameField);
        vBox.getChildren().add(row1);

        //row 2
        HBox row2 = new HBox();

        Label bioLabel = new Label("Bio: ");
        bioLabel.setPrefWidth(90);
        bioLabel.setAlignment(Pos.CENTER);

        TextArea bioArea = new TextArea();
        bioArea.setPrefWidth(180);

        row2.getChildren().addAll(bioLabel, bioArea);
        vBox.getChildren().add(row2);

        return new Scene(vBox, 300, 300);
    }
    //check boxes
    public Scene createCheckBoxes()
    {
        String[] hobbies = {"Games", "Drawing", "Eating","Sleeping","5","6"};

        CheckBox[] boxes = new CheckBox[hobbies.length];

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        //add out checkboxes
        for(int i = 0; i<hobbies.length; i++)
        {
            CheckBox box = new CheckBox(hobbies[i]);
            boxes[i] = box;
            box.setPrefWidth(200);

        }
        vBox.getChildren().addAll(boxes);

        //add event handlers
        for(int i = 0; i<boxes.length; i++)
        {
            final CheckBox box = boxes[i];
            final String hobby = hobbies[i];
            boxes[i].selectedProperty().addListener(new ChangeListener<Boolean>()
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
                {
                    if(newValue)
                    {
                        //do somethig with the check box
                        box.setText("You clicked me: "+ newValue);
                    }
                    else
                    {
                        box.setText(hobby);
                    }

                }
            });
        }

        return new Scene(vBox, 300, 300);
    }


    //radio buttons image

    //drop down lists
    public Scene createDropDowns()
    {
        //create layout and controls
        VBox vBox = new VBox();

        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);

        ComboBox combo = new ComboBox();

        //add items to my dropdown
        ObservableList<String> options = FXCollections.observableArrayList("blue", "purple", "green", "yellow", "orange");

        combo.getItems().addAll(options);

        vBox.getChildren().add(combo);

        //select a default
        combo.getSelectionModel().select(0);

        //respond to selections (do this for buttons tooooooo)
        combo.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
               Alert alert = new Alert(AlertType.INFORMATION, "You clicked "+ combo.getValue());

               alert.show();
            }
        });

        //other types of lists
        DatePicker datePicker = new DatePicker();
        vBox.getChildren().add(datePicker);

        //color picker
        ColorPicker colorPicker = new ColorPicker();
        vBox.getChildren().add(colorPicker);

        return new Scene(vBox, 300, 300);
    }

    //lists
    public Scene createLists()
    {
        //create scene
        VBox vBox = new VBox();

        ListView listView = new ListView();

        //add a few items
        ObservableList<String> item = FXCollections.observableArrayList("Hurt", "Five Finger Death Punch", "Cold");
        vBox.getChildren().add(listView);
        listView.getItems().addAll(item);

        return new Scene(vBox, 300, 300);
    }


}
