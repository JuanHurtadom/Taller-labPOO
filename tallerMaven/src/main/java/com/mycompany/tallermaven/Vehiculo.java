package com.mycompany.tallermaven;

import lombok.Getter;
import lombok.Setter;

public class Vehiculo {
  @Setter @Getter private String marca, modelo, placa, horaIngreso, horaSalida;

    // Constructores, getters y setters

    // Otros métodos específicos si es necesario

    public Vehiculo(String marca, String modelo, String placa, String horaIngreso) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.horaIngreso = horaIngreso;
    }

       public int calcularGanancia() {

        if (this.horaSalida == null) {
            return 0;
        }
        
        //extrae del string las horas
        String[] partesHoraI = this.horaIngreso.split(":");
        int horasIngreso = Integer.parseInt(partesHoraI[0]);
        //extrae del string las horas
        String[] partesHoraS = this.horaSalida.split(":");
        int horasSalida = Integer.parseInt(partesHoraS[0]);
        
        //Valor minimo 2000    

        return 2000 + ((horasIngreso - horasSalida) * 200);

    } 
}
