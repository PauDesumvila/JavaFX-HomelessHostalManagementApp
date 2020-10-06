package AvisSenseLlar;

import java.util.ArrayList;
import java.util.List;

public class PersonaSinHogarDBView {
    public void verPersonaSinHogar(PersonaSinHogarDB psh){
        System.out.println("Dades Persona Sense Llar: " + psh);
    }

    /*public void verPersonasSinHogar(List<PersonaSinHogarDB> listaPSH){
        for(PersonaSinHogarDB psh : listaPSH){
            System.out.println("Dades Persona Sense Llar: " + psh);
        }
    }*/

    /*public void verPersonasSinHogar(List<PersonaSinHogarDB> listaPSH){
        PantallaPrincipalController c = new PantallaPrincipalController();

        try{
            for(PersonaSinHogarDB psh : listaPSH){
                c.taVisualitza.appendText(psh.toString());
            }
        } catch (NullPointerException e){
            System.out.println(e);
        }
    }*/

    public String verPersonasSinHogar(List<PersonaSinHogarDB> listaPSH){
        StringBuilder sb = new StringBuilder();
        for(PersonaSinHogarDB psh : listaPSH){
            //System.out.println("Dades Persona Sense Llar: " + psh);
            sb.append("Dades Persona Sense Llar: " + psh + "\n");
        }
        return sb.toString();
    }
}
