package AvisSenseLlar;

public class PersonaSinHogar {

    private String nombre, DNI, edad;
    private boolean usaSillaRuedas, necesitaEnfermera, estaIngresado;
    private int codigoRecintoIngreso;
    private int codigoPersonaSinHogar;
    private static int codigoPersonaSinHogarCount = 1;

    public PersonaSinHogar(String nombre, String DNI, String edad, boolean usaSillaRuedas, boolean necesitaEnfermera) {
        this.nombre = nombre;
        this.DNI = DNI;
        this.edad = edad;
        this.usaSillaRuedas = usaSillaRuedas;
        this.necesitaEnfermera = necesitaEnfermera;

        // inicialmente asumimos que no esta ingresado en ningun recinto
        this.estaIngresado = false;
        this.codigoPersonaSinHogar = 0;

        // asignamos un codigo automaticamente que crece de uno en uno
        codigoPersonaSinHogar = PersonaSinHogar.getNextCodigoPersonaSinHogar();

        // añadimos la persona sin hogar a la lista de personas sin hogar
        PersonaSinHogarLista.listaPersonasSinHogar.add(this);
    }

    @Override
    public String toString() {
        return "PERSONA SIN HOGAR:" + '\n' +
                "Nombre: " + nombre + '\n' +
                "DNI: " + DNI + '\n' +
                "Edad: " + edad + '\n' +
                "Usa Silla de Ruedas: " + usaSillaRuedas + '\n' +
                "Necesita Enfermera: " + necesitaEnfermera + '\n' +
                "Esta Ingresado: " + estaIngresado + '\n' +
                "Codigo Recinto Ingreso: " + codigoRecintoIngreso + '\n' +
                "Codigo Personal: " + codigoPersonaSinHogar + '\n';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public boolean isUsaSillaRuedas() {
        return usaSillaRuedas;
    }

    public void setUsaSillaRuedas(boolean usaSillaRuedas) {
        this.usaSillaRuedas = usaSillaRuedas;
    }

    public boolean isNecesitaEnfermera() {
        return necesitaEnfermera;
    }

    public void setNecesitaEnfermera(boolean necesitaEnfermera) {
        this.necesitaEnfermera = necesitaEnfermera;
    }

    public boolean isEstaIngresado() {
        return estaIngresado;
    }

    public void setEstaIngresado(boolean estaIngresado) {
        this.estaIngresado = estaIngresado;
    }

    public int getCodigoRecintoIngreso() {
        return codigoRecintoIngreso;
    }

    public void setCodigoRecintoIngreso(int codigoRecintoIngreso) {
        this.codigoRecintoIngreso = codigoRecintoIngreso;
    }

    public int getCodigoPersonaSinHogar(){
        return codigoPersonaSinHogar;
    }

    private static synchronized int getNextCodigoPersonaSinHogar(){
        return codigoPersonaSinHogarCount++;
    }
}

