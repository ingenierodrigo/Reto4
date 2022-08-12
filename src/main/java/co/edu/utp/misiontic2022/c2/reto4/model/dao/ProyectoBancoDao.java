
package co.edu.utp.misiontic2022.c2.reto4.model.dao;

import co.edu.utp.misiontic2022.c2.reto4.model.vo.ProyectoBancoVo;
import co.edu.utp.misiontic2022.c2.reto4.util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoBancoDao {
    
    public List<ProyectoBancoVo> proyectosFinanciadosPorBanco(String banco){
        
        List<ProyectoBancoVo> lista = new ArrayList();
     
        String query = "SELECT p.ID_Proyecto AS 'ID', p.Constructora AS 'CONSTRUCTORA', "
                + "p.Ciudad AS CIUDAD, p.Clasificacion AS CLASIFICACION, t.Estrato AS ESTRATO, "
                + "(l.Nombre ||' '|| l.Primer_Apellido ||' '|| l.Segundo_Apellido) AS 'LIDER'\n"
                + "FROM Proyecto p\n"
                + "INNER JOIN Tipo t on p.ID_Tipo = t.ID_Tipo\n"
                + "INNER JOIN Lider l on p.ID_Lider = l.ID_Lider \n"
                + "WHERE p.Banco_Vinculado = ? \n"
                + "ORDER BY p.Fecha_Inicio DESC, p.Ciudad, p.Constructora";

        try (Connection conexion = JDBCUtilities.getConnection()){
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, banco);
            ResultSet rs = ps.executeQuery();  
            while (rs.next()) {
              ProyectoBancoVo obj = new ProyectoBancoVo();
              obj.setId(rs.getInt("ID"));
              obj.setConstructora(rs.getString("CONSTRUCTORA"));
              obj.setCiudad(rs.getString("CIUDAD"));
              obj.setClasificacion(rs.getString("CLASIFICACION"));
              obj.setEstrato(rs.getInt("ESTRATO"));
              obj.setLider(rs.getString("LIDER"));
              lista.add(obj);
            }  
        } catch (SQLException ex) {
            
        }
        return lista; 
    }
}
