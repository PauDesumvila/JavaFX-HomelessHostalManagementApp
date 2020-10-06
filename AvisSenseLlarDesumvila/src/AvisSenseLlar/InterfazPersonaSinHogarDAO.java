package AvisSenseLlar;

import java.util.List;

public interface InterfazPersonaSinHogarDAO {
    public boolean registrar(PersonaSinHogarDB psh);
    public List<PersonaSinHogarDB> obtener();
    public boolean actualizar(PersonaSinHogarDB psh);
    public boolean eliminar(PersonaSinHogarDB psh);
}
