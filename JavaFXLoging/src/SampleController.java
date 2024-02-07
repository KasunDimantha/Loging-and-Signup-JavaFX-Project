import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UserService;

import java.io.IOException;

import entity.UserEntity;
import javafx.event.ActionEvent;

public class SampleController {

    private Stage stage;
    private Scene scene;

    UserService service = new UserService();
    LoggedInController loggedInController = new LoggedInController();

    @FXML
    private Button ButtonLogIn;

    @FXML
    private Button ButtonSignUp;

    @FXML
    private PasswordField TextPassword;

    @FXML
    private TextField TextUserName;

    @FXML
    private Label LableError;

    @FXML
    void btnLoggedInClicked(ActionEvent event) throws IOException {

        UserEntity entity = new UserEntity();
        entity.setUserName(TextUserName.getText());
        entity.setPassword(TextPassword.getText());

        Boolean bool = service.authonticationUser(entity);

        if (bool) {
            Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);            
            stage.setScene(scene);
            UserEntity entity1 = service.findUser(TextPassword.getText());
            loggedInController.setLable(entity1);
            stage.show();
        } else {
            LableError.setText("Some details was wrong! plese try again");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Your detais was wrong, Try again");
            alert.show();
        }

    }

    @FXML
    void btnSignUpClicked(ActionEvent event) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }

    }

}