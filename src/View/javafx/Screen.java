package View.javafx;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Screen {
    //Creates the various roots for the different options from the MenuScreen


    private Group root;
    private Color borderColor = Color.BLACK;
    private Color textColor = Color.WHITE;

    //All of these will belong to the instance so we can modify them
    private Rectangle titleBorder = new Rectangle(5, 5, 1000 - 5 * 2, 800 - 680); // 5 is the outline width
    private Rectangle optionBorder = new Rectangle(300, 200, 400, 500);
    private Text titleText;
    private Text text1;
    private Text text2;
    private Text text3;
    private Font menuTextFont = new Font("impact", 70);
    private Font titleTextFont = new Font("impact", 100);
    private Font menuTextSelectedFont = new Font("impact", 80);




    public Screen(String aTitle, String text1String, String text2String, String text3String) {

        root = new Group();


        titleText = new Text(aTitle);
        text1 = new Text(text1String);
        text2 = new Text(text2String);
        text3 = new Text(text3String);

        int SCREENX = 1000;
        int SCREENY = 800;


//titleBorder
        titleBorder.setFill(borderColor);
        titleBorder.setStroke(textColor);
        titleBorder.setStrokeWidth(5);

        titleBorder.setId("titleBorder");
        root.getChildren().add(titleBorder);

//titleText
        titleText.setFont(titleTextFont);
        titleText.setFill(textColor);
        titleText.setX(0);
        titleText.setY(100);
        titleText.setStroke(Color.BLACK);
        titleText.setOnMouseEntered(event -> {

            textColor = Color.color(Math.random(), Math.random(), Math.random());
            borderColor = Color.color(Math.random(), Math.random(), Math.random());

            titleText.setFill(textColor);
            text1.setFill(textColor);
            text2.setFill(textColor);
            text3.setFill(textColor);
            titleBorder.setStroke(textColor);
            optionBorder.setStroke(textColor);


            titleBorder.setFill(borderColor);
            optionBorder.setFill(borderColor);
        });

        titleText.setId("titleText");
        root.getChildren().add(titleText);

//optionBorder
        optionBorder.setStrokeWidth(5);
        optionBorder.setId("optionBorder");
        root.getChildren().add(optionBorder);


//text1
        text1.setFont(menuTextFont);
        text1.setFill(textColor);
        text1.setStroke(Color.BLACK);
        text1.setX((SCREENX / 2) - 80);
        text1.setY(300);

        // Action when mouse hovering
        text1.setOnMouseEntered(event -> {
            text1.setUnderline(true);
            text1.setFill(Color.RED);
            text1.setFont(menuTextSelectedFont);
            text1.setX((SCREENX / 2) - 88);


        });

        // Action when mouse exiting hover (revert action above)
        text1.setOnMouseExited(event -> {
            text1.setUnderline(false);
            text1.setFill(textColor);
            text1.setFont(menuTextFont);
            text1.setX((SCREENX / 2) - 80);


        });


// text 2
        text2.setFont(menuTextFont);
        text2.setFill(textColor);
        text2.setStroke(Color.BLACK);
        text2.setX((SCREENX / 2) - 80);
        text2.setY(450);

        // Action when mouse hovering
        text2.setOnMouseEntered(event -> {
            text2.setUnderline(true);
            text2.setFill(Color.RED);
            text2.setFont(menuTextSelectedFont);
            text2.setX((SCREENX / 2) - 88);


        });

        // Action when mouse exiting hover (revert action above)
        text2.setOnMouseExited(event -> {
            text2.setUnderline(false);
            text2.setFill(textColor);
            text2.setFont(menuTextFont);
            text2.setX((SCREENX / 2) - 80);


        });


// text 3
        text3.setFont(menuTextFont);
        text3.setFill(textColor);
        text3.setStroke(Color.BLACK);
        text3.setX((SCREENX / 2) - 80);
        text3.setY(600);

        // Action when mouse hovering
        text3.setOnMouseEntered(event -> {
            text3.setUnderline(true);
            text3.setFill(Color.RED);
            text3.setFont(menuTextSelectedFont);
            text3.setX((SCREENX / 2) - 88);


        });

        // Action when mouse exiting hover (revert action above)
        text3.setOnMouseExited(event -> {
            text3.setUnderline(false);
            text3.setFill(textColor);
            text3.setFont(menuTextFont);
            text3.setX((SCREENX / 2) - 80);


        });


        text3.setId("text3");
        text1.setId("text1");
        text2.setId("text2");
        root.getChildren().add(text3);
        root.getChildren().add(text1);
        root.getChildren().add(text2);


    }


    public Group getRoot() {
        //Return the Root assigned to the screen
        //Initial call of this will return the root produced in the constructor
        //Later to edit this we must create a copy of that root --> change stuff and then setRoot to that
        return this.root;
    }

    public void setRoot(Group aRoot) {
        //Reformats root to the new Root passed in
        root = new Group();
        root = aRoot;
    }

    public void addToRoot(Node aNode)
    {
        this.root.getChildren().add(aNode);
    }

    public Rectangle getTitleBorder()
    {
        return this.titleBorder;
    }

    public Rectangle getOptionBorder()
    {
        return this.optionBorder;
    }

    public Text getTitleText()
    {
        return this.titleText;
    }

    public Text getText1()
    {
        return this.text1;
    }

    public Text getText2()
    {
        return this.text2;
    }

    public Text getText3()
    {
        return this.text3;
    }
}


