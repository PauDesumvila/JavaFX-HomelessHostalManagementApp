package AvisSenseLlar;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaResidentModificacioController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbCadiraRodes.getItems().addAll("SI", "NO");
        cbEnfermera.getItems().addAll("SI", "NO");
    }

    @FXML private ChoiceBox cbCadiraRodes, cbEnfermera;
    @FXML private TextField tfCodi, tfNom, tfDNI, tfEdat;
    @FXML private Button btTanca, btModifica;
    @FXML private Label lbModifica, lbError;

    // metodo para mostrar una etiqueta durante 2 segundos y luego borrarla
    private void mostraEtiqueta(Label etiqueta){
        etiqueta.setVisible(true);                                        // mostramos la etiqueta
        PauseTransition wait = new PauseTransition(Duration.seconds(2));  // le damos una pausa de 2 segundos
        wait.setOnFinished((e) -> {etiqueta.setVisible(false);});         // despues de 2 segundos la borramos
        wait.play();
    }

    @FXML
    protected void modificaResident(){
        PersonaSinHogar psh;
        int codiResident = Integer.parseInt(tfCodi.getText());

        if(PersonaSinHogarLista.findResidente(codiResident)){
            for(int i = 0; i < PersonaSinHogarLista.listaPersonasSinHogar.size(); i++){
                if(PersonaSinHogarLista.listaPersonasSinHogar.get(i).getCodigoPersonaSinHogar() == codiResident){
                    psh = PersonaSinHogarLista.listaPersonasSinHogar.get(i);

                    String nom = tfNom.getText();
                    String DNI = tfDNI.getText();
                    String edat = tfEdat.getText();
                    boolean cadiraRodes, necesitaEnfermera;

                    if(nom == null || DNI == null || edat == null || cbCadiraRodes.getValue() == null || cbEnfermera.getValue() == null){
                        lbError.setText("ERROR. NO ES PERMETEN CAMPS BUITS");
                        mostraEtiqueta(lbError);
                        tfNom.setText(""); tfDNI.setText(""); tfEdat.setText(""); cbEnfermera.setValue(null); cbCadiraRodes.setValue(null);
                    } else {
                        necesitaEnfermera = cbEnfermera.getValue() == "SI" ? true : false;
                        cadiraRodes = cbCadiraRodes.getValue() == "SI" ? true : false;
                        psh.setNombre(nom);
                        psh.setDNI(DNI);
                        psh.setEdad(edat);
                        psh.setUsaSillaRuedas(cadiraRodes);
                        psh.setNecesitaEnfermera(necesitaEnfermera);

                        mostraEtiqueta(lbModifica);
                        tfNom.setText(""); tfDNI.setText(""); tfEdat.setText(""); cbEnfermera.setValue(null); cbCadiraRodes.setValue(null);
                    }
                }
            }
        } else {
            lbError.setText("CODI ERRONI. RESIDENT NO MODIFICAT");
            mostraEtiqueta(lbError);
        }
    }


    @FXML
    protected void tancaFinestra(){
        Stage stage = (Stage)btTanca.getScene().getWindow();
        stage.close();
    }
}
