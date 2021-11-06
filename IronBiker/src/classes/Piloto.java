package classes;

public class Piloto {
    private String nome;
    private int numero;
    private Trilha trilha;
    
    public Piloto (){
    }
    
    public Piloto(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }
}