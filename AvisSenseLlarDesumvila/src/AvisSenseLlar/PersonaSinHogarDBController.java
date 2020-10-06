package AvisSenseLlar;

import java.util.ArrayList;
import java.util.List;

public class PersonaSinHogarDBController {

    private PersonaSinHogarDBView vista = new PersonaSinHogarDBView();

    public PersonaSinHogarDBController(){
    }

    //llama al DAO para guardar una persona sin hogar
    public void registrar(PersonaSinHogarDB psh ) {
        InterfazPersonaSinHogarDAO dao = new PersonaSinHogarDAOImplementacion();
        dao.registrar(psh);
    }

    //llama al DAO para actualizar una persona sin hogar
    public void actualizar(PersonaSinHogarDB psh) {
        InterfazPersonaSinHogarDAO dao = new PersonaSinHogarDAOImplementacion();
        dao.actualizar(psh);
    }

    //llama al DAO para eliminar una persona sin hogar
    public void eliminar(PersonaSinHogarDB psh) {
        InterfazPersonaSinHogarDAO dao = new PersonaSinHogarDAOImplementacion();
        dao.eliminar(psh);
    }

    //llama al DAO para obtener todos los clientes y luego los muestra en la vista
    public String verPersonasSinHogar(){
        List<PersonaSinHogarDB> listaPSH = new ArrayList<PersonaSinHogarDB>();
        InterfazPersonaSinHogarDAO dao = new  PersonaSinHogarDAOImplementacion();
        listaPSH = dao.obtener();
        //vista.verPersonasSinHogar(listaPSH);
        return vista.verPersonasSinHogar(listaPSH);
    }
}
