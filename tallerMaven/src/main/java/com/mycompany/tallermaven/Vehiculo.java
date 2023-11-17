package com.mycompany.tallermaven;


public class Vehiculo {
    private String marca;
    private String modelo;
    private String placa;
    private String horaIngreso;
    private String horaSalida;


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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(String horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    
}
