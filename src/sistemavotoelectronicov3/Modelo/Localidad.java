/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavotoelectronicov3.Modelo;

import java.util.*;

/**
 *
 * @author Tomás Contreras
 */
public class Localidad {
    
    private final int id;
            
    protected final static Localidad OBJETO_INVALIDO = new Localidad();

    private static Set<Localidad> listaObjetos = new HashSet<>();

    private static int getNewId(){

        //Crear un nuevo identificador
        int idActual = listaObjetos.size();

        //Buscar el siguiente identificador
        int siguienteIdentificador = Valor.SIGUIENTE_IDENTIFICADOR;

        //Combinar ambos valores
        idActual = idActual + siguienteIdentificador;

        //Devolver el nuevo identificador
        return idActual;

    }

    //Constructor

    private Localidad() {

        //Asignar un identificador
        this.id = getNewId();


    }

    protected static Localidad nuevo(){

        //Crear un objeto a devolver
        Localidad objetoDevolver = Localidad.OBJETO_INVALIDO;

        //Crear un nuevo objeto
        Localidad objetoNuevo = new Localidad();

        //Agregar a la lista de control
        Estado seAgrego = addNewObjeto(objetoNuevo);

        //Si se agrega con exito
        if(seAgrego == Estado.EXITO){

            //Establecer el objeto a devolver
            objetoDevolver = objetoNuevo;

        }else{

            //TODO capturar el error generado por un ingreso erroneo a la lista
            //...se establecio un valor por defecto

        }

        //Devolver el objeto requerido
        return objetoDevolver;

    }

    //Manejo de lista

    private static Estado addNewObjeto(Object objetoActual){

        //Establecer un valor por defecto
        Estado estadoDevolver= Estado.FRACASO;

        //Si el objeto recibido es del tipo correcto
        if(objetoActual.getClass() == Localidad.class){

            //Obtener el objeto requerido
            Localidad objetoAgregar = (Localidad)objetoActual;

            //Agregar el nuevo elemento a la lista
            boolean seAgrego;
            seAgrego = listaObjetos.add(objetoAgregar);

            if(seAgrego){

                //...asignar el estado correspondiente
                estadoDevolver = Estado.EXITO;

            }else{

                //...se establecio un valor por defecto

            }//...fin if


        }else{

            //...se establecio un valor por defecto

        }//...fin if

        //Devolver el estado correspondiente
        return estadoDevolver;

    }//...fin funcion
    
}
