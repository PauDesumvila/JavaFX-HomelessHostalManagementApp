package AvisSenseLlar;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaResidentAltaController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbCadiraRodes.getItems().addAll("SI", "NO");
        cbEnfermera.getItems().addAll("SI", "NO");
    }

    @FXML private TextField tfNom, tfDNI, tfEdat;
    @FXML private Button btAlta, btTanca;
    @FXML private Label lbError, lbAlta;
    @FXML private ChoiceBox cbEnfermera, cbCadiraRodes;

    // metodo para mostrar una etiqueta durante 2 segundos y luego borrarla
    private void mostraEtiqueta(Label etiqueta){
        etiqueta.setVisible(true);                                        // mostramos la etiqueta
        PauseTransition wait = new PauseTransition(Duration.seconds(2));  // le damos una pausa de 2 segundos
        wait.setOnFinished((e) -> {etiqueta.setVisible(false);});         // despues de 2 segundos la borramos
        wait.play();
    }

    @FXML
    protected void altaResident(){
        String nom = tfNom.getText();
        String DNI = tfDNI.getText();
        String edat = tfEdat.getText();

        boolean cadiraRodes, necesitaEnfermera;

        if(nom == null || DNI == null || edat == null || cbCadiraRodes.getValue() == null || cbEnfermera.getValue() == null){
            mostraEtiqueta(lbError);
            tfNom.setText(""); tfDNI.setText(""); tfEdat.setText(""); cbEnfermera.setValue(null); cbCadiraRodes.setValue(null);
        } else {
            necesitaEnfermera = cbEnfermera.getValue() == "SI" ? true : false;
            cadiraRodes = cbCadiraRodes.getValue() == "SI" ? true : false;

            PersonaSinHogar psh = new PersonaSinHogar(nom, DNI, edat, cadiraRodes, necesitaEnfermera);
            mostraEtiqueta(lbAlta);
            tfNom.setText(""); tfDNI.setText(""); tfEdat.setText(""); cbEnfermera.setValue(null); cbCadiraRodes.setValue(null);
        }
    }

    @FXML
    protected void tancaFinestra(){
        Stage stage = (Stage)btTanca.getScene().getWindow();
        stage.close();
    }
}
