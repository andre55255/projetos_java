package classes;

public class Trilha {
    private String nome;
    private int codigo;
    private boolean isSorteado;
    
    public Trilha(){
    }

    public Trilha(String nomeTrilha, int codigo) {
        this.nome = nomeTrilha;
        this.codigo = codigo;
        this.isSorteado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isSorteado() {
        return isSorteado;
    }

    public void setIsSorteado(boolean sorteado) {
        this.isSorteado = sorteado;
    }
}