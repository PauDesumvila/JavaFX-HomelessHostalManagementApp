package AvisSenseLlar;

public class PersonaSinHogarDB {
    private int codi;
    private String nom;
    private String DNI;
    private int edat;
    private boolean cadiraRodes;
    private boolean necesitaEnfermera;
    private boolean estaIngresat;
    private int codiRecienteIngres;

    public PersonaSinHogarDB() {
    }

    public PersonaSinHogarDB(int codi, String nom, String DNI, int edat, boolean cadiraRodes, boolean necesitaEnfermera, boolean estaIngresat, int codiRecienteIngres) {
        this.codi = codi;
        this.nom = nom;
        this.DNI = DNI;
        this.edat = edat;
        this.cadiraRodes = cadiraRodes;
        this.necesitaEnfermera = necesitaEnfermera;
        this.estaIngresat = estaIngresat;
        this.codiRecienteIngres = codiRecienteIngres;
    }

    @Override
    public String toString() {
        return "PersonaSinHogarDB: " + '\n' +
                "Codi: " + codi + '\n' +
                "Nom: " + nom + '\n' +
                "DNI: " + DNI + '\n' +
                "Edat: " + edat + '\n' +
                "Cadira de Rodes: " + cadiraRodes + '\n' +
                "Necesita Enfermera: " + necesitaEnfermera + '\n' +
                "Esta Ingresat: " + estaIngresat + '\n' +
                "Codi Recinte Ingres: " + codiRecienteIngres + '\n';
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public boolean isCadiraRodes() {
        return cadiraRodes;
    }

    public void setCadiraRodes(boolean cadiraRodes) {
        this.cadiraRodes = cadiraRodes;
    }

    public boolean isNecesitaEnfermera() {
        return necesitaEnfermera;
    }

    public void setNecesitaEnfermera(boolean necesitaEnfermera) {
        this.necesitaEnfermera = necesitaEnfermera;
    }

    public boolean isEstaIngresat() {
        return estaIngresat;
    }

    public void setEstaIngresat(boolean estaIngresat) {
        this.estaIngresat = estaIngresat;
    }

    public int getCodiRecienteIngres() {
        return codiRecienteIngres;
    }

    public void setCodiRecienteIngres(int codiRecienteIngres) {
        this.codiRecienteIngres = codiRecienteIngres;
    }
}
