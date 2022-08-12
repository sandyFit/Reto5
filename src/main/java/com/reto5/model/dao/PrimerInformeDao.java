package com.reto5.model.dao;

import java.sql.*;
import java.util.*;

import com.reto5.model.vo.PrimerInformeVo;
import com.reto5.util.JDBCUtilities;



public class PrimerInformeDao {
    public List<PrimerInformeVo> listar() throws SQLException {
        ArrayList<PrimerInformeVo> respuesta = new ArrayList<PrimerInformeVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT ID_Lider as id, Nombre, Primer_Apellido as apellido, "
                + "Ciudad_Residencia as ciudad "
                + "FROM Lider l "
                + "ORDER BY Ciudad_Residencia";
                
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                PrimerInformeVo p = new PrimerInformeVo();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setCiudad(rs.getString("ciudad"));
                respuesta.add(p);
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
    
}
