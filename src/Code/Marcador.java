package Code;

public class Marcador {
    
    private final int tanteoLocal;
    private final int tanteoVisitante;
    
    public Marcador(int tanteoLocal, int tanteoVisitante){
        this.tanteoLocal = tanteoLocal;
        this.tanteoVisitante = tanteoVisitante;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.tanteoLocal;
        hash = 37 * hash + this.tanteoVisitante;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Marcador other = (Marcador) obj;
        if (this.tanteoLocal != other.tanteoLocal) {
            return false;
        }
        if (this.tanteoVisitante != other.tanteoVisitante) {
            return false;
        }
        return true;
    }
    
}
