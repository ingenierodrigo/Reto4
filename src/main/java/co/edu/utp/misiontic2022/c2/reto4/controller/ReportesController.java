
package co.edu.utp.misiontic2022.c2.reto4.controller;

import co.edu.utp.misiontic2022.c2.reto4.model.dao.ComprasDeLiderDao;
import co.edu.utp.misiontic2022.c2.reto4.model.dao.DeudasPorProyectoDao;
import co.edu.utp.misiontic2022.c2.reto4.model.dao.ProyectoBancoDao;
import co.edu.utp.misiontic2022.c2.reto4.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.c2.reto4.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.c2.reto4.model.vo.ProyectoBancoVo;
import java.util.List;


public class ReportesController {
    
    public List<ComprasDeLiderVo> lideresQueMasGastan(){
        ComprasDeLiderDao liderDao = new ComprasDeLiderDao();
        return liderDao.líderesQueMasGastan();
    }
    
    public List<ProyectoBancoVo> proyectosFinanciadosPorBanco(String banco){
        ProyectoBancoDao bancoDao = new ProyectoBancoDao();
        return bancoDao.proyectosFinanciadosPorBanco(banco);
    }
    
    public List<DeudasPorProyectoVo> totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior){
        DeudasPorProyectoDao deudasDao = new DeudasPorProyectoDao();
        return deudasDao.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
    }
}
