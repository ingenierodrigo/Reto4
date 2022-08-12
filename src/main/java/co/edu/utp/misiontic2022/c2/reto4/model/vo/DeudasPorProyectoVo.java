
package co.edu.utp.misiontic2022.c2.reto4.model.vo;

public class DeudasPorProyectoVo {
    private int id;
    private double valor;

    public DeudasPorProyectoVo() {
    }

    public DeudasPorProyectoVo(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format("%-25s %,15.1f", id, valor);
    }  
}
