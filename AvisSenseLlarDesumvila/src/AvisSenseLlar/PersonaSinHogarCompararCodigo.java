package AvisSenseLlar;

import java.util.Comparator;

public class PersonaSinHogarCompararCodigo implements Comparator<PersonaSinHogar> {
    public int compare(PersonaSinHogar psh1, PersonaSinHogar psh2){
        if(psh1.getCodigoPersonaSinHogar() < psh2.getCodigoPersonaSinHogar()) return -1;
        if(psh1.getCodigoPersonaSinHogar() > psh2.getCodigoPersonaSinHogar()) return 1;
        else return 0;
    }
}
