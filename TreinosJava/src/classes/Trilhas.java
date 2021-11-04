
package classes;

/**
 *
 * @author Wagner
 */
public class Trilhas {
    private String nomeTrilha;
    private int codigo;
    private boolean sorteado;
    
    public Trilhas(){
        
    }

    public Trilhas(String nomeTrilha, int codigo) {
        this.nomeTrilha = nomeTrilha;
        this.codigo = codigo;
        this.sorteado = false;
    }

    public String getNomeTrilha() {
        return nomeTrilha;
    }

    public void setNomeTrilha(String nomeTrilha) {
        this.nomeTrilha = nomeTrilha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isSorteado() {
        return sorteado;
    }

    public void setSorteado(boolean sorteado) {
        this.sorteado = sorteado;
    }
    
    
}
