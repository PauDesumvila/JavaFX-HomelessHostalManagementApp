package AvisSenseLlar;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaLoginController implements Initializable {

    @FXML private Button btLogin;
    @FXML private TextField tfUsuari;
    @FXML private PasswordField pfPassword;
    @FXML private Label lbError1, lbError2;
    @FXML private ImageView ivLogo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image("logo.png");
        ivLogo.setImage(image);
    }

    @FXML
    protected void login(MouseEvent event){
        UsuariPasswordUtility upw = new UsuariPasswordUtility();
        String usuari = tfUsuari.getText();
        String password = pfPassword.getText();
        String pass = upw.llistaPaswords.get(usuari);
        String currentUser = upw.llistaUsuaris.get(usuari);

        if(upw.llistaPaswords.containsKey(usuari) && pass.equals(password)){
            try{
                CurrentUserUtility.currentUser = currentUser;
                Parent parent = FXMLLoader.load(getClass().getResource("pantalla_principal.fxml"));
                Scene scene = new Scene(parent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setTitle("AVIS SENSE LLAR I SENSE CORONA");
                window.setScene(scene);
                window.show();
            } catch(IOException ioe){
                ioe.printStackTrace();
            }
        } else {
            lbError1.setVisible(true);
            lbError2.setVisible(true);  // mostramos la etiqueta
            PauseTransition wait = new PauseTransition(Duration.seconds(3));
            wait.setOnFinished((e) -> {lbError1.setVisible(false);});
            wait.play();
            PauseTransition wait2 = new PauseTransition(Duration.seconds(3));
            wait2.setOnFinished((e) -> {lbError2.setVisible(false);});
            wait2.play();
            tfUsuari.setText(""); pfPassword.setText("");
        }
    }
}
