
import java.io.IOException;

import entity.UserEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoggedInController {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button ButtonLogOut;

    @FXML
    private Label LabelChannel;

    @FXML
    private Label LabelWelcome;

    @FXML
    void btnLogOutClicked(ActionEvent event) {

        

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }

    }

    public void setLable(UserEntity entity) {
        LabelChannel.setText("Hi " + entity.getFirstName() + " " + entity.getLastName() + "...");
    }



}