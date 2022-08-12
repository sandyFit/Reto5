package com.reto5.model.dao;

import java.sql.*;
import java.util.*;

import com.reto5.model.vo.TercerInformeVo;
import com.reto5.util.JDBCUtilities;

public class TercerInformeDao {
    public List<TercerInformeVo> listar() throws SQLException {
        ArrayList<TercerInformeVo> respuesta = new ArrayList<TercerInformeVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;

        String sql = " SELECT c.ID_Compra id, p.Constructora, p.Banco_Vinculado banco "
                + " FROM Compra c "
                + " JOIN Proyecto p ON (c.ID_Proyecto = p.ID_Proyecto) "
                + " WHERE p.Ciudad = 'Salento' "
                + " AND Proveedor = 'Homecenter'; ";
        
        try {
            stm = conn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                TercerInformeVo t = new TercerInformeVo();
                t.setId(rs.getInt("id"));
                t.setConstructora(rs.getString("Constructora"));
                t.setBanco(rs.getString("banco"));
                respuesta.add(t);
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
