
package com.mycompany.tallermaven;

public class Motocicleta extends Vehiculo {
    private int cilindrada;
    
    // Constructores, getters y setters

    // Otros métodos específicos para motocicletas

    public Motocicleta(int cilindrada, String marca, String modelo, String placa, String horaIngreso) {
        super(marca, modelo, placa, horaIngreso);
        this.cilindrada = cilindrada;
    }

 
    

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    
    

    
}