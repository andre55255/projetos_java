package main;

import data.CarregarArquivos;
import javax.swing.JOptionPane;
import views.SorteioTrilhas;

public class Main {

    public static void main(String[] args) {
        String pilotos = CarregarArquivos.lerTxt("pilotos.txt");
        
        if (pilotos.length() == 0) {
            JOptionPane.showMessageDialog(null, "Cadastre os pilotos no arquivo de 'pilotos.txt'\nEx: -Nome do piloto,2");
            return;
        } else {
            listas.Pilotos.insere(pilotos);
        }
        
        new SorteioTrilhas().setVisible(true);
    }
}