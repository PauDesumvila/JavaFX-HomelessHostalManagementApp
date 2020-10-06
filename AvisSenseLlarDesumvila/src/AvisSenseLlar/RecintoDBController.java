package AvisSenseLlar;

import java.util.ArrayList;
import java.util.List;

public class RecintoDBController {

    private RecintoDBView vista = new RecintoDBView();

    public RecintoDBController() {
    }

    //llama al DAO para guardar un recinto
    public void registrar(RecintoDB recinto ) {
        InterfazRecintoDAO dao = new RecintoDAOImplementacion();
        dao.registrar(recinto);
    }

    //llama al DAO para actualizar un recinto
    public void actualizar(RecintoDB recinto) {
        InterfazRecintoDAO dao = new  RecintoDAOImplementacion();
        dao.actualizar(recinto);
    }

    //llama al DAO para eliminar un recinto
    public void eliminar(RecintoDB recinto) {
        InterfazRecintoDAO dao = new  RecintoDAOImplementacion();
        dao.eliminar(recinto);
    }

    //llama al DAO para obtener todos los recintos y luego los muestra en la vista
    public String verRecintos(){
        List<RecintoDB> listaRecintos = new ArrayList<RecintoDB>();
        InterfazRecintoDAO dao = new  RecintoDAOImplementacion();
        listaRecintos=dao.obtener();
        return vista.verRecintos(listaRecintos);
    }

}
