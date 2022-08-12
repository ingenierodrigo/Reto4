
package app;

import co.edu.utp.misiontic2022.c2.reto4.view.ReportesView;

public class App {
    
    public static void main(String[] args) {
        ReportesView reportesView = new ReportesView();

//        var banco = "Conavi";
//        reportesView.proyectosFinanciadosPorBanco(banco);

//        reportesView.lideresQueMasGastan();
        
        var limiteInferior = 50_000d;
        reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
    }
}
