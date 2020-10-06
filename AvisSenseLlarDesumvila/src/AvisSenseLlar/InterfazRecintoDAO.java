package AvisSenseLlar;

import java.util.List;

public interface InterfazRecintoDAO {
    public boolean registrar(RecintoDB recinto);
    public List<RecintoDB> obtener();
    public boolean actualizar(RecintoDB recinto);
    public boolean eliminar(RecintoDB recinto);
}
