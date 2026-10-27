package main.examen1;

/**
 *
 * @author $(user)
 */
public class Grado {

    private String codigo;
    private String nombre; // "Grado Medio Sistemas" o "Grado Superior Desarrollo"
    private String cursoAcademico; // "2025/2026"
    private int nivel; // 1 o 2
    private String grupo; // A, B, C ....

    public Grado(String codigo, String nombre, String cursoAcademico, int nivel, String grupo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cursoAcademico = cursoAcademico;
        this.nivel = nivel;
        this.grupo = grupo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCursoAcademico() {
        return cursoAcademico;
    }

    public void setCursoAcademico(String cursoAcademico) {
        this.cursoAcademico = cursoAcademico;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "-- Grado --"
                + "\nCodigo: " + codigo
                + "\nNombre: " + nombre
                + "\nCurso Academico: " + cursoAcademico
                + "\nNivel: " + nivel
                + "\nGrupo: " + grupo;
    }

}
