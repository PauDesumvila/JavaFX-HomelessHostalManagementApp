package AvisSenseLlar;

import java.time.LocalDate;
import java.util.Date;

public class Ingreso {

    private Recinto recinto;
    private PersonaSinHogar personaSinHogar;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private int codigoIngreso;
    private static int codigoIngresoCount = 1;

    // inicializamos el ingreso pero dejamos la fecha de salida vacia de momento.
    public Ingreso(Recinto recinto, PersonaSinHogar personaSinHogar, LocalDate fechaEntrada) {
        this.recinto = recinto;
        this.personaSinHogar = personaSinHogar;
        this.fechaEntrada = fechaEntrada;

        // assignamos un codigo de ingreso que crece de uno en uno
        codigoIngreso = Ingreso.getNextCodigoIngreso();

        // guardamos que la persona ha sido ingresada
        personaSinHogar.setEstaIngresado(true);

        // guardamos que una plaza del recinto ha sido ocupada
        recinto.numPlazasOcupadas++;

        // guardamos la persona en la lista de personas del recinto
        recinto.listaPersonasSinHogar.add(personaSinHogar);

        // guardamos el ingreso en la lista de ingresos
        IngresoLista.listaIngresos.add(this);

        // guardamos el codigo de recinto donde la persona esta ingresada
        personaSinHogar.setCodigoRecintoIngreso(recinto.getCodigoRecinto());
    }

    public static void addIngreso(Recinto r, PersonaSinHogar psh, LocalDate fechaEntrada){
        Ingreso i = new Ingreso(r, psh, fechaEntrada);
    }

    public static void addIngresoCodis(int codigoRecinto, int codigoPersonaSinHogar, LocalDate fechaEntrada){
        Recinto r;
        PersonaSinHogar psh;
        for(int i = 0; i < RecintoLista.listaRecintos.size(); i++){
            for(int j = 0; j < PersonaSinHogarLista.listaPersonasSinHogar.size(); j++){
                if(RecintoLista.listaRecintos.get(i).getCodigoRecinto() == codigoRecinto){
                    r = RecintoLista.listaRecintos.get(i);
                    if(PersonaSinHogarLista.listaPersonasSinHogar.get(j).getCodigoPersonaSinHogar() == codigoPersonaSinHogar){
                        psh = PersonaSinHogarLista.listaPersonasSinHogar.get(j);
                        addIngreso(r, psh, fechaEntrada);
                    }
                }
            }
        }
    }

    public static void addAlta(int codigoIngreso, LocalDate fechaAlta){
        Ingreso in;
        for(int i = 0; i < IngresoLista.listaIngresos.size(); i++){
            if(IngresoLista.listaIngresos.get(i).getCodigoIngreso() == codigoIngreso){
                in = IngresoLista.listaIngresos.get(i);

                // guardamos la fecha de alta en el ingreso
                in.setFechaSalida(fechaAlta);

                // guardamos que la persona ya no esta ingresada
                in.getPersonaSinHogar().setEstaIngresado(false);

                // cambiamos el codigo del recinto ingreso a 0 (no esta ingreado)
                in.getPersonaSinHogar().setCodigoRecintoIngreso(0);

                // guardamos que una plaza ha quedado libre
                in.getRecinto().numPlazasOcupadas--;
            }
        }
    }

    @Override
    public String toString() {
        return  "INGRESO" + '\n' +
                "Codigo Recinto: " + recinto.getCodigoRecinto() + '\n' +
                "Codigo Persona Sin Hogar: " + personaSinHogar.getCodigoPersonaSinHogar() + '\n' +
                "Fecha Entrada: " + fechaEntrada + '\n' +
                "Fecha Salida: " + fechaSalida + '\n' +
                "Codigo Ingreso: " + codigoIngreso + '\n';
    }

    public Recinto getRecinto() {
        return recinto;
    }

    public void setRecinto(Recinto recinto) {
        this.recinto = recinto;
    }

    public PersonaSinHogar getPersonaSinHogar() {
        return personaSinHogar;
    }

    public void setPersonaSinHogar(PersonaSinHogar personaSinHogar) {
        this.personaSinHogar = personaSinHogar;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getCodigoIngreso(){
        return codigoIngreso;
    }

    private static synchronized int getNextCodigoIngreso(){
        return codigoIngresoCount++;
    }
}