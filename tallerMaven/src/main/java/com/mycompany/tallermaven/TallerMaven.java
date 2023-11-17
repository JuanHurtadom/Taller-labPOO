

package com.mycompany.tallermaven;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.Date;

import java.util.LinkedList;


public class TallerMaven {

    public static void main(String[] args) {
           /*
        * Esto nos sirve para generar un formato json para retornar la data del array
        * sin tener que acomodarla bonita de manera manual
        */
        Gson gson = new Gson();
        
        LinkedList <Automovil> automoviles = new LinkedList<>();
        LinkedList <Motocicleta> motos = new LinkedList<>();
        
        //Objeto para obtener la hora de ingreso y de salida
        
        Date tiempo = new Date();        
        
        // Automovil creado por defecto
        Automovil auto = new Automovil(4 , "Mazda", "3", "ZYX987",(tiempo.getHours() + ":" + tiempo.getMinutes()));
        automoviles.add(auto);
        
        Motocicleta moto = new Motocicleta(600, "Honda", "CBR600", "XYZ789",(tiempo.getHours() + ":" + tiempo.getMinutes()));
        motos.add(moto);
        
        
        // Definir endpoints
        
             
        //listado de motos
        get("/motos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(motos);
        });
        // Listado de automovile
        get("/automoviles", (req, res) -> {
            res.type("application/json");
            return gson.toJson(automoviles);
        });

        
        // Guardar automovil
        // endpoint GET para agregar un automóvil
        //Al momento de crear el vehiculo tambien se crea la hora de ingreso
        get("/agregarAutomovil/:marca/:modelo/:placa/:numeroPuertas", (req, res) -> {
            
            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String marca = req.params(":marca");
            String modelo = req.params(":modelo");
            String placa = req.params(":placa");
            
            //Objeto para registarar la hora de ingreso del nuevo vehiculo
            Date nuevoTiempo = new Date();
            
            // No olvidar convertir en integer los string numericos que llegan por url
            int numeroPuertas = Integer.parseInt(req.params(":numeroPuertas"));

            // Crear un nuevo automóvil y agregarlo al parqueadero
            Automovil nuevoAuto = new Automovil(numeroPuertas, marca, modelo,placa,(nuevoTiempo.getHours() + ":" + nuevoTiempo.getMinutes()));
            automoviles.add(nuevoAuto);

            return gson.toJson(nuevoAuto);
        });
        
        
        
        // Guardar motoclicleta
        // endpoint GET para agregar un automóvil
        get("agregarMoto/:marca/:modelo/:placa/:cilindrada", (req, res) -> {
            
            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            // Obtener parámetros de la URL
            String marca = req.params(":marca");
            String modelo = req.params(":modelo");
            String placa = req.params(":placa");
            
            //Objeto para registarar la hora de ingreso de la nueva moto
            Date nuevoTiempo = new Date();
            
            // No olvidar convertir en integer los string numericos que llegan por url
            int cilindrada = Integer.parseInt(req.params(":cilindrada"));

            // Crear una nueva  y agregarlo al parqueadero
            Motocicleta nuevaMoto = new Motocicleta(cilindrada,marca, modelo,placa,(nuevoTiempo.getHours() + ":" + nuevoTiempo.getMinutes()) );
            motos.add(nuevaMoto);
            
            

            return gson.toJson(nuevaMoto);
        });
        
        
        //Se registra la hora de salida del vehiculo
         get("/registrarSalidaAutomovil/:placa", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            //Objeto para registarar la hora de salida de un vehiculo en especifico
            Date nuevaTiempo = new Date();

            // Obtener parámetros de la URL
            String placa = req.params(":placa");

            // Buscar por medio de la placa a que vehiculo se le va a registrar la hora de salida
            for (Vehiculo automovil : automoviles) {
                if (automovil.getPlaca().equals(placa)) {
                    automovil.setHoraSalida((nuevaTiempo.getHours() + ":" + nuevaTiempo.getMinutes()));
                    return gson.toJson(automovil);
                }

            }
            return gson.toJson("Este automovil no se encuentra en el parqueadero");
        });
         
         
        //endpoint registrar hora de salida de la moto
        get("/registrarSalidaMoto/:placa", (req, res) -> {

            // Añadimos esto para retornar en formato Json
            res.type("application/json");

            //Objeto para registarar la hora de salida de una moto en especifico
            Date nuevaTiempo = new Date();

            // Obtener parámetros de la URL
            String placa = req.params(":placa");

            // Buscar la motocicleta en el parqueadero
            for (Motocicleta motocicleta : motos) {
                if (motocicleta.getPlaca().equals(placa)) {
                    motocicleta.setHoraSalida((nuevaTiempo.getHours() + ":" + nuevaTiempo.getMinutes()));
                    return gson.toJson(motocicleta);
                }
            }
            return gson.toJson("Esta moto no se encuentra en el parqueadero");
        });
         
         
        // Verificar las motos actuales en el parqueadero
        get("/motosActuales", (req, res) -> {
            res.type("application/json");

            LinkedList<Motocicleta> motosActuales = new LinkedList<>();

            //Verificar a que automovil todavia no se le registra hora de salida, es decir que todavia no sale del parquedero 
            for (Motocicleta moto1 : motos) {
                if (moto.getHoraSalida() == null) {
                    motosActuales.add(moto1);
                }
            }

            return gson.toJson(motosActuales);
        });
        
        // Verificar automóviles actuales en el parqueadero
        get("/AutomovilesActuales", (req, res) -> {
            res.type("application/json");

            LinkedList<Automovil> automovilesActuales = new LinkedList<>();

            //Verificar a que automovil todavia no se le registra hora de salida, es decir que todavia no sale del parqueadero 
            for (Automovil automovil : automoviles) {
                if (automovil.getHoraSalida() == null) {
                    automovilesActuales.add(automovil);
                }
            }

            return gson.toJson(automovilesActuales);
        });
         
         //Reporte de automoviles con toda la informacion
        get("/AutomovilesReporte", (req, res) -> {
            res.type("application/json");

            LinkedList<String> automovilesReporte = new LinkedList<>();
            for (Vehiculo e : automoviles) {
                automovilesReporte.add("Placa: " + e.getPlaca() + ", Ganancia: " + e.calcularGanancia()+ ", Hora de Entrada: " + e.getHoraIngreso()+ ", Hora de Salida: " + e.getHoraSalida());
            }
            return new Gson().toJson(automovilesReporte);
        });
        
        //Reporte de motos con toda su informacion
        get("/motosReporte", (req, res) -> {
            res.type("application/json");

            LinkedList<String> motosReporte = new LinkedList<>();
            for (Motocicleta e : motos) {
                motosReporte.add("Placa: " + e.getPlaca() + ", Ganancia: " + e.calcularGanancia() + ", Hora de Entrada: " + e.getHoraIngreso()+ ", Hora de Salida: " + e.getHoraSalida());
            }

            return new Gson().toJson(motosReporte);
        });  
                
        //End point adicional 
        //Suma total de todas las ganancias generadas en los automoviles 
         get("/gananciasAutomoviles", (req, res) -> {
            res.type("application/json");

           double gananciasAutomoviles = 0;
           
           for(Vehiculo e : automoviles){
               gananciasAutomoviles = gananciasAutomoviles + e.calcularGanancia();
           }

            return new Gson().toJson(gananciasAutomoviles);
        }); 
         
         //Suma total de todas las ganancias generadas en las motos 
         get("/gananciasMotos", (req, res) -> {
            res.type("application/json");

           double gananciasMotos = 0;
           
           for(Motocicleta e : motos){
               gananciasMotos = gananciasMotos + e.calcularGanancia();
           }

            return new Gson().toJson(gananciasMotos);
        });
         
        //Suma de las ganancias en general  
        
         get("/gananciasEnGeneral", (req, res) -> {
            res.type("application/json");

           double gananciasEnGeneral = 0;
           
           //Sumar todo lo generado en las motos
           for(Motocicleta e : motos){
               gananciasEnGeneral = gananciasEnGeneral + e.calcularGanancia();
           }
          
           //En la suma se le agrega la suma de las ganancia de los automoviles
           for(Vehiculo e : automoviles){
               gananciasEnGeneral = gananciasEnGeneral + e.calcularGanancia();
           }

            return new Gson().toJson(gananciasEnGeneral);
        });
    }
       
}
