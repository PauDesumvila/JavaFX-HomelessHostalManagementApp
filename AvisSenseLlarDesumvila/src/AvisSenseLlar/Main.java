package AvisSenseLlar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("pantalla_login.fxml"));
        primaryStage.setTitle("AVIS SENSE LLAR I SENSE CORONA");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();

        // instanciamos las listas para poder usarlas
        PersonaSinHogarLista listaPersonasSinHogar = new PersonaSinHogarLista();
        RecintoLista listaRecintos = new RecintoLista();
        IngresoLista listaIngresos = new IngresoLista();

        PersonaSinHogar psh1 = new PersonaSinHogar("Perico Palotes", "40555444Y", "50", false, false);
        PersonaSinHogar psh2 = new PersonaSinHogar("Julian Ramos", "30888111G", "40", false, false);
        PersonaSinHogar psh3 = new PersonaSinHogar("Maria Garcia", "420666444F", "54", true, false);
        PersonaSinHogar psh4 = new PersonaSinHogar("Andrea Pazos", "20333444L", "59", true, true);

        Recinto r1 = new Recinto("Hostal La Paloma", "C/ Gran Via 200", "Ajuntament de Barcelona", 20, true, true);
        Recinto r2 = new Recinto("Gimnas La Flor", "C/ Arago 120", "Diputacio de Barcelona", 10, false, false);
        Recinto r3 = new Recinto("Hotel El Velero", "C/ Valencia 435", "Velero S.A.", 50, false, true);
        Recinto r4 = new Recinto("Hotel La Barca", "C/ Sicilia 44", "Barca S.L.", 15, true, false);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
