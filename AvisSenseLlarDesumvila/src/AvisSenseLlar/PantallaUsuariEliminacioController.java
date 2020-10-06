package AvisSenseLlar;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaUsuariEliminacioController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private Button btEliminaUsuari, btTanca;
    @FXML private Label lbUsuariEliminat, lbError;
    @FXML private TextField tfUsuari;

    // metodo para mostrar una etiqueta durante 2 segundos y luego borrarla
    private void mostraEtiqueta(Label etiqueta){
        etiqueta.setVisible(true);                                        // mostramos la etiqueta
        PauseTransition wait = new PauseTransition(Duration.seconds(2));  // le damos una pausa de 2 segundos
        wait.setOnFinished((e) -> {etiqueta.setVisible(false);});         // despues de 2 segundos la borramos
        wait.play();
    }

    @FXML
    public void eliminaUsuari(){
        String usuari = tfUsuari.getText();

        if(UsuariPasswordUtility.llistaPaswords.containsKey(usuari)){
            UsuariPasswordUtility.EsborrraUsuari(usuari);
            lbUsuariEliminat.setText("USUARI ELIMNAT CORRECTAMENT");
            mostraEtiqueta(lbUsuariEliminat);
            tfUsuari.setText("");
        } else {
            lbError.setText("NOM D'USUARI INCORRECTE");
            mostraEtiqueta(lbError);
            tfUsuari.setText("");
        }
    }

    @FXML
    protected void tancaFinestra(){
        Stage stage = (Stage)btTanca.getScene().getWindow();
        stage.close();
    }
}
