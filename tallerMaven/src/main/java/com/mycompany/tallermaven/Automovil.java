
package com.mycompany.tallermaven;

import lombok.Getter;
import lombok.Setter;

public class Automovil extends Vehiculo {
    @Setter @Getter private int numeroPuertas;
   

    // Constructores, getters y setters

    // Otros métodos específicos para automóviles

    public Automovil(int numeroPuertas, String marca, String modelo, String placa, String horaIngreso) {
        super(marca, modelo, placa, horaIngreso);
        this.numeroPuertas = numeroPuertas;
    }
}
