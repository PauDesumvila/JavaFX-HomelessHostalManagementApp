package AvisSenseLlar;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaSinHogarDAOImplementacion implements InterfazPersonaSinHogarDAO {

    @Override
    public boolean registrar(PersonaSinHogarDB psh) {
        boolean registrar = false;

        Statement stm = null;
        Connection con = null;

        String sql = "INSERT INTO residents values (" + psh.getCodi() + "','" + psh.getNom() + "','" + psh.getDNI() + "','" + psh.getEdat() + "','" + psh.isCadiraRodes() + "','" + psh.isNecesitaEnfermera() + "','" + psh.isEstaIngresat() + "','" + psh.getCodiRecienteIngres() +"')";

        try {
            con = Conexion.conectar();
            stm = con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase PersonaSinHogarDAOImplementacion, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public List<PersonaSinHogarDB> obtener() {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;

        String sql="SELECT * FROM residents ORDER BY codi";

        List<PersonaSinHogarDB> listaPSH = new ArrayList<PersonaSinHogarDB>();

        try {
            co = Conexion.conectar();
            stm = co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                PersonaSinHogarDB psh = new PersonaSinHogarDB();
                psh.setCodi(rs.getInt(1));
                psh.setNom(rs.getString(2));
                psh.setDNI(rs.getString(3));
                psh.setEdat(rs.getInt(4));
                psh.setCadiraRodes(rs.getBoolean(5));
                psh.setNecesitaEnfermera(rs.getBoolean(6));
                psh.setEstaIngresat(rs.getBoolean(7));
                psh.setCodiRecienteIngres(rs.getInt(8));
                listaPSH.add(psh);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase PersonaSinHogarDAOImplementacion, método obtener");
            e.printStackTrace();
        }
        return listaPSH;
    }

    @Override
    public boolean actualizar(PersonaSinHogarDB psh) {
        Connection connect = null;
        Statement stm = null;

        boolean actualizar = false;

        String sql="UPDATE residents SET nom='" + psh.getNom() + "', DNI='" + psh.getDNI() +  "', edat='" + psh.getEdat() + "', cadiraRodes='" + psh.isCadiraRodes() +  "', necesitaEnfermera='" + psh.isNecesitaEnfermera() +  "', estaIngresat='" + psh.isEstaIngresat() + "', codiRecinteIngres='" + psh.getCodiRecienteIngres() + "'" +" WHERE codi="+psh.getCodi();

        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            actualizar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase PersonaSinHogarDAOImplementacion, método actualizar");
            e.printStackTrace();
        }
        return actualizar;
    }

    @Override
    public boolean eliminar(PersonaSinHogarDB psh) {
        Connection connect = null;
        Statement stm = null;

        boolean eliminar = false;

        String sql = "DELETE FROM residents WHERE codi=" + psh.getCodi();
        try {
            connect = Conexion.conectar();
            stm = connect.createStatement();
            stm.execute(sql);
            eliminar = true;
        } catch (SQLException e) {
            System.out.println("Error: Clase PersonaSinHogarDAOImplementacion, método eliminar");
            e.printStackTrace();
        }
        return eliminar;
    }
}
