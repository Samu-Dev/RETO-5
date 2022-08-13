package reto4.model.dao;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import reto4.util.*;
import java.util.List;
import java.util.ArrayList;
import reto4.model.vo.ComprasDeLiderVo;

public class ComprasDeLiderDao {
    public List<ComprasDeLiderVo> listar() throws SQLException{
        ArrayList<ComprasDeLiderVo> respuesta = new ArrayList<ComprasDeLiderVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Lider AS id, Nombre, Primer_Apellido AS apellido, Ciudad_Residencia AS ciudad FROM Lider l ORDER BY Ciudad_Residencia";
        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                ComprasDeLiderVo vo = new ComprasDeLiderVo();
                vo.setId(rs.getInt("id"));
                vo.setNombre(rs.getString("nombre"));
                vo.setApellido(rs.getString("apellido"));
                vo.setCiudad(rs.getString("ciudad"));
                respuesta.add(vo);
            }
            
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return respuesta;
    }
}
