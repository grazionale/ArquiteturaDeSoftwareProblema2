package data;

import java.util.HashSet;
import java.util.Set;
import model.Pais;

public class PaisData {
    private Set<Pais> paises = new HashSet<>();

    public Set<Pais> getPaises() {
        return paises;
    }

    public void setPaises(Set<Pais> paises) {
        this.paises = paises;
    }
}
