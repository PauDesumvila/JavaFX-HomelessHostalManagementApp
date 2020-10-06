package AvisSenseLlar;

import java.util.ArrayList;

public class RecintoLista {

    public static ArrayList<Recinto> listaRecintos;

    public RecintoLista(){
        this.listaRecintos = new ArrayList<>();
    }

    public void verListaRecintos(){
        System.out.println("Lista de Recintos; ");
        for(int i = 0; i < listaRecintos.size(); i++){
            System.out.println(listaRecintos.get(i));
        }
    }

    // metodo para ver si existe o no un recinto con el codigo que se pasa por parametro
    public static boolean findRecinto(int codi) {
        for(Recinto recinto : listaRecintos) {
            if(recinto.getCodigoRecinto() == codi) {
                return true;
            }
        }
        return false;
    }
}