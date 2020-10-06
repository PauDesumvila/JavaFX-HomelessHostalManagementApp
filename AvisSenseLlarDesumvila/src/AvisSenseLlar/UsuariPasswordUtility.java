package AvisSenseLlar;

import java.util.ArrayList;
import java.util.HashMap;

public final class UsuariPasswordUtility {

    public static HashMap<String, String> llistaPaswords = new HashMap<>();
    public static HashMap<String, String> llistaUsuaris = new HashMap<>();

    public UsuariPasswordUtility(){
        llistaPaswords.put("admin@admin.com", "admin");
        llistaUsuaris.put("admin@admin.com", "ADMIN");
    }

    public static void AgefeixUsuari(String usuari, String password, String tipusUsuari){
        llistaPaswords.put(usuari, password);
        llistaUsuaris.put(usuari, tipusUsuari);
    }

    public static void EsborrraUsuari(String usuari){
        llistaPaswords.remove(usuari);
        llistaUsuaris.remove(usuari);
    }

    public static void ModificaUsuari(String usuari, String password, String tipusUsuari){
        llistaPaswords.replace(usuari, password);
        llistaUsuaris.replace(usuari, tipusUsuari);
    }
}
