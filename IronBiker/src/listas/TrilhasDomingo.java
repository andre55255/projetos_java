package listas;

import classes.Trilha;
import java.util.ArrayList;
import java.util.List;

public abstract class TrilhasDomingo {
    public static List<Trilha> trilhasDomingo = new ArrayList<>();
    
    public static boolean insere(String td) {
        boolean resultado = true;
        
        String[] trilhasDomingoVetor = td.split("-");
        
        for (int i=0; i<trilhasDomingoVetor.length; i++) {
            Trilha t = new Trilha(trilhasDomingoVetor[i], i+1);
            resultado = TrilhasDomingo.trilhasDomingo.add(t);
        }
        
        return resultado;
    }
}