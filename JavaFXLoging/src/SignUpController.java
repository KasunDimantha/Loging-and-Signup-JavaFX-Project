import java.io.IOException;

import entity.UserEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import repository.UserRepository;
import service.UserService;

public class SignUpController {

    private Stage stage;
    private Scene scene;

    UserService service = new UserService();

    @FXML
    private TextField TextDOB;

    @FXML
    private TextField TextFirstName;

    @FXML
    private TextField TextLastName;

    @FXML
    private TextField TextPassword;

    @FXML
    private TextField TextTeliphoneNumber;

    @FXML
    private TextField TextUserName;

    @FXML
    private TextField TextConfomPassword;

    @FXML
    private Label LableError;

    @FXML
    private Button ButtonLogIn;

    @FXML
    private Button ButtonSignUp;

    @FXML
    void btnLogInClicked(ActionEvent event) {
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

    @FXML
    void btnSignUpClicked(ActionEvent event) {

        UserEntity entity = new UserEntity();
        entity.setFirstName(TextFirstName.getText());
        entity.setLastName(TextLastName.getText());
        entity.setDob(TextDOB.getText());
        entity.setTelNumber(Integer.parseInt(TextTeliphoneNumber.getText()));
        entity.setUserName(TextUserName.getText());
        entity.setPassword(TextPassword.getText());
        entity.setConfomePassword(TextConfomPassword.getText());

        if (TextPassword.getText().equals(TextConfomPassword.getText())) {
            Integer id = service.saveUser(entity);

            if (id != -1) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException e) {
                }
            } else {
                LableError.setText("Some details was wrong! plese try again");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Your detais was wrong, Try again");
                alert.show();
            }
        } else {
            LableError.setText("Password is not match reEnter pasword corectly");
        }

    }
}