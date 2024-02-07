import java.io.IOException;

import org.hibernate.Session;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.SessionFactoryConfiguration;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Sample.fxml"));

            Scene scene = new Scene(root);

            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (IOException e) {
            
        }

    }

    public static void main(String[] args) {
        
        Session session = SessionFactoryConfiguration.getInstance().getSession();

        launch(args);
    }
}
