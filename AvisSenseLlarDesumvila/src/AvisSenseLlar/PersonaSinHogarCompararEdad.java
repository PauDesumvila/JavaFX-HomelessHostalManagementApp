package AvisSenseLlar;

import java.util.Comparator;

public class PersonaSinHogarCompararEdad implements Comparator<PersonaSinHogar> {
    public int compare(PersonaSinHogar psh1, PersonaSinHogar psh2){
        int edad1, edad2;
        edad1 = Integer.parseInt(psh1.getEdad());
        edad2 = Integer.parseInt(psh2.getEdad());
        if(edad1 < edad2) return -1;
        if(edad1 > edad2) return 1;
        else return 0;
    }
}
