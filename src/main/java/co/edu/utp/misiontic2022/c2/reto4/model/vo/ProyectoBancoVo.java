
package co.edu.utp.misiontic2022.c2.reto4.model.vo;

public class ProyectoBancoVo {
    private int id;
    private String constructora;
    private String ciudad;
    private String clasificacion;
    private int estrato;
    private String lider;

    public ProyectoBancoVo() {
    }

    public ProyectoBancoVo(int id, String constructora, String ciudad, String clasificacion, int estrato, String lider) {
        this.id = id;
        this.constructora = constructora;
        this.ciudad = ciudad;
        this.clasificacion = clasificacion;
        this.estrato = estrato;
        this.lider = lider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    @Override
    public String toString() {
        return String.format("%3d %-25s %-20s %-15s %7d %-30s", id,constructora,
                ciudad, clasificacion, estrato, lider);
    }

}
