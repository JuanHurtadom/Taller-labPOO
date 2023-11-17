
package com.mycompany.tallermaven;


public class Automovil extends Vehiculo {
    private int numeroPuertas;
   

    // Constructores, getters y setters

    // Otros métodos específicos para automóviles

    public Automovil(int numeroPuertas, String marca, String modelo, String placa, String horaIngreso) {
        super(marca, modelo, placa, horaIngreso);
        this.numeroPuertas = numeroPuertas;
    }

  
    
  
    
    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }
    
    
}