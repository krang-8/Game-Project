package View;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ApplicationWindow extends Application {


    private Screen menuScreen = new Screen("    {  (UN)-TITLED GAME  }", "Start", "Load", "Settings"); // Main root
    private Screen settingsScreen = new Screen("\t\t\t\t  Settings", "Music", "Effects", "");
    private Screen loadScreen = new Screen("\t\t\t\tLoad Save", "- Empty -", "- Empty -", "- Empty -");
    private Screen startScreen = new Screen("\t\tCharacter Select", "RODDY", "MACE", "DRAKE");
    private Scene mainScene;


    @Override
    public void start(Stage myStage) throws Exception {
        myStage.setTitle("{Un}-titled Game - 2020 - CPSC-233"); //Title

        //Start By making the Menu Scene
        //Set the Scene to the MenuGroup and show the Stage
        mainScene = new Scene(menuScreen.getRoot(), 1000, 800);
        myStage.setScene(mainScene);
        myStage.show();
        
        //Load FXML
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("HUD.fxml"));
        AnchorPane HUD = loader.load();
        


        // Create a reference of the node we want to modify with events --> will directly modify the elements in menuScreen's root
        Text startText = menuScreen.getText1();
        Text loadText = menuScreen.getText2();
        Text settingsText = menuScreen.getText3();

        //Create event Handlers of these 3 text options

        //Exit button to be moved around different Screens depending on which action they chose
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: transparent;");
        backButton.setStyle("-fx-border-color: black;");
        backButton.setPrefSize(150, 100);
        backButton.setLayoutX(15);
        backButton.setLayoutY(15);
        backButton.setId("backButton");
        backButton.setFont(new Font("impact", 30));

        backButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainScene.setRoot(menuScreen.getRoot());
            }
        });


// Events for the Main Menu options
        settingsText.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settingsScreen.getRoot().getChildren().add(backButton);
                mainScene.setRoot(settingsScreen.getRoot());
                
                
                


            }
        });

        loadText.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loadScreen.getRoot().getChildren().add(backButton);
                mainScene.setRoot(loadScreen.getRoot());
            }
        });

        startText.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               // startScreen.getRoot().getChildren().add(backButton);
                // mainScene.setRoot(startScreen.getRoot());
            	//mainScene.setRoot(HUD);
            	Platformer platform = new Platformer();
            	myStage.hide();
//When the User wants to start the game we will hide the Javafx window, and start the Swing Platformer            	
            }
        });
//Interactions with the main menu Complete








    }


    public static void main(String[] args) {
        System.out.println("Starting the Program...\n");
        launch(args);
    }


}
