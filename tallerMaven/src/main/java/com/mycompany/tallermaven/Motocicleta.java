
package com.mycompany.tallermaven;

import lombok.Getter;
import lombok.Setter;

public class Motocicleta extends Vehiculo {
     @Setter @Getter private int cilindrada;
    
    // Constructores, getters y setters

    // Otros métodos específicos para motocicletas

    public Motocicleta(int cilindrada, String marca, String modelo, String placa, String horaIngreso) {
        super(marca, modelo, placa, horaIngreso);
        this.cilindrada = cilindrada;
    }
}
