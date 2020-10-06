package AvisSenseLlar;

import java.util.ArrayList;

public class Recinto {

    private String nombreRecinto, direccion, propietario;
    public int numPlazasTotales, numPlazasOcupadas;
    private boolean adaptadoSillasRuedas, disponeEnfermera;
    public ArrayList<PersonaSinHogar> listaPersonasSinHogar;
    private int codigoRecinto;
    private static int codigoRecintoCount = 1;

    public Recinto(String nombreRecinto, String direccion, String propietario, int numPlazasTotales, boolean adaptadoSillasRuedas, boolean disponeEnfermera) {
        this.nombreRecinto = nombreRecinto;
        this.direccion = direccion;
        this.propietario = propietario;
        this.numPlazasTotales = numPlazasTotales;
        this.adaptadoSillasRuedas = adaptadoSillasRuedas;
        this.disponeEnfermera = disponeEnfermera;

        // inicialmente asumimos que el recinto esta vacio.
        this.numPlazasOcupadas = 0;

        // inicializamos el array con la lista de personas sin hogar en un recinto concreto.
        this.listaPersonasSinHogar = new ArrayList<>();

        // assignamos un codigo de recinto automaticamente que crece de uno en uno
        codigoRecinto = Recinto.getNextCodigoRecinto();

        // añadimos el recinto a la lista de recintos
        RecintoLista.listaRecintos.add(this);
    }

    @Override
    public String toString() {
        return  "RECINTO: " + '\n' +
                "Nombre del Recinto: " + nombreRecinto + '\n' +
                "Direccion: " + direccion + '\n' +
                "Propietario: " + propietario + '\n' +
                "Numero de Plazas Totales: " + numPlazasTotales + '\n' +
                "Numero de Plazas Ocupadas: " + numPlazasOcupadas + '\n' +
                "Adaptado para Silla de Ruedas: " + adaptadoSillasRuedas + '\n' +
                "Dispone de Enfermera: " + disponeEnfermera + '\n' +
                "Codigo de Recinto: " + codigoRecinto + '\n';
    }

    public String getNombreRecinto() {
        return nombreRecinto;
    }

    public void setNombreRecinto(String nombreRecinto) {
        this.nombreRecinto = nombreRecinto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getNumPlazasTotales() {
        return numPlazasTotales;
    }

    public void setNumPlazasTotales(int numPlazasTotales) {
        this.numPlazasTotales = numPlazasTotales;
    }

    public int getNumPlazasOcupadas() {
        return numPlazasOcupadas;
    }

    public void setNumPlazasOcupadas(int numPlazasOcupadas) {
        this.numPlazasOcupadas = numPlazasOcupadas;
    }

    public boolean isAdaptadoSillasRuedas() {
        return adaptadoSillasRuedas;
    }

    public void setAdaptadoSillasRuedas(boolean adaptadoSillasRuedas) {
        this.adaptadoSillasRuedas = adaptadoSillasRuedas;
    }

    public boolean isDisponeEnfermera() {
        return disponeEnfermera;
    }

    public void setDisponeEnfermera(boolean disponeEnfermera) {
        this.disponeEnfermera = disponeEnfermera;
    }

    public int getCodigoRecinto(){
        return codigoRecinto;
    }

    private static synchronized int getNextCodigoRecinto(){
        return codigoRecintoCount++;
    }
}
