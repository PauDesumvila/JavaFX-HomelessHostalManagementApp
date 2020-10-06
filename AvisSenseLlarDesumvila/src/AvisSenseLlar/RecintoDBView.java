package AvisSenseLlar;

import java.util.List;

public class RecintoDBView {
    public void verRecinto(RecintoDB recinto) {
        System.out.println("Dades del Recinte: " + recinto);
    }

    /*public void verRecintos(List<RecintoDB> listaRecintos) {
        for (RecintoDB recinto : listaRecintos) {
            System.out.println("Dades del Recinte: " + recinto);
        }
    }*/

    public String verRecintos(List<RecintoDB> listaRecintos) {
        StringBuilder sb = new StringBuilder();
        for (RecintoDB recinto : listaRecintos) {
            sb.append("Dades del Recinte: " + recinto + "\n");
        }
        return sb.toString();
    }
}


