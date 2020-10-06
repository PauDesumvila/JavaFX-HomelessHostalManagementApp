package AvisSenseLlar;

import java.util.ArrayList;

public class PersonaSinHogarLista {

    public static ArrayList<PersonaSinHogar> listaPersonasSinHogar;

    public PersonaSinHogarLista(){
        this.listaPersonasSinHogar = new ArrayList<>();
    }

    public void verListaPersonasSinHogar(){
        System.out.println("Lista personas sin hogar: ");
        for(int i = 0; i < listaPersonasSinHogar.size(); i++){
            System.out.println(listaPersonasSinHogar.get(i));
        }
    }

    // metodo para ver si existe o no un residente con el codigo que se pasa por parametro
    public static boolean findResidente(int codi) {
        for(PersonaSinHogar psh : listaPersonasSinHogar) {
            if(psh.getCodigoPersonaSinHogar() == codi) {
                return true;
            }
        }
        return false;
    }
}