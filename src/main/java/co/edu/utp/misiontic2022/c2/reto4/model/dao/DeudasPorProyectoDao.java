
package co.edu.utp.misiontic2022.c2.reto4.model.dao;

import co.edu.utp.misiontic2022.c2.reto4.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.c2.reto4.util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DeudasPorProyectoDao {
    
    public List<DeudasPorProyectoVo> totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior){
        
        List<DeudasPorProyectoVo> lista = new ArrayList();
     
        String query = "SELECT p.ID_Proyecto AS 'ID', sum(c.Cantidad*m.Precio_Unidad) AS 'VALOR' \n" 
                + "FROM Proyecto p\n"
                + "JOIN Compra c\n"
                + "ON p.ID_Proyecto = c.ID_Proyecto\n"
                + "JOIN MaterialConstruccion m\n"
                + "ON c.ID_MaterialConstruccion = m.ID_MaterialConstruccion\n"
                + "WHERE c.Pagado = 'No'\n"
                + "GROUP BY p.ID_Proyecto\n"
                + "HAVING sum(c.Cantidad*m.Precio_Unidad) > ?\n"
                + "ORDER BY VALOR DESC";

        try (Connection conexion = JDBCUtilities.getConnection()){
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setDouble(1, limiteInferior);
            ResultSet rs = ps.executeQuery();  
            while (rs.next()) {
              DeudasPorProyectoVo obj = new DeudasPorProyectoVo(rs.getInt("ID"), rs.getInt("VALOR"));
              lista.add(obj);
            }  
        } catch (SQLException ex) {
            
        }
        return lista; 
    }
    
}
