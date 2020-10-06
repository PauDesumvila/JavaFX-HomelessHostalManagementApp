package AvisSenseLlar;

import java.util.Comparator;

public class RecintoCompararNombre implements Comparator<Recinto> {
    public int compare(Recinto r1, Recinto r2){
        return r1.getNombreRecinto().compareTo(r2.getNombreRecinto());
    }
}
