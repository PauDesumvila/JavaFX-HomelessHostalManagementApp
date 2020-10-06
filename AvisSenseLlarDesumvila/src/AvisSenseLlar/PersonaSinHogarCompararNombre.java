package AvisSenseLlar;

import java.util.Comparator;

public class PersonaSinHogarCompararNombre implements Comparator<PersonaSinHogar> {
    public int compare(PersonaSinHogar psh1, PersonaSinHogar psh2){
        return psh1.getNombre().compareTo(psh2.getNombre());
    }
}
