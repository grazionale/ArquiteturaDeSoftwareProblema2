package controler;

import data.ClienteData;
import model.Cliente;

public class ClienteControler {
    
    ClienteData c = new ClienteData();
    
    public String cadastrar(Cliente cliente){
       
        
        if(cliente.getNome().length() < 5) {
            return "Informe pelo menos 5 caracteres para o nome do cliente";
            
        } else if(!c.getClientes().isEmpty()) {
            
            for(Cliente cli: c.getClientes()) {
                
            }
            
        }
        
    }
}
