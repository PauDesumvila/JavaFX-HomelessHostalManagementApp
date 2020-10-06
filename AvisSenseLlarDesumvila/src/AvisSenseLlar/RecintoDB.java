package AvisSenseLlar;

public class RecintoDB {
    private int codi;
    private String nomRecinte;
    private String direccio;
    private String propietari;
    private int numPlacesTotals;
    private int numPlacesOcupades;
    private boolean adaptatCadiraRodes;
    private boolean disposaEnfermera;

    public RecintoDB() {
    }

    public RecintoDB(int codi, String nomRecinte, String direccio, String propietari, int numPlacesTotals, int numPlacesOcupades, boolean adaptatCadiraRodes, boolean disposaEnfermera) {
        this.codi = codi;
        this.nomRecinte = nomRecinte;
        this.direccio = direccio;
        this.propietari = propietari;
        this.numPlacesTotals = numPlacesTotals;
        this.numPlacesOcupades = numPlacesOcupades;
        this.adaptatCadiraRodes = adaptatCadiraRodes;
        this.disposaEnfermera = disposaEnfermera;
    }

    @Override
    public String toString() {
        return "RecintoDB: " + '\n' +
                "Codi: " + codi + '\n' +
                "Nom recinte: " + nomRecinte + '\n' +
                "Direccio: " + direccio + '\n' +
                "Propietari: " + propietari + '\n' +
                "Numero de Places Totals: " + numPlacesTotals + '\n' +
                "Numero de Places Ocupades: " + numPlacesOcupades + '\n' +
                "Adpatat a Cadira de Rodes: " + adaptatCadiraRodes + '\n' +
                "Disposa d'Enfermera: " + disposaEnfermera + '\n';
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNomRecinte() {
        return nomRecinte;
    }

    public void setNomRecinte(String nomRecinte) {
        this.nomRecinte = nomRecinte;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getPropietari() {
        return propietari;
    }

    public void setPropietari(String propietari) {
        this.propietari = propietari;
    }

    public int getNumPlacesTotals() {
        return numPlacesTotals;
    }

    public void setNumPlacesTotals(int numPlacesTotals) {
        this.numPlacesTotals = numPlacesTotals;
    }

    public int getNumPlacesOcupades() {
        return numPlacesOcupades;
    }

    public void setNumPlacesOcupades(int numPlacesOcupades) {
        this.numPlacesOcupades = numPlacesOcupades;
    }

    public boolean isAdaptatCadiraRodes() {
        return adaptatCadiraRodes;
    }

    public void setAdaptatCadiraRodes(boolean adaptatCadiraRodes) {
        this.adaptatCadiraRodes = adaptatCadiraRodes;
    }

    public boolean isDisposaEnfermera() {
        return disposaEnfermera;
    }

    public void setDisposaEnfermera(boolean disposaEnfermera) {
        this.disposaEnfermera = disposaEnfermera;
    }
}
