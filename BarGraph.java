package Assignment;

import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * This is programme creates bar graph using javaFx and loops
 * This programme created on jun 14,2020 at 6:00 pm
 *
 * @author RIDHAM PATEL , 000831171
 */
public class BarGraph extends Application {

    /**
     * Start method (use this instead of main).
     *
     * @param stage The FX stage to draw on
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root);
        Canvas canvas = new Canvas(800, 800); // Set canvas Size in Pixels
        stage.setTitle("Ridham Patel  000831171"); // Set window title
        root.getChildren().add(canvas);
        stage.setScene(scene);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        // YOUR CODE STARTS HERE

        // create object of scanner class
        Scanner obj = new Scanner(System.in);


        //****input
        //get user input for title of graph using scanner
        System.out.println("Enter yout title for graph");
        String title = obj.nextLine();

        // set title in javaFx using stroketext
        gc.strokeText(title, 400, 100);


        //***input
        //get minimum value from user using scanner
        System.out.println("Enter minimum value for your vertical axis");
        int graphMinimum = obj.nextInt();

        //**input
        //get maximum value from user using scanner
        System.out.println("Enter maximum value for your vertical axis");
        int graphMaximum = obj.nextInt();

        //get graph different for vertical line to divide line
        int graphDiff = (graphMaximum - graphMinimum) / 4;

        //** process
        // use for loop to draw horizontal line on javaFx
        //draw 5 horizontal line
        //use stroke text to write vertical label
        for (int i = 1; i <= 5; i++) {
            int y = 100;
            y += i * 100;
            int x1 = i * 100;
            int j = i - 1;
            int stringLable = graphMaximum - j * graphDiff;
            // to draw horizontalline using graphic outlate
            gc.strokeLine(100, y, 700, y);
            // set value for horizontalline using stoketext
            gc.strokeText(String.valueOf(stringLable), 50, 101 + x1);
        }

        //** process
        // use while loop to get infinite input from users
        int x = 0;
        while (true) {

            // get lable from users for horizontal axis using scanner
            System.out.println("Enter a label or x to exit");
            //Need to flush the new line \n token from the keyboard Scanner variable
            obj.nextLine();
            String horizontalLabel = obj.nextLine();


            //give two option using if-else statement
            //x allow to exit from loop
            if (horizontalLabel.equalsIgnoreCase("x")) {
                break;
            } else {
                gc.strokeText(String.valueOf(horizontalLabel), 122 + x, 620);

            }

            // get value from user for lable using scanner
            System.out.println("Enter a value for this lable");
            int scale = obj.nextInt();

            //  check wether entered number is between min and max number
            if (scale > graphMinimum && scale < graphMaximum) {
                // use fillrect to draw bar graph on javaFx
                gc.fillRect(120 + x, 600 - ((scale * 100) / graphDiff), 30, (scale * 100) / graphDiff);
                //move bargraph by 50 point
                x = x + 50;
            } else {
                // use fillrect to draw bar graph on javaFx
                System.out.println(("Invalid value: must be between" + graphMinimum + " and " + graphMaximum));
            }


        }

        // YOUR CODE STOPS HERE
        stage.show();
    }

    /**
     * The actual main method that launches the app.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        launch(args);
    }
}

