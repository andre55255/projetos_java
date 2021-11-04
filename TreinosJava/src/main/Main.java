package main;

import classes.Pilotos;
import views.SorteioTrilhas;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wagner
 */
public class Main {

    public static void main(String[] args) {

        Pilotos aldinho = new Pilotos("Aldinho", 3);
        Pilotos gustavo = new Pilotos("Gustavo", 4);
        Pilotos ricardo = new Pilotos("Ricardo", 2);

        List<Pilotos> pilotos = new ArrayList<>();
        pilotos.add(aldinho);
        pilotos.add(gustavo);
        pilotos.add(ricardo);
        
//        Trilhas t1 = new Trilhas("Fazenda da palha / Entrada da trilha do dinossauro", 3);       
//        Trilhas t2 = new Trilhas("Fazenda dos Rola / Ponte das Criolas", 4);       
//        Trilhas t3 = new Trilhas("Ponte do gama / Trilha do Waguinho", 2);              



        SorteioTrilhas sorteioTrilhas = new SorteioTrilhas(pilotos);
        sorteioTrilhas.setVisible(true);
    }
}
