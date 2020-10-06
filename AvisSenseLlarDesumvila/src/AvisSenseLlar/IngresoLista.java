package AvisSenseLlar;

import java.util.ArrayList;

public class IngresoLista {

    public static ArrayList<Ingreso> listaIngresos;

    public IngresoLista(){
        this.listaIngresos = new ArrayList<>();
    }

    public void verListaIngresos(){
        System.out.println("Lista de ingresos; ");
        for(int i = 0; i < listaIngresos.size(); i++){
            System.out.println(listaIngresos.get(i));
        }
    }
}
