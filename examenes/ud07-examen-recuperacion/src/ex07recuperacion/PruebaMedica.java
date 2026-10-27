package ex07recuperacion;

import java.time.LocalDate;

/**
 *
 * @author $(user)
 */
public class PruebaMedica {

    private String codigo;
    private LocalDate fechaPrueba;
    private String descripPrueba;
    private String resultadoPrueba;
    private String numSegSocial;

    public PruebaMedica(String numSegSocial, String codigo, LocalDate fechaPrueba, String descripPrueba) {
        this.codigo = codigo;
        this.fechaPrueba = fechaPrueba;
        this.descripPrueba = descripPrueba;
        this.numSegSocial = numSegSocial;
        this.resultadoPrueba = null;
    }

    public PruebaMedica(String numSegSocial, String codigo, LocalDate fechaPrueba, String descripPrueba, String resultadoPrueba) {
        this.numSegSocial = numSegSocial;
        this.codigo = codigo;
        this.fechaPrueba = fechaPrueba;
        this.descripPrueba = descripPrueba;
        this.resultadoPrueba = resultadoPrueba;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPrueba() {
        return fechaPrueba;
    }

    public void setFechaPrueba(LocalDate fechaPrueba) {
        this.fechaPrueba = fechaPrueba;
    }

    public String getDescripPrueba() {
        return descripPrueba;
    }

    public void setDescripPrueba(String descripPrueba) {
        this.descripPrueba = descripPrueba;
    }

    public String getResultadoPrueba() {
        return resultadoPrueba;
    }

    public void setResultadoPrueba(String resultadoPrueba) {
        this.resultadoPrueba = resultadoPrueba;
    }

    public boolean asignaResultadoPrueba(String resultadoPrueba) {
        this.resultadoPrueba = resultadoPrueba;
        return true;
    }

    public boolean asignaPaciente(Paciente listaPacientes) {
        this.numSegSocial = numSegSocial;
        return true;
    }

    @Override
    public String toString() {
        return "Cod_prueba: " + codigo + ". Tipo: " + descripPrueba + " - fecha: " + fechaPrueba + " . Resultado: " + (this.resultadoPrueba.equals("N/A") ? " : Pendiente." :  resultadoPrueba);
    }

}
