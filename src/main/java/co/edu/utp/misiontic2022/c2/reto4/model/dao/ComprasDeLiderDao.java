
package co.edu.utp.misiontic2022.c2.reto4.model.dao;

import co.edu.utp.misiontic2022.c2.reto4.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.reto4.util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComprasDeLiderDao {
    
    public List<ComprasDeLiderVo> líderesQueMasGastan(){
        
        List<ComprasDeLiderVo> lista = new ArrayList();
         
        String query = " SELECT l.Nombre || ' ' || l.Primer_Apellido || ' ' || l.Segundo_Apellido  \n" +
                        "AS 'LIDER', sum(c.Cantidad * m.Precio_Unidad) \n" +
                        "AS 'VALOR'\n" +
                        "FROM Lider l\n" +
                        "JOIN Proyecto p\n" +
                        "ON l.ID_Lider = p.ID_Lider\n" +
                        "JOIN Compra C\n" +
                        "ON p.ID_Proyecto = c.ID_Proyecto\n" +
                        "JOIN MaterialConstruccion m\n" +
                        "ON c.ID_MaterialConstruccion = m.ID_MaterialConstruccion\n" +
                        "GROUP BY LIDER\n" +
                        "ORDER BY VALOR DESC\n" +
                        "LIMIT 10";
        
        try (Connection conexion = JDBCUtilities.getConnection()){
            
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();  
            while (rs.next()) {
              ComprasDeLiderVo obj = new ComprasDeLiderVo(rs.getString("LIDER"), rs.getDouble("VALOR"));
              lista.add(obj);
            }  
        } catch (SQLException ex) {
        }
        return lista; 
    }

}
