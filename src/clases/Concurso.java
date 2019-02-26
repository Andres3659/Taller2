package clases;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Concurso {
    private String nombre;
    private final Integer numProblemas;
    private HashSet<String> equipos;
    private LinkedList<Envio> respuestas;
    
    
    public Concurso(String nombre, Integer numProblemas) {
        this.nombre = nombre;
        this.numProblemas = numProblemas;
        this.equipos = new HashSet<>();
        this.respuestas = new LinkedList<>();
    }
    
   
    public Concurso(String nombre) {
        this(nombre, 5); 
    }
    

    public String getNombre() { return nombre; }
    public Integer getNumProblemas() { return numProblemas; }
    public HashSet<String> getEquipos() { return equipos; }
    
    
    
    public int getNumEquipos() { return this.equipos.size(); }
    
 
    public void añadirEquipos(String... str) {
        Collections.addAll(equipos, str);
    }
    
    boolean eliminarEquipo(String equipo) {
        
        LinkedList<Envio> envios = new LinkedList<>();
        for(Envio ev : this.respuestas) {
            if(ev.getNombreEquipo().equals(equipo)) {
                envios.add(ev);
            }
        }
        this.respuestas.removeAll(envios);
 
        return this.equipos.remove(equipo);
    }
    
    public Envio registrarEnvio(String nombreEquipo, Integer numProblema, String respuesta) {
        if(this.equipos.contains(nombreEquipo)) { 
            if(!(numProblema < 0) && (numProblema <= numProblemas)) {
                if((respuesta != null) && !(respuesta.isEmpty())) {
                    Envio ev = new Envio(nombreEquipo, numProblema, respuesta);
                    this.respuestas.add(ev);
                    return ev;
                }
            }
        }
        return null;
    }
}
