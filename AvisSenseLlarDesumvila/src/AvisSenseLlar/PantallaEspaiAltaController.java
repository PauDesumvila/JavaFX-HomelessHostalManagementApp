package AvisSenseLlar;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaEspaiAltaController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbCadiraRodes.getItems().addAll("SI", "NO");
        cbEnfermera.getItems().addAll("SI", "NO");
    }

    @FXML private TextField tfNomRecinte, tfDireccio, tfPropietari, tfPlacesTotals;
    @FXML private ChoiceBox cbCadiraRodes, cbEnfermera;
    @FXML private Button btAlta, btTanca;
    @FXML private Label lbAlta, lbError;

    // metodo para mostrar una etiqueta durante 2 segundos y luego borrarla
    private void mostraEtiqueta(Label etiqueta){
        etiqueta.setVisible(true);                                        // mostramos la etiqueta
        PauseTransition wait = new PauseTransition(Duration.seconds(2));  // le damos una pausa de 2 segundos
        wait.setOnFinished((e) -> {etiqueta.setVisible(false);});         // despues de 2 segundos la borramos
        wait.play();
    }

    @FXML
    protected void altaEspai(){
        String nomRecinte, direccio, propietari;
        int placesTotals;
        boolean cadiraRodes, enfermera;
        nomRecinte = tfNomRecinte.getText();
        direccio = tfDireccio.getText();
        propietari = tfPropietari.getText();
        if(nomRecinte == null || direccio == null || propietari == null || cbCadiraRodes.getValue() == null || cbEnfermera.getValue() == null){
            lbError.setText("ERROR. NO ES PERMETEN CAMPS BUITS");
            mostraEtiqueta(lbError);
            tfNomRecinte.setText(""); tfDireccio.setText(""); tfPropietari.setText(""); tfPlacesTotals.setText("");
            cbEnfermera.setValue(null); cbCadiraRodes.setValue(null);
        } else {
            placesTotals = Integer.parseInt(tfPlacesTotals.getText());
            cadiraRodes = cbCadiraRodes.getValue() == "SI" ? true : false;
            enfermera = cbEnfermera.getValue() == "SI" ? true : false;

            Recinto recinto = new Recinto(nomRecinte, direccio, propietari, placesTotals, cadiraRodes, enfermera);
            mostraEtiqueta(lbAlta);
            tfNomRecinte.setText(""); tfDireccio.setText(""); tfPropietari.setText(""); tfPlacesTotals.setText("");
            cbEnfermera.setValue(null); cbCadiraRodes.setValue(null);
        }
    }

    @FXML
    protected void tancaFinestra(){
        Stage stage = (Stage)btTanca.getScene().getWindow();
        stage.close();
    }
}
