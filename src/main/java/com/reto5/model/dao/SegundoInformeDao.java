package com.reto5.model.dao;

import java.sql.*;
import java.util.*;
import com.reto5.util.JDBCUtilities;
import com.reto5.model.vo.SegundoInformeVo;

public class SegundoInformeDao {
    public List<SegundoInformeVo> listar() throws SQLException {
        ArrayList<SegundoInformeVo> respuesta = new ArrayList<SegundoInformeVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;

        String sql = "SELECT ID_Proyecto id, Constructora, "
                + "Numero_Habitaciones hab, Ciudad "
                + "FROM Proyecto p "
                + "WHERE Clasificacion = 'Casa Campestre' "
                + "AND ciudad in('Santa Marta', 'Cartagena', 'Barranquilla')";
        
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                SegundoInformeVo s = new SegundoInformeVo();
                s.setId(rs.getInt("id"));
                s.setConstructora(rs.getString("constructora"));
                s.setHabitaciones(rs.getInt("hab"));
                s.setCiudad(rs.getString("ciudad"));
                respuesta.add(s);
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
