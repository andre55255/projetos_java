package data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class CarregarArquivos {
    
    public static String lerTxt(String nomeDoArquivo) {
        String diretorioAtual;
        String dadosLidos;
        try {
            diretorioAtual = new File(".").getCanonicalPath();
            Path caminhoTxt = Paths.get(diretorioAtual + "/src/data/" + nomeDoArquivo);
            dadosLidos = new String(Files.readAllBytes(caminhoTxt));
            return dadosLidos;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return "";
        }
    }
}