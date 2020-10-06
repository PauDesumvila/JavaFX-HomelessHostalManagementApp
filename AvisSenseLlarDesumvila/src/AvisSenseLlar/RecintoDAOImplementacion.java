package AvisSenseLlar;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecintoDAOImplementacion implements InterfazRecintoDAO {

    @Override
    public boolean registrar(RecintoDB recinto) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;

        String sql = "INSERT INTO recintes values (" + recinto.getCodi() + "','" + recinto.getNomRecinte() + "','" + recinto.getDireccio() + "','" + recinto.getPropietari() + "','" + recinto.getNumPlacesTotals() + "','" + recinto.getNumPlacesOcupades() + "','" + recinto.isAdaptatCadiraRodes() + "','" + recinto.isDisposaEnfermera() +"')";

        try {
            con=Conexion.conectar();
            stm= con.createStatement();
            stm.execute(sql);
            registrar=true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase RecintoDAOImplementacion, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<RecintoDB> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM recintes ORDER BY codi";

        List<RecintoDB> listaRecintos= new ArrayList<RecintoDB>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                RecintoDB r = new RecintoDB();
                r.setCodi(rs.getInt(1));
                r.setNomRecinte(rs.getString(2));
                r.setDireccio(rs.getString(3));
                r.setPropietari(rs.getString(4));
                r.setNumPlacesTotals(rs.getInt(5));
                r.setNumPlacesOcupades(rs.getInt(6));
                r.setAdaptatCadiraRodes(rs.getBoolean(7));
                r.setDisposaEnfermera(rs.getBoolean(8));
                listaRecintos.add(r);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase RecintoDAOImplementacion, método obtener");
            e.printStackTrace();
        }

        return listaRecintos;
    }

    @Override
    public boolean actualizar(RecintoDB recinto) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql = "UPDATE recintes SET nomRecinte='" + recinto.getNomRecinte() + "', direccio='" + recinto.getDireccio() +  "', propietari='" + recinto.getPropietari() + "', numPlacesTotals ='" + recinto.getNumPlacesTotals() +  "', numPlacesOcupades ='" + recinto.getNumPlacesOcupades() +  "', adaptatCadiraRodes ='" + recinto.isAdaptatCadiraRodes() + "', disposaEnfermera ='" + recinto.isDisposaEnfermera() + "'" +" WHERE codi="+recinto.getCodi();

        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase RecintoDAOImplementacion, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(RecintoDB recinto) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM recintes WHERE ID=" + recinto.getCodi();

        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase RecintoDAOImplementacion, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }

}
