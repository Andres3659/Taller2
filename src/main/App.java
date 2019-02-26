package main;

import clases.Concurso;
import java.util.HashSet;
import java.util.LinkedList;

public class App {

    public static void main(String[] args) {
        //Declara y construye un concurso con nombre “Sesión 1” y 2 problemas. 
        Concurso concurso1 = new Concurso("Sesion 1", 2);
        
        //Declara y construye un concurso con nombre “Sesión 2” y 3 problemas. 
        Concurso concurso2 = new Concurso("Sesion 2", 3);
        
        //Declara y construye un concurso con nombre “Sesión 3” y 3 problemas. 
        Concurso concurso3 = new Concurso("Sesion 3", 3);
        
        //Crea una lista de concursos y añade los tres concursos creados en los pasos
        //anteriores
        LinkedList<Concurso> lista = new LinkedList<>();
        lista.add(concurso1);
        lista.add(concurso2);
        lista.add(concurso3);
        
        //Recorre los concursos y realiza lo siguiente: 
        for (Concurso cs : lista) {
            //Muestra el nombre del concurso. 
            System.out.println("Nombre del Concurso: " + cs.getNombre());
            //Añade los equipos “Equipo 1”, “Equipo 2” y “Equipo 3”. 
            cs.añadirEquipos("Equipo 1", "Equipo 2", "Equipo 3");
            // Recorre los equipos para que cada uno realice el envío “(1, 2)” a todos los
            //problemas.
            HashSet<String> equipos = cs.getEquipos();
            for (String str : equipos) {
                for (int i = 1; i <= cs.getNumProblemas(); i++) {
                    cs.registrarEnvio(str, i, "(1, 2)");
                }
            }
        }
    }
}
