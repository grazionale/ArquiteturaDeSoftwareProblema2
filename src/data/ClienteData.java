package data;

import java.util.ArrayList;
import model.Cliente;

public class ClienteData {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    
    public ArrayList<ClienteData> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<ClienteData> clientes) {
        this.clientes = clientes;
    }
    
    
}
