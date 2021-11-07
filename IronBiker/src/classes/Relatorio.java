package classes;

public abstract class Relatorio {
    public static String sabado() {
        StringBuilder sb = new StringBuilder();
        
        for (Piloto p : listas.Pilotos.pilotosSabado) {
            if (p.getTrilha() != null) {
                sb.append(p.toString());
            } else {
                sb.append("\nPiloto: ")
                        .append(p.getNome())
                        .append(", Trilha: não sorteada ainda");
            }
        }
        
        return sb.toString();
    }
    
    public static String domingo() {
        StringBuilder sb = new StringBuilder();
        
        for (Piloto p : listas.Pilotos.pilotosDomingo) {
            if (p.getTrilha() != null) {
                sb.append(p.toString());
            } else {
                sb.append("\nPiloto: ")
                        .append(p.getNome())
                        .append(", Trilha: não sorteada ainda");
            }
        }
        
        return sb.toString();
    }
}