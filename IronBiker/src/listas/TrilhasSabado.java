package listas;

import classes.Trilha;
import java.util.ArrayList;
import java.util.List;

public abstract class TrilhasSabado {
    public static List<Trilha> trilhasSabado = new ArrayList<>();
    
    public static boolean insere(String ts) {
        boolean resultado = true;
        
        String[] trilhasSabadoVetor = ts.split("-");
        
        for (int i=0; i<trilhasSabadoVetor.length; i++) {
            Trilha t = new Trilha(trilhasSabadoVetor[i], i+1);
            resultado = TrilhasSabado.trilhasSabado.add(t);
        }
        
        return resultado;
    }
}