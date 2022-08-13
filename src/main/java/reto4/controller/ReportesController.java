package reto4.controller;
import reto4.model.dao.*;
import reto4.model.vo.*;

import java.sql.SQLException;
import java.util.List;

public class ReportesController {
    private ComprasDeLiderDao comprasDeLiderDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ProyectoBancoDao proyectoBancoDao;

    public ReportesController(){
        proyectoBancoDao = new ProyectoBancoDao();
        deudasPorProyectoDao = new DeudasPorProyectoDao();
        comprasDeLiderDao = new ComprasDeLiderDao();
    }

    public List<ProyectoBancoVo> listarProyectosPorBanco() throws SQLException{
        return proyectoBancoDao.listar();
    }
    public List<DeudasPorProyectoVo> listarTotalAdeudadoProyectos() throws SQLException{
        return deudasPorProyectoDao.listar();
    }
    public List<ComprasDeLiderVo> listarLideresCompras() throws SQLException{
        return comprasDeLiderDao.listar();
    }


}
