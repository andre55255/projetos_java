package listas;

import java.util.List;
import classes.Piloto;
import classes.Trilha;
import java.util.ArrayList;

public abstract class Pilotos {
    public static List<Piloto> pilotosSabado = new ArrayList<>();
    public static List<Piloto> pilotosDomingo = new ArrayList<>();
    
    public static boolean insere(String pi) {
        boolean resultado = true;
        
        String[] pilotosVetor = pi.split("-");
        
        for (int i=0; i<pilotosVetor.length; i++) {
            if (i == 0) {
                continue;
            } 
            
            String nome = pilotosVetor[i].split(",")[0];
            String numStr = pilotosVetor[i].split(",")[1];
            int numero = Integer.parseInt(numStr.trim());
            Piloto p = new Piloto(nome, numero);
            Piloto p1 = new Piloto(nome, numero);
            resultado = Pilotos.pilotosSabado.add(p);
            resultado = Pilotos.pilotosDomingo.add(p1);
        }
        
        return resultado;
    }

    public static boolean alterarPilotosSabado(String nome, int num, Trilha trilha) {
        boolean resultado = false;
        
        for (Piloto p : Pilotos.pilotosSabado) {
            if (p.getNome().equals(nome) && p.getNumero() == num) {
                p.setTrilha(trilha);
                resultado = true;
                break;
            }
        }
        
        return resultado;
    }
    
    public static boolean alterarPilotosDomingo(String nome, int num, Trilha trilha) {
        boolean resultado = false;
        
        for (Piloto p : Pilotos.pilotosDomingo) {
            if (p.getNome().equals(nome) && p.getNumero() == num) {
                p.setTrilha(trilha);
                resultado = true;
                break;
            }
        }
        
        return resultado;
    }
}