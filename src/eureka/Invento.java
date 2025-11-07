/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eureka;

/**
 *
 * @author lpzcahuillan
 */
public abstract class Invento {
    protected String codigo;
    protected String nombre;
    protected double valorBase;
    
    //constructor

    public Invento(String codigo, String nombre, double valorBase) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valorBase = valorBase;
    }

    // getter y setter

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

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
    
    // Metodos abstracto
    
    public abstract double ajusteValor();
    public abstract double valorFinal();
}

