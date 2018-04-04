package data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import model.Cliente;

public class ClienteData {
    private Set<Cliente> clientes = new HashSet<>();
    
    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
}
