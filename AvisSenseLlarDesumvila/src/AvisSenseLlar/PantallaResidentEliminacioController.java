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

public class PantallaResidentEliminacioController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private Button btTanca, btElimina;
    @FXML private TextField tfCodi;
    @FXML Label lbElimina, lbError;

    // metodo para mostrar una etiqueta durante 2 segundos y luego borrarla
    private void mostraEtiqueta(Label etiqueta){
        etiqueta.setVisible(true);                                        // mostramos la etiqueta
        PauseTransition wait = new PauseTransition(Duration.seconds(2));  // le damos una pausa de 2 segundos
        wait.setOnFinished((e) -> {etiqueta.setVisible(false);});         // despues de 2 segundos la borramos
        wait.play();
    }

    @FXML
    protected void eliminaResident(){
        PersonaSinHogar psh;
        int codiResident = Integer.parseInt(tfCodi.getText());

        if(PersonaSinHogarLista.findResidente(codiResident)){
            for(int i = 0; i < PersonaSinHogarLista.listaPersonasSinHogar.size(); i++){
                if(PersonaSinHogarLista.listaPersonasSinHogar.get(i).getCodigoPersonaSinHogar() == codiResident){
                    psh = PersonaSinHogarLista.listaPersonasSinHogar.get(i);
                    PersonaSinHogarLista.listaPersonasSinHogar.remove(psh);   // lo borramos de la lista de recintos
                    mostraEtiqueta(lbElimina);
                    tfCodi.setText("");
                }
            }
        } else {
            mostraEtiqueta(lbError);
        }
    }

    @FXML
    protected void tancaFinestra(){
        Stage stage = (Stage)btTanca.getScene().getWindow();
        stage.close();
    }
}
