/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examencompleto;

import java.time.LocalDate;

/**
 *
 * @author juand
 */
public class Contrato {

    private String dniContrato;
    private LocalDate fechaInicio;
    private double salarioAnual;

    public Contrato(String dniContrato, LocalDate fechaInicio, double salarioAnual) {
        this.dniContrato = dniContrato;
        this.fechaInicio = fechaInicio;
        this.salarioAnual = salarioAnual;
    }

    public Contrato() {
    }

    public String getDniContrato() {
        return dniContrato;
    }

    public void setDniContrato(String dniContrato) {
        this.dniContrato = dniContrato;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getSalarioAnual() {
        return salarioAnual;
    }

    public void setSalarioAnual(double salarioAnual) {
        this.salarioAnual = salarioAnual;
    }

    @Override
    public String toString() {
        return "Contrato: " + " fechaInicio= " + fechaInicio + ", salario= " + salarioAnual;
    }

}
