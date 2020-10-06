package AvisSenseLlar;

import java.util.Comparator;

public class RecintoCompararPlazas implements Comparator<Recinto> {
    public int compare(Recinto r1, Recinto r2){
        if(r1.getNumPlazasTotales() < r2.getNumPlazasTotales()) return -1;
        if(r1.getNumPlazasTotales() > r2.getNumPlazasTotales()) return 1;
        else return 0;
    }
}
