package AvisSenseLlar;

import java.util.Comparator;

public class RecintoCompararCodigo implements Comparator<Recinto> {
    public int compare(Recinto r1, Recinto r2){
        if(r1.getCodigoRecinto() < r2.getCodigoRecinto()) return -1;
        if(r1.getCodigoRecinto() > r2.getCodigoRecinto()) return 1;
        else return 0;
    }
}
