package AvisSenseLlar;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PantallaPrincipalController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        cbResidents.getItems().addAll("NOM", "EDAT", "CODI");
        cbEspais.getItems().addAll("NOM", "PLAÇES", "CODI");

        if(CurrentUserUtility.currentUser == "COORDINADOR"){
            miUsuariAlta.setVisible(false);
            miUsuariModifica.setVisible(false);
            miUsuariElimina.setVisible(false);
        }
        if(CurrentUserUtility.currentUser == "BASIC"){
            miUsuariAlta.setVisible(false);
            miUsuariModifica.setVisible(false);
            miUsuariElimina.setVisible(false);
            tfCodiResident.setVisible(false);
            tfCodiEspai.setVisible(false);
            tfCodiIngres.setVisible(false);
            btAlta.setVisible(false);
            btBaixa.setVisible(false);
            dpAlta.setVisible(false);
            dpBaixa.setVisible(false);
            lb1.setVisible(false);
            lb2.setVisible(false);
            lb3.setVisible(false);
            lb4.setVisible(false);
            lb5.setVisible(false);
        }
    }

    @FXML private MenuItem miUsuariAlta, miUsuariModifica, miUsuariElimina, miCanviUsuari, miSortir;
    @FXML private Button btLlistaResidents, btLlistaEspais, btLlistaIngresos, btAlta, btBaixa;
    @FXML private TextField tfCodiResident, tfCodiEspai, tfCodiIngres;
    @FXML private DatePicker dpAlta, dpBaixa;
    @FXML private Label lbAltaCorrecte, lbBaixaCorrecte, lb1, lb2, lb3, lb4, lb5;
    @FXML public TextArea taVisualitza;
    @FXML private ChoiceBox cbResidents, cbEspais;

    // metodo para mostrar una etiqueta durante 2 segundos y luego borrarla
    private void mostraEtiqueta(Label etiqueta){
        etiqueta.setVisible(true);                                        // mostramos la etiqueta
        PauseTransition wait = new PauseTransition(Duration.seconds(2));  // le damos una pausa de 2 segundos
        wait.setOnFinished((e) -> {etiqueta.setVisible(false);});         // despues de 2 segundos la borramos
        wait.play();
    }

    @FXML
    protected void obrirFinestraLogin(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pantalla_login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
            Stage stage = new Stage();
            stage.setTitle("AVIS SENSE LLAR I SENSE CORONA");
            stage.setScene(scene);
            stage.show();
            Stage stage2 = (Stage)btLlistaResidents.getScene().getWindow();
            stage2.close();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    protected void obrirFinestraUsuariAlta(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pantalla_usuari_alta.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("ALTA D'USUARI");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    protected void obrirFinestraUsuariModifica(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pantalla_usuari_modificacio.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("MODIFICACIO D'USUARI");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    protected void obrirFinestraUsuariElimina(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pantalla_usuari_eliminacio.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("ELIMINACIO D'USUARI");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    protected void obrirFinestraEspaiAlta(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pantalla_espai_alta.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = new Stage();
            stage.setTitle("ALTA D'ESPAI");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    protected void obrirFinestraEspaiModifica(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pantalla_espai_modificacio.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = new Stage();
            stage.setTitle("MODIFICACIO D'ESPAI");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    protected void obrirFinestraEspaiElimina(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pantalla_espai_eliminacio.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("ELIMINACIO D'ESPAI");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    protected void obrirFinestraResidentAlta(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pantalla_resident_alta.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = new Stage();
            stage.setTitle("ALTA RESIDENT");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    protected void obrirFinestraResidentModifica(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pantalla_resident_modificacio.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            Stage stage = new Stage();
            stage.setTitle("MODIFICACIO RESIDENT");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    protected void obrirFinestraResidentElimina(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pantalla_resident_eliminacio.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage stage = new Stage();
            stage.setTitle("ELIMINACIO RESIDENT");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }

    @FXML
    protected void visualitzaLlistaResidents(MouseEvent event){
        taVisualitza.setText("");
        if(cbResidents.getValue().toString() == "EDAT"){
            PersonaSinHogarCompararEdad p = new PersonaSinHogarCompararEdad();
            Collections.sort(PersonaSinHogarLista.listaPersonasSinHogar, p);
            Iterator<PersonaSinHogar> i = PersonaSinHogarLista.listaPersonasSinHogar.iterator();
            while(i.hasNext()){
                String element = i.next().toString();
                taVisualitza.appendText(element + "\n");
            }
        }
        if(cbResidents.getValue().toString() == "CODI"){
            PersonaSinHogarCompararCodigo p = new PersonaSinHogarCompararCodigo();
            Collections.sort(PersonaSinHogarLista.listaPersonasSinHogar, p);
            Iterator<PersonaSinHogar> i = PersonaSinHogarLista.listaPersonasSinHogar.iterator();
            while(i.hasNext()){
                String element = i.next().toString();
                taVisualitza.appendText(element + "\n");
            }
        }
        if(cbResidents.getValue().toString() == "NOM"){
            PersonaSinHogarCompararNombre p = new PersonaSinHogarCompararNombre();
            Collections.sort(PersonaSinHogarLista.listaPersonasSinHogar, p);
            Iterator<PersonaSinHogar> i = PersonaSinHogarLista.listaPersonasSinHogar.iterator();
            while(i.hasNext()){
                String element = i.next().toString();
                taVisualitza.appendText(element + "\n");
            }
        }
    }

    @FXML
    protected void visualitzaLlistaEspais(MouseEvent event){
        taVisualitza.setText("");
        if(cbEspais.getValue().toString() == "NOM"){
            RecintoCompararNombre r = new RecintoCompararNombre();
            Collections.sort(RecintoLista.listaRecintos, r);
            Iterator<Recinto> i = RecintoLista.listaRecintos.iterator();
            while(i.hasNext()){
                String element = i.next().toString();
                taVisualitza.appendText(element + "\n");
            }
        }
        if(cbEspais.getValue().toString() == "PLAÇES"){
            RecintoCompararPlazas r = new RecintoCompararPlazas();
            Collections.sort(RecintoLista.listaRecintos, r);
            Iterator<Recinto> i = RecintoLista.listaRecintos.iterator();
            while(i.hasNext()){
                String element = i.next().toString();
                taVisualitza.appendText(element + "\n");
            }
        }
        if(cbEspais.getValue().toString() == "CODI"){
            RecintoCompararCodigo r = new RecintoCompararCodigo();
            Collections.sort(RecintoLista.listaRecintos, r);
            Iterator<Recinto> i = RecintoLista.listaRecintos.iterator();
            while(i.hasNext()){
                String element = i.next().toString();
                taVisualitza.appendText(element + "\n");
            }
        }
    }

    @FXML
    protected void visualitzaLlistaIngresos(MouseEvent event){
        taVisualitza.setText("");
        Iterator<Ingreso> i = IngresoLista.listaIngresos.iterator();
        while(i.hasNext()){
            String element = i.next().toString();
            taVisualitza.appendText(element + "\n");
        }
    }

    @FXML
    protected void altaIngres(MouseEvent event){
        int codiResident, codiRecinte;
        LocalDate dataIngres;
        codiResident = Integer.parseInt(tfCodiResident.getText());
        codiRecinte = Integer.parseInt(tfCodiEspai.getText());
        dataIngres = dpAlta.getValue();
        Ingreso.addIngresoCodis(codiRecinte, codiResident, dataIngres);
        mostraEtiqueta(lbAltaCorrecte);
        tfCodiResident.setText(""); tfCodiEspai.setText(""); dpAlta.getEditor().clear();
    }

    @FXML
    protected void baixaIngres(MouseEvent event){
        int codiIngres;
        LocalDate dataBaixa;
        codiIngres = Integer.parseInt(tfCodiIngres.getText());
        dataBaixa = dpBaixa.getValue();
        Ingreso.addAlta(codiIngres, dataBaixa);
        mostraEtiqueta(lbBaixaCorrecte);
        tfCodiIngres.setText(""); dpBaixa.getEditor().clear();
    }

    /*@FXML
    protected void visualitzaLlistaResidents(MouseEvent event){
        taVisualitza.setText(""); // limpiamos el TextArea
        PersonaSinHogarDBController pshController = new PersonaSinHogarDBController(); // instanciamos el controller DAO para usarlo
        taVisualitza.setText(pshController.verPersonasSinHogar()); // imprimimos en el TextArea el resultado
    }

    @FXML
    protected void visualitzaLlistaEspais(MouseEvent event){
        taVisualitza.setText(""); // limpiamos el TextArea
        RecintoDBController recintoController = new RecintoDBController(); // instanciamos el controller DAO para usarlo
        taVisualitza.setText(recintoController.verRecintos());
    }*/

    @FXML
    public void sortir(){
        Platform.exit();
    }
}
