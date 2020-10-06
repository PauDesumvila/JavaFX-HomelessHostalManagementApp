package AvisSenseLlar;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaUsuariAltaController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbTipusUsuari.getItems().addAll("ADMIN", "COORDINADOR", "BASIC");
    }

    @FXML private ChoiceBox cbTipusUsuari;
    @FXML private TextField tfUsuari, tfPassword;
    @FXML private Button btAltaUsuari, btTanca;
    @FXML private Label lbError1, lbError2, lbUsuariAfegit;

    // metodo para mostrar una etiqueta durante 2 segundos y luego borrarla
    private void mostraEtiqueta(Label etiqueta){
        etiqueta.setVisible(true);                                        // mostramos la etiqueta
        PauseTransition wait = new PauseTransition(Duration.seconds(3));  // le damos una pausa de 2 segundos
        wait.setOnFinished((e) -> {etiqueta.setVisible(false);});         // despues de 2 segundos la borramos
        wait.play();
    }

    @FXML
    public void afegeixUsuari(MouseEvent event){
        String usuari, password, tipusUsuari;
        usuari = tfUsuari.getText();
        password = tfPassword.getText();
        tipusUsuari = cbTipusUsuari.getValue().toString();

        if(tfUsuari.getText().equals("") || tfPassword.getText().equals("")){
            lbError1.setText("USUARI NO REGISTRAT");
            lbError2.setText("NO ES PERMETEN CAMPS BUITS");
            mostraEtiqueta(lbError1);
            mostraEtiqueta(lbError2);
            tfUsuari.setText("");
            tfPassword.setText("");
        } else if(UsuariPasswordUtility.llistaPaswords.containsKey(usuari)){
            lbError1.setText("USUARI NO REGISTRAT");
            lbError2.setText("NO ES PERMETEN NOMS REPETITS");
            mostraEtiqueta(lbError1);
            mostraEtiqueta(lbError2);
            tfUsuari.setText("");
            tfPassword.setText("");
        } else {
            UsuariPasswordUtility.AgefeixUsuari(usuari, password, tipusUsuari);
            lbUsuariAfegit.setText("USUARI AFEGIT CORRECTAMENT");
            mostraEtiqueta(lbUsuariAfegit);
            tfUsuari.setText("");
            tfPassword.setText("");
        }
    }

    @FXML
    protected void tancaFinestra(){
        Stage stage = (Stage)btTanca.getScene().getWindow();
        stage.close();
    }
}
