/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio14;

/**
 *
 * @author juand
 */
public class Empleado {

    // Atributos privados
    private String nif;
    private String nombre;
    private double sueldoBase;
    private int horasExtra;
    private double tipoIRPF; // en porcentaje, p.ej. 15.0
    private boolean casado;
    private int numHijos;

    // Atributo de clase (static)
    private static double importeHoraExtra = 20.0;

    // Constructor por defecto
    public Empleado() {
        this.nif = "";
        this.nombre = "";
        this.sueldoBase = 0.0;
        this.horasExtra = 0;
        this.tipoIRPF = 0.0;
        this.casado = false;
        this.numHijos = 0;
    }

    // Constructor con todos los parámetros (menos importeHoraExtra)
    public Empleado(String nif, String nombre, double sueldoBase,
            int horasExtra, double tipoIRPF, boolean casado, int numHijos) {
        this.nif = nif;
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
        this.horasExtra = horasExtra;
        this.tipoIRPF = tipoIRPF;
        this.casado = casado;
        this.numHijos = numHijos;
    }

    // Getters y setters
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }

    public double getTipoIRPF() {
        return tipoIRPF;
    }

    public void setTipoIRPF(double tipoIRPF) {
        this.tipoIRPF = tipoIRPF;
    }

    public boolean isCasado() {
        return casado;
    }

    public void setCasado(boolean casado) {
        this.casado = casado;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }

    // Getter/Setter para el atributo static importeHoraExtra
    public static double getImporteHoraExtra() {
        return importeHoraExtra;
    }

    public static void setImporteHoraExtra(double importe) {
        importeHoraExtra = importe;
    }

    // Método para el cálculo del complemento correspondiente a las horas extra realizadas.
    public double complementoHorasExtra() {
        return horasExtra * importeHoraExtra;
    }

    // Método para calcular el sueldo bruto (sueldo base + complemento por horas extras)
    public double sueldoBruto() {
        return sueldoBase + complementoHorasExtra();
    }

    // Método para calcular las retenciones por IRPF.
    // El tipo a aplicar es: tipoIRPF - 2 puntos si casado - 1 punto por cada hijo.
    public double retencionesIRPF() {
        double tipoAplicable = tipoIRPF;
        if (casado) {
            tipoAplicable -= 2.0;
        }
        tipoAplicable -= numHijos * 1.0;
        if (tipoAplicable < 0.0) {
            tipoAplicable = 0.0;
        }
        return sueldoBruto() * (tipoAplicable / 100.0);
    }

    // Método que devuelve el sueldo neto (bruto - retenciones)
    public double sueldoNeto() {
        return sueldoBruto() - retencionesIRPF();
    }

    // toString() para mostrar los datos del empleado en el formato solicitado
    @Override
    public String toString() {
        String casadoStr = casado ? "S" : "N";
        StringBuilder sb = new StringBuilder();
        sb.append(nif).append(" ").append(nombre).append("\n");
        sb.append(String.format("Sueldo Base: %.2f%n", sueldoBase));
        sb.append("Horas Extras: ").append(horasExtra).append("\n");
        sb.append(String.format("tipo IRPF: %.1f%n", tipoIRPF));
        sb.append("Casado: ").append(casadoStr).append("\n");
        sb.append("Número de Hijos: ").append(numHijos).append("\n");
        return sb.toString();
    }
}
